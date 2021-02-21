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
    private f.a iHi;
    private SpanGroupManager mSpanGroupManager;
    private e nBp;
    private a nBq;
    private String nBr;
    private String nBs;
    private byte[] nBt;
    private b nBu;
    private c nBv;
    private d nBw;
    private boolean nBx;
    private a.InterfaceC0873a nBy;
    private WriteData nmk;
    private String nyv;

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
        this.nBp = null;
        this.nBq = null;
        this.nmk = null;
        this.nBr = null;
        this.nBs = null;
        this.nBt = null;
        this.nBv = null;
        this.nBw = null;
        this.nBx = false;
        this.iHi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvc() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nBp = null;
                    NewWriteModel.this.nmk.setAuthSid(null);
                    NewWriteModel.this.dPd();
                } else if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jj(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nmk.setAuthSid(null);
                }
                if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }
        };
        this.eVB = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.nBp = null;
        this.nBq = null;
        this.nmk = null;
        this.nBr = null;
        this.nBs = null;
        this.nBt = null;
        this.nBv = null;
        this.nBw = null;
        this.nBx = false;
        this.iHi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvc() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nBp = null;
                    NewWriteModel.this.nmk.setAuthSid(null);
                    NewWriteModel.this.dPd();
                } else if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jj(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nmk.setAuthSid(null);
                }
                if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }
        };
        this.eVB = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.nBp = null;
        this.nBq = null;
        this.nmk = null;
        this.nBr = null;
        this.nBs = null;
        this.nBt = null;
        this.nBv = null;
        this.nBw = null;
        this.nBx = false;
        this.iHi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvc() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nBp = null;
                    NewWriteModel.this.nmk.setAuthSid(null);
                    NewWriteModel.this.dPd();
                } else if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jj(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nmk.setAuthSid(null);
                }
                if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }
        };
        this.eVB = tbPageContext;
    }

    public NewWriteModel() {
        this.nBp = null;
        this.nBq = null;
        this.nmk = null;
        this.nBr = null;
        this.nBs = null;
        this.nBt = null;
        this.nBv = null;
        this.nBw = null;
        this.nBx = false;
        this.iHi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ji(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cvc() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nBp = null;
                    NewWriteModel.this.nmk.setAuthSid(null);
                    NewWriteModel.this.dPd();
                } else if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jj(String str) {
                if (NewWriteModel.this.nmk == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.nBw != null) {
                        NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.nBp = null;
                NewWriteModel.this.nmk.setAuthSid(str);
                NewWriteModel.this.dPd();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nmk != null) {
                    NewWriteModel.this.nmk.setAuthSid(null);
                }
                if (NewWriteModel.this.nBw != null) {
                    NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
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
        this.nBx = z;
    }

    public void b(d dVar) {
        this.nBw = dVar;
    }

    public void a(c cVar) {
        this.nBv = cVar;
    }

    public void f(WriteData writeData) {
        this.nmk = writeData;
    }

    public WriteData daC() {
        return this.nmk;
    }

    public boolean dPr() {
        if (this.nmk == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：开始上传");
        this.nmk.startPublish();
        bi.a(this.nmk, 0).ju(true);
        dPs();
        return true;
    }

    public boolean dPd() {
        if (this.nmk == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.nmk.getWriteImagesInfo() == null || this.nmk.getWriteImagesInfo().size() == 0 || !this.nmk.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dPs();
        } else {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eVB == null) {
                dPs();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVB.getPageActivity());
            aVar.nx(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dPs();
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
    public void dPs() {
        if (this.nBp == null) {
            if (com.baidu.tieba.tbadkCore.writeModel.a.dPc().dPj() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, daC());
                customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, com.baidu.tieba.tbadkCore.writeModel.a.dPc().dPj()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            this.nBp = new e();
            com.baidu.tieba.tbadkCore.writeModel.b.d("dealPost()");
            this.nBp.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.nBp != null && !this.nBp.isCancelled()) {
            this.nBp.cancel();
        } else if (this.nBw != null) {
            this.nBw.callback(false, null, null, this.nmk, null);
        } else if (this.nBv != null) {
            this.nBv.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.nBp != null && !this.nBp.isCancelled()) {
            this.nBp.cancel();
            return false;
        }
        return false;
    }

    public void dPt() {
        if (this.nBq != null && !this.nBq.isCancelled()) {
            this.nBq.cancel();
        }
    }

    public boolean dPf() {
        if (this.nmk == null) {
            return true;
        }
        return (this.nmk.getWriteImagesInfo() != null ? this.nmk.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, f> {
        private k nBC;
        private com.baidu.tieba.l.g nyu;
        private com.baidu.tieba.tbadkCore.c.a nBA = null;
        private String nBB = null;
        private boolean gxp = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
            if (runTask != null) {
                this.nBC = (k) runTask.getData();
            }
            if (this.nBC != null) {
                this.nyu = this.nBC.dhf();
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
            if (!this.gxp) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.nmk.getContent());
                com.baidu.tieba.tbadkCore.writeModel.b.d("doInBackground() start");
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground");
                this.nBA = new com.baidu.tieba.tbadkCore.c.a();
                this.nBA.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.nBA.Ts(NewWriteModel.this.nyv);
                this.nBA.a(this.nyu);
                this.nBA.a(NewWriteModel.this.nBy);
                this.nBB = this.nBA.a(NewWriteModel.this.nmk, NewWriteModel.this.nBx);
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData dNV = this.nBA.dNV();
                if (this.nBA.isRequestSuccess() && this.nBB != null) {
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData dNU = this.nBA.dNU();
                    String error_msg = dNV.getError_msg();
                    if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    f fVar2 = new f(dNV.getError_code(), error_msg, dNU);
                    if (NewWriteModel.this.nmk != null && NewWriteModel.this.nmk.isHasImages() && !fVar2.hasError()) {
                        NewWriteModel.this.nmk.deleteUploadedTempImages();
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                    fVar = fVar2;
                } else if (dNV != null && dNV.error_code == 220015) {
                    fVar = new f(dNV.getError_code(), dNV.getError_msg(), null);
                    if (this.nBB != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.nBB).optJSONObject("info");
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
                } else if (dNV != null && dNV.error_code == 238010) {
                    fVar = new f(dNV.getError_code(), dNV.getError_msg(), null);
                    if (this.nBB != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.nBB).optJSONObject("info");
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
                } else if (dNV != null && dNV.error_code != 0) {
                    String error_msg2 = dNV.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dNV.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    f fVar3 = new f(dNV.getError_code(), error_msg2, this.nBA.dNU());
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
                    if (this.nBB != null) {
                        JSONObject jSONObject = new JSONObject(this.nBB);
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
                                fVar.TU(str6);
                                fVar.TV(str7);
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
                                fVar.TU(str6);
                                fVar.TV(str7);
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
                            fVar.TU(str6);
                            fVar.TV(str7);
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
                    fVar.TU(str6);
                    fVar.TV(str7);
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
            NewWriteModel.this.nBp = null;
            if (fVar != null && fVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", fVar.getErrorCode(), fVar.getErrorString(), "tid", fVar.getThreadId(), "pid", fVar.getPostId());
            }
            if (this.gxp || fVar == null) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute isCanceled");
                return;
            }
            if (fVar.hasError()) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute error");
                d(fVar);
                if (this.nyu != null) {
                    this.nyu.bN(fVar.errorCode, fVar.getErrorString());
                }
            } else {
                com.baidu.tieba.tbadkCore.writeModel.b.d("onPostExecute success");
                if (NewWriteModel.this.nBw == null) {
                    if (NewWriteModel.this.nBv != null) {
                        NewWriteModel.this.nBv.a(true, fVar.getErrorString(), null, null, fVar.cBz());
                    }
                } else {
                    String str = null;
                    String str2 = null;
                    if (!StringUtils.isNull(fVar.getPreMsg()) && !StringUtils.isNull(fVar.getColorMsg())) {
                        str = fVar.getPreMsg();
                        str2 = fVar.getColorMsg();
                    } else if (!StringUtils.isNull(fVar.dPA()) || !StringUtils.isNull(fVar.dPz())) {
                        str = fVar.dPz();
                        str2 = fVar.dPA();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), str, str2);
                    postWriteCallBackData.setThreadId(fVar.getThreadId());
                    postWriteCallBackData.setPostId(fVar.getPostId());
                    postWriteCallBackData.setIsCopyTWZhibo(fVar.getIsCopyTWZhibo());
                    postWriteCallBackData.setErrorString(fVar.getErrorString());
                    postWriteCallBackData.setActivityDialog(fVar.getActivityDialog());
                    postWriteCallBackData.setVideoid(fVar.getVideoId());
                    postWriteCallBackData.setContriInfo(fVar.getContriInfo());
                    if (NewWriteModel.this.nmk != null) {
                        postWriteCallBackData.setProZone(NewWriteModel.this.nmk.getProZone());
                        postWriteCallBackData.setGeneralTabId(NewWriteModel.this.nmk.getTabId());
                    }
                    postWriteCallBackData.setVideoEasterEggData(fVar.getVideoEasterEggData());
                    postWriteCallBackData.setIconStampData(fVar.getIconStampData());
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nBB);
                    NewWriteModel.this.nBw.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.nmk, fVar.cBz());
                    if (NewWriteModel.this.nmk != null && com.baidu.tieba.tbadkCore.writeModel.a.dPc().dPj() != null) {
                        com.baidu.tieba.tbadkCore.writeModel.a.dPc().TR(NewWriteModel.this.nmk.getForumId());
                        com.baidu.tieba.tbadkCore.writeModel.a.dPc().TS(NewWriteModel.this.nmk.getForumName());
                        if (NewWriteModel.this.nmk.getVideoInfo() != null) {
                            postWriteCallBackData.writeDataForVideo = NewWriteModel.this.nmk;
                        }
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, com.baidu.tieba.tbadkCore.writeModel.a.dPc().dPj()));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        com.baidu.tieba.tbadkCore.writeModel.a.dPc().E(null);
                    }
                    final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                    if (activityDialog != null && fVar.getIconStampData() == null) {
                        if (NewWriteModel.this.nmk != null) {
                            switch (NewWriteModel.this.nmk.getType()) {
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
                if (this.nyu != null) {
                    this.nyu.dgQ();
                }
            }
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： onPostExecute 完全结束");
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.gxp = true;
            if (this.nBA != null) {
                this.nBA.cancel();
            }
            if (NewWriteModel.this.nBw != null) {
                NewWriteModel.this.nBw.callback(false, null, null, NewWriteModel.this.nmk, null);
            } else if (NewWriteModel.this.nBv != null) {
                NewWriteModel.this.nBv.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.nBp = null;
        }

        private void d(f fVar) {
            if (!com.baidu.tieba.tbadkCore.util.f.a(fVar.getErrorCode(), AuthTokenData.parse(this.nBB), NewWriteModel.this.iHi)) {
                if (fVar.dPw()) {
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dPx()) {
                    NewWriteModel.this.b(fVar);
                    NewWriteModel.this.a(fVar);
                } else if (fVar.dPv()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nBB);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.nmk != null) {
                        NewWriteModel.this.nmk.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.nmk.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(fVar, null, ahVar, NewWriteModel.this.nmk);
                    }
                } else if (fVar.dPy()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.nBB);
                    NewWriteModel.this.a(fVar, accessState, null, NewWriteModel.this.nmk);
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
        a(fVar, null, null, this.nmk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        if (this.eVB != null && fVar != null && fVar.cBz() != null && fVar.cBz().mFrsForbidenDialogInfo != null) {
            AntiHelper.br(this.eVB.getPageActivity(), fVar.cBz().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (fVar != null) {
            if (this.nBw != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(fVar.getErrorCode(), fVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(fVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(fVar.getReplyPrivacyTip());
                this.nBw.callback(false, postWriteCallBackData, ahVar, writeData, fVar.cBz());
            } else if (this.nBv != null) {
                this.nBv.a(false, fVar.getErrorString(), ahVar, writeData, fVar.cBz());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean gxp = false;
        com.baidu.tieba.tbadkCore.c.a nBA = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = o.isLocalImagePath(NewWriteModel.this.nBs);
            if (this.gxp) {
                return null;
            }
            if (NewWriteModel.this.nBt == null || NewWriteModel.this.nBt.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.nBs) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.nBs);
                NewWriteModel.this.nBr = o.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.nBr)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.nBr, this.nBA);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.nBt);
            if (this.bm != null) {
                NewWriteModel.this.nBr = o.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.nBr)) {
                    return NewWriteModel.this.a(NewWriteModel.this.nBr, this.nBA);
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
            this.gxp = true;
            if (this.nBA != null) {
                this.nBA.cancel();
            }
            if (NewWriteModel.this.nBu != null) {
                NewWriteModel.this.nBu.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.nBq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.gxp) {
                if (NewWriteModel.this.nBu != null) {
                    NewWriteModel.this.nBu.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void czb() {
        if (this.nBq == null) {
            this.nBq = new a();
            this.nBq.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.nBt = bArr;
        this.nBs = str;
    }

    public void a(b bVar) {
        this.nBu = bVar;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void dPu() {
        if (this.mSpanGroupManager != null) {
            this.nyv = this.mSpanGroupManager.bvc();
        } else {
            this.nyv = null;
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
