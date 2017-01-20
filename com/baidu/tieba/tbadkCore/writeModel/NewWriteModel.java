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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    public static final String THREAD_TYPE_LBS = "7";
    private String bgO;
    private e fsP;
    private a fsQ;
    private String fsR;
    private byte[] fsS;
    private b fsT;
    private c fsU;
    private d fsV;
    private boolean fsW;
    private a.InterfaceC0075a fsX;
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
        this.fsP = null;
        this.fsQ = null;
        this.mData = null;
        this.fsR = null;
        this.bgO = null;
        this.fsS = null;
        this.fsU = null;
        this.fsV = null;
        this.fsW = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fsP = null;
        this.fsQ = null;
        this.mData = null;
        this.fsR = null;
        this.bgO = null;
        this.fsS = null;
        this.fsU = null;
        this.fsV = null;
        this.fsW = false;
        this.mPageContext = tbPageContext;
    }

    public void lm(boolean z) {
        this.fsW = z;
    }

    public void b(d dVar) {
        this.fsV = dVar;
    }

    public void a(c cVar) {
        this.fsU = cVar;
    }

    public void a(a.InterfaceC0075a interfaceC0075a) {
        this.fsX = interfaceC0075a;
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
        if (!i.gk() || i.gl() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.ca(r.l.original_img_up_no_wifi_tip);
            aVar.a(r.l.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(r.l.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.mPageContext);
            aVar.sV();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.fsP == null) {
            this.fsP = new e();
            this.fsP.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fsP != null && !this.fsP.isCancelled()) {
            this.fsP.cancel();
        } else if (this.fsV != null) {
            this.fsV.callback(false, null, null, null, null);
        } else if (this.fsU != null) {
            this.fsU.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fsP != null && !this.fsP.isCancelled()) {
            this.fsP.cancel();
            return false;
        }
        return false;
    }

    public void PV() {
        if (this.fsQ != null && !this.fsQ.isCancelled()) {
            this.fsQ.cancel();
        }
    }

    public boolean biT() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a bgP = null;
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
            this.bgP = new com.baidu.tieba.tbadkCore.c.a();
            this.bgP.a(NewWriteModel.this.fsX);
            this.mRetData = this.bgP.a(NewWriteModel.this.mData, NewWriteModel.this.fsW);
            ErrorData errorData = this.bgP.getErrorData();
            if (this.bgP.isRequestSuccess() && this.mRetData != null) {
                AntiData bic = this.bgP.bic();
                String error_msg = errorData.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(r.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, bic);
                if (NewWriteModel.this.mData == null || !NewWriteModel.this.mData.isHasImages() || dVar2.hasError()) {
                    dVar = dVar2;
                } else {
                    NewWriteModel.this.mData.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (errorData != null && !StringUtils.isNull(errorData.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), errorData.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m9getInst().getApp().getString(r.l.neterror), null);
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
                                                        dVar.qU(str8);
                                                        dVar.qV(str7);
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
                    str5 = TbadkCoreApplication.m9getInst().getString(r.l.send_success);
                }
                dVar.setErrorString(str5);
                dVar.setPreMsg(str4);
                dVar.setColorMsg(str3);
                dVar.setThreadId(str2);
                dVar.setPostId(str);
                dVar.setIsCopyTWZhibo(i);
                dVar.qU(str8);
                dVar.qV(str7);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            String biX;
            String str = null;
            super.onPostExecute((e) dVar);
            NewWriteModel.this.fsP = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.isCanceled && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.c.b(NewWriteModel.this.mData);
                    if (NewWriteModel.this.fsV == null) {
                        if (NewWriteModel.this.fsU != null) {
                            NewWriteModel.this.fsU.a(true, dVar.getErrorString(), null, null, dVar.axd());
                        }
                    } else {
                        if (!StringUtils.isNull(dVar.getPreMsg()) && !StringUtils.isNull(dVar.getColorMsg())) {
                            str = dVar.getPreMsg();
                            biX = dVar.getColorMsg();
                        } else if (StringUtils.isNull(dVar.biX()) && StringUtils.isNull(dVar.biW())) {
                            biX = null;
                        } else {
                            str = dVar.biW();
                            biX = dVar.biX();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), str, biX);
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.fsV.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, dVar.axd());
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
            if (this.bgP != null) {
                this.bgP.cancel();
            }
            if (NewWriteModel.this.fsV == null) {
                if (NewWriteModel.this.fsU != null) {
                    NewWriteModel.this.fsU.a(false, null, null, null, null);
                }
            } else {
                NewWriteModel.this.fsV.callback(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.fsP = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData axd = dVar.axd();
            if (dVar.biU()) {
                q qVar = new q();
                qVar.parserJson(this.mRetData);
                if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                    if (NewWriteModel.this.fsV == null) {
                        if (NewWriteModel.this.fsU != null) {
                            NewWriteModel.this.fsU.a(false, dVar.getErrorString(), qVar, NewWriteModel.this.mData, axd);
                            return;
                        }
                        return;
                    }
                    NewWriteModel.this.fsV.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), qVar, NewWriteModel.this.mData, axd);
                }
            } else if (!dVar.biV()) {
                if (NewWriteModel.this.fsV == null) {
                    if (NewWriteModel.this.fsU != null) {
                        NewWriteModel.this.fsU.a(false, dVar.getErrorString(), null, null, dVar.axd());
                        return;
                    }
                    return;
                }
                NewWriteModel.this.fsV.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.axd());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.mRetData);
                if (NewWriteModel.this.fsV == null) {
                    if (NewWriteModel.this.fsU != null) {
                        NewWriteModel.this.fsU.a(false, dVar.getErrorString(), null, NewWriteModel.this.mData, axd);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                NewWriteModel.this.fsV.callback(false, postWriteCallBackData, null, NewWriteModel.this.mData, axd);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bgP = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aEw = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean di = l.di(NewWriteModel.this.bgO);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.fsS == null || NewWriteModel.this.fsS.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bgO) || !di) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bgO);
                NewWriteModel.this.fsR = l.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.fsR)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fsR, this.bgP);
            }
            this.aEw = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.fsS);
            if (this.aEw != null) {
                NewWriteModel.this.fsR = l.a(TbConfig.IMAGE_RESIZED_FILE, this.aEw, 80);
                if (TextUtils.isEmpty(NewWriteModel.this.fsR)) {
                    if (this.aEw == null || this.aEw.isRecycled()) {
                        return null;
                    }
                    this.aEw.recycle();
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fsR, this.bgP);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bgP != null) {
                this.bgP.cancel();
            }
            if (NewWriteModel.this.fsT != null) {
                NewWriteModel.this.fsT.a(null, true);
            }
            if (this.aEw != null && !this.aEw.isRecycled()) {
                this.aEw.recycle();
            }
            super.cancel();
            NewWriteModel.this.fsQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.fsT != null) {
                    NewWriteModel.this.fsT.a(imageUploadResult, false);
                }
                if (this.aEw != null && !this.aEw.isRecycled()) {
                    this.aEw.recycle();
                }
            }
        }
    }

    public void Wo() {
        if (this.fsQ == null) {
            this.fsQ = new a();
            this.fsQ.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fsS = bArr;
        this.bgO = str;
    }

    public void a(b bVar) {
        this.fsT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.G(au.vg().vm(), au.vg().vm()));
        return aVar.d(imageFileInfo, true);
    }
}
