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
    private final com.baidu.adp.base.e<?> eul;
    private f.a hPx;
    private e mIa;
    private a mIb;
    private String mIc;
    private String mIe;
    private byte[] mIf;
    private b mIg;
    private c mIh;
    private d mIi;
    private boolean mIj;
    private a.InterfaceC0822a mIk;
    private SpanGroupManager mSpanGroupManager;
    private WriteData mtA;

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
        this.mIa = null;
        this.mIb = null;
        this.mtA = null;
        this.mIc = null;
        this.mIe = null;
        this.mIf = null;
        this.mIh = null;
        this.mIi = null;
        this.mIj = false;
        this.hPx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ID(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void clh() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mIa = null;
                    NewWriteModel.this.mtA.setAuthSid(null);
                    NewWriteModel.this.dFC();
                } else if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void IE(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mtA.setAuthSid(null);
                }
                if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }
        };
        this.eul = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mIa = null;
        this.mIb = null;
        this.mtA = null;
        this.mIc = null;
        this.mIe = null;
        this.mIf = null;
        this.mIh = null;
        this.mIi = null;
        this.mIj = false;
        this.hPx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ID(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void clh() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mIa = null;
                    NewWriteModel.this.mtA.setAuthSid(null);
                    NewWriteModel.this.dFC();
                } else if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void IE(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mtA.setAuthSid(null);
                }
                if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }
        };
        this.eul = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mIa = null;
        this.mIb = null;
        this.mtA = null;
        this.mIc = null;
        this.mIe = null;
        this.mIf = null;
        this.mIh = null;
        this.mIi = null;
        this.mIj = false;
        this.hPx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ID(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void clh() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mIa = null;
                    NewWriteModel.this.mtA.setAuthSid(null);
                    NewWriteModel.this.dFC();
                } else if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void IE(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mtA.setAuthSid(null);
                }
                if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }
        };
        this.eul = tbPageContext;
    }

    public NewWriteModel() {
        this.mIa = null;
        this.mIb = null;
        this.mtA = null;
        this.mIc = null;
        this.mIe = null;
        this.mIf = null;
        this.mIh = null;
        this.mIi = null;
        this.mIj = false;
        this.hPx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ID(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void clh() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mIa = null;
                    NewWriteModel.this.mtA.setAuthSid(null);
                    NewWriteModel.this.dFC();
                } else if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void IE(String str) {
                if (NewWriteModel.this.mtA == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mIi != null) {
                        NewWriteModel.this.mIi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.mIa = null;
                NewWriteModel.this.mtA.setAuthSid(str);
                NewWriteModel.this.dFC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mtA != null) {
                    NewWriteModel.this.mtA.setAuthSid(null);
                }
                if (NewWriteModel.this.mIi != null) {
                    NewWriteModel.this.mIi.callback(false, null, null, null, null);
                }
            }
        };
        this.eul = null;
    }

    public void wY(boolean z) {
        this.mIj = z;
    }

    public void b(d dVar) {
        this.mIi = dVar;
    }

    public void a(c cVar) {
        this.mIh = cVar;
    }

    public void a(a.InterfaceC0822a interfaceC0822a) {
        this.mIk = interfaceC0822a;
    }

    public void e(WriteData writeData) {
        this.mtA = writeData;
    }

    public WriteData cSo() {
        return this.mtA;
    }

    public boolean dFC() {
        if (this.mtA == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.mtA.getWriteImagesInfo() == null || this.mtA.getWriteImagesInfo().size() == 0 || !this.mtA.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dFD();
        } else {
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eul == null) {
                dFD();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eul.getPageActivity());
            aVar.ob(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dFD();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eul);
            aVar.bkJ();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFD() {
        if (this.mIa == null) {
            this.mIa = new e();
            this.mIa.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.mIa != null && !this.mIa.isCancelled()) {
            this.mIa.cancel();
        } else if (this.mIi != null) {
            this.mIi.callback(false, null, null, null, null);
        } else if (this.mIh != null) {
            this.mIh.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.mIa != null && !this.mIa.isCancelled()) {
            this.mIa.cancel();
            return false;
        }
        return false;
    }

    public void dFE() {
        if (this.mIb != null && !this.mIb.isCancelled()) {
            this.mIb.cancel();
        }
    }

    public boolean dFF() {
        if (this.mtA == null) {
            return true;
        }
        return (this.mtA.getWriteImagesInfo() != null ? this.mtA.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h mFB;
        private l mIo;
        private com.baidu.tieba.tbadkCore.c.a mIm = null;
        private String mIn = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.mIo = (l) runTask.getData();
            }
            if (this.mIo != null) {
                this.mFB = this.mIo.cYJ();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.mtA.getContent());
                this.mIm = new com.baidu.tieba.tbadkCore.c.a();
                this.mIm.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.mIm.a(this.mFB);
                this.mIm.a(NewWriteModel.this.mIk);
                this.mIn = this.mIm.a(NewWriteModel.this.mtA, NewWriteModel.this.mIj);
                ErrorData dEF = this.mIm.dEF();
                if (this.mIm.isRequestSuccess() && this.mIn != null) {
                    AntiData dEE = this.mIm.dEE();
                    String error_msg = dEF.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dEF.getError_code(), error_msg, dEE);
                    if (NewWriteModel.this.mtA != null && NewWriteModel.this.mtA.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.mtA.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dEF != null && dEF.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dEF.getError_code(), dEF.getError_msg(), null);
                    if (this.mIn != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.mIn).optJSONObject("info");
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
                } else if (dEF != null && dEF.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dEF.getError_code(), dEF.getError_msg(), null);
                    if (this.mIn != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.mIn).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bp bpVar = new bp();
                                bpVar.title = optJSONObject2.optString("block_content");
                                bpVar.eoB = optJSONObject2.optString("block_cancel");
                                bpVar.eoC = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bpVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dEF != null && dEF.error_code != 0) {
                    String error_msg2 = dEF.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dEF.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dEF.getError_code(), error_msg2, this.mIm.dEE());
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
                        if (this.mIn == null) {
                            videoEasterEggData = null;
                            iconStampData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.mIn);
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
                                                    CustomDialogData ej = com.baidu.tieba.pb.b.ej(jSONObject);
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
                                                                customDialogData = ej;
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
                                                                bVar.Sq(str);
                                                                bVar.Sr(str3);
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
                                                                    customDialogData = ej;
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
                                                                    bVar.Sq(str);
                                                                    bVar.Sr(str3);
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
                                                                customDialogData = ej;
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
                                                                    customDialogData = ej;
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
                                                                    customDialogData = ej;
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
                                                                    bVar.Sq(str);
                                                                    bVar.Sr(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    bVar.setIconStampData(iconStampData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e6) {
                                                            customDialogData = ej;
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
                                                        customDialogData = ej;
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
                    bVar.Sq(str);
                    bVar.Sr(str3);
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
            String dFK;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.mIa = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.mIi == null) {
                        if (NewWriteModel.this.mIh != null) {
                            NewWriteModel.this.mIh.a(true, bVar.getErrorString(), null, null, bVar.crF());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            dFK = bVar.getPreMsg();
                            str = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dFL()) && StringUtils.isNull(bVar.dFK())) {
                            dFK = null;
                        } else {
                            dFK = bVar.dFK();
                            str = bVar.dFL();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), dFK, str);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.mtA != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.mtA.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.mtA.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        postWriteCallBackData.setIconStampData(bVar.getIconStampData());
                        ah ahVar = new ah();
                        ahVar.parserJson(this.mIn);
                        NewWriteModel.this.mIi.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.mtA, bVar.crF());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && bVar.getIconStampData() == null) {
                            if (NewWriteModel.this.mtA != null) {
                                switch (NewWriteModel.this.mtA.getType()) {
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
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eul, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(bVar.getIconStampData() == null)));
                    if (this.mFB != null) {
                        this.mFB.cYu();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.mFB != null) {
                    this.mFB.bD(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.mIm != null) {
                this.mIm.cancel();
            }
            if (NewWriteModel.this.mIi != null) {
                NewWriteModel.this.mIi.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.mIh != null) {
                NewWriteModel.this.mIh.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.mIa = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.mIn), NewWriteModel.this.hPx)) {
                if (bVar.dFH()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dFI()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dFG()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.mIn);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.mtA != null) {
                        NewWriteModel.this.mtA.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.mtA.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, ahVar, NewWriteModel.this.mtA);
                    }
                } else if (bVar.dFJ()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.mIn);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mtA);
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
        if (bVar != null && bVar.crF() != null && bVar.crF().mFrsForbidenDialogInfo != null) {
            AntiHelper.bl(this.eul.getPageActivity(), bVar.crF().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (bVar != null) {
            if (this.mIi != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.mIi.callback(false, postWriteCallBackData, ahVar, writeData, bVar.crF());
            } else if (this.mIh != null) {
                this.mIh.a(false, bVar.getErrorString(), ahVar, writeData, bVar.crF());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a mIm = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.mIe);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.mIf == null || NewWriteModel.this.mIf.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.mIe) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.mIe);
                NewWriteModel.this.mIc = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.mIc)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.mIc, this.mIm);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.mIf);
            if (this.bm != null) {
                NewWriteModel.this.mIc = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.mIc)) {
                    return NewWriteModel.this.a(NewWriteModel.this.mIc, this.mIm);
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
            if (this.mIm != null) {
                this.mIm.cancel();
            }
            if (NewWriteModel.this.mIg != null) {
                NewWriteModel.this.mIg.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.mIb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.mIg != null) {
                    NewWriteModel.this.mIg.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void cpg() {
        if (this.mIb == null) {
            this.mIb = new a();
            this.mIb.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.mIf = bArr;
        this.mIe = str;
    }

    public void a(b bVar) {
        this.mIg = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bf(au.bmV().getPostImageSize(), au.bmV().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
