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
    private f.a itE;
    private SpanGroupManager mSpanGroupManager;
    private WriteData nbe;
    private e npO;
    private a npP;
    private String npQ;
    private String npR;
    private byte[] npS;
    private b npT;
    private c npU;
    private d npV;
    private boolean npW;
    private a.InterfaceC0869a npX;

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
        this.npO = null;
        this.npP = null;
        this.nbe = null;
        this.npQ = null;
        this.npR = null;
        this.npS = null;
        this.npU = null;
        this.npV = null;
        this.npW = false;
        this.itE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuH() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.npO = null;
                    NewWriteModel.this.nbe.setAuthSid(null);
                    NewWriteModel.this.dQE();
                } else if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.nbe.setAuthSid(null);
                }
                if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.npO = null;
        this.npP = null;
        this.nbe = null;
        this.npQ = null;
        this.npR = null;
        this.npS = null;
        this.npU = null;
        this.npV = null;
        this.npW = false;
        this.itE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuH() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.npO = null;
                    NewWriteModel.this.nbe.setAuthSid(null);
                    NewWriteModel.this.dQE();
                } else if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.nbe.setAuthSid(null);
                }
                if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.npO = null;
        this.npP = null;
        this.nbe = null;
        this.npQ = null;
        this.npR = null;
        this.npS = null;
        this.npU = null;
        this.npV = null;
        this.npW = false;
        this.itE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuH() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.npO = null;
                    NewWriteModel.this.nbe.setAuthSid(null);
                    NewWriteModel.this.dQE();
                } else if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.nbe.setAuthSid(null);
                }
                if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = tbPageContext;
    }

    public NewWriteModel() {
        this.npO = null;
        this.npP = null;
        this.nbe = null;
        this.npQ = null;
        this.npR = null;
        this.npS = null;
        this.npU = null;
        this.npV = null;
        this.npW = false;
        this.itE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JK(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cuH() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.npO = null;
                    NewWriteModel.this.nbe.setAuthSid(null);
                    NewWriteModel.this.dQE();
                } else if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void JL(String str) {
                if (NewWriteModel.this.nbe == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.npV != null) {
                        NewWriteModel.this.npV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.npO = null;
                NewWriteModel.this.nbe.setAuthSid(str);
                NewWriteModel.this.dQE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.nbe != null) {
                    NewWriteModel.this.nbe.setAuthSid(null);
                }
                if (NewWriteModel.this.npV != null) {
                    NewWriteModel.this.npV.callback(false, null, null, null, null);
                }
            }
        };
        this.eNZ = null;
    }

    public void yk(boolean z) {
        this.npW = z;
    }

    public void b(d dVar) {
        this.npV = dVar;
    }

    public void a(c cVar) {
        this.npU = cVar;
    }

    public void a(a.InterfaceC0869a interfaceC0869a) {
        this.npX = interfaceC0869a;
    }

    public void e(WriteData writeData) {
        this.nbe = writeData;
    }

    public WriteData dcE() {
        return this.nbe;
    }

    public boolean dQE() {
        if (this.nbe == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.nbe.getWriteImagesInfo() == null || this.nbe.getWriteImagesInfo().size() == 0 || !this.nbe.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dQF();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eNZ == null) {
                dQF();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNZ.getPageActivity());
            aVar.oQ(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dQF();
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
    public void dQF() {
        if (this.npO == null) {
            this.npO = new e();
            this.npO.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.npO != null && !this.npO.isCancelled()) {
            this.npO.cancel();
        } else if (this.npV != null) {
            this.npV.callback(false, null, null, null, null);
        } else if (this.npU != null) {
            this.npU.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.npO != null && !this.npO.isCancelled()) {
            this.npO.cancel();
            return false;
        }
        return false;
    }

    public void dQG() {
        if (this.npP != null && !this.npP.isCancelled()) {
            this.npP.cancel();
        }
    }

    public boolean dQH() {
        if (this.nbe == null) {
            return true;
        }
        return (this.nbe.getWriteImagesInfo() != null ? this.nbe.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h nnd;
        private l nqb;
        private com.baidu.tieba.tbadkCore.c.a npZ = null;
        private String nqa = null;
        private boolean goB = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.nqb = (l) runTask.getData();
            }
            if (this.nqb != null) {
                this.nnd = this.nqb.djc();
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
            if (!this.goB) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.nbe.getContent());
                this.npZ = new com.baidu.tieba.tbadkCore.c.a();
                this.npZ.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.npZ.a(this.nnd);
                this.npZ.a(NewWriteModel.this.npX);
                this.nqa = this.npZ.a(NewWriteModel.this.nbe, NewWriteModel.this.npW);
                ErrorData dPx = this.npZ.dPx();
                if (this.npZ.isRequestSuccess() && this.nqa != null) {
                    AntiData dPw = this.npZ.dPw();
                    String error_msg = dPx.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dPx.getError_code(), error_msg, dPw);
                    if (NewWriteModel.this.nbe != null && NewWriteModel.this.nbe.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.nbe.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dPx != null && dPx.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dPx.getError_code(), dPx.getError_msg(), null);
                    if (this.nqa != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.nqa).optJSONObject("info");
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
                } else if (dPx != null && dPx.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dPx.getError_code(), dPx.getError_msg(), null);
                    if (this.nqa != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.nqa).optJSONObject("info");
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
                } else if (dPx != null && dPx.error_code != 0) {
                    String error_msg2 = dPx.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dPx.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dPx.getError_code(), error_msg2, this.npZ.dPw());
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
                        if (this.nqa == null) {
                            videoEasterEggData = null;
                            iconStampData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.nqa);
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
            String dQM;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.npO = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.goB && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.npV == null) {
                        if (NewWriteModel.this.npU != null) {
                            NewWriteModel.this.npU.a(true, bVar.getErrorString(), null, null, bVar.cBf());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            dQM = bVar.getPreMsg();
                            str = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dQN()) && StringUtils.isNull(bVar.dQM())) {
                            dQM = null;
                        } else {
                            dQM = bVar.dQM();
                            str = bVar.dQN();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), dQM, str);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.nbe != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.nbe.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.nbe.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        postWriteCallBackData.setIconStampData(bVar.getIconStampData());
                        ah ahVar = new ah();
                        ahVar.parserJson(this.nqa);
                        NewWriteModel.this.npV.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.nbe, bVar.cBf());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && bVar.getIconStampData() == null) {
                            if (NewWriteModel.this.nbe != null) {
                                switch (NewWriteModel.this.nbe.getType()) {
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
                    if (this.nnd != null) {
                        this.nnd.diN();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.nnd != null) {
                    this.nnd.bG(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.goB = true;
            if (this.npZ != null) {
                this.npZ.cancel();
            }
            if (NewWriteModel.this.npV != null) {
                NewWriteModel.this.npV.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.npU != null) {
                NewWriteModel.this.npU.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.npO = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.nqa), NewWriteModel.this.itE)) {
                if (bVar.dQJ()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dQK()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dQI()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.nqa);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.nbe != null) {
                        NewWriteModel.this.nbe.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.nbe.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, ahVar, NewWriteModel.this.nbe);
                    }
                } else if (bVar.dQL()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.nqa);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.nbe);
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
        if (bVar != null && bVar.cBf() != null && bVar.cBf().mFrsForbidenDialogInfo != null) {
            AntiHelper.bo(this.eNZ.getPageActivity(), bVar.cBf().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (bVar != null) {
            if (this.npV != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.npV.callback(false, postWriteCallBackData, ahVar, writeData, bVar.cBf());
            } else if (this.npU != null) {
                this.npU.a(false, bVar.getErrorString(), ahVar, writeData, bVar.cBf());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean goB = false;
        com.baidu.tieba.tbadkCore.c.a npZ = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.npR);
            if (this.goB) {
                return null;
            }
            if (NewWriteModel.this.npS == null || NewWriteModel.this.npS.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.npR) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.npR);
                NewWriteModel.this.npQ = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.npQ)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.npQ, this.npZ);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.npS);
            if (this.bm != null) {
                NewWriteModel.this.npQ = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.npQ)) {
                    return NewWriteModel.this.a(NewWriteModel.this.npQ, this.npZ);
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
            this.goB = true;
            if (this.npZ != null) {
                this.npZ.cancel();
            }
            if (NewWriteModel.this.npT != null) {
                NewWriteModel.this.npT.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.npP = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.goB) {
                if (NewWriteModel.this.npT != null) {
                    NewWriteModel.this.npT.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cyH() {
        if (this.npP == null) {
            this.npP = new a();
            this.npP.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.npS = bArr;
        this.npR = str;
    }

    public void a(b bVar) {
        this.npT = bVar;
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
