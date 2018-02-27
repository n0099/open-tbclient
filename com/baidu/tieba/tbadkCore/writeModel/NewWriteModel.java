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
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    private String cRN;
    private e hdT;
    private a hdU;
    private String hdV;
    private byte[] hdW;
    private b hdX;
    private c hdY;
    private d hdZ;
    private boolean hea;
    private a.InterfaceC0235a heb;
    private WriteData mData;
    private final com.baidu.adp.base.e<?> mPageContext;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, t tVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hdT = null;
        this.hdU = null;
        this.mData = null;
        this.hdV = null;
        this.cRN = null;
        this.hdW = null;
        this.hdY = null;
        this.hdZ = null;
        this.hea = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hdT = null;
        this.hdU = null;
        this.mData = null;
        this.hdV = null;
        this.cRN = null;
        this.hdW = null;
        this.hdY = null;
        this.hdZ = null;
        this.hea = false;
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.hdT = null;
        this.hdU = null;
        this.mData = null;
        this.hdV = null;
        this.cRN = null;
        this.hdW = null;
        this.hdY = null;
        this.hdZ = null;
        this.hea = false;
        this.mPageContext = null;
    }

    public void mO(boolean z) {
        this.hea = z;
    }

    public void b(d dVar) {
        this.hdZ = dVar;
    }

    public void a(c cVar) {
        this.hdY = cVar;
    }

    public void a(a.InterfaceC0235a interfaceC0235a) {
        this.heb = interfaceC0235a;
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
        if (!j.oJ() || j.oK() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_up_tip", true);
            if (this.mPageContext == null) {
                dealPost();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.fb(d.j.original_img_up_no_wifi_tip);
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
            aVar.AU();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.hdT == null) {
            this.hdT = new e();
            this.hdT.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.hdT != null && !this.hdT.isCancelled()) {
            this.hdT.cancel();
        } else if (this.hdZ != null) {
            this.hdZ.callback(false, null, null, null, null);
        } else if (this.hdY != null) {
            this.hdY.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hdT != null && !this.hdT.isCancelled()) {
            this.hdT.cancel();
            return false;
        }
        return false;
    }

    public void akj() {
        if (this.hdU != null && !this.hdU.isCancelled()) {
            this.hdU.cancel();
        }
    }

    public boolean byc() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h hbC;
        private k hed;
        private com.baidu.tieba.tbadkCore.c.a cRO = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
            if (runTask != null) {
                this.hed = (k) runTask.getData();
            }
            if (this.hed != null) {
                this.hbC = this.hed.aXf();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0150  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            JSONArray jSONArray;
            if (!this.isCanceled) {
                com.baidu.tbadk.imageManager.d.gQ(NewWriteModel.this.mData.getContent());
                this.cRO = new com.baidu.tieba.tbadkCore.c.a();
                this.cRO.a(this.hbC);
                this.cRO.a(NewWriteModel.this.heb);
                this.mRetData = this.cRO.a(NewWriteModel.this.mData, NewWriteModel.this.hea);
                ErrorData errorData = this.cRO.getErrorData();
                if (this.cRO.isRequestSuccess() && this.mRetData != null) {
                    AntiData bxj = this.cRO.bxj();
                    String error_msg = errorData.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, bxj);
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
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                bVar.setSensitiveWords(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (errorData != null && errorData.error_code != 0) {
                    String error_msg2 = errorData.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        error_msg2 = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, this.cRO.bxj());
                } else {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.getInst().getApp().getString(d.j.neterror), null);
                }
                if (!bVar.hasError()) {
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    CustomDialogData customDialogData = null;
                    ContriInfo contriInfo = new ContriInfo();
                    int i2 = 0;
                    try {
                        if (this.mRetData != null) {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str = jSONObject.optString("msg");
                            str2 = jSONObject.optString("pre_msg");
                            str3 = jSONObject.optString("color_msg");
                            str4 = jSONObject.optString("tid");
                            str5 = jSONObject.optString(Info.kBaiduPIDKey);
                            str8 = jSONObject.optString("video_id");
                            customDialogData = com.baidu.tieba.pb.b.Q(jSONObject);
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("twzhibo_info");
                            if (optJSONObject2 != null) {
                                i2 = optJSONObject2.optInt("is_copytwzhibo", 0);
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("exp");
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString("pre_msg");
                                try {
                                    str7 = optJSONObject3.optString("color_msg");
                                    str6 = optString;
                                } catch (JSONException e2) {
                                    str6 = optString;
                                    e = e2;
                                    e.printStackTrace();
                                    if (StringUtils.isNull(str)) {
                                    }
                                    bVar.setErrorString(str);
                                    bVar.setPreMsg(str2);
                                    bVar.setColorMsg(str3);
                                    bVar.setThreadId(str4);
                                    bVar.setPostId(str5);
                                    bVar.setIsCopyTWZhibo(i2);
                                    bVar.tb(str6);
                                    bVar.tc(str7);
                                    bVar.setActivityDialog(customDialogData);
                                    bVar.setVideoId(str8);
                                    bVar.setContriInfo(contriInfo);
                                    return bVar;
                                }
                            }
                            contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                        }
                    } catch (JSONException e3) {
                        e = e3;
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.getInst().getString(d.j.send_success);
                    }
                    bVar.setErrorString(str);
                    bVar.setPreMsg(str2);
                    bVar.setColorMsg(str3);
                    bVar.setThreadId(str4);
                    bVar.setPostId(str5);
                    bVar.setIsCopyTWZhibo(i2);
                    bVar.tb(str6);
                    bVar.tc(str7);
                    bVar.setActivityDialog(customDialogData);
                    bVar.setVideoId(str8);
                    bVar.setContriInfo(contriInfo);
                    return bVar;
                }
                return bVar;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String byi;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.hdT = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.hdZ == null) {
                        if (NewWriteModel.this.hdY != null) {
                            NewWriteModel.this.hdY.a(true, bVar.getErrorString(), null, null, bVar.bbk());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            byi = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.byi()) && StringUtils.isNull(bVar.byh())) {
                            byi = null;
                        } else {
                            str = bVar.byh();
                            byi = bVar.byi();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, byi);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        t tVar = new t();
                        tVar.parserJson(this.mRetData);
                        NewWriteModel.this.hdZ.callback(true, postWriteCallBackData, tVar, NewWriteModel.this.mData, bVar.bbk());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
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
                            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.mPageContext, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, true));
                    if (this.hbC != null) {
                        this.hbC.aWO();
                        return;
                    }
                    return;
                }
                handleRequestFail(bVar);
                if (this.hbC != null) {
                    this.hbC.X(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.cRO != null) {
                this.cRO.cancel();
            }
            if (NewWriteModel.this.hdZ != null) {
                NewWriteModel.this.hdZ.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.hdY != null) {
                NewWriteModel.this.hdY.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.hdT = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (bVar.bye()) {
                NewWriteModel.this.a(bVar);
            } else if (bVar.byf()) {
                NewWriteModel.this.b(bVar);
                NewWriteModel.this.a(bVar);
            } else if (bVar.byd()) {
                t tVar = new t();
                tVar.parserJson(this.mRetData);
                if (tVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(tVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(tVar.getVcode_pic_url());
                    NewWriteModel.this.a(bVar, null, tVar, NewWriteModel.this.mData);
                }
            } else if (bVar.byg()) {
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
    public void b(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        if (bVar != null && bVar.bbk() != null && bVar.bbk().mFrsForbidenDialogInfo != null) {
            AntiHelper.as(this.mPageContext.getPageActivity(), bVar.bbk().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, t tVar, WriteData writeData) {
        if (bVar != null) {
            if (this.hdZ != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                this.hdZ.callback(false, postWriteCallBackData, tVar, writeData, bVar.bbk());
            } else if (this.hdY != null) {
                this.hdY.a(false, bVar.getErrorString(), tVar, writeData, bVar.bbk());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a cRO = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bEq = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dX = com.baidu.tbadk.core.util.k.dX(NewWriteModel.this.cRN);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.hdW == null || NewWriteModel.this.hdW.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.cRN) || !dX) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.cRN);
                NewWriteModel.this.hdV = com.baidu.tbadk.core.util.k.n(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.hdV)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.hdV, this.cRO);
            }
            this.bEq = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.hdW);
            if (this.bEq != null) {
                NewWriteModel.this.hdV = com.baidu.tbadk.core.util.k.a(TbConfig.IMAGE_RESIZED_FILE, this.bEq, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.hdV)) {
                    return NewWriteModel.this.a(NewWriteModel.this.hdV, this.cRO);
                }
                if (this.bEq == null || this.bEq.isRecycled()) {
                    return null;
                }
                this.bEq.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.cRO != null) {
                this.cRO.cancel();
            }
            if (NewWriteModel.this.hdX != null) {
                NewWriteModel.this.hdX.a(null, true);
            }
            if (this.bEq != null && !this.bEq.isRecycled()) {
                this.bEq.recycle();
            }
            super.cancel();
            NewWriteModel.this.hdU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.hdX != null) {
                    NewWriteModel.this.hdX.a(imageUploadResult, false);
                }
                if (this.bEq != null && !this.bEq.isRecycled()) {
                    this.bEq.recycle();
                }
            }
        }
    }

    public void arY() {
        if (this.hdU == null) {
            this.hdU = new a();
            this.hdU.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.hdW = bArr;
        this.cRN = str;
    }

    public void a(b bVar) {
        this.hdX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aI(ao.Dd().Dj(), ao.Dd().Dk()));
        return aVar.e(imageFileInfo, true);
    }
}
