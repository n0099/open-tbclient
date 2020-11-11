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
import com.baidu.tbadk.core.data.bp;
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
    private final com.baidu.adp.base.e<?> eIz;
    private f.a ihV;
    private WriteData mMg;
    private SpanGroupManager mSpanGroupManager;
    private e naI;
    private a naJ;
    private String naK;
    private String naL;
    private byte[] naM;
    private b naN;
    private c naO;
    private d naP;
    private boolean naQ;
    private a.InterfaceC0852a naR;

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
        this.naI = null;
        this.naJ = null;
        this.mMg = null;
        this.naK = null;
        this.naL = null;
        this.naM = null;
        this.naO = null;
        this.naP = null;
        this.naQ = false;
        this.ihV = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jt(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cqP() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.naI = null;
                    NewWriteModel.this.mMg.setAuthSid(null);
                    NewWriteModel.this.dLm();
                } else if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ju(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.mMg.setAuthSid(null);
                }
                if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }
        };
        this.eIz = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.naI = null;
        this.naJ = null;
        this.mMg = null;
        this.naK = null;
        this.naL = null;
        this.naM = null;
        this.naO = null;
        this.naP = null;
        this.naQ = false;
        this.ihV = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jt(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cqP() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.naI = null;
                    NewWriteModel.this.mMg.setAuthSid(null);
                    NewWriteModel.this.dLm();
                } else if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ju(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.mMg.setAuthSid(null);
                }
                if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }
        };
        this.eIz = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.naI = null;
        this.naJ = null;
        this.mMg = null;
        this.naK = null;
        this.naL = null;
        this.naM = null;
        this.naO = null;
        this.naP = null;
        this.naQ = false;
        this.ihV = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jt(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cqP() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.naI = null;
                    NewWriteModel.this.mMg.setAuthSid(null);
                    NewWriteModel.this.dLm();
                } else if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ju(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.mMg.setAuthSid(null);
                }
                if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }
        };
        this.eIz = tbPageContext;
    }

    public NewWriteModel() {
        this.naI = null;
        this.naJ = null;
        this.mMg = null;
        this.naK = null;
        this.naL = null;
        this.naM = null;
        this.naO = null;
        this.naP = null;
        this.naQ = false;
        this.ihV = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jt(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cqP() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.naI = null;
                    NewWriteModel.this.mMg.setAuthSid(null);
                    NewWriteModel.this.dLm();
                } else if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ju(String str) {
                if (NewWriteModel.this.mMg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.naP != null) {
                        NewWriteModel.this.naP.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.naI = null;
                NewWriteModel.this.mMg.setAuthSid(str);
                NewWriteModel.this.dLm();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mMg != null) {
                    NewWriteModel.this.mMg.setAuthSid(null);
                }
                if (NewWriteModel.this.naP != null) {
                    NewWriteModel.this.naP.callback(false, null, null, null, null);
                }
            }
        };
        this.eIz = null;
    }

    public void xy(boolean z) {
        this.naQ = z;
    }

    public void b(d dVar) {
        this.naP = dVar;
    }

    public void a(c cVar) {
        this.naO = cVar;
    }

    public void a(a.InterfaceC0852a interfaceC0852a) {
        this.naR = interfaceC0852a;
    }

    public void e(WriteData writeData) {
        this.mMg = writeData;
    }

    public WriteData cXW() {
        return this.mMg;
    }

    public boolean dLm() {
        if (this.mMg == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.mMg.getWriteImagesInfo() == null || this.mMg.getWriteImagesInfo().size() == 0 || !this.mMg.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dLn();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eIz == null) {
                dLn();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIz.getPageActivity());
            aVar.ow(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dLn();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eIz);
            aVar.bpc();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLn() {
        if (this.naI == null) {
            this.naI = new e();
            this.naI.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.naI != null && !this.naI.isCancelled()) {
            this.naI.cancel();
        } else if (this.naP != null) {
            this.naP.callback(false, null, null, null, null);
        } else if (this.naO != null) {
            this.naO.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.naI != null && !this.naI.isCancelled()) {
            this.naI.cancel();
            return false;
        }
        return false;
    }

    public void dLo() {
        if (this.naJ != null && !this.naJ.isCancelled()) {
            this.naJ.cancel();
        }
    }

    public boolean dLp() {
        if (this.mMg == null) {
            return true;
        }
        return (this.mMg.getWriteImagesInfo() != null ? this.mMg.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h mYk;
        private l naV;
        private com.baidu.tieba.tbadkCore.c.a naT = null;
        private String naU = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.naV = (l) runTask.getData();
            }
            if (this.naV != null) {
                this.mYk = this.naV.det();
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
            if (!this.isCanceled) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.mMg.getContent());
                this.naT = new com.baidu.tieba.tbadkCore.c.a();
                this.naT.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.naT.a(this.mYk);
                this.naT.a(NewWriteModel.this.naR);
                this.naU = this.naT.a(NewWriteModel.this.mMg, NewWriteModel.this.naQ);
                ErrorData dKp = this.naT.dKp();
                if (this.naT.isRequestSuccess() && this.naU != null) {
                    AntiData dKo = this.naT.dKo();
                    String error_msg = dKp.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dKp.getError_code(), error_msg, dKo);
                    if (NewWriteModel.this.mMg != null && NewWriteModel.this.mMg.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.mMg.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dKp != null && dKp.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dKp.getError_code(), dKp.getError_msg(), null);
                    if (this.naU != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.naU).optJSONObject("info");
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
                } else if (dKp != null && dKp.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dKp.getError_code(), dKp.getError_msg(), null);
                    if (this.naU != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.naU).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bp bpVar = new bp();
                                bpVar.title = optJSONObject2.optString("block_content");
                                bpVar.eCQ = optJSONObject2.optString("block_cancel");
                                bpVar.eCR = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bpVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dKp != null && dKp.error_code != 0) {
                    String error_msg2 = dKp.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dKp.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dKp.getError_code(), error_msg2, this.naT.dKo());
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
                        if (this.naU == null) {
                            videoEasterEggData = null;
                            iconStampData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.naU);
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
                                                    CustomDialogData ev = com.baidu.tieba.pb.b.ev(jSONObject);
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
                                                                customDialogData = ev;
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
                                                                bVar.Tg(str);
                                                                bVar.Th(str3);
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
                                                                    customDialogData = ev;
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
                                                                    bVar.Tg(str);
                                                                    bVar.Th(str3);
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
                                                                customDialogData = ev;
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
                                                                    customDialogData = ev;
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
                                                                    customDialogData = ev;
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
                                                                    bVar.Tg(str);
                                                                    bVar.Th(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    bVar.setIconStampData(iconStampData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e6) {
                                                            customDialogData = ev;
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
                                                        customDialogData = ev;
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
                    bVar.Tg(str);
                    bVar.Th(str3);
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
            String dLu;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.naI = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.naP == null) {
                        if (NewWriteModel.this.naO != null) {
                            NewWriteModel.this.naO.a(true, bVar.getErrorString(), null, null, bVar.cxn());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            dLu = bVar.getPreMsg();
                            str = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dLv()) && StringUtils.isNull(bVar.dLu())) {
                            dLu = null;
                        } else {
                            dLu = bVar.dLu();
                            str = bVar.dLv();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), dLu, str);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.mMg != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.mMg.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.mMg.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        postWriteCallBackData.setIconStampData(bVar.getIconStampData());
                        ah ahVar = new ah();
                        ahVar.parserJson(this.naU);
                        NewWriteModel.this.naP.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.mMg, bVar.cxn());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && bVar.getIconStampData() == null) {
                            if (NewWriteModel.this.mMg != null) {
                                switch (NewWriteModel.this.mMg.getType()) {
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
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eIz, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(bVar.getIconStampData() == null)));
                    if (this.mYk != null) {
                        this.mYk.dee();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.mYk != null) {
                    this.mYk.bI(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.naT != null) {
                this.naT.cancel();
            }
            if (NewWriteModel.this.naP != null) {
                NewWriteModel.this.naP.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.naO != null) {
                NewWriteModel.this.naO.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.naI = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.naU), NewWriteModel.this.ihV)) {
                if (bVar.dLr()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dLs()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dLq()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.naU);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.mMg != null) {
                        NewWriteModel.this.mMg.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.mMg.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, ahVar, NewWriteModel.this.mMg);
                    }
                } else if (bVar.dLt()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.naU);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mMg);
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
        if (bVar != null && bVar.cxn() != null && bVar.cxn().mFrsForbidenDialogInfo != null) {
            AntiHelper.bn(this.eIz.getPageActivity(), bVar.cxn().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (bVar != null) {
            if (this.naP != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.naP.callback(false, postWriteCallBackData, ahVar, writeData, bVar.cxn());
            } else if (this.naO != null) {
                this.naO.a(false, bVar.getErrorString(), ahVar, writeData, bVar.cxn());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a naT = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.naL);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.naM == null || NewWriteModel.this.naM.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.naL) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.naL);
                NewWriteModel.this.naK = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.naK)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.naK, this.naT);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.naM);
            if (this.bm != null) {
                NewWriteModel.this.naK = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.naK)) {
                    return NewWriteModel.this.a(NewWriteModel.this.naK, this.naT);
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
            if (this.naT != null) {
                this.naT.cancel();
            }
            if (NewWriteModel.this.naN != null) {
                NewWriteModel.this.naN.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.naJ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.naN != null) {
                    NewWriteModel.this.naN.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cuO() {
        if (this.naJ == null) {
            this.naJ = new a();
            this.naJ.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.naM = bArr;
        this.naL = str;
    }

    public void a(b bVar) {
        this.naN = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bg(au.bro().getPostImageSize(), au.bro().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
