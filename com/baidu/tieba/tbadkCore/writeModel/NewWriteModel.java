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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
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
    private com.baidu.adp.base.f<?> eXW;
    private f.a iFR;
    private SpanGroupManager mSpanGroupManager;
    private WriteData ngI;
    private String nsQ;
    private e nvM;
    private a nvN;
    private String nvO;
    private String nvP;
    private byte[] nvQ;
    private b nvR;
    private c nvS;
    private d nvT;
    private boolean nvU;
    private a.InterfaceC0852a nvV;

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
        this.nvM = null;
        this.nvN = null;
        this.ngI = null;
        this.nvO = null;
        this.nvP = null;
        this.nvQ = null;
        this.nvS = null;
        this.nvT = null;
        this.nvU = false;
        this.iFR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JI(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cxA() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.nvM = null;
                    NewWriteModel.this.ngI.setAuthSid(null);
                    NewWriteModel.this.dQB();
                } else if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JJ(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.ngI.setAuthSid(null);
                }
                if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }
        };
        this.eXW = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.nvM = null;
        this.nvN = null;
        this.ngI = null;
        this.nvO = null;
        this.nvP = null;
        this.nvQ = null;
        this.nvS = null;
        this.nvT = null;
        this.nvU = false;
        this.iFR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JI(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cxA() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.nvM = null;
                    NewWriteModel.this.ngI.setAuthSid(null);
                    NewWriteModel.this.dQB();
                } else if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JJ(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.ngI.setAuthSid(null);
                }
                if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }
        };
        this.eXW = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.nvM = null;
        this.nvN = null;
        this.ngI = null;
        this.nvO = null;
        this.nvP = null;
        this.nvQ = null;
        this.nvS = null;
        this.nvT = null;
        this.nvU = false;
        this.iFR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JI(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cxA() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.nvM = null;
                    NewWriteModel.this.ngI.setAuthSid(null);
                    NewWriteModel.this.dQB();
                } else if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JJ(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.ngI.setAuthSid(null);
                }
                if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }
        };
        this.eXW = tbPageContext;
    }

    public NewWriteModel() {
        this.nvM = null;
        this.nvN = null;
        this.ngI = null;
        this.nvO = null;
        this.nvP = null;
        this.nvQ = null;
        this.nvS = null;
        this.nvT = null;
        this.nvU = false;
        this.iFR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JI(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cxA() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.nvM = null;
                    NewWriteModel.this.ngI.setAuthSid(null);
                    NewWriteModel.this.dQB();
                } else if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JJ(String str) {
                if (NewWriteModel.this.ngI == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nvT != null) {
                        NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nvM = null;
                NewWriteModel.this.ngI.setAuthSid(str);
                NewWriteModel.this.dQB();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ngI != null) {
                    NewWriteModel.this.ngI.setAuthSid(null);
                }
                if (NewWriteModel.this.nvT != null) {
                    NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
                }
            }
        };
        this.eXW = null;
    }

    public void h(@Nullable com.baidu.adp.base.f<?> fVar) {
        if (fVar != null) {
            this.eXW = fVar;
            this.unique_id = fVar.getUniqueId();
            return;
        }
        this.eXW = null;
        this.unique_id = null;
    }

    public void yp(boolean z) {
        this.nvU = z;
    }

    public void b(d dVar) {
        this.nvT = dVar;
    }

    public void a(c cVar) {
        this.nvS = cVar;
    }

    public void f(WriteData writeData) {
        this.ngI = writeData;
    }

    public WriteData dco() {
        return this.ngI;
    }

    public boolean dQP() {
        if (this.ngI == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：开始上传");
        this.ngI.startPublish();
        bg.a(this.ngI, 0).jw(true);
        dQQ();
        return true;
    }

    public boolean dQB() {
        if (this.ngI == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.ngI.getWriteImagesInfo() == null || this.ngI.getWriteImagesInfo().size() == 0 || !this.ngI.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dQQ();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eXW == null) {
                dQQ();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXW.getPageActivity());
            aVar.pa(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dQQ();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eXW);
            aVar.btX();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQQ() {
        if (this.nvM == null) {
            if (com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, dco());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.nvM = new e();
            com.baidu.tieba.tbadkCore.writeModel.b.d("dealPost()");
            this.nvM.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.nvM != null && !this.nvM.isCancelled()) {
            this.nvM.cancel();
        } else if (this.nvT != null) {
            this.nvT.callback(false, null, null, this.ngI, null);
        } else if (this.nvS != null) {
            this.nvS.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nvM != null && !this.nvM.isCancelled()) {
            this.nvM.cancel();
            return false;
        }
        return false;
    }

    public void dQR() {
        if (this.nvN != null && !this.nvN.isCancelled()) {
            this.nvN.cancel();
        }
    }

    public boolean dQD() {
        if (this.ngI == null) {
            return true;
        }
        return (this.ngI.getWriteImagesInfo() != null ? this.ngI.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, f> {
        private com.baidu.tieba.l.g nsP;
        private k nvZ;
        private com.baidu.tieba.tbadkCore.c.a nvX = null;
        private String nvY = null;
        private boolean gyY = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
            if (runTask != null) {
                this.nvZ = (k) runTask.getData();
            }
            if (this.nvZ != null) {
                this.nsP = this.nvZ.diP();
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
            if (!this.gyY) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.ngI.getContent());
                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground() start");
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground");
                this.nvX = new com.baidu.tieba.tbadkCore.c.a();
                this.nvX.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.nvX.Tr(NewWriteModel.this.nsQ);
                this.nvX.a(this.nsP);
                this.nvX.a(NewWriteModel.this.nvV);
                this.nvY = this.nvX.a(NewWriteModel.this.ngI, NewWriteModel.this.nvU);
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData dPt = this.nvX.dPt();
                if (this.nvX.isRequestSuccess() && this.nvY != null) {
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData dPs = this.nvX.dPs();
                    String error_msg = dPt.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    f fVar2 = new f(dPt.getError_code(), error_msg, dPs);
                    if (NewWriteModel.this.ngI != null && NewWriteModel.this.ngI.isHasImages() && !fVar2.hasError()) {
                        NewWriteModel.this.ngI.deleteUploadedTempImages();
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                    fVar = fVar2;
                } else if (dPt != null && dPt.error_code == 220015) {
                    fVar = new f(dPt.getError_code(), dPt.getError_msg(), null);
                    if (this.nvY != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.nvY).optJSONObject("info");
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
                } else if (dPt != null && dPt.error_code == 238010) {
                    fVar = new f(dPt.getError_code(), dPt.getError_msg(), null);
                    if (this.nvY != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.nvY).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bs bsVar = new bs();
                                bsVar.title = optJSONObject2.optString("block_content");
                                bsVar.eRZ = optJSONObject2.optString("block_cancel");
                                bsVar.eSa = optJSONObject2.optString("block_confirm");
                                fVar.setReplyPrivacyTip(bsVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (dPt != null && dPt.error_code != 0) {
                    String error_msg2 = dPt.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dPt.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    f fVar3 = new f(dPt.getError_code(), error_msg2, this.nvX.dPs());
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
                    if (this.nvY != null) {
                        JSONObject jSONObject = new JSONObject(this.nvY);
                        str = jSONObject.optString("msg");
                        str2 = jSONObject.optString("pre_msg");
                        str3 = jSONObject.optString("color_msg");
                        str4 = jSONObject.optString("tid");
                        str5 = jSONObject.optString("pid");
                        str8 = jSONObject.optString("video_id");
                        customDialogData = com.baidu.tieba.pb.b.eF(jSONObject);
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
                                fVar.TT(str6);
                                fVar.TU(str7);
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
                                fVar.TT(str6);
                                fVar.TU(str7);
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
                            fVar.TT(str6);
                            fVar.TU(str7);
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
                    fVar.TT(str6);
                    fVar.TU(str7);
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
            NewWriteModel.this.nvM = null;
            if (fVar != null && fVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", fVar.getErrorCode(), fVar.getErrorString(), "tid", fVar.getThreadId(), "pid", fVar.getPostId());
            }
            if (this.gyY || fVar == null) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute isCanceled");
                return;
            }
            if (fVar.hasError()) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute error");
                d(fVar);
                if (this.nsP != null) {
                    this.nsP.bG(fVar.errorCode, fVar.getErrorString());
                }
            } else {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute success");
                if (NewWriteModel.this.nvT == null) {
                    if (NewWriteModel.this.nvS != null) {
                        NewWriteModel.this.nvS.a(true, fVar.getErrorString(), null, null, fVar.cDY());
                    }
                } else {
                    String str = null;
                    String str2 = null;
                    if (!StringUtils.isNull(fVar.getPreMsg()) && !StringUtils.isNull(fVar.getColorMsg())) {
                        str = fVar.getPreMsg();
                        str2 = fVar.getColorMsg();
                    } else if (!StringUtils.isNull(fVar.dQY()) || !StringUtils.isNull(fVar.dQX())) {
                        str = fVar.dQX();
                        str2 = fVar.dQY();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), str, str2);
                    postWriteCallBackData.setThreadId(fVar.getThreadId());
                    postWriteCallBackData.setPostId(fVar.getPostId());
                    postWriteCallBackData.setIsCopyTWZhibo(fVar.getIsCopyTWZhibo());
                    postWriteCallBackData.setErrorString(fVar.getErrorString());
                    postWriteCallBackData.setActivityDialog(fVar.getActivityDialog());
                    postWriteCallBackData.setVideoid(fVar.getVideoId());
                    postWriteCallBackData.setContriInfo(fVar.getContriInfo());
                    if (NewWriteModel.this.ngI != null) {
                        postWriteCallBackData.setProZone(NewWriteModel.this.ngI.getProZone());
                        postWriteCallBackData.setGeneralTabId(NewWriteModel.this.ngI.getTabId());
                    }
                    postWriteCallBackData.setVideoEasterEggData(fVar.getVideoEasterEggData());
                    postWriteCallBackData.setIconStampData(fVar.getIconStampData());
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nvY);
                    NewWriteModel.this.nvT.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.ngI, fVar.cDY());
                    if (NewWriteModel.this.ngI != null && com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH() != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dQA().TQ(NewWriteModel.this.ngI.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dQA().TR(NewWriteModel.this.ngI.getForumName());
                        if (NewWriteModel.this.ngI.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = NewWriteModel.this.ngI;
                        }
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQH()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        com.baidu.tieba.tbadkCore.writeModel.a.dQA().D(null);
                    }
                    final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                    if (activityDialog != null && fVar.getIconStampData() == null) {
                        if (NewWriteModel.this.ngI != null) {
                            switch (NewWriteModel.this.ngI.getType()) {
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
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eXW, activityDialog).show();
                            }
                        }, 1000L);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(fVar.getIconStampData() == null)));
                if (this.nsP != null) {
                    this.nsP.diA();
                }
            }
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute 完全结束");
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.gyY = true;
            if (this.nvX != null) {
                this.nvX.cancel();
            }
            if (NewWriteModel.this.nvT != null) {
                NewWriteModel.this.nvT.callback(false, null, null, NewWriteModel.this.ngI, null);
            } else if (NewWriteModel.this.nvS != null) {
                NewWriteModel.this.nvS.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.nvM = null;
        }

        private void d(f fVar) {
            if (!com.baidu.tieba.tbadkCore.util.f.a(fVar.getErrorCode(), AuthTokenData.parse(this.nvY), NewWriteModel.this.iFR)) {
                if (fVar.dQU()) {
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dQV()) {
                    NewWriteModel.this.b(fVar);
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dQT()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nvY);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.ngI != null) {
                        NewWriteModel.this.ngI.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.ngI.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(fVar, null, ahVar, NewWriteModel.this.ngI);
                    }
                } else if (fVar.dQW()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.nvY);
                    NewWriteModel.this.a(fVar, accessState, null, NewWriteModel.this.ngI);
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
        a(fVar, null, null, this.ngI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (this.eXW != null && fVar != null && fVar.cDY() != null && fVar.cDY().mFrsForbidenDialogInfo != null) {
            AntiHelper.bt(this.eXW.getPageActivity(), fVar.cDY().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (fVar != null) {
            if (this.nvT != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(fVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(fVar.getReplyPrivacyTip());
                this.nvT.callback(false, postWriteCallBackData, ahVar, writeData, fVar.cDY());
            } else if (this.nvS != null) {
                this.nvS.a(false, fVar.getErrorString(), ahVar, writeData, fVar.cDY());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean gyY = false;
        com.baidu.tieba.tbadkCore.c.a nvX = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.nvP);
            if (this.gyY) {
                return null;
            }
            if (NewWriteModel.this.nvQ == null || NewWriteModel.this.nvQ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.nvP) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.nvP);
                NewWriteModel.this.nvO = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.nvO)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.nvO, this.nvX);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.nvQ);
            if (this.bm != null) {
                NewWriteModel.this.nvO = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.nvO)) {
                    return NewWriteModel.this.a(NewWriteModel.this.nvO, this.nvX);
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
            this.gyY = true;
            if (this.nvX != null) {
                this.nvX.cancel();
            }
            if (NewWriteModel.this.nvR != null) {
                NewWriteModel.this.nvR.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.nvN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.gyY) {
                if (NewWriteModel.this.nvR != null) {
                    NewWriteModel.this.nvR.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cBA() {
        if (this.nvN == null) {
            this.nvN = new a();
            this.nvN.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.nvQ = bArr;
        this.nvP = str;
    }

    public void a(b bVar) {
        this.nvR = bVar;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void dQS() {
        if (this.mSpanGroupManager != null) {
            this.nsQ = this.mSpanGroupManager.byB();
        } else {
            this.nsQ = null;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bg(au.bwr().getPostImageSize(), au.bwr().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
