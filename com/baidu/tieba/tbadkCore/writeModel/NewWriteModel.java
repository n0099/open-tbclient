package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    public static final String THREAD_TYPE_LBS = "7";
    private String bns;
    private e fyW;
    private a fyX;
    private String fyY;
    private byte[] fyZ;
    private b fza;
    private c fzb;
    private d fzc;
    private boolean fzd;
    private a.InterfaceC0073a fze;
    private WriteData mData;
    private final g<?> mPageContext;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, q qVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fyW = null;
        this.fyX = null;
        this.mData = null;
        this.fyY = null;
        this.bns = null;
        this.fyZ = null;
        this.fzb = null;
        this.fzc = null;
        this.fzd = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fyW = null;
        this.fyX = null;
        this.mData = null;
        this.fyY = null;
        this.bns = null;
        this.fyZ = null;
        this.fzb = null;
        this.fzc = null;
        this.fzd = false;
        this.mPageContext = tbPageContext;
    }

    public void lo(boolean z) {
        this.fzd = z;
    }

    public void b(d dVar) {
        this.fzc = dVar;
    }

    public void a(c cVar) {
        this.fzb = cVar;
    }

    public void a(a.InterfaceC0073a interfaceC0073a) {
        this.fze = interfaceC0073a;
    }

    public void setWriteData(WriteData writeData) {
        this.mData = writeData;
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    public boolean startPostWrite() {
        if (this.mData == null) {
            return false;
        }
        if (!i.hj() || i.hk() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.bZ(w.l.original_img_up_no_wifi_tip);
            aVar.a(w.l.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(w.l.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.mPageContext);
            aVar.tQ();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.fyW == null) {
            this.fyW = new e();
            this.fyW.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fyW != null && !this.fyW.isCancelled()) {
            this.fyW.cancel();
        } else if (this.fzc != null) {
            this.fzc.callback(false, null, null, null, null);
        } else if (this.fzb != null) {
            this.fzb.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fyW != null && !this.fyW.isCancelled()) {
            this.fyW.cancel();
            return false;
        }
        return false;
    }

    public void Rm() {
        if (this.fyX != null && !this.fyX.isCancelled()) {
            this.fyX.cancel();
        }
    }

    public boolean bju() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a bnt = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00f0  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.d doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.d dVar;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int i;
            String str6;
            String str7;
            String str8 = null;
            if (this.isCanceled) {
                return null;
            }
            this.bnt = new com.baidu.tieba.tbadkCore.c.a();
            this.bnt.a(NewWriteModel.this.fze);
            this.mRetData = this.bnt.a(NewWriteModel.this.mData, NewWriteModel.this.fzd);
            ErrorData errorData = this.bnt.getErrorData();
            if (this.bnt.isRequestSuccess() && this.mRetData != null) {
                AntiData biD = this.bnt.biD();
                String error_msg = errorData.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, biD);
                if (NewWriteModel.this.mData == null || !NewWriteModel.this.mData.isHasImages() || dVar2.hasError()) {
                    dVar = dVar2;
                } else {
                    NewWriteModel.this.mData.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (errorData != null && !StringUtils.isNull(errorData.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), errorData.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m9getInst().getApp().getString(w.l.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.mRetData != null) {
                        JSONObject jSONObject = new JSONObject(this.mRetData);
                        String optString = jSONObject.optString(AddFriendActivityConfig.MSG);
                        try {
                            String optString2 = jSONObject.optString("pre_msg");
                            try {
                                String optString3 = jSONObject.optString("color_msg");
                                try {
                                    String optString4 = jSONObject.optString("tid");
                                    try {
                                        String optString5 = jSONObject.optString(Info.kBaiduPIDKey);
                                        try {
                                            JSONObject optJSONObject = new JSONObject(this.mRetData).optJSONObject("twzhibo_info");
                                            i = optJSONObject != null ? optJSONObject.optInt("is_copytwzhibo", 0) : 0;
                                            try {
                                                JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                                if (optJSONObject2 != null) {
                                                    String optString6 = optJSONObject2.optString("pre_msg");
                                                    try {
                                                        str7 = optJSONObject2.optString("color_msg");
                                                        str8 = optString6;
                                                        str = optString5;
                                                        str2 = optString4;
                                                        str3 = optString3;
                                                        str4 = optString2;
                                                        str5 = optString;
                                                    } catch (JSONException e) {
                                                        str6 = optString6;
                                                        str = optString5;
                                                        str2 = optString4;
                                                        str3 = optString3;
                                                        str4 = optString2;
                                                        str5 = optString;
                                                        jSONException = e;
                                                        jSONException.printStackTrace();
                                                        str8 = str6;
                                                        str7 = null;
                                                        if (StringUtils.isNull(str5)) {
                                                        }
                                                        dVar.setErrorString(str5);
                                                        dVar.setPreMsg(str4);
                                                        dVar.setColorMsg(str3);
                                                        dVar.setThreadId(str2);
                                                        dVar.setPostId(str);
                                                        dVar.setIsCopyTWZhibo(i);
                                                        dVar.qt(str8);
                                                        dVar.qu(str7);
                                                        return dVar;
                                                    }
                                                } else {
                                                    str7 = null;
                                                    str = optString5;
                                                    str2 = optString4;
                                                    str3 = optString3;
                                                    str4 = optString2;
                                                    str5 = optString;
                                                }
                                            } catch (JSONException e2) {
                                                str = optString5;
                                                str2 = optString4;
                                                str3 = optString3;
                                                str4 = optString2;
                                                str5 = optString;
                                                jSONException = e2;
                                                str6 = null;
                                            }
                                        } catch (JSONException e3) {
                                            str = optString5;
                                            str2 = optString4;
                                            str3 = optString3;
                                            str4 = optString2;
                                            str5 = optString;
                                            jSONException = e3;
                                            i = 0;
                                            str6 = null;
                                        }
                                    } catch (JSONException e4) {
                                        str = null;
                                        str2 = optString4;
                                        str3 = optString3;
                                        str4 = optString2;
                                        str5 = optString;
                                        jSONException = e4;
                                        i = 0;
                                        str6 = null;
                                    }
                                } catch (JSONException e5) {
                                    str = null;
                                    str2 = null;
                                    str3 = optString3;
                                    str4 = optString2;
                                    str5 = optString;
                                    jSONException = e5;
                                    i = 0;
                                    str6 = null;
                                }
                            } catch (JSONException e6) {
                                str = null;
                                str2 = null;
                                str3 = null;
                                str4 = optString2;
                                str5 = optString;
                                jSONException = e6;
                                i = 0;
                                str6 = null;
                            }
                        } catch (JSONException e7) {
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = optString;
                            jSONException = e7;
                            i = 0;
                            str6 = null;
                        }
                    } else {
                        i = 0;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str7 = null;
                    }
                } catch (JSONException e8) {
                    jSONException = e8;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    i = 0;
                    str6 = null;
                }
                if (StringUtils.isNull(str5)) {
                    str5 = TbadkCoreApplication.m9getInst().getString(w.l.send_success);
                }
                dVar.setErrorString(str5);
                dVar.setPreMsg(str4);
                dVar.setColorMsg(str3);
                dVar.setThreadId(str2);
                dVar.setPostId(str);
                dVar.setIsCopyTWZhibo(i);
                dVar.qt(str8);
                dVar.qu(str7);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            String bjy;
            String str = null;
            super.onPostExecute((e) dVar);
            NewWriteModel.this.fyW = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a("write", 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.isCanceled && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.c.b(NewWriteModel.this.mData);
                    if (NewWriteModel.this.fzc == null) {
                        if (NewWriteModel.this.fzb != null) {
                            NewWriteModel.this.fzb.a(true, dVar.getErrorString(), null, null, dVar.aws());
                        }
                    } else {
                        if (!StringUtils.isNull(dVar.getPreMsg()) && !StringUtils.isNull(dVar.getColorMsg())) {
                            str = dVar.getPreMsg();
                            bjy = dVar.getColorMsg();
                        } else if (StringUtils.isNull(dVar.bjy()) && StringUtils.isNull(dVar.bjx())) {
                            bjy = null;
                        } else {
                            str = dVar.bjx();
                            bjy = dVar.bjy();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), str, bjy);
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.fzc.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, dVar.aws());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                handleRequestFail(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bnt != null) {
                this.bnt.cancel();
            }
            if (NewWriteModel.this.fzc == null) {
                if (NewWriteModel.this.fzb != null) {
                    NewWriteModel.this.fzb.a(false, null, null, null, null);
                }
            } else {
                NewWriteModel.this.fzc.callback(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.fyW = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData aws = dVar.aws();
            if (dVar.bjv()) {
                q qVar = new q();
                qVar.parserJson(this.mRetData);
                if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                    if (NewWriteModel.this.fzc == null) {
                        if (NewWriteModel.this.fzb != null) {
                            NewWriteModel.this.fzb.a(false, dVar.getErrorString(), qVar, NewWriteModel.this.mData, aws);
                            return;
                        }
                        return;
                    }
                    NewWriteModel.this.fzc.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), qVar, NewWriteModel.this.mData, aws);
                }
            } else if (!dVar.bjw()) {
                if (NewWriteModel.this.fzc == null) {
                    if (NewWriteModel.this.fzb != null) {
                        NewWriteModel.this.fzb.a(false, dVar.getErrorString(), null, null, dVar.aws());
                        return;
                    }
                    return;
                }
                NewWriteModel.this.fzc.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.aws());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.mRetData);
                if (NewWriteModel.this.fzc == null) {
                    if (NewWriteModel.this.fzb != null) {
                        NewWriteModel.this.fzb.a(false, dVar.getErrorString(), null, NewWriteModel.this.mData, aws);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                NewWriteModel.this.fzc.callback(false, postWriteCallBackData, null, NewWriteModel.this.mData, aws);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bnt = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aKj = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean di = l.di(NewWriteModel.this.bns);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.fyZ == null || NewWriteModel.this.fyZ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bns) || !di) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bns);
                NewWriteModel.this.fyY = l.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.fyY)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fyY, this.bnt);
            }
            this.aKj = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.fyZ);
            if (this.aKj != null) {
                NewWriteModel.this.fyY = l.a(TbConfig.IMAGE_RESIZED_FILE, this.aKj, 80);
                if (TextUtils.isEmpty(NewWriteModel.this.fyY)) {
                    if (this.aKj == null || this.aKj.isRecycled()) {
                        return null;
                    }
                    this.aKj.recycle();
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fyY, this.bnt);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bnt != null) {
                this.bnt.cancel();
            }
            if (NewWriteModel.this.fza != null) {
                NewWriteModel.this.fza.a(null, true);
            }
            if (this.aKj != null && !this.aKj.isRecycled()) {
                this.aKj.recycle();
            }
            super.cancel();
            NewWriteModel.this.fyX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.fza != null) {
                    NewWriteModel.this.fza.a(imageUploadResult, false);
                }
                if (this.aKj != null && !this.aKj.isRecycled()) {
                    this.aKj.recycle();
                }
            }
        }
    }

    public void XK() {
        if (this.fyX == null) {
            this.fyX = new a();
            this.fyX.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.fyZ = bArr;
        this.bns = str;
    }

    public void a(b bVar) {
        this.fza = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.M(av.wa().wg(), av.wa().wg()));
        return aVar.d(imageFileInfo, true);
    }
}
