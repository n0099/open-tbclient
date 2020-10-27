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
    private final com.baidu.adp.base.e<?> eCK;
    private f.a ibU;
    private WriteData mGf;
    private SpanGroupManager mSpanGroupManager;
    private e mUM;
    private a mUN;
    private String mUO;
    private String mUP;
    private byte[] mUQ;
    private b mUR;
    private c mUS;
    private d mUT;
    private boolean mUU;
    private a.InterfaceC0837a mUV;

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
        this.mUM = null;
        this.mUN = null;
        this.mGf = null;
        this.mUO = null;
        this.mUP = null;
        this.mUQ = null;
        this.mUS = null;
        this.mUT = null;
        this.mUU = false;
        this.ibU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jc(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void coo() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mUM = null;
                    NewWriteModel.this.mGf.setAuthSid(null);
                    NewWriteModel.this.dIK();
                } else if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jd(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mGf.setAuthSid(null);
                }
                if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }
        };
        this.eCK = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mUM = null;
        this.mUN = null;
        this.mGf = null;
        this.mUO = null;
        this.mUP = null;
        this.mUQ = null;
        this.mUS = null;
        this.mUT = null;
        this.mUU = false;
        this.ibU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jc(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void coo() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mUM = null;
                    NewWriteModel.this.mGf.setAuthSid(null);
                    NewWriteModel.this.dIK();
                } else if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jd(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mGf.setAuthSid(null);
                }
                if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }
        };
        this.eCK = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mUM = null;
        this.mUN = null;
        this.mGf = null;
        this.mUO = null;
        this.mUP = null;
        this.mUQ = null;
        this.mUS = null;
        this.mUT = null;
        this.mUU = false;
        this.ibU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jc(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void coo() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mUM = null;
                    NewWriteModel.this.mGf.setAuthSid(null);
                    NewWriteModel.this.dIK();
                } else if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jd(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mGf.setAuthSid(null);
                }
                if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }
        };
        this.eCK = tbPageContext;
    }

    public NewWriteModel() {
        this.mUM = null;
        this.mUN = null;
        this.mGf = null;
        this.mUO = null;
        this.mUP = null;
        this.mUQ = null;
        this.mUS = null;
        this.mUT = null;
        this.mUU = false;
        this.ibU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jc(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void coo() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mUM = null;
                    NewWriteModel.this.mGf.setAuthSid(null);
                    NewWriteModel.this.dIK();
                } else if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Jd(String str) {
                if (NewWriteModel.this.mGf == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mUT != null) {
                        NewWriteModel.this.mUT.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mUM = null;
                NewWriteModel.this.mGf.setAuthSid(str);
                NewWriteModel.this.dIK();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mGf != null) {
                    NewWriteModel.this.mGf.setAuthSid(null);
                }
                if (NewWriteModel.this.mUT != null) {
                    NewWriteModel.this.mUT.callback(false, null, null, null, null);
                }
            }
        };
        this.eCK = null;
    }

    public void xp(boolean z) {
        this.mUU = z;
    }

    public void b(d dVar) {
        this.mUT = dVar;
    }

    public void a(c cVar) {
        this.mUS = cVar;
    }

    public void a(a.InterfaceC0837a interfaceC0837a) {
        this.mUV = interfaceC0837a;
    }

    public void e(WriteData writeData) {
        this.mGf = writeData;
    }

    public WriteData cVv() {
        return this.mGf;
    }

    public boolean dIK() {
        if (this.mGf == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.mGf.getWriteImagesInfo() == null || this.mGf.getWriteImagesInfo().size() == 0 || !this.mGf.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dIL();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eCK == null) {
                dIL();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCK.getPageActivity());
            aVar.om(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dIL();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eCK);
            aVar.bmC();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIL() {
        if (this.mUM == null) {
            this.mUM = new e();
            this.mUM.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.mUM != null && !this.mUM.isCancelled()) {
            this.mUM.cancel();
        } else if (this.mUT != null) {
            this.mUT.callback(false, null, null, null, null);
        } else if (this.mUS != null) {
            this.mUS.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mUM != null && !this.mUM.isCancelled()) {
            this.mUM.cancel();
            return false;
        }
        return false;
    }

    public void dIM() {
        if (this.mUN != null && !this.mUN.isCancelled()) {
            this.mUN.cancel();
        }
    }

    public boolean dIN() {
        if (this.mGf == null) {
            return true;
        }
        return (this.mGf.getWriteImagesInfo() != null ? this.mGf.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h mSh;
        private l mUZ;
        private com.baidu.tieba.tbadkCore.c.a mUX = null;
        private String mUY = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.mUZ = (l) runTask.getData();
            }
            if (this.mUZ != null) {
                this.mSh = this.mUZ.dbR();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.mGf.getContent());
                this.mUX = new com.baidu.tieba.tbadkCore.c.a();
                this.mUX.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.mUX.a(this.mSh);
                this.mUX.a(NewWriteModel.this.mUV);
                this.mUY = this.mUX.a(NewWriteModel.this.mGf, NewWriteModel.this.mUU);
                ErrorData dHN = this.mUX.dHN();
                if (this.mUX.isRequestSuccess() && this.mUY != null) {
                    AntiData dHM = this.mUX.dHM();
                    String error_msg = dHN.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dHN.getError_code(), error_msg, dHM);
                    if (NewWriteModel.this.mGf != null && NewWriteModel.this.mGf.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.mGf.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dHN != null && dHN.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dHN.getError_code(), dHN.getError_msg(), null);
                    if (this.mUY != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.mUY).optJSONObject("info");
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
                } else if (dHN != null && dHN.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dHN.getError_code(), dHN.getError_msg(), null);
                    if (this.mUY != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.mUY).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bp bpVar = new bp();
                                bpVar.title = optJSONObject2.optString("block_content");
                                bpVar.ewY = optJSONObject2.optString("block_cancel");
                                bpVar.ewZ = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bpVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dHN != null && dHN.error_code != 0) {
                    String error_msg2 = dHN.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dHN.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dHN.getError_code(), error_msg2, this.mUX.dHM());
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
                        if (this.mUY == null) {
                            videoEasterEggData = null;
                            iconStampData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.mUY);
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
                                                    CustomDialogData ep = com.baidu.tieba.pb.b.ep(jSONObject);
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
                                                                customDialogData = ep;
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
                                                                bVar.SP(str);
                                                                bVar.SQ(str3);
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
                                                                    customDialogData = ep;
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
                                                                    bVar.SP(str);
                                                                    bVar.SQ(str3);
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
                                                                customDialogData = ep;
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
                                                                    customDialogData = ep;
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
                                                                    customDialogData = ep;
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
                                                                    bVar.SP(str);
                                                                    bVar.SQ(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    bVar.setIconStampData(iconStampData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e6) {
                                                            customDialogData = ep;
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
                                                        customDialogData = ep;
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
                    bVar.SP(str);
                    bVar.SQ(str3);
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
            String dIS;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.mUM = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.mUT == null) {
                        if (NewWriteModel.this.mUS != null) {
                            NewWriteModel.this.mUS.a(true, bVar.getErrorString(), null, null, bVar.cuM());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            dIS = bVar.getPreMsg();
                            str = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dIT()) && StringUtils.isNull(bVar.dIS())) {
                            dIS = null;
                        } else {
                            dIS = bVar.dIS();
                            str = bVar.dIT();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), dIS, str);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.mGf != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.mGf.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.mGf.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        postWriteCallBackData.setIconStampData(bVar.getIconStampData());
                        ah ahVar = new ah();
                        ahVar.parserJson(this.mUY);
                        NewWriteModel.this.mUT.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.mGf, bVar.cuM());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && bVar.getIconStampData() == null) {
                            if (NewWriteModel.this.mGf != null) {
                                switch (NewWriteModel.this.mGf.getType()) {
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
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eCK, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(bVar.getIconStampData() == null)));
                    if (this.mSh != null) {
                        this.mSh.dbC();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.mSh != null) {
                    this.mSh.bE(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.mUX != null) {
                this.mUX.cancel();
            }
            if (NewWriteModel.this.mUT != null) {
                NewWriteModel.this.mUT.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.mUS != null) {
                NewWriteModel.this.mUS.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.mUM = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.mUY), NewWriteModel.this.ibU)) {
                if (bVar.dIP()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dIQ()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dIO()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.mUY);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.mGf != null) {
                        NewWriteModel.this.mGf.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.mGf.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, ahVar, NewWriteModel.this.mGf);
                    }
                } else if (bVar.dIR()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.mUY);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mGf);
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
        if (bVar != null && bVar.cuM() != null && bVar.cuM().mFrsForbidenDialogInfo != null) {
            AntiHelper.bn(this.eCK.getPageActivity(), bVar.cuM().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (bVar != null) {
            if (this.mUT != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.mUT.callback(false, postWriteCallBackData, ahVar, writeData, bVar.cuM());
            } else if (this.mUS != null) {
                this.mUS.a(false, bVar.getErrorString(), ahVar, writeData, bVar.cuM());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a mUX = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.mUP);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.mUQ == null || NewWriteModel.this.mUQ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.mUP) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.mUP);
                NewWriteModel.this.mUO = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.mUO)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.mUO, this.mUX);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.mUQ);
            if (this.bm != null) {
                NewWriteModel.this.mUO = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.mUO)) {
                    return NewWriteModel.this.a(NewWriteModel.this.mUO, this.mUX);
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
            if (this.mUX != null) {
                this.mUX.cancel();
            }
            if (NewWriteModel.this.mUR != null) {
                NewWriteModel.this.mUR.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.mUN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.mUR != null) {
                    NewWriteModel.this.mUR.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void csn() {
        if (this.mUN == null) {
            this.mUN = new a();
            this.mUN.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.mUQ = bArr;
        this.mUP = str;
    }

    public void a(b bVar) {
        this.mUR = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bg(au.boO().getPostImageSize(), au.boO().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
