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
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
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
    private final com.baidu.adp.base.e<?> dWk;
    private f.a hgy;
    private WriteData lCz;
    private e lQT;
    private a lQU;
    private String lQV;
    private String lQW;
    private byte[] lQX;
    private b lQY;
    private c lQZ;
    private d lRa;
    private boolean lRb;
    private a.InterfaceC0754a lRc;
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
        this.lQT = null;
        this.lQU = null;
        this.lCz = null;
        this.lQV = null;
        this.lQW = null;
        this.lQX = null;
        this.lQZ = null;
        this.lRa = null;
        this.lRb = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ET(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bUj() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lQT = null;
                    NewWriteModel.this.lCz.setAuthSid(null);
                    NewWriteModel.this.dmw();
                } else if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void EU(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lCz.setAuthSid(null);
                }
                if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }
        };
        this.dWk = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lQT = null;
        this.lQU = null;
        this.lCz = null;
        this.lQV = null;
        this.lQW = null;
        this.lQX = null;
        this.lQZ = null;
        this.lRa = null;
        this.lRb = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ET(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bUj() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lQT = null;
                    NewWriteModel.this.lCz.setAuthSid(null);
                    NewWriteModel.this.dmw();
                } else if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void EU(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lCz.setAuthSid(null);
                }
                if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }
        };
        this.dWk = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.lQT = null;
        this.lQU = null;
        this.lCz = null;
        this.lQV = null;
        this.lQW = null;
        this.lQX = null;
        this.lQZ = null;
        this.lRa = null;
        this.lRb = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ET(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bUj() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lQT = null;
                    NewWriteModel.this.lCz.setAuthSid(null);
                    NewWriteModel.this.dmw();
                } else if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void EU(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lCz.setAuthSid(null);
                }
                if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }
        };
        this.dWk = tbPageContext;
    }

    public NewWriteModel() {
        this.lQT = null;
        this.lQU = null;
        this.lCz = null;
        this.lQV = null;
        this.lQW = null;
        this.lQX = null;
        this.lQZ = null;
        this.lRa = null;
        this.lRb = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ET(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bUj() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lQT = null;
                    NewWriteModel.this.lCz.setAuthSid(null);
                    NewWriteModel.this.dmw();
                } else if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void EU(String str) {
                if (NewWriteModel.this.lCz == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lRa != null) {
                        NewWriteModel.this.lRa.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lQT = null;
                NewWriteModel.this.lCz.setAuthSid(str);
                NewWriteModel.this.dmw();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lCz != null) {
                    NewWriteModel.this.lCz.setAuthSid(null);
                }
                if (NewWriteModel.this.lRa != null) {
                    NewWriteModel.this.lRa.callback(false, null, null, null, null);
                }
            }
        };
        this.dWk = null;
    }

    public void vr(boolean z) {
        this.lRb = z;
    }

    public void b(d dVar) {
        this.lRa = dVar;
    }

    public void a(c cVar) {
        this.lQZ = cVar;
    }

    public void a(a.InterfaceC0754a interfaceC0754a) {
        this.lRc = interfaceC0754a;
    }

    public void d(WriteData writeData) {
        this.lCz = writeData;
    }

    public WriteData dhF() {
        return this.lCz;
    }

    public boolean dmw() {
        if (this.lCz == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.lCz.getWriteImagesInfo() == null || this.lCz.getWriteImagesInfo().size() == 0 || !this.lCz.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dmx();
        } else {
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.dWk == null) {
                dmx();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dWk.getPageActivity());
            aVar.ln(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dmx();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.dWk);
            aVar.aYL();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmx() {
        if (this.lQT == null) {
            this.lQT = new e();
            this.lQT.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.lQT != null && !this.lQT.isCancelled()) {
            this.lQT.cancel();
        } else if (this.lRa != null) {
            this.lRa.callback(false, null, null, null, null);
        } else if (this.lQZ != null) {
            this.lQZ.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lQT != null && !this.lQT.isCancelled()) {
            this.lQT.cancel();
            return false;
        }
        return false;
    }

    public void dmy() {
        if (this.lQU != null && !this.lQU.isCancelled()) {
            this.lQU.cancel();
        }
    }

    public boolean dmz() {
        if (this.lCz == null) {
            return true;
        }
        return (this.lCz.getWriteImagesInfo() != null ? this.lCz.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h lOt;
        private l lRg;
        private com.baidu.tieba.tbadkCore.c.a lRe = null;
        private String lRf = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.lRg = (l) runTask.getData();
            }
            if (this.lRg != null) {
                this.lOt = this.lRg.cGE();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.lCz.getContent());
                this.lRe = new com.baidu.tieba.tbadkCore.c.a();
                this.lRe.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.lRe.a(this.lOt);
                this.lRe.a(NewWriteModel.this.lRc);
                this.lRf = this.lRe.a(NewWriteModel.this.lCz, NewWriteModel.this.lRb);
                ErrorData dlx = this.lRe.dlx();
                if (this.lRe.isRequestSuccess() && this.lRf != null) {
                    AntiData dlw = this.lRe.dlw();
                    String error_msg = dlx.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dlx.getError_code(), error_msg, dlw);
                    if (NewWriteModel.this.lCz != null && NewWriteModel.this.lCz.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.lCz.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dlx != null && dlx.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dlx.getError_code(), dlx.getError_msg(), null);
                    if (this.lRf != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.lRf).optJSONObject("info");
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
                } else if (dlx != null && dlx.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dlx.getError_code(), dlx.getError_msg(), null);
                    if (this.lRf != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.lRf).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bo boVar = new bo();
                                boVar.title = optJSONObject2.optString("block_content");
                                boVar.dQO = optJSONObject2.optString("block_cancel");
                                boVar.dQP = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(boVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dlx != null && dlx.error_code != 0) {
                    String error_msg2 = dlx.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dlx.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dlx.getError_code(), error_msg2, this.lRe.dlw());
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
                        if (this.lRf == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.lRf);
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
                                                    CustomDialogData dM = com.baidu.tieba.pb.b.dM(jSONObject);
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
                                                                customDialogData = dM;
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
                                                                bVar.Oe(str);
                                                                bVar.Of(str3);
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
                                                                customDialogData = dM;
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
                                                                    customDialogData = dM;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = dM;
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
                                                                    bVar.Oe(str);
                                                                    bVar.Of(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = dM;
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
                                                        customDialogData = dM;
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
                    bVar.Oe(str);
                    bVar.Of(str3);
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
            String dmF;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.lQT = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.lRa == null) {
                        if (NewWriteModel.this.lQZ != null) {
                            NewWriteModel.this.lQZ.a(true, bVar.getErrorString(), null, null, bVar.cax());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            dmF = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dmF()) && StringUtils.isNull(bVar.dmE())) {
                            dmF = null;
                        } else {
                            str = bVar.dmE();
                            dmF = bVar.dmF();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, dmF);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.lCz != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.lCz.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.lCz.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        ad adVar = new ad();
                        adVar.parserJson(this.lRf);
                        NewWriteModel.this.lRa.callback(true, postWriteCallBackData, adVar, NewWriteModel.this.lCz, bVar.cax());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.lCz != null) {
                                switch (NewWriteModel.this.lCz.getType()) {
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
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.dWk, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.lOt != null) {
                        this.lOt.cGp();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.lOt != null) {
                    this.lOt.bs(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.lRe != null) {
                this.lRe.cancel();
            }
            if (NewWriteModel.this.lRa != null) {
                NewWriteModel.this.lRa.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.lQZ != null) {
                NewWriteModel.this.lQZ.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.lQT = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.lRf), NewWriteModel.this.hgy)) {
                if (bVar.dmB()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dmC()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dmA()) {
                    ad adVar = new ad();
                    adVar.parserJson(this.lRf);
                    if (adVar.getVcode_pic_url() != null && NewWriteModel.this.lCz != null) {
                        NewWriteModel.this.lCz.setVcodeMD5(adVar.getVcode_md5());
                        NewWriteModel.this.lCz.setVcodeUrl(adVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, adVar, NewWriteModel.this.lCz);
                    }
                } else if (bVar.dmD()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.lRf);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.lCz);
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
        if (bVar != null && bVar.cax() != null && bVar.cax().mFrsForbidenDialogInfo != null) {
            AntiHelper.aX(this.dWk.getPageActivity(), bVar.cax().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ad adVar, WriteData writeData) {
        if (bVar != null) {
            if (this.lRa != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.lRa.callback(false, postWriteCallBackData, adVar, writeData, bVar.cax());
            } else if (this.lQZ != null) {
                this.lQZ.a(false, bVar.getErrorString(), adVar, writeData, bVar.cax());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a lRe = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.lQW);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.lQX == null || NewWriteModel.this.lQX.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.lQW) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.lQW);
                NewWriteModel.this.lQV = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.lQV)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.lQV, this.lRe);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.lQX);
            if (this.bm != null) {
                NewWriteModel.this.lQV = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.lQV)) {
                    return NewWriteModel.this.a(NewWriteModel.this.lQV, this.lRe);
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
            if (this.lRe != null) {
                this.lRe.cancel();
            }
            if (NewWriteModel.this.lQY != null) {
                NewWriteModel.this.lQY.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.lQU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.lQY != null) {
                    NewWriteModel.this.lQY.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bXY() {
        if (this.lQU == null) {
            this.lQU = new a();
            this.lQU.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.lQX = bArr;
        this.lQW = str;
    }

    public void a(b bVar) {
        this.lQY = bVar;
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
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aX(at.baS().getPostImageSize(), at.baS().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
