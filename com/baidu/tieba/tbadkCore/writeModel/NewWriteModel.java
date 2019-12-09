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
    private final com.baidu.adp.base.e<?> ceS;
    private f.a eZd;
    private WriteData iXH;
    private e jlk;
    private a jll;
    private String jlm;
    private String jln;
    private byte[] jlo;
    private b jlp;
    private c jlq;
    private d jlr;
    private boolean jls;
    private a.InterfaceC0514a jlt;

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
        this.jlk = null;
        this.jll = null;
        this.iXH = null;
        this.jlm = null;
        this.jln = null;
        this.jlo = null;
        this.jlq = null;
        this.jlr = null;
        this.jls = false;
        this.eZd = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uU(String str) {
                if (NewWriteModel.this.iXH == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jlr != null) {
                        NewWriteModel.this.jlr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jlk = null;
                NewWriteModel.this.iXH.setAuthSid(str);
                NewWriteModel.this.cpC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bdC() {
                if (NewWriteModel.this.iXH != null) {
                    NewWriteModel.this.jlk = null;
                    NewWriteModel.this.iXH.setAuthSid(null);
                    NewWriteModel.this.cpC();
                } else if (NewWriteModel.this.jlr != null) {
                    NewWriteModel.this.jlr.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uV(String str) {
                if (NewWriteModel.this.iXH == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jlr != null) {
                        NewWriteModel.this.jlr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jlk = null;
                NewWriteModel.this.iXH.setAuthSid(str);
                NewWriteModel.this.cpC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.iXH != null) {
                    NewWriteModel.this.iXH.setAuthSid(null);
                }
                if (NewWriteModel.this.jlr != null) {
                    NewWriteModel.this.jlr.callback(false, null, null, null, null);
                }
            }
        };
        this.ceS = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jlk = null;
        this.jll = null;
        this.iXH = null;
        this.jlm = null;
        this.jln = null;
        this.jlo = null;
        this.jlq = null;
        this.jlr = null;
        this.jls = false;
        this.eZd = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uU(String str) {
                if (NewWriteModel.this.iXH == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jlr != null) {
                        NewWriteModel.this.jlr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jlk = null;
                NewWriteModel.this.iXH.setAuthSid(str);
                NewWriteModel.this.cpC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bdC() {
                if (NewWriteModel.this.iXH != null) {
                    NewWriteModel.this.jlk = null;
                    NewWriteModel.this.iXH.setAuthSid(null);
                    NewWriteModel.this.cpC();
                } else if (NewWriteModel.this.jlr != null) {
                    NewWriteModel.this.jlr.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uV(String str) {
                if (NewWriteModel.this.iXH == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jlr != null) {
                        NewWriteModel.this.jlr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jlk = null;
                NewWriteModel.this.iXH.setAuthSid(str);
                NewWriteModel.this.cpC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.iXH != null) {
                    NewWriteModel.this.iXH.setAuthSid(null);
                }
                if (NewWriteModel.this.jlr != null) {
                    NewWriteModel.this.jlr.callback(false, null, null, null, null);
                }
            }
        };
        this.ceS = tbPageContext;
    }

    public NewWriteModel() {
        this.jlk = null;
        this.jll = null;
        this.iXH = null;
        this.jlm = null;
        this.jln = null;
        this.jlo = null;
        this.jlq = null;
        this.jlr = null;
        this.jls = false;
        this.eZd = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uU(String str) {
                if (NewWriteModel.this.iXH == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jlr != null) {
                        NewWriteModel.this.jlr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jlk = null;
                NewWriteModel.this.iXH.setAuthSid(str);
                NewWriteModel.this.cpC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bdC() {
                if (NewWriteModel.this.iXH != null) {
                    NewWriteModel.this.jlk = null;
                    NewWriteModel.this.iXH.setAuthSid(null);
                    NewWriteModel.this.cpC();
                } else if (NewWriteModel.this.jlr != null) {
                    NewWriteModel.this.jlr.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void uV(String str) {
                if (NewWriteModel.this.iXH == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jlr != null) {
                        NewWriteModel.this.jlr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jlk = null;
                NewWriteModel.this.iXH.setAuthSid(str);
                NewWriteModel.this.cpC();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.iXH != null) {
                    NewWriteModel.this.iXH.setAuthSid(null);
                }
                if (NewWriteModel.this.jlr != null) {
                    NewWriteModel.this.jlr.callback(false, null, null, null, null);
                }
            }
        };
        this.ceS = null;
    }

    public void qV(boolean z) {
        this.jls = z;
    }

    public void b(d dVar) {
        this.jlr = dVar;
    }

    public void a(c cVar) {
        this.jlq = cVar;
    }

    public void a(a.InterfaceC0514a interfaceC0514a) {
        this.jlt = interfaceC0514a;
    }

    public void d(WriteData writeData) {
        this.iXH = writeData;
    }

    public WriteData cla() {
        return this.iXH;
    }

    public boolean cpC() {
        if (this.iXH == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.iXH.getWriteImagesInfo() == null || this.iXH.getWriteImagesInfo().size() == 0 || !this.iXH.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            cpD();
        } else {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.ceS == null) {
                cpD();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceS.getPageActivity());
            aVar.hT(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cpD();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.ceS);
            aVar.akM();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpD() {
        if (this.jlk == null) {
            this.jlk = new e();
            this.jlk.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.jlk != null && !this.jlk.isCancelled()) {
            this.jlk.cancel();
        } else if (this.jlr != null) {
            this.jlr.callback(false, null, null, null, null);
        } else if (this.jlq != null) {
            this.jlq.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jlk != null && !this.jlk.isCancelled()) {
            this.jlk.cancel();
            return false;
        }
        return false;
    }

    public void cpE() {
        if (this.jll != null && !this.jll.isCancelled()) {
            this.jll.cancel();
        }
    }

    public boolean cpF() {
        if (this.iXH == null) {
            return true;
        }
        return (this.iXH.getWriteImagesInfo() != null ? this.iXH.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h jiP;
        private l jly;
        private com.baidu.tieba.tbadkCore.c.a jlw = null;
        private String jlx = null;
        private boolean jlv = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.jly = (l) runTask.getData();
            }
            if (this.jly != null) {
                this.jiP = this.jly.bMW();
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
            if (!this.jlv) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.iXH.getContent());
                this.jlw = new com.baidu.tieba.tbadkCore.c.a();
                this.jlw.a(this.jiP);
                this.jlw.a(NewWriteModel.this.jlt);
                this.jlx = this.jlw.a(NewWriteModel.this.iXH, NewWriteModel.this.jls);
                ErrorData coF = this.jlw.coF();
                if (this.jlw.isRequestSuccess() && this.jlx != null) {
                    AntiData coE = this.jlw.coE();
                    String error_msg = coF.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(coF.getError_code(), error_msg, coE);
                    if (NewWriteModel.this.iXH != null && NewWriteModel.this.iXH.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.iXH.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (coF != null && coF.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(coF.getError_code(), coF.getError_msg(), null);
                    if (this.jlx != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.jlx).optJSONObject(Config.LAUNCH_INFO);
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
                } else if (coF != null && coF.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(coF.getError_code(), coF.getError_msg(), null);
                    if (this.jlx != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.jlx).optJSONObject(Config.LAUNCH_INFO);
                            if (optJSONObject2 != null) {
                                bb bbVar = new bb();
                                bbVar.title = optJSONObject2.optString("block_content");
                                bbVar.caa = optJSONObject2.optString("block_cancel");
                                bbVar.cab = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bbVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (coF != null && coF.error_code != 0) {
                    String error_msg2 = coF.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (coF.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(coF.getError_code(), error_msg2, this.jlw.coE());
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
                        if (this.jlx == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.jlx);
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
                                                    CustomDialogData cn = com.baidu.tieba.pb.b.cn(jSONObject);
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
                                                                customDialogData = cn;
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
                                                                customDialogData = cn;
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
                                                                    customDialogData = cn;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = cn;
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
                                                            customDialogData = cn;
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
                                                        customDialogData = cn;
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
            String cpL;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.jlk = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.jlv && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.jlr == null) {
                        if (NewWriteModel.this.jlq != null) {
                            NewWriteModel.this.jlq.a(true, bVar.getErrorString(), null, null, bVar.biX());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            cpL = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.cpL()) && StringUtils.isNull(bVar.cpK())) {
                            cpL = null;
                        } else {
                            str = bVar.cpK();
                            cpL = bVar.cpL();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, cpL);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.iXH != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.iXH.getProZone());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        y yVar = new y();
                        yVar.parserJson(this.jlx);
                        NewWriteModel.this.jlr.callback(true, postWriteCallBackData, yVar, NewWriteModel.this.iXH, bVar.biX());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.iXH != null) {
                                switch (NewWriteModel.this.iXH.getType()) {
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
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.ceS, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.jiP != null) {
                        this.jiP.bMB();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.jiP != null) {
                    this.jiP.ax(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.jlv = true;
            if (this.jlw != null) {
                this.jlw.cancel();
            }
            if (NewWriteModel.this.jlr != null) {
                NewWriteModel.this.jlr.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.jlq != null) {
                NewWriteModel.this.jlq.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.jlk = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.jlx), NewWriteModel.this.eZd)) {
                if (bVar.cpH()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cpI()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cpG()) {
                    y yVar = new y();
                    yVar.parserJson(this.jlx);
                    if (yVar.getVcode_pic_url() != null && NewWriteModel.this.iXH != null) {
                        NewWriteModel.this.iXH.setVcodeMD5(yVar.getVcode_md5());
                        NewWriteModel.this.iXH.setVcodeUrl(yVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, yVar, NewWriteModel.this.iXH);
                    }
                } else if (bVar.cpJ()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.jlx);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.iXH);
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
        if (bVar != null && bVar.biX() != null && bVar.biX().mFrsForbidenDialogInfo != null) {
            AntiHelper.aT(this.ceS.getPageActivity(), bVar.biX().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, y yVar, WriteData writeData) {
        if (bVar != null) {
            if (this.jlr != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.jlr.callback(false, postWriteCallBackData, yVar, writeData, bVar.biX());
            } else if (this.jlq != null) {
                this.jlq.a(false, bVar.getErrorString(), yVar, writeData, bVar.biX());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean jlv = false;
        com.baidu.tieba.tbadkCore.c.a jlw = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = m.isLocalImagePath(NewWriteModel.this.jln);
            if (this.jlv) {
                return null;
            }
            if (NewWriteModel.this.jlo == null || NewWriteModel.this.jlo.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.jln) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.jln);
                NewWriteModel.this.jlm = m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.jlm)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.jlm, this.jlw);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.jlo);
            if (this.bm != null) {
                NewWriteModel.this.jlm = m.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.jlm)) {
                    return NewWriteModel.this.a(NewWriteModel.this.jlm, this.jlw);
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
            this.jlv = true;
            if (this.jlw != null) {
                this.jlw.cancel();
            }
            if (NewWriteModel.this.jlp != null) {
                NewWriteModel.this.jlp.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.jll = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.jlv) {
                if (NewWriteModel.this.jlp != null) {
                    NewWriteModel.this.jlp.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bgE() {
        if (this.jll == null) {
            this.jll = new a();
            this.jll.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.jlo = bArr;
        this.jln = str;
    }

    public void a(b bVar) {
        this.jlp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.am(ar.amM().getPostImageSize(), ar.amM().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
