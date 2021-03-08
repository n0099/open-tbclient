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
    private com.baidu.adp.base.f<?> eXa;
    private f.a iIR;
    private SpanGroupManager mSpanGroupManager;
    private String nAA;
    private c nDA;
    private d nDB;
    private boolean nDC;
    private a.InterfaceC0879a nDD;
    private e nDu;
    private a nDv;
    private String nDw;
    private String nDx;
    private byte[] nDy;
    private b nDz;
    private WriteData noo;

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
        this.nDu = null;
        this.nDv = null;
        this.noo = null;
        this.nDw = null;
        this.nDx = null;
        this.nDy = null;
        this.nDA = null;
        this.nDB = null;
        this.nDC = false;
        this.iIR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jr(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvi() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.nDu = null;
                    NewWriteModel.this.noo.setAuthSid(null);
                    NewWriteModel.this.dPm();
                } else if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Js(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.noo.setAuthSid(null);
                }
                if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }
        };
        this.eXa = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.nDu = null;
        this.nDv = null;
        this.noo = null;
        this.nDw = null;
        this.nDx = null;
        this.nDy = null;
        this.nDA = null;
        this.nDB = null;
        this.nDC = false;
        this.iIR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jr(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvi() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.nDu = null;
                    NewWriteModel.this.noo.setAuthSid(null);
                    NewWriteModel.this.dPm();
                } else if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Js(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.noo.setAuthSid(null);
                }
                if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }
        };
        this.eXa = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.nDu = null;
        this.nDv = null;
        this.noo = null;
        this.nDw = null;
        this.nDx = null;
        this.nDy = null;
        this.nDA = null;
        this.nDB = null;
        this.nDC = false;
        this.iIR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jr(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvi() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.nDu = null;
                    NewWriteModel.this.noo.setAuthSid(null);
                    NewWriteModel.this.dPm();
                } else if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Js(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.noo.setAuthSid(null);
                }
                if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }
        };
        this.eXa = tbPageContext;
    }

    public NewWriteModel() {
        this.nDu = null;
        this.nDv = null;
        this.noo = null;
        this.nDw = null;
        this.nDx = null;
        this.nDy = null;
        this.nDA = null;
        this.nDB = null;
        this.nDC = false;
        this.iIR = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jr(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvi() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.nDu = null;
                    NewWriteModel.this.noo.setAuthSid(null);
                    NewWriteModel.this.dPm();
                } else if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Js(String str) {
                if (NewWriteModel.this.noo == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nDB != null) {
                        NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nDu = null;
                NewWriteModel.this.noo.setAuthSid(str);
                NewWriteModel.this.dPm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.noo != null) {
                    NewWriteModel.this.noo.setAuthSid(null);
                }
                if (NewWriteModel.this.nDB != null) {
                    NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
                }
            }
        };
        this.eXa = null;
    }

    public void h(@Nullable com.baidu.adp.base.f<?> fVar) {
        if (fVar != null) {
            this.eXa = fVar;
            this.unique_id = fVar.getUniqueId();
            return;
        }
        this.eXa = null;
        this.unique_id = null;
    }

    public void yD(boolean z) {
        this.nDC = z;
    }

    public void b(d dVar) {
        this.nDB = dVar;
    }

    public void a(c cVar) {
        this.nDA = cVar;
    }

    public void f(WriteData writeData) {
        this.noo = writeData;
    }

    public WriteData daL() {
        return this.noo;
    }

    public boolean dPA() {
        if (this.noo == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：开始上传");
        this.noo.startPublish();
        bi.a(this.noo, 0).ju(true);
        dPB();
        return true;
    }

    public boolean dPm() {
        if (this.noo == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.noo.getWriteImagesInfo() == null || this.noo.getWriteImagesInfo().size() == 0 || !this.noo.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dPB();
        } else {
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eXa == null) {
                dPB();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXa.getPageActivity());
            aVar.ny(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dPB();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eXa);
            aVar.bqz();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPB() {
        if (this.nDu == null) {
            if (com.baidu.tieba.tbadkCore.writeModel.a.dPl().dPs() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, daL());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, com.baidu.tieba.tbadkCore.writeModel.a.dPl().dPs()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.nDu = new e();
            com.baidu.tieba.tbadkCore.writeModel.b.d("dealPost()");
            this.nDu.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.nDu != null && !this.nDu.isCancelled()) {
            this.nDu.cancel();
        } else if (this.nDB != null) {
            this.nDB.callback(false, null, null, this.noo, null);
        } else if (this.nDA != null) {
            this.nDA.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nDu != null && !this.nDu.isCancelled()) {
            this.nDu.cancel();
            return false;
        }
        return false;
    }

    public void dPC() {
        if (this.nDv != null && !this.nDv.isCancelled()) {
            this.nDv.cancel();
        }
    }

    public boolean dPo() {
        if (this.noo == null) {
            return true;
        }
        return (this.noo.getWriteImagesInfo() != null ? this.noo.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, f> {
        private com.baidu.tieba.l.g nAz;
        private k nDH;
        private com.baidu.tieba.tbadkCore.c.a nDF = null;
        private String nDG = null;
        private boolean gyY = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
            if (runTask != null) {
                this.nDH = (k) runTask.getData();
            }
            if (this.nDH != null) {
                this.nAz = this.nDH.dho();
            }
            setPriority(3);
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01da  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f doInBackground(Integer... numArr) {
            f fVar;
            JSONArray jSONArray;
            IconStampData iconStampData;
            if (!this.gyY) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.noo.getContent());
                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground() start");
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground");
                this.nDF = new com.baidu.tieba.tbadkCore.c.a();
                this.nDF.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.nDF.Tz(NewWriteModel.this.nAA);
                this.nDF.a(this.nAz);
                this.nDF.a(NewWriteModel.this.nDD);
                this.nDG = this.nDF.a(NewWriteModel.this.noo, NewWriteModel.this.nDC);
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData dOe = this.nDF.dOe();
                if (this.nDF.isRequestSuccess() && this.nDG != null) {
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData dOd = this.nDF.dOd();
                    String error_msg = dOe.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    f fVar2 = new f(dOe.getError_code(), error_msg, dOd);
                    if (NewWriteModel.this.noo != null && NewWriteModel.this.noo.isHasImages() && !fVar2.hasError()) {
                        NewWriteModel.this.noo.deleteUploadedTempImages();
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                    fVar = fVar2;
                } else if (dOe != null && dOe.error_code == 220015) {
                    fVar = new f(dOe.getError_code(), dOe.getError_msg(), null);
                    if (this.nDG != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.nDG).optJSONObject("info");
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
                } else if (dOe != null && dOe.error_code == 238010) {
                    fVar = new f(dOe.getError_code(), dOe.getError_msg(), null);
                    if (this.nDG != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.nDG).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bu buVar = new bu();
                                buVar.title = optJSONObject2.optString("block_content");
                                buVar.eRb = optJSONObject2.optString("block_cancel");
                                buVar.eRc = optJSONObject2.optString("block_confirm");
                                fVar.setReplyPrivacyTip(buVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (dOe != null && dOe.error_code != 0) {
                    String error_msg2 = dOe.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dOe.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    f fVar3 = new f(dOe.getError_code(), error_msg2, this.nDF.dOd());
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
                    if (this.nDG != null) {
                        JSONObject jSONObject = new JSONObject(this.nDG);
                        str = jSONObject.optString("msg");
                        str2 = jSONObject.optString("pre_msg");
                        str3 = jSONObject.optString("color_msg");
                        str4 = jSONObject.optString("tid");
                        str5 = jSONObject.optString("pid");
                        str8 = jSONObject.optString("video_id");
                        customDialogData = com.baidu.tieba.pb.b.eI(jSONObject);
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
                                fVar.Ub(str6);
                                fVar.Uc(str7);
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
                                fVar.Ub(str6);
                                fVar.Uc(str7);
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
                            fVar.Ub(str6);
                            fVar.Uc(str7);
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
                    fVar.Ub(str6);
                    fVar.Uc(str7);
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
            NewWriteModel.this.nDu = null;
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
                if (this.nAz != null) {
                    this.nAz.bN(fVar.errorCode, fVar.getErrorString());
                }
            } else {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute success");
                if (NewWriteModel.this.nDB == null) {
                    if (NewWriteModel.this.nDA != null) {
                        NewWriteModel.this.nDA.a(true, fVar.getErrorString(), null, null, fVar.cBF());
                    }
                } else {
                    String str = null;
                    String str2 = null;
                    if (!StringUtils.isNull(fVar.getPreMsg()) && !StringUtils.isNull(fVar.getColorMsg())) {
                        str = fVar.getPreMsg();
                        str2 = fVar.getColorMsg();
                    } else if (!StringUtils.isNull(fVar.dPJ()) || !StringUtils.isNull(fVar.dPI())) {
                        str = fVar.dPI();
                        str2 = fVar.dPJ();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), str, str2);
                    postWriteCallBackData.setThreadId(fVar.getThreadId());
                    postWriteCallBackData.setPostId(fVar.getPostId());
                    postWriteCallBackData.setIsCopyTWZhibo(fVar.getIsCopyTWZhibo());
                    postWriteCallBackData.setErrorString(fVar.getErrorString());
                    postWriteCallBackData.setActivityDialog(fVar.getActivityDialog());
                    postWriteCallBackData.setVideoid(fVar.getVideoId());
                    postWriteCallBackData.setContriInfo(fVar.getContriInfo());
                    if (NewWriteModel.this.noo != null) {
                        postWriteCallBackData.setProZone(NewWriteModel.this.noo.getProZone());
                        postWriteCallBackData.setGeneralTabId(NewWriteModel.this.noo.getTabId());
                    }
                    postWriteCallBackData.setVideoEasterEggData(fVar.getVideoEasterEggData());
                    postWriteCallBackData.setIconStampData(fVar.getIconStampData());
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nDG);
                    NewWriteModel.this.nDB.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.noo, fVar.cBF());
                    if (NewWriteModel.this.noo != null && com.baidu.tieba.tbadkCore.writeModel.a.dPl().dPs() != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dPl().TY(NewWriteModel.this.noo.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dPl().TZ(NewWriteModel.this.noo.getForumName());
                        if (NewWriteModel.this.noo.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = NewWriteModel.this.noo;
                        }
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dPl().dPs()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        com.baidu.tieba.tbadkCore.writeModel.a.dPl().F(null);
                    }
                    final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                    if (activityDialog != null && fVar.getIconStampData() == null) {
                        if (NewWriteModel.this.noo != null) {
                            switch (NewWriteModel.this.noo.getType()) {
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
                                com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eXa, activityDialog).show();
                            }
                        }, 1000L);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(fVar.getIconStampData() == null)));
                if (this.nAz != null) {
                    this.nAz.dgZ();
                }
            }
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute 完全结束");
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.gyY = true;
            if (this.nDF != null) {
                this.nDF.cancel();
            }
            if (NewWriteModel.this.nDB != null) {
                NewWriteModel.this.nDB.callback(false, null, null, NewWriteModel.this.noo, null);
            } else if (NewWriteModel.this.nDA != null) {
                NewWriteModel.this.nDA.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.nDu = null;
        }

        private void d(f fVar) {
            if (!com.baidu.tieba.tbadkCore.util.f.a(fVar.getErrorCode(), AuthTokenData.parse(this.nDG), NewWriteModel.this.iIR)) {
                if (fVar.dPF()) {
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dPG()) {
                    NewWriteModel.this.b(fVar);
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dPE()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nDG);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.noo != null) {
                        NewWriteModel.this.noo.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.noo.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(fVar, null, ahVar, NewWriteModel.this.noo);
                    }
                } else if (fVar.dPH()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.nDG);
                    NewWriteModel.this.a(fVar, accessState, null, NewWriteModel.this.noo);
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
        a(fVar, null, null, this.noo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (this.eXa != null && fVar != null && fVar.cBF() != null && fVar.cBF().mFrsForbidenDialogInfo != null) {
            AntiHelper.br(this.eXa.getPageActivity(), fVar.cBF().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (fVar != null) {
            if (this.nDB != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(fVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(fVar.getReplyPrivacyTip());
                this.nDB.callback(false, postWriteCallBackData, ahVar, writeData, fVar.cBF());
            } else if (this.nDA != null) {
                this.nDA.a(false, fVar.getErrorString(), ahVar, writeData, fVar.cBF());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean gyY = false;
        com.baidu.tieba.tbadkCore.c.a nDF = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = o.isLocalImagePath(NewWriteModel.this.nDx);
            if (this.gyY) {
                return null;
            }
            if (NewWriteModel.this.nDy == null || NewWriteModel.this.nDy.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.nDx) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.nDx);
                NewWriteModel.this.nDw = o.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.nDw)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.nDw, this.nDF);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.nDy);
            if (this.bm != null) {
                NewWriteModel.this.nDw = o.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.nDw)) {
                    return NewWriteModel.this.a(NewWriteModel.this.nDw, this.nDF);
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
            if (this.nDF != null) {
                this.nDF.cancel();
            }
            if (NewWriteModel.this.nDz != null) {
                NewWriteModel.this.nDz.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.nDv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.gyY) {
                if (NewWriteModel.this.nDz != null) {
                    NewWriteModel.this.nDz.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void czh() {
        if (this.nDv == null) {
            this.nDv = new a();
            this.nDv.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.nDy = bArr;
        this.nDx = str;
    }

    public void a(b bVar) {
        this.nDz = bVar;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void dPD() {
        if (this.mSpanGroupManager != null) {
            this.nAA = this.mSpanGroupManager.bvf();
        } else {
            this.nAA = null;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bd(av.bsV().getPostImageSize(), av.bsV().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
