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
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    public static final String THREAD_TYPE_LBS = "7";
    private String bML;
    private a.InterfaceC0125a gjS;
    private String gsA;
    private byte[] gsB;
    private b gsC;
    private c gsD;
    private d gsE;
    private boolean gsF;
    private e gsy;
    private a gsz;
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
        this.gsy = null;
        this.gsz = null;
        this.mData = null;
        this.gsA = null;
        this.bML = null;
        this.gsB = null;
        this.gsD = null;
        this.gsE = null;
        this.gsF = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gsy = null;
        this.gsz = null;
        this.mData = null;
        this.gsA = null;
        this.bML = null;
        this.gsB = null;
        this.gsD = null;
        this.gsE = null;
        this.gsF = false;
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.gsy = null;
        this.gsz = null;
        this.mData = null;
        this.gsA = null;
        this.bML = null;
        this.gsB = null;
        this.gsD = null;
        this.gsE = null;
        this.gsF = false;
        this.mPageContext = null;
    }

    public void mB(boolean z) {
        this.gsF = z;
    }

    public void b(d dVar) {
        this.gsE = dVar;
    }

    public void a(c cVar) {
        this.gsD = cVar;
    }

    public void a(a.InterfaceC0125a interfaceC0125a) {
        this.gjS = interfaceC0125a;
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
            aVar.cc(d.j.original_img_up_no_wifi_tip);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dealPost();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
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
        if (this.gsy == null) {
            this.gsy = new e();
            this.gsy.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.gsy != null && !this.gsy.isCancelled()) {
            this.gsy.cancel();
        } else if (this.gsE != null) {
            this.gsE.callback(false, null, null, null, null);
        } else if (this.gsD != null) {
            this.gsD.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gsy != null && !this.gsy.isCancelled()) {
            this.gsy.cancel();
            return false;
        }
        return false;
    }

    public void YC() {
        if (this.gsz != null && !this.gsz.isCancelled()) {
            this.gsz.cancel();
        }
    }

    public boolean bvz() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tieba.tbadkCore.c.a bMM = null;
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
            JSONArray jSONArray;
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
            com.baidu.tbadk.imageManager.d.gp(NewWriteModel.this.mData.getContent());
            this.bMM = new com.baidu.tieba.tbadkCore.c.a();
            this.bMM.a(NewWriteModel.this.gjS);
            this.mRetData = this.bMM.a(NewWriteModel.this.mData, NewWriteModel.this.gsF);
            ErrorData errorData = this.bMM.getErrorData();
            if (this.bMM.isRequestSuccess() && this.mRetData != null) {
                AntiData buJ = this.bMM.buJ();
                String error_msg = errorData.getError_msg();
                if (k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, buJ);
                if (NewWriteModel.this.mData != null && NewWriteModel.this.mData.isHasImages() && !bVar2.hasError()) {
                    NewWriteModel.this.mData.deleteUploadedTempImages();
                }
                bVar = bVar2;
            } else if (errorData != null && errorData.error_code == 220015) {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), errorData.getError_msg(), null);
                if (this.mRetData != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(this.mRetData).optJSONObject(LoginActivityConfig.INFO);
                        if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                            int length = jSONArray.length();
                            ArrayList<String> arrayList = new ArrayList<>();
                            for (int i2 = 0; i2 < length; i2++) {
                                arrayList.add(jSONArray.optString(i2));
                            }
                            bVar.setSensitiveWords(arrayList);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (errorData != null && errorData.error_code != 0) {
                String error_msg2 = errorData.getError_msg();
                if (StringUtils.isNull(error_msg2)) {
                    error_msg2 = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                }
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, null);
            } else {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.getInst().getApp().getString(d.j.neterror), null);
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
                                            CustomDialogData I = com.baidu.tieba.pb.b.I(jSONObject);
                                            try {
                                                JSONObject optJSONObject2 = jSONObject.optJSONObject("twzhibo_info");
                                                i = optJSONObject2 != null ? optJSONObject2.optInt("is_copytwzhibo", 0) : 0;
                                                try {
                                                    JSONObject optJSONObject3 = jSONObject.optJSONObject("exp");
                                                    if (optJSONObject3 != null) {
                                                        String optString = optJSONObject3.optString("pre_msg");
                                                        try {
                                                            str7 = optJSONObject3.optString("color_msg");
                                                            str = optString;
                                                            customDialogData = I;
                                                        } catch (JSONException e3) {
                                                            e = e3;
                                                            str = optString;
                                                            customDialogData = I;
                                                            e.printStackTrace();
                                                            if (StringUtils.isNull(str6)) {
                                                            }
                                                            bVar.setErrorString(str6);
                                                            bVar.setPreMsg(str5);
                                                            bVar.setColorMsg(str4);
                                                            bVar.setThreadId(str3);
                                                            bVar.setPostId(str2);
                                                            bVar.setIsCopyTWZhibo(i);
                                                            bVar.sL(str);
                                                            bVar.sM(str7);
                                                            bVar.setActivityDialog(customDialogData);
                                                            return bVar;
                                                        }
                                                    } else {
                                                        customDialogData = I;
                                                        str = null;
                                                    }
                                                } catch (JSONException e4) {
                                                    e = e4;
                                                    customDialogData = I;
                                                    str = null;
                                                }
                                            } catch (JSONException e5) {
                                                e = e5;
                                                i = 0;
                                                customDialogData = I;
                                                str = null;
                                            }
                                        } catch (JSONException e6) {
                                            e = e6;
                                            str = null;
                                            i = 0;
                                            customDialogData = null;
                                        }
                                    } catch (JSONException e7) {
                                        e = e7;
                                        str = null;
                                        str2 = null;
                                        i = 0;
                                        customDialogData = null;
                                    }
                                } catch (JSONException e8) {
                                    e = e8;
                                    str = null;
                                    str2 = null;
                                    str3 = null;
                                    i = 0;
                                    customDialogData = null;
                                }
                            } catch (JSONException e9) {
                                e = e9;
                                str = null;
                                str2 = null;
                                str3 = null;
                                str4 = null;
                                i = 0;
                                customDialogData = null;
                            }
                        } catch (JSONException e10) {
                            e = e10;
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
                } catch (JSONException e11) {
                    e = e11;
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
                    str6 = TbadkCoreApplication.getInst().getString(d.j.send_success);
                }
                bVar.setErrorString(str6);
                bVar.setPreMsg(str5);
                bVar.setColorMsg(str4);
                bVar.setThreadId(str3);
                bVar.setPostId(str2);
                bVar.setIsCopyTWZhibo(i);
                bVar.sL(str);
                bVar.sM(str7);
                bVar.setActivityDialog(customDialogData);
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String bvE;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.gsy = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.gsE == null) {
                        if (NewWriteModel.this.gsD != null) {
                            NewWriteModel.this.gsD.a(true, bVar.getErrorString(), null, null, bVar.aEB());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            bvE = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.bvE()) && StringUtils.isNull(bVar.bvD())) {
                            bvE = null;
                        } else {
                            str = bVar.bvD();
                            bvE = bVar.bvE();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, bvE);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.gsE.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, bVar.aEB());
                        CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.mData != null) {
                                switch (NewWriteModel.this.mData.getType()) {
                                    case 0:
                                    case 4:
                                    case 6:
                                    case 7:
                                    case 9:
                                        activityDialog.type = 2;
                                        break;
                                    case 1:
                                    case 2:
                                        activityDialog.type = 1;
                                        break;
                                }
                            }
                            com.baidu.tieba.pb.b.a(2000, activityDialog);
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
            if (this.bMM != null) {
                this.bMM.cancel();
            }
            if (NewWriteModel.this.gsE != null) {
                NewWriteModel.this.gsE.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.gsD != null) {
                NewWriteModel.this.gsD.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.gsy = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (bVar.bvB()) {
                NewWriteModel.this.a(bVar);
            } else if (bVar.bvA()) {
                q qVar = new q();
                qVar.parserJson(this.mRetData);
                if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                    NewWriteModel.this.a(bVar, null, qVar, NewWriteModel.this.mData);
                }
            } else if (bVar.bvC()) {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.mRetData);
                NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mData);
            } else if (bVar.isSensitiveError()) {
                NewWriteModel.this.a(bVar);
            } else {
                NewWriteModel.this.a(bVar);
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
            if (this.gsE != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                this.gsE.callback(false, postWriteCallBackData, qVar, writeData, bVar.aEB());
            } else if (this.gsD != null) {
                this.gsD.a(false, bVar.getErrorString(), qVar, writeData, bVar.aEB());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bMM = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aNG = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dz = com.baidu.tbadk.core.util.k.dz(NewWriteModel.this.bML);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.gsB == null || NewWriteModel.this.gsB.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bML) || !dz) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bML);
                NewWriteModel.this.gsA = com.baidu.tbadk.core.util.k.b(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.gsA)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.gsA, this.bMM);
            }
            this.aNG = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.gsB);
            if (this.aNG != null) {
                NewWriteModel.this.gsA = com.baidu.tbadk.core.util.k.a(TbConfig.IMAGE_RESIZED_FILE, this.aNG, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.gsA)) {
                    return NewWriteModel.this.a(NewWriteModel.this.gsA, this.bMM);
                }
                if (this.aNG == null || this.aNG.isRecycled()) {
                    return null;
                }
                this.aNG.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bMM != null) {
                this.bMM.cancel();
            }
            if (NewWriteModel.this.gsC != null) {
                NewWriteModel.this.gsC.a(null, true);
            }
            if (this.aNG != null && !this.aNG.isRecycled()) {
                this.aNG.recycle();
            }
            super.cancel();
            NewWriteModel.this.gsz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.gsC != null) {
                    NewWriteModel.this.gsC.a(imageUploadResult, false);
                }
                if (this.aNG != null && !this.aNG.isRecycled()) {
                    this.aNG.recycle();
                }
            }
        }
    }

    public void agt() {
        if (this.gsz == null) {
            this.gsz = new a();
            this.gsz.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.gsB = bArr;
        this.bML = str;
    }

    public void a(b bVar) {
        this.gsC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(an.vs().vy(), an.vs().vz()));
        return aVar.e(imageFileInfo, true);
    }
}
