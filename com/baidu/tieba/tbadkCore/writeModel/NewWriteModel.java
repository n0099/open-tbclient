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
    private final com.baidu.adp.base.e<?> eid;
    private f.a hAC;
    private SpanGroupManager mSpanGroupManager;
    private WriteData mdW;
    private c msA;
    private d msB;
    private boolean msC;
    private a.InterfaceC0804a msD;
    private e msu;
    private a msv;
    private String msw;
    private String msx;
    private byte[] msy;
    private b msz;

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
        this.msu = null;
        this.msv = null;
        this.mdW = null;
        this.msw = null;
        this.msx = null;
        this.msy = null;
        this.msA = null;
        this.msB = null;
        this.msC = false;
        this.hAC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HQ(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void chL() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.msu = null;
                    NewWriteModel.this.mdW.setAuthSid(null);
                    NewWriteModel.this.dBQ();
                } else if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HR(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.mdW.setAuthSid(null);
                }
                if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }
        };
        this.eid = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.msu = null;
        this.msv = null;
        this.mdW = null;
        this.msw = null;
        this.msx = null;
        this.msy = null;
        this.msA = null;
        this.msB = null;
        this.msC = false;
        this.hAC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HQ(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void chL() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.msu = null;
                    NewWriteModel.this.mdW.setAuthSid(null);
                    NewWriteModel.this.dBQ();
                } else if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HR(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.mdW.setAuthSid(null);
                }
                if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }
        };
        this.eid = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.msu = null;
        this.msv = null;
        this.mdW = null;
        this.msw = null;
        this.msx = null;
        this.msy = null;
        this.msA = null;
        this.msB = null;
        this.msC = false;
        this.hAC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HQ(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void chL() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.msu = null;
                    NewWriteModel.this.mdW.setAuthSid(null);
                    NewWriteModel.this.dBQ();
                } else if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HR(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.mdW.setAuthSid(null);
                }
                if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }
        };
        this.eid = tbPageContext;
    }

    public NewWriteModel() {
        this.msu = null;
        this.msv = null;
        this.mdW = null;
        this.msw = null;
        this.msx = null;
        this.msy = null;
        this.msA = null;
        this.msB = null;
        this.msC = false;
        this.hAC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HQ(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void chL() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.msu = null;
                    NewWriteModel.this.mdW.setAuthSid(null);
                    NewWriteModel.this.dBQ();
                } else if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void HR(String str) {
                if (NewWriteModel.this.mdW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.msB != null) {
                        NewWriteModel.this.msB.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.msu = null;
                NewWriteModel.this.mdW.setAuthSid(str);
                NewWriteModel.this.dBQ();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mdW != null) {
                    NewWriteModel.this.mdW.setAuthSid(null);
                }
                if (NewWriteModel.this.msB != null) {
                    NewWriteModel.this.msB.callback(false, null, null, null, null);
                }
            }
        };
        this.eid = null;
    }

    public void wr(boolean z) {
        this.msC = z;
    }

    public void b(d dVar) {
        this.msB = dVar;
    }

    public void a(c cVar) {
        this.msA = cVar;
    }

    public void a(a.InterfaceC0804a interfaceC0804a) {
        this.msD = interfaceC0804a;
    }

    public void e(WriteData writeData) {
        this.mdW = writeData;
    }

    public WriteData cOG() {
        return this.mdW;
    }

    public boolean dBQ() {
        if (this.mdW == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.mdW.getWriteImagesInfo() == null || this.mdW.getWriteImagesInfo().size() == 0 || !this.mdW.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dBR();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.eid == null) {
                dBR();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eid.getPageActivity());
            aVar.nE(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dBR();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.eid);
            aVar.bia();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBR() {
        if (this.msu == null) {
            this.msu = new e();
            this.msu.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.msu != null && !this.msu.isCancelled()) {
            this.msu.cancel();
        } else if (this.msB != null) {
            this.msB.callback(false, null, null, null, null);
        } else if (this.msA != null) {
            this.msA.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.msu != null && !this.msu.isCancelled()) {
            this.msu.cancel();
            return false;
        }
        return false;
    }

    public void dBS() {
        if (this.msv != null && !this.msv.isCancelled()) {
            this.msv.cancel();
        }
    }

    public boolean dBT() {
        if (this.mdW == null) {
            return true;
        }
        return (this.mdW.getWriteImagesInfo() != null ? this.mdW.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h mpU;
        private l msH;
        private com.baidu.tieba.tbadkCore.c.a msF = null;
        private String msG = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.msH = (l) runTask.getData();
            }
            if (this.msH != null) {
                this.mpU = this.msH.cVa();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.mdW.getContent());
                this.msF = new com.baidu.tieba.tbadkCore.c.a();
                this.msF.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.msF.a(this.mpU);
                this.msF.a(NewWriteModel.this.msD);
                this.msG = this.msF.a(NewWriteModel.this.mdW, NewWriteModel.this.msC);
                ErrorData dAT = this.msF.dAT();
                if (this.msF.isRequestSuccess() && this.msG != null) {
                    AntiData dAS = this.msF.dAS();
                    String error_msg = dAT.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dAT.getError_code(), error_msg, dAS);
                    if (NewWriteModel.this.mdW != null && NewWriteModel.this.mdW.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.mdW.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dAT != null && dAT.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dAT.getError_code(), dAT.getError_msg(), null);
                    if (this.msG != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.msG).optJSONObject("info");
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
                } else if (dAT != null && dAT.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dAT.getError_code(), dAT.getError_msg(), null);
                    if (this.msG != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.msG).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bp bpVar = new bp();
                                bpVar.title = optJSONObject2.optString("block_content");
                                bpVar.ecw = optJSONObject2.optString("block_cancel");
                                bpVar.ecx = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bpVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dAT != null && dAT.error_code != 0) {
                    String error_msg2 = dAT.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dAT.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dAT.getError_code(), error_msg2, this.msF.dAS());
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
                        if (this.msG == null) {
                            videoEasterEggData = null;
                            iconStampData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.msG);
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
                                                    CustomDialogData ef = com.baidu.tieba.pb.b.ef(jSONObject);
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
                                                                customDialogData = ef;
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
                                                                bVar.RC(str);
                                                                bVar.RD(str3);
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
                                                                    customDialogData = ef;
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
                                                                    bVar.RC(str);
                                                                    bVar.RD(str3);
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
                                                                customDialogData = ef;
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
                                                                    customDialogData = ef;
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
                                                                    customDialogData = ef;
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
                                                                    bVar.RC(str);
                                                                    bVar.RD(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    bVar.setIconStampData(iconStampData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e6) {
                                                            customDialogData = ef;
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
                                                        customDialogData = ef;
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
                    bVar.RC(str);
                    bVar.RD(str3);
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
            String dBY;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.msu = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.msB == null) {
                        if (NewWriteModel.this.msA != null) {
                            NewWriteModel.this.msA.a(true, bVar.getErrorString(), null, null, bVar.coh());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            dBY = bVar.getPreMsg();
                            str = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dBZ()) && StringUtils.isNull(bVar.dBY())) {
                            dBY = null;
                        } else {
                            dBY = bVar.dBY();
                            str = bVar.dBZ();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), dBY, str);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.mdW != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.mdW.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.mdW.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        postWriteCallBackData.setIconStampData(bVar.getIconStampData());
                        ah ahVar = new ah();
                        ahVar.parserJson(this.msG);
                        NewWriteModel.this.msB.callback(true, postWriteCallBackData, ahVar, NewWriteModel.this.mdW, bVar.coh());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null && bVar.getIconStampData() == null) {
                            if (NewWriteModel.this.mdW != null) {
                                switch (NewWriteModel.this.mdW.getType()) {
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
                            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.eid, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, Boolean.valueOf(bVar.getIconStampData() == null)));
                    if (this.mpU != null) {
                        this.mpU.cUL();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.mpU != null) {
                    this.mpU.bt(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.msF != null) {
                this.msF.cancel();
            }
            if (NewWriteModel.this.msB != null) {
                NewWriteModel.this.msB.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.msA != null) {
                NewWriteModel.this.msA.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.msu = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.msG), NewWriteModel.this.hAC)) {
                if (bVar.dBV()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dBW()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dBU()) {
                    ah ahVar = new ah();
                    ahVar.parserJson(this.msG);
                    if (ahVar.getVcode_pic_url() != null && NewWriteModel.this.mdW != null) {
                        NewWriteModel.this.mdW.setVcodeMD5(ahVar.getVcode_md5());
                        NewWriteModel.this.mdW.setVcodeUrl(ahVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, ahVar, NewWriteModel.this.mdW);
                    }
                } else if (bVar.dBX()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.msG);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mdW);
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
        if (bVar != null && bVar.coh() != null && bVar.coh().mFrsForbidenDialogInfo != null) {
            AntiHelper.bi(this.eid.getPageActivity(), bVar.coh().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ah ahVar, WriteData writeData) {
        if (bVar != null) {
            if (this.msB != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.msB.callback(false, postWriteCallBackData, ahVar, writeData, bVar.coh());
            } else if (this.msA != null) {
                this.msA.a(false, bVar.getErrorString(), ahVar, writeData, bVar.coh());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a msF = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.msx);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.msy == null || NewWriteModel.this.msy.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.msx) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.msx);
                NewWriteModel.this.msw = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.msw)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.msw, this.msF);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.msy);
            if (this.bm != null) {
                NewWriteModel.this.msw = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.msw)) {
                    return NewWriteModel.this.a(NewWriteModel.this.msw, this.msF);
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
            if (this.msF != null) {
                this.msF.cancel();
            }
            if (NewWriteModel.this.msz != null) {
                NewWriteModel.this.msz.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.msv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.msz != null) {
                    NewWriteModel.this.msz.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void clI() {
        if (this.msv == null) {
            this.msv = new a();
            this.msv.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.msy = bArr;
        this.msx = str;
    }

    public void a(b bVar) {
        this.msz = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.bg(au.bkm().getPostImageSize(), au.bkm().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
