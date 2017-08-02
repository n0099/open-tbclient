package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
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
    private String bzj;
    private a.InterfaceC0120a gbf;
    private e gjR;
    private a gjS;
    private String gjT;
    private byte[] gjU;
    private b gjV;
    private c gjW;
    private d gjX;
    private boolean gjY;
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
        this.gjR = null;
        this.gjS = null;
        this.mData = null;
        this.gjT = null;
        this.bzj = null;
        this.gjU = null;
        this.gjW = null;
        this.gjX = null;
        this.gjY = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjR = null;
        this.gjS = null;
        this.mData = null;
        this.gjT = null;
        this.bzj = null;
        this.gjU = null;
        this.gjW = null;
        this.gjX = null;
        this.gjY = false;
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.gjR = null;
        this.gjS = null;
        this.mData = null;
        this.gjT = null;
        this.bzj = null;
        this.gjU = null;
        this.gjW = null;
        this.gjX = null;
        this.gjY = false;
        this.mPageContext = null;
    }

    public void mC(boolean z) {
        this.gjY = z;
    }

    public void b(d dVar) {
        this.gjX = dVar;
    }

    public void a(c cVar) {
        this.gjW = cVar;
    }

    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.gbf = interfaceC0120a;
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
        if (!i.hh() || i.hi() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_up_tip", true);
            if (this.mPageContext == null) {
                dealPost();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.ca(d.l.original_img_up_no_wifi_tip);
            aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dealPost();
                }
            });
            aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.mPageContext);
            aVar.th();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.gjR == null) {
            this.gjR = new e();
            this.gjR.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.gjR != null && !this.gjR.isCancelled()) {
            this.gjR.cancel();
        } else if (this.gjX != null) {
            this.gjX.callback(false, null, null, null, null);
        } else if (this.gjW != null) {
            this.gjW.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gjR != null && !this.gjR.isCancelled()) {
            this.gjR.cancel();
            return false;
        }
        return false;
    }

    public void Uu() {
        if (this.gjS != null && !this.gjS.isCancelled()) {
            this.gjS.cancel();
        }
    }

    public boolean btx() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tieba.tbadkCore.c.a bzk = null;
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
            com.baidu.tbadk.imageManager.d.gl(NewWriteModel.this.mData.getContent());
            this.bzk = new com.baidu.tieba.tbadkCore.c.a();
            this.bzk.a(NewWriteModel.this.gbf);
            this.mRetData = this.bzk.a(NewWriteModel.this.mData, NewWriteModel.this.gjY);
            ErrorData errorData = this.bzk.getErrorData();
            if (this.bzk.isRequestSuccess() && this.mRetData != null) {
                AntiData bsG = this.bzk.bsG();
                String error_msg = errorData.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, bsG);
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
                                            CustomDialogData H = com.baidu.tieba.pb.c.H(jSONObject);
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
                                                            bVar.sl(str);
                                                            bVar.sm(str7);
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
                bVar.sl(str);
                bVar.sm(str7);
                bVar.setActivityDialog(customDialogData);
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String btC;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.gjR = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    com.baidu.tieba.graffiti.b.b(NewWriteModel.this.mData);
                    if (NewWriteModel.this.gjX == null) {
                        if (NewWriteModel.this.gjW != null) {
                            NewWriteModel.this.gjW.a(true, bVar.getErrorString(), null, null, bVar.aAK());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            btC = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.btC()) && StringUtils.isNull(bVar.btB())) {
                            btC = null;
                        } else {
                            str = bVar.btB();
                            btC = bVar.btC();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, btC);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.gjX.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, bVar.aAK());
                        if (postWriteCallBackData.getActivityDialog() != null) {
                            com.baidu.tieba.pb.c.a(2000, postWriteCallBackData.getActivityDialog());
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
            if (this.bzk != null) {
                this.bzk.cancel();
            }
            if (NewWriteModel.this.gjX != null) {
                NewWriteModel.this.gjX.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.gjW != null) {
                NewWriteModel.this.gjW.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.gjR = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (bVar.btz()) {
                NewWriteModel.this.a(bVar);
            } else if (bVar.bty()) {
                q qVar = new q();
                qVar.parserJson(this.mRetData);
                if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                    NewWriteModel.this.a(bVar, null, qVar, NewWriteModel.this.mData);
                }
            } else if (!bVar.btA()) {
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
            if (this.gjX != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                this.gjX.callback(false, postWriteCallBackData, qVar, writeData, bVar.aAK());
            } else if (this.gjW != null) {
                this.gjW.a(false, bVar.getErrorString(), qVar, writeData, bVar.aAK());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bzk = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aME = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dA = k.dA(NewWriteModel.this.bzj);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.gjU == null || NewWriteModel.this.gjU.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bzj) || !dA) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bzj);
                NewWriteModel.this.gjT = k.b(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.gjT)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.gjT, this.bzk);
            }
            this.aME = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.gjU);
            if (this.aME != null) {
                NewWriteModel.this.gjT = k.a(TbConfig.IMAGE_RESIZED_FILE, this.aME, 80);
                if (!TextUtils.isEmpty(NewWriteModel.this.gjT)) {
                    return NewWriteModel.this.a(NewWriteModel.this.gjT, this.bzk);
                }
                if (this.aME == null || this.aME.isRecycled()) {
                    return null;
                }
                this.aME.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bzk != null) {
                this.bzk.cancel();
            }
            if (NewWriteModel.this.gjV != null) {
                NewWriteModel.this.gjV.a(null, true);
            }
            if (this.aME != null && !this.aME.isRecycled()) {
                this.aME.recycle();
            }
            super.cancel();
            NewWriteModel.this.gjS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.gjV != null) {
                    NewWriteModel.this.gjV.a(imageUploadResult, false);
                }
                if (this.aME != null && !this.aME.isRecycled()) {
                    this.aME.recycle();
                }
            }
        }
    }

    public void acZ() {
        if (this.gjS == null) {
            this.gjS = new a();
            this.gjS.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.gjU = bArr;
        this.bzj = str;
    }

    public void a(b bVar) {
        this.gjV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(am.vG().vM(), am.vG().vM()));
        return aVar.d(imageFileInfo, true);
    }
}
