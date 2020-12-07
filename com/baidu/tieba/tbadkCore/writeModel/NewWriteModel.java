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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
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
import com.baidu.tieba.l.h;
import com.baidu.tieba.l.l;
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
    private final com.baidu.adp.base.e<?> eNZ;
    private f.a itC;
    private SpanGroupManager mSpanGroupManager;
    private WriteData nbc;
    private e npM;
    private a npN;
    private String npO;
    private String npP;
    private byte[] npQ;
    private b npR;
    private c npS;
    private d npT;
    private boolean npU;
    private a.InterfaceC0869a npV;

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
        this.npM = null;
        this.npN = null;
        this.nbc = null;
        this.npO = null;
        this.npP = null;
        this.npQ = null;
        this.npS = null;
        this.npT = null;
        this.npU = false;
        this.itC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuG() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.npM = null;
                    NewWriteModel.this.nbc.setAuthSid(null);
                    NewWriteModel.this.dQD();
                } else if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.nbc.setAuthSid(null);
                }
                if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.npM = null;
        this.npN = null;
        this.nbc = null;
        this.npO = null;
        this.npP = null;
        this.npQ = null;
        this.npS = null;
        this.npT = null;
        this.npU = false;
        this.itC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuG() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.npM = null;
                    NewWriteModel.this.nbc.setAuthSid(null);
                    NewWriteModel.this.dQD();
                } else if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.nbc.setAuthSid(null);
                }
                if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.npM = null;
        this.npN = null;
        this.nbc = null;
        this.npO = null;
        this.npP = null;
        this.npQ = null;
        this.npS = null;
        this.npT = null;
        this.npU = false;
        this.itC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuG() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.npM = null;
                    NewWriteModel.this.nbc.setAuthSid(null);
                    NewWriteModel.this.dQD();
                } else if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.nbc.setAuthSid(null);
                }
                if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = tbPageContext;
    }

    public NewWriteModel() {
        this.npM = null;
        this.npN = null;
        this.nbc = null;
        this.npO = null;
        this.npP = null;
        this.npQ = null;
        this.npS = null;
        this.npT = null;
        this.npU = false;
        this.itC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuG() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.npM = null;
                    NewWriteModel.this.nbc.setAuthSid(null);
                    NewWriteModel.this.dQD();
                } else if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbc == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npT != null) {
                        NewWriteModel.this.npT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npM = null;
                NewWriteModel.this.nbc.setAuthSid(str);
                NewWriteModel.this.dQD();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbc != null) {
                    NewWriteModel.this.nbc.setAuthSid(null);
                }
                if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = null;
    }

    public void yk(boolean z) {
        this.npU = z;
    }

    public void b(d dVar) {
        this.npT = dVar;
    }

    public void a(c cVar) {
        this.npS = cVar;
    }

    public void a(a.InterfaceC0869a interfaceC0869a) {
        this.npV = interfaceC0869a;
    }

    public void e(WriteData writeData) {
        this.nbc = writeData;
    }

    public WriteData dcD() {
        return this.nbc;
    }

    public boolean dQD() {
        if (this.nbc == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.nbc.getWriteImagesInfo() == null || this.nbc.getWriteImagesInfo().size() == 0 || !this.nbc.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dQE();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eNZ == null) {
                dQE();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNZ.getPageActivity());
            aVar.oQ(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dQE();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eNZ);
            aVar.brv();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQE() {
        if (this.npM == null) {
            this.npM = new e();
            this.npM.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.npM != null && !this.npM.isCancelled()) {
            this.npM.cancel();
        } else if (this.npT != null) {
            this.npT.callback(false, null, null, null, null);
        } else if (this.npS != null) {
            this.npS.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.npM != null && !this.npM.isCancelled()) {
            this.npM.cancel();
            return false;
        }
        return false;
    }

    public void dQF() {
        if (this.npN != null && !this.npN.isCancelled()) {
            this.npN.cancel();
        }
    }

    public boolean dQG() {
        if (this.nbc == null) {
            return true;
        }
        return (this.nbc.getWriteImagesInfo() != null ? this.nbc.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h nnb;
        private l npZ;
        private com.baidu.tieba.tbadkCore.c.a npX = null;
        private String npY = null;
        private boolean goz = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.npZ = (l) runTask.getData();
            }
            if (this.npZ != null) {
                this.nnb = this.npZ.djb();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01b0  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            JSONArray jSONArray;
            VideoEasterEggData videoEasterEggData;
            IconStampData iconStampData;
            String str;
            String str2;
            String str3;
            VideoEasterEggData videoEasterEggData2;
            if (!this.goz) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.nbc.getContent());
                this.npX = new com.baidu.tieba.tbadkCore.c.a();
                this.npX.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.npX.a(this.nnb);
                this.npX.a(NewWriteModel.this.npV);
                this.npY = this.npX.a(NewWriteModel.this.nbc, NewWriteModel.this.npU);
                ErrorData dPw = this.npX.dPw();
                if (this.npX.isRequestSuccess() && this.npY != null) {
                    AntiData dPv = this.npX.dPv();
                    String error_msg = dPw.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dPw.getError_code(), error_msg, dPv);
                    if (NewWriteModel.this.nbc != null && NewWriteModel.this.nbc.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.nbc.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dPw != null && dPw.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dPw.getError_code(), dPw.getError_msg(), null);
                    if (this.npY != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.npY).optJSONObject("info");
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
                } else if (dPw != null && dPw.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dPw.getError_code(), dPw.getError_msg(), null);
                    if (this.npY != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.npY).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                br brVar = new br();
                                brVar.title = optJSONObject2.optString("block_content");
                                brVar.eIh = optJSONObject2.optString("block_cancel");
                                brVar.eIi = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(brVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dPw != null && dPw.error_code != 0) {
                    String error_msg2 = dPw.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dPw.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dPw.getError_code(), error_msg2, this.npX.dPv());
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
                    CustomDialogData customDialogData = null;
                    ContriInfo contriInfo = new ContriInfo();
                    int i2 = 0;
                    try {
                        if (this.npY == null) {
                            videoEasterEggData = null;
                            iconStampData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.npY);
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
                                                    CustomDialogData er = com.baidu.tieba.pb.b.er(jSONObject);
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
                                                                customDialogData = er;
                                                                str10 = optString6;
                                                                str3 = null;
                                                                str = str8;
                                                                str2 = optString5;
                                                                str7 = optString4;
                                                                str6 = optString3;
                                                                str5 = optString2;
                                                                str4 = optString;
                                                                e = e3;
                                                                videoEasterEggData = null;
                                                                iconStampData = null;
                                                                e.printStackTrace();
                                                                if (StringUtils.isNull(str4)) {
                                                                }
                                                                bVar.setErrorString(str4);
                                                                bVar.setPreMsg(str5);
                                                                bVar.setColorMsg(str6);
                                                                bVar.setThreadId(str7);
                                                                bVar.setPostId(str2);
                                                                bVar.setIsCopyTWZhibo(i2);
                                                                bVar.Ug(str);
                                                                bVar.Uh(str3);
                                                                bVar.setActivityDialog(customDialogData);
                                                                bVar.setVideoId(str10);
                                                                bVar.setContriInfo(contriInfo);
                                                                bVar.setVideoEasterEggData(videoEasterEggData);
                                                                bVar.setIconStampData(iconStampData);
                                                                return bVar;
                                                            }
                                                        }
                                                        try {
                                                            contriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
                                                            JSONObject optJSONObject5 = jSONObject.optJSONObject("star_info");
                                                            if (optJSONObject5 == null) {
                                                                videoEasterEggData2 = null;
                                                            } else {
                                                                videoEasterEggData2 = new VideoEasterEggData();
                                                                try {
                                                                    videoEasterEggData2.parseJson(optJSONObject5);
                                                                } catch (JSONException e4) {
                                                                    iconStampData = null;
                                                                    videoEasterEggData = videoEasterEggData2;
                                                                    customDialogData = er;
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
                                                                    bVar.Ug(str);
                                                                    bVar.Uh(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    bVar.setIconStampData(iconStampData);
                                                                    return bVar;
                                                                }
                                                            }
                                                            JSONObject optJSONObject6 = jSONObject.optJSONObject("icon_stamp_info");
                                                            if (optJSONObject6 == null) {
                                                                iconStampData = null;
                                                                videoEasterEggData = videoEasterEggData2;
                                                                customDialogData = er;
                                                                str10 = optString6;
                                                                str3 = str9;
                                                                str = str8;
                                                                str2 = optString5;
                                                                str7 = optString4;
                                                                str6 = optString3;
                                                                str5 = optString2;
                                                                str4 = optString;
                                                            } else {
                                                                iconStampData = new IconStampData();
                                                                try {
                                                                    iconStampData.parseJson(optJSONObject6);
                                                                    videoEasterEggData = videoEasterEggData2;
                                                                    customDialogData = er;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e5) {
                                                                    videoEasterEggData = videoEasterEggData2;
                                                                    customDialogData = er;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                    e = e5;
                                                                    e.printStackTrace();
                                                                    if (StringUtils.isNull(str4)) {
                                                                    }
                                                                    bVar.setErrorString(str4);
                                                                    bVar.setPreMsg(str5);
                                                                    bVar.setColorMsg(str6);
                                                                    bVar.setThreadId(str7);
                                                                    bVar.setPostId(str2);
                                                                    bVar.setIsCopyTWZhibo(i2);
                                                                    bVar.Ug(str);
                                                                    bVar.Uh(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    bVar.setIconStampData(iconStampData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e6) {
                                                            customDialogData = er;
                                                            str10 = optString6;
                                                            str3 = str9;
                                                            str = str8;
                                                            str2 = optString5;
                                                            str7 = optString4;
                                                            str6 = optString3;
                                                            str5 = optString2;
                                                            str4 = optString;
                                                            e = e6;
                                                            videoEasterEggData = null;
                                                            iconStampData = null;
                                                        }
                                                    } catch (JSONException e7) {
                                                        customDialogData = er;
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
                                                        iconStampData = null;
                                                    }
                                                } catch (JSONException e8) {
                                                    str10 = optString6;
                                                    str3 = null;
                                                    str = null;
                                                    str2 = optString5;
                                                    str7 = optString4;
                                                    str6 = optString3;
                                                    str5 = optString2;
                                                    str4 = optString;
                                                    e = e8;
                                                    iconStampData = null;
                                                    videoEasterEggData = null;
                                                }
                                            } catch (JSONException e9) {
                                                str3 = null;
                                                str = null;
                                                str2 = optString5;
                                                str7 = optString4;
                                                str6 = optString3;
                                                str5 = optString2;
                                                str4 = optString;
                                                e = e9;
                                                iconStampData = null;
                                                videoEasterEggData = null;
                                            }
                                        } catch (JSONException e10) {
                                            str7 = optString4;
                                            str6 = optString3;
                                            str5 = optString2;
                                            str4 = optString;
                                            e = e10;
                                            str3 = null;
                                            str = null;
                                            str2 = null;
                                            iconStampData = null;
                                            videoEasterEggData = null;
                                        }
                                    } catch (JSONException e11) {
                                        str6 = optString3;
                                        str5 = optString2;
                                        str4 = optString;
                                        e = e11;
                                        str2 = null;
                                        str3 = null;
                                        str = null;
                                        videoEasterEggData = null;
                                        iconStampData = null;
                                    }
                                } catch (JSONException e12) {
                                    str5 = optString2;
                                    str4 = optString;
                                    e = e12;
                                    str = null;
                                    str2 = null;
                                    str3 = null;
                                    iconStampData = null;
                                    videoEasterEggData = null;
                                }
                            } catch (JSONException e13) {
                                str4 = optString;
                                e = e13;
                                iconStampData = null;
                                videoEasterEggData = null;
                                str2 = null;
                                str3 = null;
                                str = null;
                            }
                        }
                    } catch (JSONException e14) {
                        e = e14;
                        videoEasterEggData = null;
                        iconStampData = null;
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
                    bVar.Ug(str);
                    bVar.Uh(str3);
                    bVar.setActivityDialog(customDialogData);
                    bVar.setVideoId(str10);
                    bVar.setContriInfo(contriInfo);
                    bVar.setVideoEasterEggData(videoEasterEggData);
                    bVar.setIconStampData(iconStampData);
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
            String dQL;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.npM = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.goz && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.npT == null) {
                        if (NewWriteModel.this.npS != null) {
                            NewWriteModel.this.npS.a(true, bVar.getErrorString(), null, null, bVar.cBe());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            dQL = bVar.getPreMsg();
                            str = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dQM()) && StringUtils.isNull(bVar.dQL())) {
                            dQL = null;
                        } else {
                            dQL = bVar.dQL();
                            str = bVar.dQM();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), dQL, str);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.nbc != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.nbc.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.nbc.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        postWriteCallBackData.setIconStampData(bVar.getIconStampData());
                        ah ahVar = new ah();
                        ahVar.parserJson(this.npY);
                        NewWriteModel.this.npT.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.nbc, bVar.cBe());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && bVar.getIconStampData() == null) {
                            if (NewWriteModel.this.nbc != null) {
                                switch (NewWriteModel.this.nbc.getType()) {
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
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eNZ, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(bVar.getIconStampData() == null)));
                    if (this.nnb != null) {
                        this.nnb.diM();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.nnb != null) {
                    this.nnb.bG(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.goz = true;
            if (this.npX != null) {
                this.npX.cancel();
            }
            if (NewWriteModel.this.npT != null) {
                NewWriteModel.this.npT.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.npS != null) {
                NewWriteModel.this.npS.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.npM = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.npY), NewWriteModel.this.itC)) {
                if (bVar.dQI()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dQJ()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dQH()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.npY);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.nbc != null) {
                        NewWriteModel.this.nbc.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.nbc.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, ahVar, NewWriteModel.this.nbc);
                    }
                } else if (bVar.dQK()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.npY);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.nbc);
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
        if (bVar != null && bVar.cBe() != null && bVar.cBe().mFrsForbidenDialogInfo != null) {
            AntiHelper.bo(this.eNZ.getPageActivity(), bVar.cBe().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (bVar != null) {
            if (this.npT != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.npT.callback(false, postWriteCallBackData, ahVar, writeData, bVar.cBe());
            } else if (this.npS != null) {
                this.npS.a(false, bVar.getErrorString(), ahVar, writeData, bVar.cBe());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean goz = false;
        com.baidu.tieba.tbadkCore.c.a npX = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.npP);
            if (this.goz) {
                return null;
            }
            if (NewWriteModel.this.npQ == null || NewWriteModel.this.npQ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.npP) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.npP);
                NewWriteModel.this.npO = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.npO)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.npO, this.npX);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.npQ);
            if (this.bm != null) {
                NewWriteModel.this.npO = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.npO)) {
                    return NewWriteModel.this.a(NewWriteModel.this.npO, this.npX);
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
            this.goz = true;
            if (this.npX != null) {
                this.npX.cancel();
            }
            if (NewWriteModel.this.npR != null) {
                NewWriteModel.this.npR.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.npN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.goz) {
                if (NewWriteModel.this.npR != null) {
                    NewWriteModel.this.npR.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cyG() {
        if (this.npN == null) {
            this.npN = new a();
            this.npN.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.npQ = bArr;
        this.npP = str;
    }

    public void a(b bVar) {
        this.npR = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bi(av.btX().getPostImageSize(), av.btX().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
