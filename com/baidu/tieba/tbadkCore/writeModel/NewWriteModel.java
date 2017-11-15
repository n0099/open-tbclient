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
import com.baidu.tbadk.coreExtra.data.r;
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
    private String bMY;
    private a.InterfaceC0128a gkU;
    private e gtB;
    private a gtC;
    private String gtD;
    private byte[] gtE;
    private b gtF;
    private c gtG;
    private d gtH;
    private boolean gtI;
    private WriteData mData;
    private final com.baidu.adp.base.e<?> mPageContext;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, r rVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gtB = null;
        this.gtC = null;
        this.mData = null;
        this.gtD = null;
        this.bMY = null;
        this.gtE = null;
        this.gtG = null;
        this.gtH = null;
        this.gtI = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gtB = null;
        this.gtC = null;
        this.mData = null;
        this.gtD = null;
        this.bMY = null;
        this.gtE = null;
        this.gtG = null;
        this.gtH = null;
        this.gtI = false;
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.gtB = null;
        this.gtC = null;
        this.mData = null;
        this.gtD = null;
        this.bMY = null;
        this.gtE = null;
        this.gtG = null;
        this.gtH = null;
        this.gtI = false;
        this.mPageContext = null;
    }

    public void mJ(boolean z) {
        this.gtI = z;
    }

    public void b(d dVar) {
        this.gtH = dVar;
    }

    public void a(c cVar) {
        this.gtG = cVar;
    }

    public void a(a.InterfaceC0128a interfaceC0128a) {
        this.gkU = interfaceC0128a;
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
        if (this.gtB == null) {
            this.gtB = new e();
            this.gtB.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.gtB != null && !this.gtB.isCancelled()) {
            this.gtB.cancel();
        } else if (this.gtH != null) {
            this.gtH.callback(false, null, null, null, null);
        } else if (this.gtG != null) {
            this.gtG.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gtB != null && !this.gtB.isCancelled()) {
            this.gtB.cancel();
            return false;
        }
        return false;
    }

    public void YO() {
        if (this.gtC != null && !this.gtC.isCancelled()) {
            this.gtC.cancel();
        }
    }

    public boolean bvL() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tieba.tbadkCore.c.a bMZ = null;
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
            com.baidu.tbadk.imageManager.d.gq(NewWriteModel.this.mData.getContent());
            this.bMZ = new com.baidu.tieba.tbadkCore.c.a();
            this.bMZ.a(NewWriteModel.this.gkU);
            this.mRetData = this.bMZ.a(NewWriteModel.this.mData, NewWriteModel.this.gtI);
            ErrorData errorData = this.bMZ.getErrorData();
            if (this.bMZ.isRequestSuccess() && this.mRetData != null) {
                AntiData buV = this.bMZ.buV();
                String error_msg = errorData.getError_msg();
                if (k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, buV);
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
                                                            bVar.sR(str);
                                                            bVar.sS(str7);
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
                bVar.sR(str);
                bVar.sS(str7);
                bVar.setActivityDialog(customDialogData);
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String bvQ;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.gtB = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.gtH == null) {
                        if (NewWriteModel.this.gtG != null) {
                            NewWriteModel.this.gtG.a(true, bVar.getErrorString(), null, null, bVar.aEF());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            bvQ = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.bvQ()) && StringUtils.isNull(bVar.bvP())) {
                            bvQ = null;
                        } else {
                            str = bVar.bvP();
                            bvQ = bVar.bvQ();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, bvQ);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        r rVar = new r();
                        rVar.parserJson(this.mRetData);
                        NewWriteModel.this.gtH.callback(true, postWriteCallBackData, rVar, NewWriteModel.this.mData, bVar.aEF());
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
            if (this.bMZ != null) {
                this.bMZ.cancel();
            }
            if (NewWriteModel.this.gtH != null) {
                NewWriteModel.this.gtH.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.gtG != null) {
                NewWriteModel.this.gtG.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.gtB = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (bVar.bvN()) {
                NewWriteModel.this.a(bVar);
            } else if (bVar.bvM()) {
                r rVar = new r();
                rVar.parserJson(this.mRetData);
                if (rVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(rVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(rVar.getVcode_pic_url());
                    NewWriteModel.this.a(bVar, null, rVar, NewWriteModel.this.mData);
                }
            } else if (bVar.bvO()) {
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
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, r rVar, WriteData writeData) {
        if (bVar != null) {
            if (this.gtH != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                this.gtH.callback(false, postWriteCallBackData, rVar, writeData, bVar.aEF());
            } else if (this.gtG != null) {
                this.gtG.a(false, bVar.getErrorString(), rVar, writeData, bVar.aEF());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bMZ = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aNO = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dz = com.baidu.tbadk.core.util.k.dz(NewWriteModel.this.bMY);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.gtE == null || NewWriteModel.this.gtE.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bMY) || !dz) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bMY);
                NewWriteModel.this.gtD = com.baidu.tbadk.core.util.k.b(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.gtD)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.gtD, this.bMZ);
            }
            this.aNO = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.gtE);
            if (this.aNO != null) {
                NewWriteModel.this.gtD = com.baidu.tbadk.core.util.k.a(TbConfig.IMAGE_RESIZED_FILE, this.aNO, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.gtD)) {
                    return NewWriteModel.this.a(NewWriteModel.this.gtD, this.bMZ);
                }
                if (this.aNO == null || this.aNO.isRecycled()) {
                    return null;
                }
                this.aNO.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bMZ != null) {
                this.bMZ.cancel();
            }
            if (NewWriteModel.this.gtF != null) {
                NewWriteModel.this.gtF.a(null, true);
            }
            if (this.aNO != null && !this.aNO.isRecycled()) {
                this.aNO.recycle();
            }
            super.cancel();
            NewWriteModel.this.gtC = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.gtF != null) {
                    NewWriteModel.this.gtF.a(imageUploadResult, false);
                }
                if (this.aNO != null && !this.aNO.isRecycled()) {
                    this.aNO.recycle();
                }
            }
        }
    }

    public void agH() {
        if (this.gtC == null) {
            this.gtC = new a();
            this.gtC.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.gtE = bArr;
        this.bMY = str;
    }

    public void a(b bVar) {
        this.gtF = bVar;
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
