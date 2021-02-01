package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.l.k;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    private com.baidu.adp.base.f<?> eVB;
    private f.a iGU;
    private SpanGroupManager mSpanGroupManager;
    private e nAP;
    private a nAQ;
    private String nAR;
    private String nAS;
    private byte[] nAT;
    private b nAU;
    private c nAV;
    private d nAW;
    private boolean nAX;
    private a.InterfaceC0871a nAY;
    private WriteData nlK;
    private String nxV;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, ah ahVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.nAP = null;
        this.nAQ = null;
        this.nlK = null;
        this.nAR = null;
        this.nAS = null;
        this.nAT = null;
        this.nAV = null;
        this.nAW = null;
        this.nAX = false;
        this.iGU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jh(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuV() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nAP = null;
                    NewWriteModel.this.nlK.setAuthSid(null);
                    NewWriteModel.this.dOV();
                } else if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nlK.setAuthSid(null);
                }
                if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }
        };
        this.eVB = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.nAP = null;
        this.nAQ = null;
        this.nlK = null;
        this.nAR = null;
        this.nAS = null;
        this.nAT = null;
        this.nAV = null;
        this.nAW = null;
        this.nAX = false;
        this.iGU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jh(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuV() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nAP = null;
                    NewWriteModel.this.nlK.setAuthSid(null);
                    NewWriteModel.this.dOV();
                } else if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nlK.setAuthSid(null);
                }
                if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }
        };
        this.eVB = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.nAP = null;
        this.nAQ = null;
        this.nlK = null;
        this.nAR = null;
        this.nAS = null;
        this.nAT = null;
        this.nAV = null;
        this.nAW = null;
        this.nAX = false;
        this.iGU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jh(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuV() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nAP = null;
                    NewWriteModel.this.nlK.setAuthSid(null);
                    NewWriteModel.this.dOV();
                } else if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nlK.setAuthSid(null);
                }
                if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }
        };
        this.eVB = tbPageContext;
    }

    public NewWriteModel() {
        this.nAP = null;
        this.nAQ = null;
        this.nlK = null;
        this.nAR = null;
        this.nAS = null;
        this.nAT = null;
        this.nAV = null;
        this.nAW = null;
        this.nAX = false;
        this.iGU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jh(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuV() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nAP = null;
                    NewWriteModel.this.nlK.setAuthSid(null);
                    NewWriteModel.this.dOV();
                } else if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nlK == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nAW != null) {
                        NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nAP = null;
                NewWriteModel.this.nlK.setAuthSid(str);
                NewWriteModel.this.dOV();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nlK != null) {
                    NewWriteModel.this.nlK.setAuthSid(null);
                }
                if (NewWriteModel.this.nAW != null) {
                    NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
                }
            }
        };
        this.eVB = null;
    }

    public void h(@Nullable com.baidu.adp.base.f<?> fVar) {
        if (fVar != null) {
            this.eVB = fVar;
            this.unique_id = fVar.getUniqueId();
            return;
        }
        this.eVB = null;
        this.unique_id = null;
    }

    public void yE(boolean z) {
        this.nAX = z;
    }

    public void b(d dVar) {
        this.nAW = dVar;
    }

    public void a(c cVar) {
        this.nAV = cVar;
    }

    public void f(WriteData writeData) {
        this.nlK = writeData;
    }

    public WriteData dav() {
        return this.nlK;
    }

    public boolean dPj() {
        if (this.nlK == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：开始上传");
        this.nlK.startPublish();
        bi.a(this.nlK, 0).ju(true);
        dPk();
        return true;
    }

    public boolean dOV() {
        if (this.nlK == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.nlK.getWriteImagesInfo() == null || this.nlK.getWriteImagesInfo().size() == 0 || !this.nlK.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dPk();
        } else {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eVB == null) {
                dPk();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVB.getPageActivity());
            aVar.nx(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dPk();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eVB);
            aVar.bqx();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPk() {
        if (this.nAP == null) {
            if (com.baidu.tieba.tbadkCore.writeModel.a.dOU().dPb() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, dav());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, com.baidu.tieba.tbadkCore.writeModel.a.dOU().dPb()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.nAP = new e();
            com.baidu.tieba.tbadkCore.writeModel.b.d("dealPost()");
            this.nAP.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.nAP != null && !this.nAP.isCancelled()) {
            this.nAP.cancel();
        } else if (this.nAW != null) {
            this.nAW.callback(false, null, null, this.nlK, null);
        } else if (this.nAV != null) {
            this.nAV.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nAP != null && !this.nAP.isCancelled()) {
            this.nAP.cancel();
            return false;
        }
        return false;
    }

    public void dPl() {
        if (this.nAQ != null && !this.nAQ.isCancelled()) {
            this.nAQ.cancel();
        }
    }

    public boolean dOX() {
        if (this.nlK == null) {
            return true;
        }
        return (this.nlK.getWriteImagesInfo() != null ? this.nlK.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, f> {
        private k nBc;
        private com.baidu.tieba.l.g nxU;
        private com.baidu.tieba.tbadkCore.c.a nBa = null;
        private String nBb = null;
        private boolean gxb = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
            if (runTask != null) {
                this.nBc = (k) runTask.getData();
            }
            if (this.nBc != null) {
                this.nxU = this.nBc.dgY();
            }
            setPriority(3);
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01da  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f doInBackground(Integer... numArr) {
            f fVar;
            JSONArray jSONArray;
            IconStampData iconStampData;
            if (!this.gxb) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.nlK.getContent());
                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground() start");
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground");
                this.nBa = new com.baidu.tieba.tbadkCore.c.a();
                this.nBa.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.nBa.Tg(NewWriteModel.this.nxV);
                this.nBa.a(this.nxU);
                this.nBa.a(NewWriteModel.this.nAY);
                this.nBb = this.nBa.a(NewWriteModel.this.nlK, NewWriteModel.this.nAX);
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData dNN = this.nBa.dNN();
                if (this.nBa.isRequestSuccess() && this.nBb != null) {
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData dNM = this.nBa.dNM();
                    String error_msg = dNN.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    f fVar2 = new f(dNN.getError_code(), error_msg, dNM);
                    if (NewWriteModel.this.nlK != null && NewWriteModel.this.nlK.isHasImages() && !fVar2.hasError()) {
                        NewWriteModel.this.nlK.deleteUploadedTempImages();
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                    fVar = fVar2;
                } else if (dNN != null && dNN.error_code == 220015) {
                    fVar = new f(dNN.getError_code(), dNN.getError_msg(), null);
                    if (this.nBb != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.nBb).optJSONObject("info");
                            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(jSONArray.optString(i));
                                }
                                fVar.setSensitiveWords(arrayList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (dNN != null && dNN.error_code == 238010) {
                    fVar = new f(dNN.getError_code(), dNN.getError_msg(), null);
                    if (this.nBb != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.nBb).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bu buVar = new bu();
                                buVar.title = optJSONObject2.optString("block_content");
                                buVar.ePA = optJSONObject2.optString("block_cancel");
                                buVar.ePB = optJSONObject2.optString("block_confirm");
                                fVar.setReplyPrivacyTip(buVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (dNN != null && dNN.error_code != 0) {
                    String error_msg2 = dNN.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dNN.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    f fVar3 = new f(dNN.getError_code(), error_msg2, this.nBa.dNM());
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 3");
                    fVar = fVar3;
                } else {
                    fVar = new f(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (!fVar.hasError()) {
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
                    VideoEasterEggData videoEasterEggData = null;
                    int i2 = 0;
                    try {
                    } catch (JSONException e3) {
                        e = e3;
                        iconStampData = null;
                    }
                    if (this.nBb != null) {
                        JSONObject jSONObject = new JSONObject(this.nBb);
                        str = jSONObject.optString("msg");
                        str2 = jSONObject.optString("pre_msg");
                        str3 = jSONObject.optString("color_msg");
                        str4 = jSONObject.optString("tid");
                        str5 = jSONObject.optString("pid");
                        str8 = jSONObject.optString("video_id");
                        customDialogData = com.baidu.tieba.pb.b.eG(jSONObject);
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                        if (optJSONObject3 != null) {
                            i2 = optJSONObject3.optInt("is_copytwzhibo", 0);
                        }
                        JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str6 = optJSONObject4.optString("pre_msg");
                            str7 = optJSONObject4.optString("color_msg");
                        }
                        contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                        JSONObject optJSONObject5 = jSONObject.optJSONObject("star_info");
                        if (optJSONObject5 != null) {
                            VideoEasterEggData videoEasterEggData2 = new VideoEasterEggData();
                            try {
                                videoEasterEggData2.parseJson(optJSONObject5);
                                videoEasterEggData = videoEasterEggData2;
                            } catch (JSONException e4) {
                                e = e4;
                                iconStampData = null;
                                videoEasterEggData = videoEasterEggData2;
                                e.printStackTrace();
                                if (StringUtils.isNull(str)) {
                                }
                                fVar.setErrorString(str);
                                fVar.setPreMsg(str2);
                                fVar.setColorMsg(str3);
                                fVar.setThreadId(str4);
                                fVar.setPostId(str5);
                                fVar.setIsCopyTWZhibo(i2);
                                fVar.TI(str6);
                                fVar.TJ(str7);
                                fVar.setActivityDialog(customDialogData);
                                fVar.setVideoId(str8);
                                fVar.setContriInfo(contriInfo);
                                fVar.setVideoEasterEggData(videoEasterEggData);
                                fVar.setIconStampData(iconStampData);
                                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground end");
                                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                        }
                        JSONObject optJSONObject6 = jSONObject.optJSONObject("icon_stamp_info");
                        if (optJSONObject6 != null) {
                            iconStampData = new IconStampData();
                            try {
                                iconStampData.parseJson(optJSONObject6);
                            } catch (JSONException e5) {
                                e = e5;
                                e.printStackTrace();
                                if (StringUtils.isNull(str)) {
                                }
                                fVar.setErrorString(str);
                                fVar.setPreMsg(str2);
                                fVar.setColorMsg(str3);
                                fVar.setThreadId(str4);
                                fVar.setPostId(str5);
                                fVar.setIsCopyTWZhibo(i2);
                                fVar.TI(str6);
                                fVar.TJ(str7);
                                fVar.setActivityDialog(customDialogData);
                                fVar.setVideoId(str8);
                                fVar.setContriInfo(contriInfo);
                                fVar.setVideoEasterEggData(videoEasterEggData);
                                fVar.setIconStampData(iconStampData);
                                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground end");
                                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 完全结束");
                                return fVar;
                            }
                            if (StringUtils.isNull(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.send_success);
                            }
                            fVar.setErrorString(str);
                            fVar.setPreMsg(str2);
                            fVar.setColorMsg(str3);
                            fVar.setThreadId(str4);
                            fVar.setPostId(str5);
                            fVar.setIsCopyTWZhibo(i2);
                            fVar.TI(str6);
                            fVar.TJ(str7);
                            fVar.setActivityDialog(customDialogData);
                            fVar.setVideoId(str8);
                            fVar.setContriInfo(contriInfo);
                            fVar.setVideoEasterEggData(videoEasterEggData);
                            fVar.setIconStampData(iconStampData);
                        }
                    }
                    iconStampData = null;
                    if (StringUtils.isNull(str)) {
                    }
                    fVar.setErrorString(str);
                    fVar.setPreMsg(str2);
                    fVar.setColorMsg(str3);
                    fVar.setThreadId(str4);
                    fVar.setPostId(str5);
                    fVar.setIsCopyTWZhibo(i2);
                    fVar.TI(str6);
                    fVar.TJ(str7);
                    fVar.setActivityDialog(customDialogData);
                    fVar.setVideoId(str8);
                    fVar.setContriInfo(contriInfo);
                    fVar.setVideoEasterEggData(videoEasterEggData);
                    fVar.setIconStampData(iconStampData);
                }
                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground end");
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 完全结束");
                return fVar;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute start");
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute");
            NewWriteModel.this.nAP = null;
            if (fVar != null && fVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", fVar.getErrorCode(), fVar.getErrorString(), "tid", fVar.getThreadId(), "pid", fVar.getPostId());
            }
            if (this.gxb || fVar == null) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute isCanceled");
                return;
            }
            if (fVar.hasError()) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute error");
                d(fVar);
                if (this.nxU != null) {
                    this.nxU.bN(fVar.errorCode, fVar.getErrorString());
                }
            } else {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute success");
                if (NewWriteModel.this.nAW == null) {
                    if (NewWriteModel.this.nAV != null) {
                        NewWriteModel.this.nAV.a(true, fVar.getErrorString(), null, null, fVar.cBs());
                    }
                } else {
                    String str = null;
                    String str2 = null;
                    if (!StringUtils.isNull(fVar.getPreMsg()) && !StringUtils.isNull(fVar.getColorMsg())) {
                        str = fVar.getPreMsg();
                        str2 = fVar.getColorMsg();
                    } else if (!StringUtils.isNull(fVar.dPs()) || !StringUtils.isNull(fVar.dPr())) {
                        str = fVar.dPr();
                        str2 = fVar.dPs();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), str, str2);
                    postWriteCallBackData.setThreadId(fVar.getThreadId());
                    postWriteCallBackData.setPostId(fVar.getPostId());
                    postWriteCallBackData.setIsCopyTWZhibo(fVar.getIsCopyTWZhibo());
                    postWriteCallBackData.setErrorString(fVar.getErrorString());
                    postWriteCallBackData.setActivityDialog(fVar.getActivityDialog());
                    postWriteCallBackData.setVideoid(fVar.getVideoId());
                    postWriteCallBackData.setContriInfo(fVar.getContriInfo());
                    if (NewWriteModel.this.nlK != null) {
                        postWriteCallBackData.setProZone(NewWriteModel.this.nlK.getProZone());
                        postWriteCallBackData.setGeneralTabId(NewWriteModel.this.nlK.getTabId());
                    }
                    postWriteCallBackData.setVideoEasterEggData(fVar.getVideoEasterEggData());
                    postWriteCallBackData.setIconStampData(fVar.getIconStampData());
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nBb);
                    NewWriteModel.this.nAW.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.nlK, fVar.cBs());
                    if (NewWriteModel.this.nlK != null && com.baidu.tieba.tbadkCore.writeModel.a.dOU().dPb() != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dOU().TF(NewWriteModel.this.nlK.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dOU().TG(NewWriteModel.this.nlK.getForumName());
                        if (NewWriteModel.this.nlK.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = NewWriteModel.this.nlK;
                        }
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dOU().dPb()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        com.baidu.tieba.tbadkCore.writeModel.a.dOU().E(null);
                    }
                    final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                    if (activityDialog != null && fVar.getIconStampData() == null) {
                        if (NewWriteModel.this.nlK != null) {
                            switch (NewWriteModel.this.nlK.getType()) {
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
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eVB, activityDialog).show();
                            }
                        }, 1000L);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(fVar.getIconStampData() == null)));
                if (this.nxU != null) {
                    this.nxU.dgJ();
                }
            }
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute 完全结束");
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.gxb = true;
            if (this.nBa != null) {
                this.nBa.cancel();
            }
            if (NewWriteModel.this.nAW != null) {
                NewWriteModel.this.nAW.callback(false, null, null, NewWriteModel.this.nlK, null);
            } else if (NewWriteModel.this.nAV != null) {
                NewWriteModel.this.nAV.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.nAP = null;
        }

        private void d(f fVar) {
            if (!com.baidu.tieba.tbadkCore.util.f.a(fVar.getErrorCode(), AuthTokenData.parse(this.nBb), NewWriteModel.this.iGU)) {
                if (fVar.dPo()) {
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dPp()) {
                    NewWriteModel.this.b(fVar);
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dPn()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nBb);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.nlK != null) {
                        NewWriteModel.this.nlK.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.nlK.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(fVar, null, ahVar, NewWriteModel.this.nlK);
                    }
                } else if (fVar.dPq()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.nBb);
                    NewWriteModel.this.a(fVar, accessState, null, NewWriteModel.this.nlK);
                } else if (fVar.isSensitiveError()) {
                    NewWriteModel.this.a(fVar);
                } else {
                    NewWriteModel.this.a(fVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        a(fVar, null, null, this.nlK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (this.eVB != null && fVar != null && fVar.cBs() != null && fVar.cBs().mFrsForbidenDialogInfo != null) {
            AntiHelper.bs(this.eVB.getPageActivity(), fVar.cBs().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (fVar != null) {
            if (this.nAW != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(fVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(fVar.getReplyPrivacyTip());
                this.nAW.callback(false, postWriteCallBackData, ahVar, writeData, fVar.cBs());
            } else if (this.nAV != null) {
                this.nAV.a(false, fVar.getErrorString(), ahVar, writeData, fVar.cBs());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean gxb = false;
        com.baidu.tieba.tbadkCore.c.a nBa = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = o.isLocalImagePath(NewWriteModel.this.nAS);
            if (this.gxb) {
                return null;
            }
            if (NewWriteModel.this.nAT == null || NewWriteModel.this.nAT.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.nAS) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.nAS);
                NewWriteModel.this.nAR = o.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.nAR)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.nAR, this.nBa);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.nAT);
            if (this.bm != null) {
                NewWriteModel.this.nAR = o.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.nAR)) {
                    return NewWriteModel.this.a(NewWriteModel.this.nAR, this.nBa);
                }
                if (this.bm == null || this.bm.isRecycled()) {
                    return null;
                }
                this.bm.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.gxb = true;
            if (this.nBa != null) {
                this.nBa.cancel();
            }
            if (NewWriteModel.this.nAU != null) {
                NewWriteModel.this.nAU.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.nAQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.gxb) {
                if (NewWriteModel.this.nAU != null) {
                    NewWriteModel.this.nAU.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cyU() {
        if (this.nAQ == null) {
            this.nAQ = new a();
            this.nAQ.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.nAT = bArr;
        this.nAS = str;
    }

    public void a(b bVar) {
        this.nAU = bVar;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void dPm() {
        if (this.mSpanGroupManager != null) {
            this.nxV = this.mSpanGroupManager.bvc();
        } else {
            this.nxV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bd(av.bsS().getPostImageSize(), av.bsS().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
