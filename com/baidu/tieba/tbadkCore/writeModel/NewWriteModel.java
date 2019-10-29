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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
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
    private final com.baidu.adp.base.e<?> cfJ;
    private f.a eZU;
    private WriteData iYy;
    private e jmb;
    private a jmc;
    private String jmd;
    private String jme;
    private byte[] jmf;
    private b jmg;
    private c jmh;
    private d jmi;
    private boolean jmj;
    private a.InterfaceC0519a jmk;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, y yVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jmb = null;
        this.jmc = null;
        this.iYy = null;
        this.jmd = null;
        this.jme = null;
        this.jmf = null;
        this.jmh = null;
        this.jmi = null;
        this.jmj = false;
        this.eZU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uU(String str) {
                if (NewWriteModel.this.iYy == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmi != null) {
                        NewWriteModel.this.jmi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmb = null;
                NewWriteModel.this.iYy.setAuthSid(str);
                NewWriteModel.this.cpE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bdE() {
                if (NewWriteModel.this.iYy != null) {
                    NewWriteModel.this.jmb = null;
                    NewWriteModel.this.iYy.setAuthSid(null);
                    NewWriteModel.this.cpE();
                } else if (NewWriteModel.this.jmi != null) {
                    NewWriteModel.this.jmi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uV(String str) {
                if (NewWriteModel.this.iYy == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmi != null) {
                        NewWriteModel.this.jmi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmb = null;
                NewWriteModel.this.iYy.setAuthSid(str);
                NewWriteModel.this.cpE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.iYy != null) {
                    NewWriteModel.this.iYy.setAuthSid(null);
                }
                if (NewWriteModel.this.jmi != null) {
                    NewWriteModel.this.jmi.callback(false, null, null, null, null);
                }
            }
        };
        this.cfJ = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jmb = null;
        this.jmc = null;
        this.iYy = null;
        this.jmd = null;
        this.jme = null;
        this.jmf = null;
        this.jmh = null;
        this.jmi = null;
        this.jmj = false;
        this.eZU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uU(String str) {
                if (NewWriteModel.this.iYy == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmi != null) {
                        NewWriteModel.this.jmi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmb = null;
                NewWriteModel.this.iYy.setAuthSid(str);
                NewWriteModel.this.cpE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bdE() {
                if (NewWriteModel.this.iYy != null) {
                    NewWriteModel.this.jmb = null;
                    NewWriteModel.this.iYy.setAuthSid(null);
                    NewWriteModel.this.cpE();
                } else if (NewWriteModel.this.jmi != null) {
                    NewWriteModel.this.jmi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uV(String str) {
                if (NewWriteModel.this.iYy == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmi != null) {
                        NewWriteModel.this.jmi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmb = null;
                NewWriteModel.this.iYy.setAuthSid(str);
                NewWriteModel.this.cpE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.iYy != null) {
                    NewWriteModel.this.iYy.setAuthSid(null);
                }
                if (NewWriteModel.this.jmi != null) {
                    NewWriteModel.this.jmi.callback(false, null, null, null, null);
                }
            }
        };
        this.cfJ = tbPageContext;
    }

    public NewWriteModel() {
        this.jmb = null;
        this.jmc = null;
        this.iYy = null;
        this.jmd = null;
        this.jme = null;
        this.jmf = null;
        this.jmh = null;
        this.jmi = null;
        this.jmj = false;
        this.eZU = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uU(String str) {
                if (NewWriteModel.this.iYy == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmi != null) {
                        NewWriteModel.this.jmi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmb = null;
                NewWriteModel.this.iYy.setAuthSid(str);
                NewWriteModel.this.cpE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bdE() {
                if (NewWriteModel.this.iYy != null) {
                    NewWriteModel.this.jmb = null;
                    NewWriteModel.this.iYy.setAuthSid(null);
                    NewWriteModel.this.cpE();
                } else if (NewWriteModel.this.jmi != null) {
                    NewWriteModel.this.jmi.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uV(String str) {
                if (NewWriteModel.this.iYy == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmi != null) {
                        NewWriteModel.this.jmi.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmb = null;
                NewWriteModel.this.iYy.setAuthSid(str);
                NewWriteModel.this.cpE();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.iYy != null) {
                    NewWriteModel.this.iYy.setAuthSid(null);
                }
                if (NewWriteModel.this.jmi != null) {
                    NewWriteModel.this.jmi.callback(false, null, null, null, null);
                }
            }
        };
        this.cfJ = null;
    }

    public void qV(boolean z) {
        this.jmj = z;
    }

    public void b(d dVar) {
        this.jmi = dVar;
    }

    public void a(c cVar) {
        this.jmh = cVar;
    }

    public void a(a.InterfaceC0519a interfaceC0519a) {
        this.jmk = interfaceC0519a;
    }

    public void d(WriteData writeData) {
        this.iYy = writeData;
    }

    public WriteData clc() {
        return this.iYy;
    }

    public boolean cpE() {
        if (this.iYy == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.iYy.getWriteImagesInfo() == null || this.iYy.getWriteImagesInfo().size() == 0 || !this.iYy.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            cpF();
        } else {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.cfJ == null) {
                cpF();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfJ.getPageActivity());
            aVar.hU(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cpF();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.cfJ);
            aVar.akO();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpF() {
        if (this.jmb == null) {
            this.jmb = new e();
            this.jmb.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.jmb != null && !this.jmb.isCancelled()) {
            this.jmb.cancel();
        } else if (this.jmi != null) {
            this.jmi.callback(false, null, null, null, null);
        } else if (this.jmh != null) {
            this.jmh.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jmb != null && !this.jmb.isCancelled()) {
            this.jmb.cancel();
            return false;
        }
        return false;
    }

    public void cpG() {
        if (this.jmc != null && !this.jmc.isCancelled()) {
            this.jmc.cancel();
        }
    }

    public boolean cpH() {
        if (this.iYy == null) {
            return true;
        }
        return (this.iYy.getWriteImagesInfo() != null ? this.iYy.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h jjG;
        private l jmq;
        private com.baidu.tieba.tbadkCore.c.a jmn = null;
        private String jmo = null;
        private boolean jmm = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.jmq = (l) runTask.getData();
            }
            if (this.jmq != null) {
                this.jjG = this.jmq.bMY();
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
            if (!this.jmm) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.iYy.getContent());
                this.jmn = new com.baidu.tieba.tbadkCore.c.a();
                this.jmn.a(this.jjG);
                this.jmn.a(NewWriteModel.this.jmk);
                this.jmo = this.jmn.a(NewWriteModel.this.iYy, NewWriteModel.this.jmj);
                ErrorData coH = this.jmn.coH();
                if (this.jmn.isRequestSuccess() && this.jmo != null) {
                    AntiData coG = this.jmn.coG();
                    String error_msg = coH.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(coH.getError_code(), error_msg, coG);
                    if (NewWriteModel.this.iYy != null && NewWriteModel.this.iYy.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.iYy.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (coH != null && coH.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(coH.getError_code(), coH.getError_msg(), null);
                    if (this.jmo != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.jmo).optJSONObject(Config.LAUNCH_INFO);
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
                } else if (coH != null && coH.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(coH.getError_code(), coH.getError_msg(), null);
                    if (this.jmo != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.jmo).optJSONObject(Config.LAUNCH_INFO);
                            if (optJSONObject2 != null) {
                                bb bbVar = new bb();
                                bbVar.title = optJSONObject2.optString("block_content");
                                bbVar.caR = optJSONObject2.optString("block_cancel");
                                bbVar.caS = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bbVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (coH != null && coH.error_code != 0) {
                    String error_msg2 = coH.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (coH.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(coH.getError_code(), error_msg2, this.jmn.coG());
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
                        if (this.jmo == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.jmo);
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
                                                    CustomDialogData cm = com.baidu.tieba.pb.b.cm(jSONObject);
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
                                                                customDialogData = cm;
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
                                                                bVar.Eh(str);
                                                                bVar.Ei(str3);
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
                                                                customDialogData = cm;
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
                                                                    customDialogData = cm;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = cm;
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
                                                                    bVar.Eh(str);
                                                                    bVar.Ei(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = cm;
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
                                                        customDialogData = cm;
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
                    bVar.Eh(str);
                    bVar.Ei(str3);
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
            String cpN;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.jmb = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.jmm && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.jmi == null) {
                        if (NewWriteModel.this.jmh != null) {
                            NewWriteModel.this.jmh.a(true, bVar.getErrorString(), null, null, bVar.biZ());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            cpN = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.cpN()) && StringUtils.isNull(bVar.cpM())) {
                            cpN = null;
                        } else {
                            str = bVar.cpM();
                            cpN = bVar.cpN();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, cpN);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.iYy != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.iYy.getProZone());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        y yVar = new y();
                        yVar.parserJson(this.jmo);
                        NewWriteModel.this.jmi.callback(true, postWriteCallBackData, yVar, NewWriteModel.this.iYy, bVar.biZ());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.iYy != null) {
                                switch (NewWriteModel.this.iYy.getType()) {
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
                            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.cfJ, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.jjG != null) {
                        this.jjG.bMD();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.jjG != null) {
                    this.jjG.ay(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.jmm = true;
            if (this.jmn != null) {
                this.jmn.cancel();
            }
            if (NewWriteModel.this.jmi != null) {
                NewWriteModel.this.jmi.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.jmh != null) {
                NewWriteModel.this.jmh.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.jmb = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.jmo), NewWriteModel.this.eZU)) {
                if (bVar.cpJ()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cpK()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cpI()) {
                    y yVar = new y();
                    yVar.parserJson(this.jmo);
                    if (yVar.getVcode_pic_url() != null && NewWriteModel.this.iYy != null) {
                        NewWriteModel.this.iYy.setVcodeMD5(yVar.getVcode_md5());
                        NewWriteModel.this.iYy.setVcodeUrl(yVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, yVar, NewWriteModel.this.iYy);
                    }
                } else if (bVar.cpL()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.jmo);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.iYy);
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
        if (bVar != null && bVar.biZ() != null && bVar.biZ().mFrsForbidenDialogInfo != null) {
            AntiHelper.aT(this.cfJ.getPageActivity(), bVar.biZ().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, y yVar, WriteData writeData) {
        if (bVar != null) {
            if (this.jmi != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.jmi.callback(false, postWriteCallBackData, yVar, writeData, bVar.biZ());
            } else if (this.jmh != null) {
                this.jmh.a(false, bVar.getErrorString(), yVar, writeData, bVar.biZ());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean jmm = false;
        com.baidu.tieba.tbadkCore.c.a jmn = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = m.isLocalImagePath(NewWriteModel.this.jme);
            if (this.jmm) {
                return null;
            }
            if (NewWriteModel.this.jmf == null || NewWriteModel.this.jmf.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.jme) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.jme);
                NewWriteModel.this.jmd = m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.jmd)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.jmd, this.jmn);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.jmf);
            if (this.bm != null) {
                NewWriteModel.this.jmd = m.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.jmd)) {
                    return NewWriteModel.this.a(NewWriteModel.this.jmd, this.jmn);
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
            this.jmm = true;
            if (this.jmn != null) {
                this.jmn.cancel();
            }
            if (NewWriteModel.this.jmg != null) {
                NewWriteModel.this.jmg.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.jmc = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.jmm) {
                if (NewWriteModel.this.jmg != null) {
                    NewWriteModel.this.jmg.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bgG() {
        if (this.jmc == null) {
            this.jmc = new a();
            this.jmc.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.jmf = bArr;
        this.jme = str;
    }

    public void a(b bVar) {
        this.jmg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.ao(ar.amO().getPostImageSize(), ar.amO().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
