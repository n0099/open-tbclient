package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.atomData.UegWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.c.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    private String cOJ;
    private e hbU;
    private a hbV;
    private String hbW;
    private byte[] hbX;
    private b hbY;
    private c hbZ;
    private d hca;
    private boolean hcb;
    private a.InterfaceC0154a hcc;
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
        this.hbU = null;
        this.hbV = null;
        this.mData = null;
        this.hbW = null;
        this.cOJ = null;
        this.hbX = null;
        this.hbZ = null;
        this.hca = null;
        this.hcb = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hbU = null;
        this.hbV = null;
        this.mData = null;
        this.hbW = null;
        this.cOJ = null;
        this.hbX = null;
        this.hbZ = null;
        this.hca = null;
        this.hcb = false;
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.hbU = null;
        this.hbV = null;
        this.mData = null;
        this.hbW = null;
        this.cOJ = null;
        this.hbX = null;
        this.hbZ = null;
        this.hca = null;
        this.hcb = false;
        this.mPageContext = null;
    }

    public void mG(boolean z) {
        this.hcb = z;
    }

    public void b(d dVar) {
        this.hca = dVar;
    }

    public void a(c cVar) {
        this.hbZ = cVar;
    }

    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.hcc = interfaceC0154a;
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
            aVar.AB();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.hbU == null) {
            this.hbU = new e();
            this.hbU.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.hbU != null && !this.hbU.isCancelled()) {
            this.hbU.cancel();
        } else if (this.hca != null) {
            this.hca.callback(false, null, null, null, null);
        } else if (this.hbZ != null) {
            this.hbZ.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hbU != null && !this.hbU.isCancelled()) {
            this.hbU.cancel();
            return false;
        }
        return false;
    }

    public void ajm() {
        if (this.hbV != null && !this.hbV.isCancelled()) {
            this.hbV.cancel();
        }
    }

    public boolean bwT() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h gZD;
        private k hce;
        private com.baidu.tieba.tbadkCore.c.a cOK = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
            if (runTask != null) {
                this.hce = (k) runTask.getData();
            }
            if (this.hce != null) {
                this.gZD = this.hce.aVx();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            JSONArray jSONArray;
            if (!this.isCanceled) {
                com.baidu.tbadk.imageManager.d.gG(NewWriteModel.this.mData.getContent());
                this.cOK = new com.baidu.tieba.tbadkCore.c.a();
                this.cOK.a(this.gZD);
                this.cOK.a(NewWriteModel.this.hcc);
                this.mRetData = this.cOK.a(NewWriteModel.this.mData, NewWriteModel.this.hcb);
                ErrorData errorData = this.cOK.getErrorData();
                if (this.cOK.isRequestSuccess() && this.mRetData != null) {
                    AntiData bwb = this.cOK.bwb();
                    String error_msg = errorData.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, bwb);
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
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, this.cOK.bwb());
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
                            customDialogData = com.baidu.tieba.pb.b.L(jSONObject);
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("twzhibo_info");
                            if (optJSONObject2 != null) {
                                i2 = optJSONObject2.optInt("is_copytwzhibo", 0);
                            }
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("exp");
                            if (optJSONObject3 != null) {
                                str6 = optJSONObject3.optString("pre_msg");
                                str7 = optJSONObject3.optString("color_msg");
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
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
                    bVar.sT(str6);
                    bVar.sU(str7);
                    bVar.setActivityDialog(customDialogData);
                    bVar.setVideoId(str8);
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
            String bwZ;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.hbU = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.hca == null) {
                        if (NewWriteModel.this.hbZ != null) {
                            NewWriteModel.this.hbZ.a(true, bVar.getErrorString(), null, null, bVar.aZG());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            bwZ = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.bwZ()) && StringUtils.isNull(bVar.bwY())) {
                            bwZ = null;
                        } else {
                            str = bVar.bwY();
                            bwZ = bVar.bwZ();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, bwZ);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        t tVar = new t();
                        tVar.parserJson(this.mRetData);
                        NewWriteModel.this.hca.callback(true, postWriteCallBackData, tVar, NewWriteModel.this.mData, bVar.aZG());
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
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.gZD != null) {
                        this.gZD.aVg();
                        return;
                    }
                    return;
                }
                handleRequestFail(bVar);
                if (this.gZD != null) {
                    this.gZD.W(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.cOK != null) {
                this.cOK.cancel();
            }
            if (NewWriteModel.this.hca != null) {
                NewWriteModel.this.hca.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.hbZ != null) {
                NewWriteModel.this.hbZ.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.hbU = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (bVar.bwV()) {
                NewWriteModel.this.a(bVar);
            } else if (bVar.bwW()) {
                NewWriteModel.this.b(bVar);
                NewWriteModel.this.a(bVar);
            } else if (bVar.bwU()) {
                t tVar = new t();
                tVar.parserJson(this.mRetData);
                if (tVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setVcodeMD5(tVar.getVcode_md5());
                    NewWriteModel.this.mData.setVcodeUrl(tVar.getVcode_pic_url());
                    NewWriteModel.this.a(bVar, null, tVar, NewWriteModel.this.mData);
                }
            } else if (bVar.bwX()) {
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
        if (bVar.aZG() != null && bVar.aZG().mFrsForbidenDialogInfo != null) {
            BlockPopInfoData blockPopInfoData = bVar.aZG().mFrsForbidenDialogInfo;
            if (!am.isEmpty(blockPopInfoData.ahead_url)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UegWebViewActivityConfig(this.mPageContext.getPageActivity(), blockPopInfoData.ahead_url)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, t tVar, WriteData writeData) {
        if (bVar != null) {
            if (this.hca != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                this.hca.callback(false, postWriteCallBackData, tVar, writeData, bVar.aZG());
            } else if (this.hbZ != null) {
                this.hbZ.a(false, bVar.getErrorString(), tVar, writeData, bVar.aZG());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a cOK = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bCz = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dL = com.baidu.tbadk.core.util.k.dL(NewWriteModel.this.cOJ);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.hbX == null || NewWriteModel.this.hbX.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.cOJ) || !dL) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.cOJ);
                NewWriteModel.this.hbW = com.baidu.tbadk.core.util.k.n(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.hbW)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.hbW, this.cOK);
            }
            this.bCz = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.hbX);
            if (this.bCz != null) {
                NewWriteModel.this.hbW = com.baidu.tbadk.core.util.k.a(TbConfig.IMAGE_RESIZED_FILE, this.bCz, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.hbW)) {
                    return NewWriteModel.this.a(NewWriteModel.this.hbW, this.cOK);
                }
                if (this.bCz == null || this.bCz.isRecycled()) {
                    return null;
                }
                this.bCz.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.cOK != null) {
                this.cOK.cancel();
            }
            if (NewWriteModel.this.hbY != null) {
                NewWriteModel.this.hbY.a(null, true);
            }
            if (this.bCz != null && !this.bCz.isRecycled()) {
                this.bCz.recycle();
            }
            super.cancel();
            NewWriteModel.this.hbV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.hbY != null) {
                    NewWriteModel.this.hbY.a(imageUploadResult, false);
                }
                if (this.bCz != null && !this.bCz.isRecycled()) {
                    this.bCz.recycle();
                }
            }
        }
    }

    public void arj() {
        if (this.hbV == null) {
            this.hbV = new a();
            this.hbV.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.hbX = bArr;
        this.cOJ = str;
    }

    public void a(b bVar) {
        this.hbY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aI(an.CK().CQ(), an.CK().CR()));
        return aVar.e(imageFileInfo, true);
    }
}
