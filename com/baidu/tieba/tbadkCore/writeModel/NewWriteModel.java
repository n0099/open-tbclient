package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.CustomDialogData;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    public static final String THREAD_TYPE_LBS = "7";
    private String bFC;
    private a.InterfaceC0125a gbf;
    private e gjN;
    private a gjO;
    private String gjP;
    private byte[] gjQ;
    private b gjR;
    private c gjS;
    private d gjT;
    private boolean gjU;
    private WriteData mData;
    private final com.baidu.adp.base.e<?> mPageContext;

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
        this.gjN = null;
        this.gjO = null;
        this.mData = null;
        this.gjP = null;
        this.bFC = null;
        this.gjQ = null;
        this.gjS = null;
        this.gjT = null;
        this.gjU = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjN = null;
        this.gjO = null;
        this.mData = null;
        this.gjP = null;
        this.bFC = null;
        this.gjQ = null;
        this.gjS = null;
        this.gjT = null;
        this.gjU = false;
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.gjN = null;
        this.gjO = null;
        this.mData = null;
        this.gjP = null;
        this.bFC = null;
        this.gjQ = null;
        this.gjS = null;
        this.gjT = null;
        this.gjU = false;
        this.mPageContext = null;
    }

    public void mF(boolean z) {
        this.gjU = z;
    }

    public void b(d dVar) {
        this.gjT = dVar;
    }

    public void a(c cVar) {
        this.gjS = cVar;
    }

    public void a(a.InterfaceC0125a interfaceC0125a) {
        this.gbf = interfaceC0125a;
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
        if (!j.hh() || j.hi() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_up_tip", true);
            if (this.mPageContext == null) {
                dealPost();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.cc(d.l.original_img_up_no_wifi_tip);
            aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dealPost();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.mPageContext);
            aVar.tb();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.gjN == null) {
            this.gjN = new e();
            this.gjN.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.gjN != null && !this.gjN.isCancelled()) {
            this.gjN.cancel();
        } else if (this.gjT != null) {
            this.gjT.callback(false, null, null, null, null);
        } else if (this.gjS != null) {
            this.gjS.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gjN != null && !this.gjN.isCancelled()) {
            this.gjN.cancel();
            return false;
        }
        return false;
    }

    public void Wu() {
        if (this.gjO != null && !this.gjO.isCancelled()) {
            this.gjO.cancel();
        }
    }

    public boolean bsv() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tieba.tbadkCore.c.a bFD = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            JSONException e;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            int i;
            CustomDialogData customDialogData;
            String str7 = null;
            if (this.isCanceled) {
                return null;
            }
            com.baidu.tbadk.imageManager.d.gi(NewWriteModel.this.mData.getContent());
            this.bFD = new com.baidu.tieba.tbadkCore.c.a();
            this.bFD.a(NewWriteModel.this.gbf);
            this.mRetData = this.bFD.a(NewWriteModel.this.mData, NewWriteModel.this.gjU);
            ErrorData errorData = this.bFD.getErrorData();
            if (this.bFD.isRequestSuccess() && this.mRetData != null) {
                AntiData brF = this.bFD.brF();
                String error_msg = errorData.getError_msg();
                if (k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, brF);
                if (NewWriteModel.this.mData != null && NewWriteModel.this.mData.isHasImages() && !bVar2.hasError()) {
                    NewWriteModel.this.mData.deleteUploadedTempImages();
                }
                bVar = bVar2;
            } else if (errorData != null && errorData.error_code != 0) {
                String error_msg2 = errorData.getError_msg();
                if (StringUtils.isNull(error_msg2)) {
                    error_msg2 = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                }
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, null);
            } else {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.getInst().getApp().getString(d.l.neterror), null);
            }
            if (!bVar.hasError()) {
                try {
                    if (this.mRetData != null) {
                        JSONObject jSONObject = new JSONObject(this.mRetData);
                        str6 = jSONObject.optString(AddFriendActivityConfig.MSG);
                        try {
                            str5 = jSONObject.optString("pre_msg");
                            try {
                                str4 = jSONObject.optString("color_msg");
                                try {
                                    str3 = jSONObject.optString("tid");
                                    try {
                                        str2 = jSONObject.optString(Info.kBaiduPIDKey);
                                        try {
                                            CustomDialogData H = com.baidu.tieba.pb.b.H(jSONObject);
                                            try {
                                                JSONObject optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                                                i = optJSONObject != null ? optJSONObject.optInt("is_copytwzhibo", 0) : 0;
                                                try {
                                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                                    if (optJSONObject2 != null) {
                                                        String optString = optJSONObject2.optString("pre_msg");
                                                        try {
                                                            str7 = optJSONObject2.optString("color_msg");
                                                            str = optString;
                                                            customDialogData = H;
                                                        } catch (JSONException e2) {
                                                            e = e2;
                                                            str = optString;
                                                            customDialogData = H;
                                                            e.printStackTrace();
                                                            if (StringUtils.isNull(str6)) {
                                                            }
                                                            bVar.setErrorString(str6);
                                                            bVar.setPreMsg(str5);
                                                            bVar.setColorMsg(str4);
                                                            bVar.setThreadId(str3);
                                                            bVar.setPostId(str2);
                                                            bVar.setIsCopyTWZhibo(i);
                                                            bVar.sd(str);
                                                            bVar.se(str7);
                                                            bVar.setActivityDialog(customDialogData);
                                                            return bVar;
                                                        }
                                                    } else {
                                                        customDialogData = H;
                                                        str = null;
                                                    }
                                                } catch (JSONException e3) {
                                                    e = e3;
                                                    customDialogData = H;
                                                    str = null;
                                                }
                                            } catch (JSONException e4) {
                                                e = e4;
                                                i = 0;
                                                customDialogData = H;
                                                str = null;
                                            }
                                        } catch (JSONException e5) {
                                            e = e5;
                                            str = null;
                                            i = 0;
                                            customDialogData = null;
                                        }
                                    } catch (JSONException e6) {
                                        e = e6;
                                        str = null;
                                        str2 = null;
                                        i = 0;
                                        customDialogData = null;
                                    }
                                } catch (JSONException e7) {
                                    e = e7;
                                    str = null;
                                    str2 = null;
                                    str3 = null;
                                    i = 0;
                                    customDialogData = null;
                                }
                            } catch (JSONException e8) {
                                e = e8;
                                str = null;
                                str2 = null;
                                str3 = null;
                                str4 = null;
                                i = 0;
                                customDialogData = null;
                            }
                        } catch (JSONException e9) {
                            e = e9;
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            i = 0;
                            customDialogData = null;
                        }
                    } else {
                        i = 0;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        customDialogData = null;
                    }
                } catch (JSONException e10) {
                    e = e10;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    i = 0;
                    customDialogData = null;
                }
                if (StringUtils.isNull(str6)) {
                    str6 = TbadkCoreApplication.getInst().getString(d.l.send_success);
                }
                bVar.setErrorString(str6);
                bVar.setPreMsg(str5);
                bVar.setColorMsg(str4);
                bVar.setThreadId(str3);
                bVar.setPostId(str2);
                bVar.setIsCopyTWZhibo(i);
                bVar.sd(str);
                bVar.se(str7);
                bVar.setActivityDialog(customDialogData);
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String bsA;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.gjN = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.gjT == null) {
                        if (NewWriteModel.this.gjS != null) {
                            NewWriteModel.this.gjS.a(true, bVar.getErrorString(), null, null, bVar.aCg());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            bsA = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.bsA()) && StringUtils.isNull(bVar.bsz())) {
                            bsA = null;
                        } else {
                            str = bVar.bsz();
                            bsA = bVar.bsA();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, bsA);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.gjT.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, bVar.aCg());
                        if (postWriteCallBackData.getActivityDialog() != null) {
                            com.baidu.tieba.pb.b.a(2000, postWriteCallBackData.getActivityDialog());
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                handleRequestFail(bVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bFD != null) {
                this.bFD.cancel();
            }
            if (NewWriteModel.this.gjT != null) {
                NewWriteModel.this.gjT.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.gjS != null) {
                NewWriteModel.this.gjS.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.gjN = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (bVar.bsx()) {
                NewWriteModel.this.a(bVar);
            } else if (bVar.bsw()) {
                q qVar = new q();
                qVar.parserJson(this.mRetData);
                if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                    NewWriteModel.this.a(bVar, null, qVar, NewWriteModel.this.mData);
                }
            } else if (!bVar.bsy()) {
                NewWriteModel.this.a(bVar);
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.mRetData);
                NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        a(bVar, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, q qVar, WriteData writeData) {
        if (bVar != null) {
            if (this.gjT != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                this.gjT.callback(false, postWriteCallBackData, qVar, writeData, bVar.aCg());
            } else if (this.gjS != null) {
                this.gjS.a(false, bVar.getErrorString(), qVar, writeData, bVar.aCg());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bFD = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aNc = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean ds = com.baidu.tbadk.core.util.k.ds(NewWriteModel.this.bFC);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.gjQ == null || NewWriteModel.this.gjQ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bFC) || !ds) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bFC);
                NewWriteModel.this.gjP = com.baidu.tbadk.core.util.k.b(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.gjP)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.gjP, this.bFD);
            }
            this.aNc = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.gjQ);
            if (this.aNc != null) {
                NewWriteModel.this.gjP = com.baidu.tbadk.core.util.k.a(TbConfig.IMAGE_RESIZED_FILE, this.aNc, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.gjP)) {
                    return NewWriteModel.this.a(NewWriteModel.this.gjP, this.bFD);
                }
                if (this.aNc == null || this.aNc.isRecycled()) {
                    return null;
                }
                this.aNc.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bFD != null) {
                this.bFD.cancel();
            }
            if (NewWriteModel.this.gjR != null) {
                NewWriteModel.this.gjR.a(null, true);
            }
            if (this.aNc != null && !this.aNc.isRecycled()) {
                this.aNc.recycle();
            }
            super.cancel();
            NewWriteModel.this.gjO = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.gjR != null) {
                    NewWriteModel.this.gjR.a(imageUploadResult, false);
                }
                if (this.aNc != null && !this.aNc.isRecycled()) {
                    this.aNc.recycle();
                }
            }
        }
    }

    public void aem() {
        if (this.gjO == null) {
            this.gjO = new a();
            this.gjO.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.gjQ = bArr;
        this.bFC = str;
    }

    public void a(b bVar) {
        this.gjR = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(an.vl().vr(), an.vl().vr()));
        return aVar.e(imageFileInfo, true);
    }
}
