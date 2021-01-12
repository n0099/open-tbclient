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
    private com.baidu.adp.base.f<?> eTl;
    private f.a iBk;
    private SpanGroupManager mSpanGroupManager;
    private WriteData ncc;
    private String noi;
    private e nrf;
    private a nrg;
    private String nrh;
    private String nri;
    private byte[] nrj;
    private b nrk;
    private c nrl;
    private d nrm;
    private boolean nrn;
    private a.InterfaceC0868a nro;

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
        this.nrf = null;
        this.nrg = null;
        this.ncc = null;
        this.nrh = null;
        this.nri = null;
        this.nrj = null;
        this.nrl = null;
        this.nrm = null;
        this.nrn = false;
        this.iBk = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Iw(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ctJ() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.nrf = null;
                    NewWriteModel.this.ncc.setAuthSid(null);
                    NewWriteModel.this.dMK();
                } else if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ix(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.ncc.setAuthSid(null);
                }
                if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }
        };
        this.eTl = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.nrf = null;
        this.nrg = null;
        this.ncc = null;
        this.nrh = null;
        this.nri = null;
        this.nrj = null;
        this.nrl = null;
        this.nrm = null;
        this.nrn = false;
        this.iBk = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Iw(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ctJ() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.nrf = null;
                    NewWriteModel.this.ncc.setAuthSid(null);
                    NewWriteModel.this.dMK();
                } else if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ix(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.ncc.setAuthSid(null);
                }
                if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }
        };
        this.eTl = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.nrf = null;
        this.nrg = null;
        this.ncc = null;
        this.nrh = null;
        this.nri = null;
        this.nrj = null;
        this.nrl = null;
        this.nrm = null;
        this.nrn = false;
        this.iBk = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Iw(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ctJ() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.nrf = null;
                    NewWriteModel.this.ncc.setAuthSid(null);
                    NewWriteModel.this.dMK();
                } else if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ix(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.ncc.setAuthSid(null);
                }
                if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }
        };
        this.eTl = tbPageContext;
    }

    public NewWriteModel() {
        this.nrf = null;
        this.nrg = null;
        this.ncc = null;
        this.nrh = null;
        this.nri = null;
        this.nrj = null;
        this.nrl = null;
        this.nrm = null;
        this.nrn = false;
        this.iBk = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Iw(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ctJ() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.nrf = null;
                    NewWriteModel.this.ncc.setAuthSid(null);
                    NewWriteModel.this.dMK();
                } else if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ix(String str) {
                if (NewWriteModel.this.ncc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nrm != null) {
                        NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nrf = null;
                NewWriteModel.this.ncc.setAuthSid(str);
                NewWriteModel.this.dMK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.ncc != null) {
                    NewWriteModel.this.ncc.setAuthSid(null);
                }
                if (NewWriteModel.this.nrm != null) {
                    NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
                }
            }
        };
        this.eTl = null;
    }

    public void h(@Nullable com.baidu.adp.base.f<?> fVar) {
        if (fVar != null) {
            this.eTl = fVar;
            this.unique_id = fVar.getUniqueId();
            return;
        }
        this.eTl = null;
        this.unique_id = null;
    }

    public void yl(boolean z) {
        this.nrn = z;
    }

    public void b(d dVar) {
        this.nrm = dVar;
    }

    public void a(c cVar) {
        this.nrl = cVar;
    }

    public void f(WriteData writeData) {
        this.ncc = writeData;
    }

    public WriteData cYx() {
        return this.ncc;
    }

    public boolean dMY() {
        if (this.ncc == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：开始上传");
        this.ncc.startPublish();
        bg.a(this.ncc, 0).js(true);
        dMZ();
        return true;
    }

    public boolean dMK() {
        if (this.ncc == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.ncc.getWriteImagesInfo() == null || this.ncc.getWriteImagesInfo().size() == 0 || !this.ncc.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dMZ();
        } else {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eTl == null) {
                dMZ();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eTl.getPageActivity());
            aVar.nu(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dMZ();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eTl);
            aVar.bqe();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMZ() {
        if (this.nrf == null) {
            if (com.baidu.tieba.tbadkCore.writeModel.a.dMJ().dMQ() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, cYx());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, com.baidu.tieba.tbadkCore.writeModel.a.dMJ().dMQ()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.nrf = new e();
            com.baidu.tieba.tbadkCore.writeModel.b.d("dealPost()");
            this.nrf.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.nrf != null && !this.nrf.isCancelled()) {
            this.nrf.cancel();
        } else if (this.nrm != null) {
            this.nrm.callback(false, null, null, this.ncc, null);
        } else if (this.nrl != null) {
            this.nrl.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nrf != null && !this.nrf.isCancelled()) {
            this.nrf.cancel();
            return false;
        }
        return false;
    }

    public void dNa() {
        if (this.nrg != null && !this.nrg.isCancelled()) {
            this.nrg.cancel();
        }
    }

    public boolean dMM() {
        if (this.ncc == null) {
            return true;
        }
        return (this.ncc.getWriteImagesInfo() != null ? this.ncc.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, f> {
        private com.baidu.tieba.l.g noh;
        private k nrs;
        private com.baidu.tieba.tbadkCore.c.a nrq = null;
        private String nrr = null;
        private boolean gur = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
            if (runTask != null) {
                this.nrs = (k) runTask.getData();
            }
            if (this.nrs != null) {
                this.noh = this.nrs.deY();
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
            if (!this.gur) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.ncc.getContent());
                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground() start");
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground");
                this.nrq = new com.baidu.tieba.tbadkCore.c.a();
                this.nrq.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.nrq.Si(NewWriteModel.this.noi);
                this.nrq.a(this.noh);
                this.nrq.a(NewWriteModel.this.nro);
                this.nrr = this.nrq.a(NewWriteModel.this.ncc, NewWriteModel.this.nrn);
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData dLC = this.nrq.dLC();
                if (this.nrq.isRequestSuccess() && this.nrr != null) {
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData dLB = this.nrq.dLB();
                    String error_msg = dLC.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    f fVar2 = new f(dLC.getError_code(), error_msg, dLB);
                    if (NewWriteModel.this.ncc != null && NewWriteModel.this.ncc.isHasImages() && !fVar2.hasError()) {
                        NewWriteModel.this.ncc.deleteUploadedTempImages();
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                    fVar = fVar2;
                } else if (dLC != null && dLC.error_code == 220015) {
                    fVar = new f(dLC.getError_code(), dLC.getError_msg(), null);
                    if (this.nrr != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.nrr).optJSONObject("info");
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
                } else if (dLC != null && dLC.error_code == 238010) {
                    fVar = new f(dLC.getError_code(), dLC.getError_msg(), null);
                    if (this.nrr != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.nrr).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bs bsVar = new bs();
                                bsVar.title = optJSONObject2.optString("block_content");
                                bsVar.eNo = optJSONObject2.optString("block_cancel");
                                bsVar.eNp = optJSONObject2.optString("block_confirm");
                                fVar.setReplyPrivacyTip(bsVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (dLC != null && dLC.error_code != 0) {
                    String error_msg2 = dLC.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dLC.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    f fVar3 = new f(dLC.getError_code(), error_msg2, this.nrq.dLB());
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
                    if (this.nrr != null) {
                        JSONObject jSONObject = new JSONObject(this.nrr);
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
                                fVar.SK(str6);
                                fVar.SL(str7);
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
                                fVar.SK(str6);
                                fVar.SL(str7);
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
                            fVar.SK(str6);
                            fVar.SL(str7);
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
                    fVar.SK(str6);
                    fVar.SL(str7);
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
            NewWriteModel.this.nrf = null;
            if (fVar != null && fVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", fVar.getErrorCode(), fVar.getErrorString(), "tid", fVar.getThreadId(), "pid", fVar.getPostId());
            }
            if (this.gur || fVar == null) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute isCanceled");
                return;
            }
            if (fVar.hasError()) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute error");
                d(fVar);
                if (this.noh != null) {
                    this.noh.bH(fVar.errorCode, fVar.getErrorString());
                }
            } else {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute success");
                if (NewWriteModel.this.nrm == null) {
                    if (NewWriteModel.this.nrl != null) {
                        NewWriteModel.this.nrl.a(true, fVar.getErrorString(), null, null, fVar.cAh());
                    }
                } else {
                    String str = null;
                    String str2 = null;
                    if (!StringUtils.isNull(fVar.getPreMsg()) && !StringUtils.isNull(fVar.getColorMsg())) {
                        str = fVar.getPreMsg();
                        str2 = fVar.getColorMsg();
                    } else if (!StringUtils.isNull(fVar.dNh()) || !StringUtils.isNull(fVar.dNg())) {
                        str = fVar.dNg();
                        str2 = fVar.dNh();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), str, str2);
                    postWriteCallBackData.setThreadId(fVar.getThreadId());
                    postWriteCallBackData.setPostId(fVar.getPostId());
                    postWriteCallBackData.setIsCopyTWZhibo(fVar.getIsCopyTWZhibo());
                    postWriteCallBackData.setErrorString(fVar.getErrorString());
                    postWriteCallBackData.setActivityDialog(fVar.getActivityDialog());
                    postWriteCallBackData.setVideoid(fVar.getVideoId());
                    postWriteCallBackData.setContriInfo(fVar.getContriInfo());
                    if (NewWriteModel.this.ncc != null) {
                        postWriteCallBackData.setProZone(NewWriteModel.this.ncc.getProZone());
                        postWriteCallBackData.setGeneralTabId(NewWriteModel.this.ncc.getTabId());
                    }
                    postWriteCallBackData.setVideoEasterEggData(fVar.getVideoEasterEggData());
                    postWriteCallBackData.setIconStampData(fVar.getIconStampData());
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nrr);
                    NewWriteModel.this.nrm.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.ncc, fVar.cAh());
                    if (NewWriteModel.this.ncc != null && com.baidu.tieba.tbadkCore.writeModel.a.dMJ().dMQ() != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dMJ().SH(NewWriteModel.this.ncc.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dMJ().SI(NewWriteModel.this.ncc.getForumName());
                        if (NewWriteModel.this.ncc.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = NewWriteModel.this.ncc;
                        }
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dMJ().dMQ()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        com.baidu.tieba.tbadkCore.writeModel.a.dMJ().D(null);
                    }
                    final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                    if (activityDialog != null && fVar.getIconStampData() == null) {
                        if (NewWriteModel.this.ncc != null) {
                            switch (NewWriteModel.this.ncc.getType()) {
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
                                com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eTl, activityDialog).show();
                            }
                        }, 1000L);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(fVar.getIconStampData() == null)));
                if (this.noh != null) {
                    this.noh.deJ();
                }
            }
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute 完全结束");
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.gur = true;
            if (this.nrq != null) {
                this.nrq.cancel();
            }
            if (NewWriteModel.this.nrm != null) {
                NewWriteModel.this.nrm.callback(false, null, null, NewWriteModel.this.ncc, null);
            } else if (NewWriteModel.this.nrl != null) {
                NewWriteModel.this.nrl.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.nrf = null;
        }

        private void d(f fVar) {
            if (!com.baidu.tieba.tbadkCore.util.f.a(fVar.getErrorCode(), AuthTokenData.parse(this.nrr), NewWriteModel.this.iBk)) {
                if (fVar.dNd()) {
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dNe()) {
                    NewWriteModel.this.b(fVar);
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dNc()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nrr);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.ncc != null) {
                        NewWriteModel.this.ncc.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.ncc.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(fVar, null, ahVar, NewWriteModel.this.ncc);
                    }
                } else if (fVar.dNf()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.nrr);
                    NewWriteModel.this.a(fVar, accessState, null, NewWriteModel.this.ncc);
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
        a(fVar, null, null, this.ncc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (this.eTl != null && fVar != null && fVar.cAh() != null && fVar.cAh().mFrsForbidenDialogInfo != null) {
            AntiHelper.bt(this.eTl.getPageActivity(), fVar.cAh().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (fVar != null) {
            if (this.nrm != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(fVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(fVar.getReplyPrivacyTip());
                this.nrm.callback(false, postWriteCallBackData, ahVar, writeData, fVar.cAh());
            } else if (this.nrl != null) {
                this.nrl.a(false, fVar.getErrorString(), ahVar, writeData, fVar.cAh());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean gur = false;
        com.baidu.tieba.tbadkCore.c.a nrq = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.nri);
            if (this.gur) {
                return null;
            }
            if (NewWriteModel.this.nrj == null || NewWriteModel.this.nrj.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.nri) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.nri);
                NewWriteModel.this.nrh = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.nrh)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.nrh, this.nrq);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.nrj);
            if (this.bm != null) {
                NewWriteModel.this.nrh = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.nrh)) {
                    return NewWriteModel.this.a(NewWriteModel.this.nrh, this.nrq);
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
            this.gur = true;
            if (this.nrq != null) {
                this.nrq.cancel();
            }
            if (NewWriteModel.this.nrk != null) {
                NewWriteModel.this.nrk.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.nrg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.gur) {
                if (NewWriteModel.this.nrk != null) {
                    NewWriteModel.this.nrk.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cxJ() {
        if (this.nrg == null) {
            this.nrg = new a();
            this.nrg.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.nrj = bArr;
        this.nri = str;
    }

    public void a(b bVar) {
        this.nrk = bVar;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void dNb() {
        if (this.mSpanGroupManager != null) {
            this.noi = this.mSpanGroupManager.buI();
        } else {
            this.noi = null;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bg(au.bsy().getPostImageSize(), au.bsy().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
