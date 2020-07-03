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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
    private final com.baidu.adp.base.e<?> dPR;
    private f.a haT;
    private e lJF;
    private a lJG;
    private String lJH;
    private String lJI;
    private byte[] lJJ;
    private b lJK;
    private c lJL;
    private d lJM;
    private boolean lJN;
    private a.InterfaceC0744a lJO;
    private WriteData lvi;
    private SpanGroupManager mSpanGroupManager;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, ad adVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lJF = null;
        this.lJG = null;
        this.lvi = null;
        this.lJH = null;
        this.lJI = null;
        this.lJJ = null;
        this.lJL = null;
        this.lJM = null;
        this.lJN = false;
        this.haT = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ei(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bQX() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lJF = null;
                    NewWriteModel.this.lvi.setAuthSid(null);
                    NewWriteModel.this.djn();
                } else if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ej(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lvi.setAuthSid(null);
                }
                if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }
        };
        this.dPR = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lJF = null;
        this.lJG = null;
        this.lvi = null;
        this.lJH = null;
        this.lJI = null;
        this.lJJ = null;
        this.lJL = null;
        this.lJM = null;
        this.lJN = false;
        this.haT = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ei(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bQX() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lJF = null;
                    NewWriteModel.this.lvi.setAuthSid(null);
                    NewWriteModel.this.djn();
                } else if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ej(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lvi.setAuthSid(null);
                }
                if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }
        };
        this.dPR = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.lJF = null;
        this.lJG = null;
        this.lvi = null;
        this.lJH = null;
        this.lJI = null;
        this.lJJ = null;
        this.lJL = null;
        this.lJM = null;
        this.lJN = false;
        this.haT = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ei(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bQX() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lJF = null;
                    NewWriteModel.this.lvi.setAuthSid(null);
                    NewWriteModel.this.djn();
                } else if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ej(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lvi.setAuthSid(null);
                }
                if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }
        };
        this.dPR = tbPageContext;
    }

    public NewWriteModel() {
        this.lJF = null;
        this.lJG = null;
        this.lvi = null;
        this.lJH = null;
        this.lJI = null;
        this.lJJ = null;
        this.lJL = null;
        this.lJM = null;
        this.lJN = false;
        this.haT = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ei(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bQX() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lJF = null;
                    NewWriteModel.this.lvi.setAuthSid(null);
                    NewWriteModel.this.djn();
                } else if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ej(String str) {
                if (NewWriteModel.this.lvi == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lJM != null) {
                        NewWriteModel.this.lJM.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lJF = null;
                NewWriteModel.this.lvi.setAuthSid(str);
                NewWriteModel.this.djn();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lvi != null) {
                    NewWriteModel.this.lvi.setAuthSid(null);
                }
                if (NewWriteModel.this.lJM != null) {
                    NewWriteModel.this.lJM.callback(false, null, null, null, null);
                }
            }
        };
        this.dPR = null;
    }

    public void uN(boolean z) {
        this.lJN = z;
    }

    public void b(d dVar) {
        this.lJM = dVar;
    }

    public void a(c cVar) {
        this.lJL = cVar;
    }

    public void a(a.InterfaceC0744a interfaceC0744a) {
        this.lJO = interfaceC0744a;
    }

    public void d(WriteData writeData) {
        this.lvi = writeData;
    }

    public WriteData dev() {
        return this.lvi;
    }

    public boolean djn() {
        if (this.lvi == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.lvi.getWriteImagesInfo() == null || this.lvi.getWriteImagesInfo().size() == 0 || !this.lvi.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            djo();
        } else {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.dPR == null) {
                djo();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPR.getPageActivity());
            aVar.kT(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.djo();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.dPR);
            aVar.aUN();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djo() {
        if (this.lJF == null) {
            this.lJF = new e();
            this.lJF.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.lJF != null && !this.lJF.isCancelled()) {
            this.lJF.cancel();
        } else if (this.lJM != null) {
            this.lJM.callback(false, null, null, null, null);
        } else if (this.lJL != null) {
            this.lJL.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lJF != null && !this.lJF.isCancelled()) {
            this.lJF.cancel();
            return false;
        }
        return false;
    }

    public void djp() {
        if (this.lJG != null && !this.lJG.isCancelled()) {
            this.lJG.cancel();
        }
    }

    public boolean djq() {
        if (this.lvi == null) {
            return true;
        }
        return (this.lvi.getWriteImagesInfo() != null ? this.lvi.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h lHf;
        private l lJS;
        private com.baidu.tieba.tbadkCore.c.a lJQ = null;
        private String lJR = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.lJS = (l) runTask.getData();
            }
            if (this.lJS != null) {
                this.lHf = this.lJS.cCP();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0198  */
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.lvi.getContent());
                this.lJQ = new com.baidu.tieba.tbadkCore.c.a();
                this.lJQ.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.lJQ.a(this.lHf);
                this.lJQ.a(NewWriteModel.this.lJO);
                this.lJR = this.lJQ.a(NewWriteModel.this.lvi, NewWriteModel.this.lJN);
                ErrorData dio = this.lJQ.dio();
                if (this.lJQ.isRequestSuccess() && this.lJR != null) {
                    AntiData din = this.lJQ.din();
                    String error_msg = dio.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dio.getError_code(), error_msg, din);
                    if (NewWriteModel.this.lvi != null && NewWriteModel.this.lvi.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.lvi.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dio != null && dio.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dio.getError_code(), dio.getError_msg(), null);
                    if (this.lJR != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.lJR).optJSONObject("info");
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
                } else if (dio != null && dio.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dio.getError_code(), dio.getError_msg(), null);
                    if (this.lJR != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.lJR).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bn bnVar = new bn();
                                bnVar.title = optJSONObject2.optString("block_content");
                                bnVar.dKC = optJSONObject2.optString("block_cancel");
                                bnVar.dKD = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bnVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dio != null && dio.error_code != 0) {
                    String error_msg2 = dio.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dio.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dio.getError_code(), error_msg2, this.lJQ.din());
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
                        if (this.lJR == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.lJR);
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
                                                    CustomDialogData dF = com.baidu.tieba.pb.b.dF(jSONObject);
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
                                                                customDialogData = dF;
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
                                                                bVar.Nw(str);
                                                                bVar.Nx(str3);
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
                                                                customDialogData = dF;
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
                                                                    customDialogData = dF;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = dF;
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
                                                                    bVar.Nw(str);
                                                                    bVar.Nx(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = dF;
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
                                                        customDialogData = dF;
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
                    bVar.Nw(str);
                    bVar.Nx(str3);
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
            String djw;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.lJF = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.lJM == null) {
                        if (NewWriteModel.this.lJL != null) {
                            NewWriteModel.this.lJL.a(true, bVar.getErrorString(), null, null, bVar.bXd());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            djw = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.djw()) && StringUtils.isNull(bVar.djv())) {
                            djw = null;
                        } else {
                            str = bVar.djv();
                            djw = bVar.djw();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, djw);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.lvi != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.lvi.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.lvi.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        ad adVar = new ad();
                        adVar.parserJson(this.lJR);
                        NewWriteModel.this.lJM.callback(true, postWriteCallBackData, adVar, NewWriteModel.this.lvi, bVar.bXd());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.lvi != null) {
                                switch (NewWriteModel.this.lvi.getType()) {
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
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.dPR, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.lHf != null) {
                        this.lHf.cCt();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.lHf != null) {
                    this.lHf.bq(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.lJQ != null) {
                this.lJQ.cancel();
            }
            if (NewWriteModel.this.lJM != null) {
                NewWriteModel.this.lJM.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.lJL != null) {
                NewWriteModel.this.lJL.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.lJF = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.lJR), NewWriteModel.this.haT)) {
                if (bVar.djs()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.djt()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.djr()) {
                    ad adVar = new ad();
                    adVar.parserJson(this.lJR);
                    if (adVar.getVcode_pic_url() != null && NewWriteModel.this.lvi != null) {
                        NewWriteModel.this.lvi.setVcodeMD5(adVar.getVcode_md5());
                        NewWriteModel.this.lvi.setVcodeUrl(adVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, adVar, NewWriteModel.this.lvi);
                    }
                } else if (bVar.dju()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.lJR);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.lvi);
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
        if (bVar != null && bVar.bXd() != null && bVar.bXd().mFrsForbidenDialogInfo != null) {
            AntiHelper.aY(this.dPR.getPageActivity(), bVar.bXd().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ad adVar, WriteData writeData) {
        if (bVar != null) {
            if (this.lJM != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.lJM.callback(false, postWriteCallBackData, adVar, writeData, bVar.bXd());
            } else if (this.lJL != null) {
                this.lJL.a(false, bVar.getErrorString(), adVar, writeData, bVar.bXd());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a lJQ = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.lJI);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.lJJ == null || NewWriteModel.this.lJJ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.lJI) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.lJI);
                NewWriteModel.this.lJH = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.lJH)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.lJH, this.lJQ);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.lJJ);
            if (this.bm != null) {
                NewWriteModel.this.lJH = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.lJH)) {
                    return NewWriteModel.this.a(NewWriteModel.this.lJH, this.lJQ);
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
            if (this.lJQ != null) {
                this.lJQ.cancel();
            }
            if (NewWriteModel.this.lJK != null) {
                NewWriteModel.this.lJK.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.lJG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.lJK != null) {
                    NewWriteModel.this.lJK.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bUE() {
        if (this.lJG == null) {
            this.lJG = new a();
            this.lJG.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.lJJ = bArr;
        this.lJI = str;
    }

    public void a(b bVar) {
        this.lJK = bVar;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aW(as.aWR().getPostImageSize(), as.aWR().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
