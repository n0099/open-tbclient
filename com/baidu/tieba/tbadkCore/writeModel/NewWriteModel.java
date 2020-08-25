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
import com.baidu.tbadk.coreExtra.data.ag;
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
/* loaded from: classes2.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    private final com.baidu.adp.base.e<?> efK;
    private f.a htr;
    private WriteData lUg;
    private SpanGroupManager mSpanGroupManager;
    private e miG;
    private a miH;
    private String miI;
    private String miJ;
    private byte[] miK;
    private b miL;
    private c miM;
    private d miN;
    private boolean miO;
    private a.InterfaceC0807a miP;

    /* loaded from: classes2.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(boolean z, String str, ag agVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.miG = null;
        this.miH = null;
        this.lUg = null;
        this.miI = null;
        this.miJ = null;
        this.miK = null;
        this.miM = null;
        this.miN = null;
        this.miO = false;
        this.htr = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hs(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cev() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.miG = null;
                    NewWriteModel.this.lUg.setAuthSid(null);
                    NewWriteModel.this.dxS();
                } else if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.lUg.setAuthSid(null);
                }
                if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }
        };
        this.efK = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.miG = null;
        this.miH = null;
        this.lUg = null;
        this.miI = null;
        this.miJ = null;
        this.miK = null;
        this.miM = null;
        this.miN = null;
        this.miO = false;
        this.htr = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hs(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cev() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.miG = null;
                    NewWriteModel.this.lUg.setAuthSid(null);
                    NewWriteModel.this.dxS();
                } else if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.lUg.setAuthSid(null);
                }
                if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }
        };
        this.efK = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.miG = null;
        this.miH = null;
        this.lUg = null;
        this.miI = null;
        this.miJ = null;
        this.miK = null;
        this.miM = null;
        this.miN = null;
        this.miO = false;
        this.htr = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hs(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cev() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.miG = null;
                    NewWriteModel.this.lUg.setAuthSid(null);
                    NewWriteModel.this.dxS();
                } else if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.lUg.setAuthSid(null);
                }
                if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }
        };
        this.efK = tbPageContext;
    }

    public NewWriteModel() {
        this.miG = null;
        this.miH = null;
        this.lUg = null;
        this.miI = null;
        this.miJ = null;
        this.miK = null;
        this.miM = null;
        this.miN = null;
        this.miO = false;
        this.htr = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hs(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cev() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.miG = null;
                    NewWriteModel.this.lUg.setAuthSid(null);
                    NewWriteModel.this.dxS();
                } else if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUg == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.miN != null) {
                        NewWriteModel.this.miN.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miG = null;
                NewWriteModel.this.lUg.setAuthSid(str);
                NewWriteModel.this.dxS();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUg != null) {
                    NewWriteModel.this.lUg.setAuthSid(null);
                }
                if (NewWriteModel.this.miN != null) {
                    NewWriteModel.this.miN.callback(false, null, null, null, null);
                }
            }
        };
        this.efK = null;
    }

    public void wg(boolean z) {
        this.miO = z;
    }

    public void b(d dVar) {
        this.miN = dVar;
    }

    public void a(c cVar) {
        this.miM = cVar;
    }

    public void a(a.InterfaceC0807a interfaceC0807a) {
        this.miP = interfaceC0807a;
    }

    public void d(WriteData writeData) {
        this.lUg = writeData;
    }

    public WriteData cKZ() {
        return this.lUg;
    }

    public boolean dxS() {
        if (this.lUg == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.lUg.getWriteImagesInfo() == null || this.lUg.getWriteImagesInfo().size() == 0 || !this.lUg.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dxT();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.efK == null) {
                dxT();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efK.getPageActivity());
            aVar.nt(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dxT();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.efK);
            aVar.bhg();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxT() {
        if (this.miG == null) {
            this.miG = new e();
            this.miG.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.miG != null && !this.miG.isCancelled()) {
            this.miG.cancel();
        } else if (this.miN != null) {
            this.miN.callback(false, null, null, null, null);
        } else if (this.miM != null) {
            this.miM.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.miG != null && !this.miG.isCancelled()) {
            this.miG.cancel();
            return false;
        }
        return false;
    }

    public void dxU() {
        if (this.miH != null && !this.miH.isCancelled()) {
            this.miH.cancel();
        }
    }

    public boolean dxV() {
        if (this.lUg == null) {
            return true;
        }
        return (this.lUg.getWriteImagesInfo() != null ? this.lUg.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h mgf;
        private l miT;
        private com.baidu.tieba.tbadkCore.c.a miR = null;
        private String miS = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.miT = (l) runTask.getData();
            }
            if (this.miT != null) {
                this.mgf = this.miT.cRt();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0197  */
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.lUg.getContent());
                this.miR = new com.baidu.tieba.tbadkCore.c.a();
                this.miR.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.miR.a(this.mgf);
                this.miR.a(NewWriteModel.this.miP);
                this.miS = this.miR.a(NewWriteModel.this.lUg, NewWriteModel.this.miO);
                ErrorData dwV = this.miR.dwV();
                if (this.miR.isRequestSuccess() && this.miS != null) {
                    AntiData dwU = this.miR.dwU();
                    String error_msg = dwV.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dwV.getError_code(), error_msg, dwU);
                    if (NewWriteModel.this.lUg != null && NewWriteModel.this.lUg.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.lUg.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dwV != null && dwV.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dwV.getError_code(), dwV.getError_msg(), null);
                    if (this.miS != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.miS).optJSONObject("info");
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
                } else if (dwV != null && dwV.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dwV.getError_code(), dwV.getError_msg(), null);
                    if (this.miS != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.miS).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bp bpVar = new bp();
                                bpVar.title = optJSONObject2.optString("block_content");
                                bpVar.eai = optJSONObject2.optString("block_cancel");
                                bpVar.eaj = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bpVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dwV != null && dwV.error_code != 0) {
                    String error_msg2 = dwV.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dwV.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dwV.getError_code(), error_msg2, this.miR.dwU());
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
                        if (this.miS == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.miS);
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
                                                    CustomDialogData dX = com.baidu.tieba.pb.b.dX(jSONObject);
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
                                                                customDialogData = dX;
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
                                                                bVar.Rc(str);
                                                                bVar.Rd(str3);
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
                                                                customDialogData = dX;
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
                                                                    customDialogData = dX;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = dX;
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
                                                                    bVar.Rc(str);
                                                                    bVar.Rd(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = dX;
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
                                                        customDialogData = dX;
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
                    bVar.Rc(str);
                    bVar.Rd(str3);
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
            String dyb;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.miG = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.miN == null) {
                        if (NewWriteModel.this.miM != null) {
                            NewWriteModel.this.miM.a(true, bVar.getErrorString(), null, null, bVar.ckT());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            dyb = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dyb()) && StringUtils.isNull(bVar.dya())) {
                            dyb = null;
                        } else {
                            str = bVar.dya();
                            dyb = bVar.dyb();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, dyb);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.lUg != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.lUg.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.lUg.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        ag agVar = new ag();
                        agVar.parserJson(this.miS);
                        NewWriteModel.this.miN.callback(true, postWriteCallBackData, agVar, NewWriteModel.this.lUg, bVar.ckT());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.lUg != null) {
                                switch (NewWriteModel.this.lUg.getType()) {
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
                            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.efK, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.mgf != null) {
                        this.mgf.cRe();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.mgf != null) {
                    this.mgf.bq(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.miR != null) {
                this.miR.cancel();
            }
            if (NewWriteModel.this.miN != null) {
                NewWriteModel.this.miN.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.miM != null) {
                NewWriteModel.this.miM.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.miG = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.miS), NewWriteModel.this.htr)) {
                if (bVar.dxX()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dxY()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dxW()) {
                    ag agVar = new ag();
                    agVar.parserJson(this.miS);
                    if (agVar.getVcode_pic_url() != null && NewWriteModel.this.lUg != null) {
                        NewWriteModel.this.lUg.setVcodeMD5(agVar.getVcode_md5());
                        NewWriteModel.this.lUg.setVcodeUrl(agVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, agVar, NewWriteModel.this.lUg);
                    }
                } else if (bVar.dxZ()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.miS);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.lUg);
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
        if (bVar != null && bVar.ckT() != null && bVar.ckT().mFrsForbidenDialogInfo != null) {
            AntiHelper.bc(this.efK.getPageActivity(), bVar.ckT().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ag agVar, WriteData writeData) {
        if (bVar != null) {
            if (this.miN != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.miN.callback(false, postWriteCallBackData, agVar, writeData, bVar.ckT());
            } else if (this.miM != null) {
                this.miM.a(false, bVar.getErrorString(), agVar, writeData, bVar.ckT());
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a miR = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.miJ);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.miK == null || NewWriteModel.this.miK.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.miJ) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.miJ);
                NewWriteModel.this.miI = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.miI)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.miI, this.miR);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.miK);
            if (this.bm != null) {
                NewWriteModel.this.miI = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.miI)) {
                    return NewWriteModel.this.a(NewWriteModel.this.miI, this.miR);
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
            if (this.miR != null) {
                this.miR.cancel();
            }
            if (NewWriteModel.this.miL != null) {
                NewWriteModel.this.miL.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.miH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.miL != null) {
                    NewWriteModel.this.miL.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void ciu() {
        if (this.miH == null) {
            this.miH = new a();
            this.miH.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.miK = bArr;
        this.miJ = str;
    }

    public void a(b bVar) {
        this.miL = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bg(au.bjr().getPostImageSize(), au.bjr().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
