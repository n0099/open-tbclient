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
    private String brn;
    private e fFn;
    private a fFo;
    private String fFp;
    private byte[] fFq;
    private b fFr;
    private c fFs;
    private d fFt;
    private boolean fFu;
    private a.InterfaceC0081a fFv;
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
        this.fFn = null;
        this.fFo = null;
        this.mData = null;
        this.fFp = null;
        this.brn = null;
        this.fFq = null;
        this.fFs = null;
        this.fFt = null;
        this.fFu = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fFn = null;
        this.fFo = null;
        this.mData = null;
        this.fFp = null;
        this.brn = null;
        this.fFq = null;
        this.fFs = null;
        this.fFt = null;
        this.fFu = false;
        this.mPageContext = tbPageContext;
    }

    public void lx(boolean z) {
        this.fFu = z;
    }

    public void b(d dVar) {
        this.fFt = dVar;
    }

    public void a(c cVar) {
        this.fFs = cVar;
    }

    public void a(a.InterfaceC0081a interfaceC0081a) {
        this.fFv = interfaceC0081a;
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
        if (!i.hk() || i.hl() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.bY(w.l.original_img_up_no_wifi_tip);
            aVar.a(w.l.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(w.l.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.mPageContext);
            aVar.tc();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.fFn == null) {
            this.fFn = new e();
            this.fFn.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fFn != null && !this.fFn.isCancelled()) {
            this.fFn.cancel();
        } else if (this.fFt != null) {
            this.fFt.callback(false, null, null, null, null);
        } else if (this.fFs != null) {
            this.fFs.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fFn != null && !this.fFn.isCancelled()) {
            this.fFn.cancel();
            return false;
        }
        return false;
    }

    public void RV() {
        if (this.fFo != null && !this.fFo.isCancelled()) {
            this.fFo.cancel();
        }
    }

    public boolean bjm() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a bro = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
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
            this.bro = new com.baidu.tieba.tbadkCore.c.a();
            this.bro.a(NewWriteModel.this.fFv);
            this.mRetData = this.bro.a(NewWriteModel.this.mData, NewWriteModel.this.fFu);
            ErrorData errorData = this.bro.getErrorData();
            if (this.bro.isRequestSuccess() && this.mRetData != null) {
                AntiData biv = this.bro.biv();
                String error_msg = errorData.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, biv);
                if (NewWriteModel.this.mData == null || !NewWriteModel.this.mData.isHasImages() || dVar2.hasError()) {
                    dVar = dVar2;
                } else {
                    NewWriteModel.this.mData.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (errorData != null && errorData.error_code != 0) {
                String error_msg2 = errorData.getError_msg();
                if (StringUtils.isNull(error_msg2)) {
                    error_msg2 = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                }
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg2, null);
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
                                            JSONObject optJSONObject = jSONObject.optJSONObject("twzhibo_info");
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
                                                        dVar.qB(str8);
                                                        dVar.qC(str7);
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
                dVar.qB(str8);
                dVar.qC(str7);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            String bjr;
            String str = null;
            super.onPostExecute((e) dVar);
            NewWriteModel.this.fFn = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.isCanceled && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.c.b(NewWriteModel.this.mData);
                    if (NewWriteModel.this.fFt == null) {
                        if (NewWriteModel.this.fFs != null) {
                            NewWriteModel.this.fFs.a(true, dVar.getErrorString(), null, null, dVar.avj());
                        }
                    } else {
                        if (!StringUtils.isNull(dVar.getPreMsg()) && !StringUtils.isNull(dVar.getColorMsg())) {
                            str = dVar.getPreMsg();
                            bjr = dVar.getColorMsg();
                        } else if (StringUtils.isNull(dVar.bjr()) && StringUtils.isNull(dVar.bjq())) {
                            bjr = null;
                        } else {
                            str = dVar.bjq();
                            bjr = dVar.bjr();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), str, bjr);
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(dVar.getErrorString());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.fFt.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, dVar.avj());
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
            if (this.bro != null) {
                this.bro.cancel();
            }
            if (NewWriteModel.this.fFt == null) {
                if (NewWriteModel.this.fFs != null) {
                    NewWriteModel.this.fFs.a(false, null, null, null, null);
                }
            } else {
                NewWriteModel.this.fFt.callback(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.fFn = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            if (!dVar.bjo()) {
                if (dVar.bjn()) {
                    q qVar = new q();
                    qVar.parserJson(this.mRetData);
                    if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                        NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                        NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                        NewWriteModel.this.a(dVar, null, qVar, NewWriteModel.this.mData);
                        return;
                    }
                    return;
                } else if (dVar.bjp()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.mRetData);
                    NewWriteModel.this.a(dVar, accessState, null, NewWriteModel.this.mData);
                    return;
                } else {
                    NewWriteModel.this.a(dVar);
                    return;
                }
            }
            NewWriteModel.this.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
        a(dVar, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.d dVar, AccessState accessState, q qVar, WriteData writeData) {
        if (dVar != null) {
            if (this.fFt != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                this.fFt.callback(false, postWriteCallBackData, qVar, writeData, dVar.avj());
            } else if (this.fFs != null) {
                this.fFs.a(false, dVar.getErrorString(), qVar, writeData, dVar.avj());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bro = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aKh = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dd = l.dd(NewWriteModel.this.brn);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.fFq == null || NewWriteModel.this.fFq.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.brn) || !dd) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.brn);
                NewWriteModel.this.fFp = l.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.fFp)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fFp, this.bro);
            }
            this.aKh = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.fFq);
            if (this.aKh != null) {
                NewWriteModel.this.fFp = l.a(TbConfig.IMAGE_RESIZED_FILE, this.aKh, 80);
                if (TextUtils.isEmpty(NewWriteModel.this.fFp)) {
                    if (this.aKh == null || this.aKh.isRecycled()) {
                        return null;
                    }
                    this.aKh.recycle();
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fFp, this.bro);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bro != null) {
                this.bro.cancel();
            }
            if (NewWriteModel.this.fFr != null) {
                NewWriteModel.this.fFr.a(null, true);
            }
            if (this.aKh != null && !this.aKh.isRecycled()) {
                this.aKh.recycle();
            }
            super.cancel();
            NewWriteModel.this.fFo = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.fFr != null) {
                    NewWriteModel.this.fFr.a(imageUploadResult, false);
                }
                if (this.aKh != null && !this.aKh.isRecycled()) {
                    this.aKh.recycle();
                }
            }
        }
    }

    public void YF() {
        if (this.fFo == null) {
            this.fFo = new a();
            this.fFo.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.fFq = bArr;
        this.brn = str;
    }

    public void a(b bVar) {
        this.fFr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(av.vl().vr(), av.vl().vr()));
        return aVar.d(imageFileInfo, true);
    }
}
