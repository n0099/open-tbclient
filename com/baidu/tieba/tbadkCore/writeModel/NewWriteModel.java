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
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
    private String bqg;
    private b fxA;
    private c fxB;
    private d fxC;
    private boolean fxD;
    private a.InterfaceC0079a fxE;
    private e fxw;
    private a fxx;
    private String fxy;
    private byte[] fxz;
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
        this.fxw = null;
        this.fxx = null;
        this.mData = null;
        this.fxy = null;
        this.bqg = null;
        this.fxz = null;
        this.fxB = null;
        this.fxC = null;
        this.fxD = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fxw = null;
        this.fxx = null;
        this.mData = null;
        this.fxy = null;
        this.bqg = null;
        this.fxz = null;
        this.fxB = null;
        this.fxC = null;
        this.fxD = false;
        this.mPageContext = tbPageContext;
    }

    public void lc(boolean z) {
        this.fxD = z;
    }

    public void b(d dVar) {
        this.fxC = dVar;
    }

    public void a(c cVar) {
        this.fxB = cVar;
    }

    public void a(a.InterfaceC0079a interfaceC0079a) {
        this.fxE = interfaceC0079a;
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
        if (!i.hk() || i.hl() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.bX(w.l.original_img_up_no_wifi_tip);
            aVar.a(w.l.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(w.l.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.mPageContext);
            aVar.td();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.fxw == null) {
            this.fxw = new e();
            this.fxw.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fxw != null && !this.fxw.isCancelled()) {
            this.fxw.cancel();
        } else if (this.fxC != null) {
            this.fxC.callback(false, null, null, null, null);
        } else if (this.fxB != null) {
            this.fxB.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fxw != null && !this.fxw.isCancelled()) {
            this.fxw.cancel();
            return false;
        }
        return false;
    }

    public void RJ() {
        if (this.fxx != null && !this.fxx.isCancelled()) {
            this.fxx.cancel();
        }
    }

    public boolean bhS() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a bqh = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
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
            this.bqh = new com.baidu.tieba.tbadkCore.c.a();
            this.bqh.a(NewWriteModel.this.fxE);
            this.mRetData = this.bqh.a(NewWriteModel.this.mData, NewWriteModel.this.fxD);
            ErrorData errorData = this.bqh.getErrorData();
            if (this.bqh.isRequestSuccess() && this.mRetData != null) {
                AntiData bhb = this.bqh.bhb();
                String error_msg = errorData.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, bhb);
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
                                                        dVar.qn(str8);
                                                        dVar.qo(str7);
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
                dVar.qn(str8);
                dVar.qo(str7);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            String bhW;
            String str = null;
            super.onPostExecute((e) dVar);
            NewWriteModel.this.fxw = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.isCanceled && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.c.b(NewWriteModel.this.mData);
                    if (NewWriteModel.this.fxC == null) {
                        if (NewWriteModel.this.fxB != null) {
                            NewWriteModel.this.fxB.a(true, dVar.getErrorString(), null, null, dVar.aup());
                        }
                    } else {
                        if (!StringUtils.isNull(dVar.getPreMsg()) && !StringUtils.isNull(dVar.getColorMsg())) {
                            str = dVar.getPreMsg();
                            bhW = dVar.getColorMsg();
                        } else if (StringUtils.isNull(dVar.bhW()) && StringUtils.isNull(dVar.bhV())) {
                            bhW = null;
                        } else {
                            str = dVar.bhV();
                            bhW = dVar.bhW();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), str, bhW);
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(dVar.getErrorString());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.fxC.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, dVar.aup());
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
            if (this.bqh != null) {
                this.bqh.cancel();
            }
            if (NewWriteModel.this.fxC == null) {
                if (NewWriteModel.this.fxB != null) {
                    NewWriteModel.this.fxB.a(false, null, null, null, null);
                }
            } else {
                NewWriteModel.this.fxC.callback(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.fxw = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData aup = dVar.aup();
            if (dVar.bhT()) {
                q qVar = new q();
                qVar.parserJson(this.mRetData);
                if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                    if (NewWriteModel.this.fxC == null) {
                        if (NewWriteModel.this.fxB != null) {
                            NewWriteModel.this.fxB.a(false, dVar.getErrorString(), qVar, NewWriteModel.this.mData, aup);
                            return;
                        }
                        return;
                    }
                    NewWriteModel.this.fxC.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), qVar, NewWriteModel.this.mData, aup);
                }
            } else if (!dVar.bhU()) {
                if (NewWriteModel.this.fxC == null) {
                    if (NewWriteModel.this.fxB != null) {
                        NewWriteModel.this.fxB.a(false, dVar.getErrorString(), null, null, dVar.aup());
                        return;
                    }
                    return;
                }
                NewWriteModel.this.fxC.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.aup());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.mRetData);
                if (NewWriteModel.this.fxC == null) {
                    if (NewWriteModel.this.fxB != null) {
                        NewWriteModel.this.fxB.a(false, dVar.getErrorString(), null, NewWriteModel.this.mData, aup);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                NewWriteModel.this.fxC.callback(false, postWriteCallBackData, null, NewWriteModel.this.mData, aup);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bqh = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aKu = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dg = l.dg(NewWriteModel.this.bqg);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.fxz == null || NewWriteModel.this.fxz.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bqg) || !dg) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bqg);
                NewWriteModel.this.fxy = l.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.fxy)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fxy, this.bqh);
            }
            this.aKu = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.fxz);
            if (this.aKu != null) {
                NewWriteModel.this.fxy = l.a(TbConfig.IMAGE_RESIZED_FILE, this.aKu, 80);
                if (TextUtils.isEmpty(NewWriteModel.this.fxy)) {
                    if (this.aKu == null || this.aKu.isRecycled()) {
                        return null;
                    }
                    this.aKu.recycle();
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fxy, this.bqh);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bqh != null) {
                this.bqh.cancel();
            }
            if (NewWriteModel.this.fxA != null) {
                NewWriteModel.this.fxA.a(null, true);
            }
            if (this.aKu != null && !this.aKu.isRecycled()) {
                this.aKu.recycle();
            }
            super.cancel();
            NewWriteModel.this.fxx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.fxA != null) {
                    NewWriteModel.this.fxA.a(imageUploadResult, false);
                }
                if (this.aKu != null && !this.aKu.isRecycled()) {
                    this.aKu.recycle();
                }
            }
        }
    }

    public void XC() {
        if (this.fxx == null) {
            this.fxx = new a();
            this.fxx.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.fxz = bArr;
        this.bqg = str;
    }

    public void a(b bVar) {
        this.fxA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.M(av.vo().vu(), av.vo().vu()));
        return aVar.d(imageFileInfo, true);
    }
}
