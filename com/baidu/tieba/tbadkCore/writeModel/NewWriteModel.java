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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
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
    private final com.baidu.adp.base.e<?> dvg;
    private f.a gzc;
    private WriteData kHM;
    private e kWd;
    private a kWe;
    private String kWf;
    private String kWg;
    private byte[] kWh;
    private b kWi;
    private c kWj;
    private d kWk;
    private boolean kWl;
    private a.InterfaceC0674a kWm;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kWd = null;
        this.kWe = null;
        this.kHM = null;
        this.kWf = null;
        this.kWg = null;
        this.kWh = null;
        this.kWj = null;
        this.kWk = null;
        this.kWl = false;
        this.gzc = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BY(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bHw() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kWd = null;
                    NewWriteModel.this.kHM.setAuthSid(null);
                    NewWriteModel.this.cXy();
                } else if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BZ(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kHM.setAuthSid(null);
                }
                if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }
        };
        this.dvg = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kWd = null;
        this.kWe = null;
        this.kHM = null;
        this.kWf = null;
        this.kWg = null;
        this.kWh = null;
        this.kWj = null;
        this.kWk = null;
        this.kWl = false;
        this.gzc = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BY(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bHw() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kWd = null;
                    NewWriteModel.this.kHM.setAuthSid(null);
                    NewWriteModel.this.cXy();
                } else if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BZ(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kHM.setAuthSid(null);
                }
                if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }
        };
        this.dvg = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.kWd = null;
        this.kWe = null;
        this.kHM = null;
        this.kWf = null;
        this.kWg = null;
        this.kWh = null;
        this.kWj = null;
        this.kWk = null;
        this.kWl = false;
        this.gzc = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BY(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bHw() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kWd = null;
                    NewWriteModel.this.kHM.setAuthSid(null);
                    NewWriteModel.this.cXy();
                } else if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BZ(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kHM.setAuthSid(null);
                }
                if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }
        };
        this.dvg = tbPageContext;
    }

    public NewWriteModel() {
        this.kWd = null;
        this.kWe = null;
        this.kHM = null;
        this.kWf = null;
        this.kWg = null;
        this.kWh = null;
        this.kWj = null;
        this.kWk = null;
        this.kWl = false;
        this.gzc = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BY(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bHw() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kWd = null;
                    NewWriteModel.this.kHM.setAuthSid(null);
                    NewWriteModel.this.cXy();
                } else if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void BZ(String str) {
                if (NewWriteModel.this.kHM == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kWk != null) {
                        NewWriteModel.this.kWk.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kWd = null;
                NewWriteModel.this.kHM.setAuthSid(str);
                NewWriteModel.this.cXy();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.kHM != null) {
                    NewWriteModel.this.kHM.setAuthSid(null);
                }
                if (NewWriteModel.this.kWk != null) {
                    NewWriteModel.this.kWk.callback(false, null, null, null, null);
                }
            }
        };
        this.dvg = null;
    }

    public void ua(boolean z) {
        this.kWl = z;
    }

    public void b(d dVar) {
        this.kWk = dVar;
    }

    public void a(c cVar) {
        this.kWj = cVar;
    }

    public void a(a.InterfaceC0674a interfaceC0674a) {
        this.kWm = interfaceC0674a;
    }

    public void d(WriteData writeData) {
        this.kHM = writeData;
    }

    public WriteData cSK() {
        return this.kHM;
    }

    public boolean cXy() {
        if (this.kHM == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.kHM.getWriteImagesInfo() == null || this.kHM.getWriteImagesInfo().size() == 0 || !this.kHM.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            cXz();
        } else {
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.dvg == null) {
                cXz();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dvg.getPageActivity());
            aVar.kd(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cXz();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.dvg);
            aVar.aMS();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXz() {
        if (this.kWd == null) {
            this.kWd = new e();
            this.kWd.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.kWd != null && !this.kWd.isCancelled()) {
            this.kWd.cancel();
        } else if (this.kWk != null) {
            this.kWk.callback(false, null, null, null, null);
        } else if (this.kWj != null) {
            this.kWj.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kWd != null && !this.kWd.isCancelled()) {
            this.kWd.cancel();
            return false;
        }
        return false;
    }

    public void cXA() {
        if (this.kWe != null && !this.kWe.isCancelled()) {
            this.kWe.cancel();
        }
    }

    public boolean cXB() {
        if (this.kHM == null) {
            return true;
        }
        return (this.kHM.getWriteImagesInfo() != null ? this.kHM.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h kTM;
        private l kWq;
        private com.baidu.tieba.tbadkCore.c.a kWo = null;
        private String kWp = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.kWq = (l) runTask.getData();
            }
            if (this.kWq != null) {
                this.kTM = this.kWq.crX();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0189  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            JSONArray jSONArray;
            CustomDialogData customDialogData;
            VideoEasterEggData videoEasterEggData;
            String str;
            String str2;
            String str3;
            if (!this.isCanceled) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.kHM.getContent());
                this.kWo = new com.baidu.tieba.tbadkCore.c.a();
                this.kWo.a(this.kTM);
                this.kWo.a(NewWriteModel.this.kWm);
                this.kWp = this.kWo.a(NewWriteModel.this.kHM, NewWriteModel.this.kWl);
                ErrorData cWF = this.kWo.cWF();
                if (this.kWo.isRequestSuccess() && this.kWp != null) {
                    AntiData cWE = this.kWo.cWE();
                    String error_msg = cWF.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(cWF.getError_code(), error_msg, cWE);
                    if (NewWriteModel.this.kHM != null && NewWriteModel.this.kHM.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.kHM.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (cWF != null && cWF.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cWF.getError_code(), cWF.getError_msg(), null);
                    if (this.kWp != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.kWp).optJSONObject("info");
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
                } else if (cWF != null && cWF.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cWF.getError_code(), cWF.getError_msg(), null);
                    if (this.kWp != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.kWp).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bd bdVar = new bd();
                                bdVar.title = optJSONObject2.optString("block_content");
                                bdVar.dqd = optJSONObject2.optString("block_cancel");
                                bdVar.dqe = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bdVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (cWF != null && cWF.error_code != 0) {
                    String error_msg2 = cWF.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (cWF.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cWF.getError_code(), error_msg2, this.kWo.cWE());
                } else {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.neterror), null);
                }
                if (!bVar.hasError()) {
                    String str4 = null;
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    String str9 = null;
                    String str10 = null;
                    ContriInfo contriInfo = new ContriInfo();
                    int i2 = 0;
                    try {
                        if (this.kWp == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.kWp);
                            String optString = jSONObject.optString("msg");
                            try {
                                String optString2 = jSONObject.optString("pre_msg");
                                try {
                                    String optString3 = jSONObject.optString("color_msg");
                                    try {
                                        String optString4 = jSONObject.optString("tid");
                                        try {
                                            String optString5 = jSONObject.optString("pid");
                                            try {
                                                String optString6 = jSONObject.optString("video_id");
                                                try {
                                                    CustomDialogData m35do = com.baidu.tieba.pb.b.m35do(jSONObject);
                                                    try {
                                                        JSONObject optJSONObject3 = jSONObject.optJSONObject("twzhibo_info");
                                                        if (optJSONObject3 != null) {
                                                            i2 = optJSONObject3.optInt("is_copytwzhibo", 0);
                                                        }
                                                        JSONObject optJSONObject4 = jSONObject.optJSONObject("exp");
                                                        if (optJSONObject4 != null) {
                                                            str8 = optJSONObject4.optString("pre_msg");
                                                            try {
                                                                str9 = optJSONObject4.optString("color_msg");
                                                            } catch (JSONException e3) {
                                                                videoEasterEggData = null;
                                                                customDialogData = m35do;
                                                                str10 = optString6;
                                                                str3 = null;
                                                                str = str8;
                                                                str2 = optString5;
                                                                str7 = optString4;
                                                                str6 = optString3;
                                                                str5 = optString2;
                                                                str4 = optString;
                                                                e = e3;
                                                                e.printStackTrace();
                                                                if (StringUtils.isNull(str4)) {
                                                                }
                                                                bVar.setErrorString(str4);
                                                                bVar.setPreMsg(str5);
                                                                bVar.setColorMsg(str6);
                                                                bVar.setThreadId(str7);
                                                                bVar.setPostId(str2);
                                                                bVar.setIsCopyTWZhibo(i2);
                                                                bVar.Lg(str);
                                                                bVar.Lh(str3);
                                                                bVar.setActivityDialog(customDialogData);
                                                                bVar.setVideoId(str10);
                                                                bVar.setContriInfo(contriInfo);
                                                                bVar.setVideoEasterEggData(videoEasterEggData);
                                                                return bVar;
                                                            }
                                                        }
                                                        try {
                                                            contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                                                            JSONObject optJSONObject5 = jSONObject.optJSONObject("star_info");
                                                            if (optJSONObject5 == null) {
                                                                videoEasterEggData = null;
                                                                customDialogData = m35do;
                                                                str10 = optString6;
                                                                str3 = str9;
                                                                str = str8;
                                                                str2 = optString5;
                                                                str7 = optString4;
                                                                str6 = optString3;
                                                                str5 = optString2;
                                                                str4 = optString;
                                                            } else {
                                                                videoEasterEggData = new VideoEasterEggData();
                                                                try {
                                                                    videoEasterEggData.parseJson(optJSONObject5);
                                                                    customDialogData = m35do;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = m35do;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                    e = e4;
                                                                    e.printStackTrace();
                                                                    if (StringUtils.isNull(str4)) {
                                                                    }
                                                                    bVar.setErrorString(str4);
                                                                    bVar.setPreMsg(str5);
                                                                    bVar.setColorMsg(str6);
                                                                    bVar.setThreadId(str7);
                                                                    bVar.setPostId(str2);
                                                                    bVar.setIsCopyTWZhibo(i2);
                                                                    bVar.Lg(str);
                                                                    bVar.Lh(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = m35do;
                                                            str10 = optString6;
                                                            str3 = str9;
                                                            str = str8;
                                                            str2 = optString5;
                                                            str7 = optString4;
                                                            str6 = optString3;
                                                            str5 = optString2;
                                                            str4 = optString;
                                                            e = e5;
                                                        }
                                                    } catch (JSONException e6) {
                                                        videoEasterEggData = null;
                                                        customDialogData = m35do;
                                                        str10 = optString6;
                                                        str3 = null;
                                                        str = null;
                                                        str2 = optString5;
                                                        str7 = optString4;
                                                        str6 = optString3;
                                                        str5 = optString2;
                                                        str4 = optString;
                                                        e = e6;
                                                    }
                                                } catch (JSONException e7) {
                                                    str10 = optString6;
                                                    str3 = null;
                                                    str = null;
                                                    str2 = optString5;
                                                    str7 = optString4;
                                                    str6 = optString3;
                                                    str5 = optString2;
                                                    str4 = optString;
                                                    e = e7;
                                                    videoEasterEggData = null;
                                                    customDialogData = null;
                                                }
                                            } catch (JSONException e8) {
                                                str3 = null;
                                                str = null;
                                                str2 = optString5;
                                                str7 = optString4;
                                                str6 = optString3;
                                                str5 = optString2;
                                                str4 = optString;
                                                e = e8;
                                                videoEasterEggData = null;
                                                customDialogData = null;
                                            }
                                        } catch (JSONException e9) {
                                            str7 = optString4;
                                            str6 = optString3;
                                            str5 = optString2;
                                            str4 = optString;
                                            e = e9;
                                            str3 = null;
                                            str = null;
                                            str2 = null;
                                            videoEasterEggData = null;
                                            customDialogData = null;
                                        }
                                    } catch (JSONException e10) {
                                        str6 = optString3;
                                        str5 = optString2;
                                        str4 = optString;
                                        e = e10;
                                        str2 = null;
                                        str3 = null;
                                        str = null;
                                        customDialogData = null;
                                        videoEasterEggData = null;
                                    }
                                } catch (JSONException e11) {
                                    str5 = optString2;
                                    str4 = optString;
                                    e = e11;
                                    str = null;
                                    str2 = null;
                                    str3 = null;
                                    videoEasterEggData = null;
                                    customDialogData = null;
                                }
                            } catch (JSONException e12) {
                                str4 = optString;
                                e = e12;
                                videoEasterEggData = null;
                                customDialogData = null;
                                str2 = null;
                                str3 = null;
                                str = null;
                            }
                        }
                    } catch (JSONException e13) {
                        e = e13;
                        customDialogData = null;
                        videoEasterEggData = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    if (StringUtils.isNull(str4)) {
                        str4 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                    }
                    bVar.setErrorString(str4);
                    bVar.setPreMsg(str5);
                    bVar.setColorMsg(str6);
                    bVar.setThreadId(str7);
                    bVar.setPostId(str2);
                    bVar.setIsCopyTWZhibo(i2);
                    bVar.Lg(str);
                    bVar.Lh(str3);
                    bVar.setActivityDialog(customDialogData);
                    bVar.setVideoId(str10);
                    bVar.setContriInfo(contriInfo);
                    bVar.setVideoEasterEggData(videoEasterEggData);
                    return bVar;
                }
                return bVar;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String cXH;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.kWd = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.kWk == null) {
                        if (NewWriteModel.this.kWj != null) {
                            NewWriteModel.this.kWj.a(true, bVar.getErrorString(), null, null, bVar.bNE());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            cXH = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.cXH()) && StringUtils.isNull(bVar.cXG())) {
                            cXH = null;
                        } else {
                            str = bVar.cXG();
                            cXH = bVar.cXH();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, cXH);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.kHM != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.kHM.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.kHM.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        aa aaVar = new aa();
                        aaVar.parserJson(this.kWp);
                        NewWriteModel.this.kWk.callback(true, postWriteCallBackData, aaVar, NewWriteModel.this.kHM, bVar.bNE());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.kHM != null) {
                                switch (NewWriteModel.this.kHM.getType()) {
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
                            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.dvg, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.kTM != null) {
                        this.kTM.crB();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.kTM != null) {
                    this.kTM.bh(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.kWo != null) {
                this.kWo.cancel();
            }
            if (NewWriteModel.this.kWk != null) {
                NewWriteModel.this.kWk.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.kWj != null) {
                NewWriteModel.this.kWj.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.kWd = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.kWp), NewWriteModel.this.gzc)) {
                if (bVar.cXD()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cXE()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cXC()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(this.kWp);
                    if (aaVar.getVcode_pic_url() != null && NewWriteModel.this.kHM != null) {
                        NewWriteModel.this.kHM.setVcodeMD5(aaVar.getVcode_md5());
                        NewWriteModel.this.kHM.setVcodeUrl(aaVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, aaVar, NewWriteModel.this.kHM);
                    }
                } else if (bVar.cXF()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.kWp);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.kHM);
                } else if (bVar.isSensitiveError()) {
                    NewWriteModel.this.a(bVar);
                } else {
                    NewWriteModel.this.a(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        a(bVar, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        if (bVar != null && bVar.bNE() != null && bVar.bNE().mFrsForbidenDialogInfo != null) {
            AntiHelper.aX(this.dvg.getPageActivity(), bVar.bNE().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, aa aaVar, WriteData writeData) {
        if (bVar != null) {
            if (this.kWk != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.kWk.callback(false, postWriteCallBackData, aaVar, writeData, bVar.bNE());
            } else if (this.kWj != null) {
                this.kWj.a(false, bVar.getErrorString(), aaVar, writeData, bVar.bNE());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a kWo = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = m.isLocalImagePath(NewWriteModel.this.kWg);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.kWh == null || NewWriteModel.this.kWh.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.kWg) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.kWg);
                NewWriteModel.this.kWf = m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.kWf)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.kWf, this.kWo);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.kWh);
            if (this.bm != null) {
                NewWriteModel.this.kWf = m.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.kWf)) {
                    return NewWriteModel.this.a(NewWriteModel.this.kWf, this.kWo);
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
            this.isCanceled = true;
            if (this.kWo != null) {
                this.kWo.cancel();
            }
            if (NewWriteModel.this.kWi != null) {
                NewWriteModel.this.kWi.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.kWe = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.kWi != null) {
                    NewWriteModel.this.kWi.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bLk() {
        if (this.kWe == null) {
            this.kWe = new a();
            this.kWe.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.kWh = bArr;
        this.kWg = str;
    }

    public void a(b bVar) {
        this.kWi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aO(ar.aOS().getPostImageSize(), ar.aOS().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
