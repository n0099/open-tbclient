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
import com.baidu.tbadk.core.data.bd;
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
    private final com.baidu.adp.base.e<?> cRq;
    private f.a fNL;
    private WriteData jSa;
    private a kfA;
    private String kfB;
    private String kfC;
    private byte[] kfD;
    private b kfE;
    private c kfF;
    private d kfG;
    private boolean kfH;
    private a.InterfaceC0598a kfI;
    private e kfz;

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

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kfz = null;
        this.kfA = null;
        this.jSa = null;
        this.kfB = null;
        this.kfC = null;
        this.kfD = null;
        this.kfF = null;
        this.kfG = null;
        this.kfH = false;
        this.fNL = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zM(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void buY() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.kfz = null;
                    NewWriteModel.this.jSa.setAuthSid(null);
                    NewWriteModel.this.cJG();
                } else if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zN(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.jSa.setAuthSid(null);
                }
                if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }
        };
        this.cRq = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kfz = null;
        this.kfA = null;
        this.jSa = null;
        this.kfB = null;
        this.kfC = null;
        this.kfD = null;
        this.kfF = null;
        this.kfG = null;
        this.kfH = false;
        this.fNL = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zM(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void buY() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.kfz = null;
                    NewWriteModel.this.jSa.setAuthSid(null);
                    NewWriteModel.this.cJG();
                } else if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zN(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.jSa.setAuthSid(null);
                }
                if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }
        };
        this.cRq = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.kfz = null;
        this.kfA = null;
        this.jSa = null;
        this.kfB = null;
        this.kfC = null;
        this.kfD = null;
        this.kfF = null;
        this.kfG = null;
        this.kfH = false;
        this.fNL = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zM(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void buY() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.kfz = null;
                    NewWriteModel.this.jSa.setAuthSid(null);
                    NewWriteModel.this.cJG();
                } else if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zN(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.jSa.setAuthSid(null);
                }
                if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }
        };
        this.cRq = tbPageContext;
    }

    public NewWriteModel() {
        this.kfz = null;
        this.kfA = null;
        this.jSa = null;
        this.kfB = null;
        this.kfC = null;
        this.kfD = null;
        this.kfF = null;
        this.kfG = null;
        this.kfH = false;
        this.fNL = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zM(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void buY() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.kfz = null;
                    NewWriteModel.this.jSa.setAuthSid(null);
                    NewWriteModel.this.cJG();
                } else if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void zN(String str) {
                if (NewWriteModel.this.jSa == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kfG != null) {
                        NewWriteModel.this.kfG.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kfz = null;
                NewWriteModel.this.jSa.setAuthSid(str);
                NewWriteModel.this.cJG();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jSa != null) {
                    NewWriteModel.this.jSa.setAuthSid(null);
                }
                if (NewWriteModel.this.kfG != null) {
                    NewWriteModel.this.kfG.callback(false, null, null, null, null);
                }
            }
        };
        this.cRq = null;
    }

    public void sC(boolean z) {
        this.kfH = z;
    }

    public void b(d dVar) {
        this.kfG = dVar;
    }

    public void a(c cVar) {
        this.kfF = cVar;
    }

    public void a(a.InterfaceC0598a interfaceC0598a) {
        this.kfI = interfaceC0598a;
    }

    public void d(WriteData writeData) {
        this.jSa = writeData;
    }

    public WriteData cFi() {
        return this.jSa;
    }

    public boolean cJG() {
        if (this.jSa == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.jSa.getWriteImagesInfo() == null || this.jSa.getWriteImagesInfo().size() == 0 || !this.jSa.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            cJH();
        } else {
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.cRq == null) {
                cJH();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRq.getPageActivity());
            aVar.jF(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cJH();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.cRq);
            aVar.aBW();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJH() {
        if (this.kfz == null) {
            this.kfz = new e();
            this.kfz.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.kfz != null && !this.kfz.isCancelled()) {
            this.kfz.cancel();
        } else if (this.kfG != null) {
            this.kfG.callback(false, null, null, null, null);
        } else if (this.kfF != null) {
            this.kfF.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kfz != null && !this.kfz.isCancelled()) {
            this.kfz.cancel();
            return false;
        }
        return false;
    }

    public void cJI() {
        if (this.kfA != null && !this.kfA.isCancelled()) {
            this.kfA.cancel();
        }
    }

    public boolean cJJ() {
        if (this.jSa == null) {
            return true;
        }
        return (this.jSa.getWriteImagesInfo() != null ? this.jSa.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h kdc;
        private l kfM;
        private com.baidu.tieba.tbadkCore.c.a kfK = null;
        private String kfL = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.kfM = (l) runTask.getData();
            }
            if (this.kfM != null) {
                this.kdc = this.kfM.cei();
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
            if (!this.isCanceled) {
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.jSa.getContent());
                this.kfK = new com.baidu.tieba.tbadkCore.c.a();
                this.kfK.a(this.kdc);
                this.kfK.a(NewWriteModel.this.kfI);
                this.kfL = this.kfK.a(NewWriteModel.this.jSa, NewWriteModel.this.kfH);
                ErrorData cIL = this.kfK.cIL();
                if (this.kfK.isRequestSuccess() && this.kfL != null) {
                    AntiData cIK = this.kfK.cIK();
                    String error_msg = cIL.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(cIL.getError_code(), error_msg, cIK);
                    if (NewWriteModel.this.jSa != null && NewWriteModel.this.jSa.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.jSa.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (cIL != null && cIL.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cIL.getError_code(), cIL.getError_msg(), null);
                    if (this.kfL != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.kfL).optJSONObject("info");
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
                } else if (cIL != null && cIL.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cIL.getError_code(), cIL.getError_msg(), null);
                    if (this.kfL != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.kfL).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bd bdVar = new bd();
                                bdVar.title = optJSONObject2.optString("block_content");
                                bdVar.cMr = optJSONObject2.optString("block_cancel");
                                bdVar.cMs = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bdVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (cIL != null && cIL.error_code != 0) {
                    String error_msg2 = cIL.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (cIL.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cIL.getError_code(), error_msg2, this.kfK.cIK());
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
                        if (this.kfL == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.kfL);
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
                                                    CustomDialogData dd = com.baidu.tieba.pb.c.dd(jSONObject);
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
                                                                customDialogData = dd;
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
                                                                bVar.IW(str);
                                                                bVar.IX(str3);
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
                                                                customDialogData = dd;
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
                                                                    customDialogData = dd;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = dd;
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
                                                                    bVar.IW(str);
                                                                    bVar.IX(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = dd;
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
                                                        customDialogData = dd;
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
                    bVar.IW(str);
                    bVar.IX(str3);
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
            String cJP;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.kfz = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.kfG == null) {
                        if (NewWriteModel.this.kfF != null) {
                            NewWriteModel.this.kfF.a(true, bVar.getErrorString(), null, null, bVar.bAs());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            cJP = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.cJP()) && StringUtils.isNull(bVar.cJO())) {
                            cJP = null;
                        } else {
                            str = bVar.cJO();
                            cJP = bVar.cJP();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, cJP);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.jSa != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.jSa.getProZone());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        y yVar = new y();
                        yVar.parserJson(this.kfL);
                        NewWriteModel.this.kfG.callback(true, postWriteCallBackData, yVar, NewWriteModel.this.jSa, bVar.bAs());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.jSa != null) {
                                switch (NewWriteModel.this.jSa.getType()) {
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
                            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.cRq, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.kdc != null) {
                        this.kdc.cdN();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.kdc != null) {
                    this.kdc.aM(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.kfK != null) {
                this.kfK.cancel();
            }
            if (NewWriteModel.this.kfG != null) {
                NewWriteModel.this.kfG.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.kfF != null) {
                NewWriteModel.this.kfF.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.kfz = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.kfL), NewWriteModel.this.fNL)) {
                if (bVar.cJL()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cJM()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cJK()) {
                    y yVar = new y();
                    yVar.parserJson(this.kfL);
                    if (yVar.getVcode_pic_url() != null && NewWriteModel.this.jSa != null) {
                        NewWriteModel.this.jSa.setVcodeMD5(yVar.getVcode_md5());
                        NewWriteModel.this.jSa.setVcodeUrl(yVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, yVar, NewWriteModel.this.jSa);
                    }
                } else if (bVar.cJN()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.kfL);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.jSa);
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
        if (bVar != null && bVar.bAs() != null && bVar.bAs().mFrsForbidenDialogInfo != null) {
            AntiHelper.bk(this.cRq.getPageActivity(), bVar.bAs().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, y yVar, WriteData writeData) {
        if (bVar != null) {
            if (this.kfG != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.kfG.callback(false, postWriteCallBackData, yVar, writeData, bVar.bAs());
            } else if (this.kfF != null) {
                this.kfF.a(false, bVar.getErrorString(), yVar, writeData, bVar.bAs());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a kfK = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = m.isLocalImagePath(NewWriteModel.this.kfC);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.kfD == null || NewWriteModel.this.kfD.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.kfC) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.kfC);
                NewWriteModel.this.kfB = m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.kfB)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.kfB, this.kfK);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.kfD);
            if (this.bm != null) {
                NewWriteModel.this.kfB = m.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.kfB)) {
                    return NewWriteModel.this.a(NewWriteModel.this.kfB, this.kfK);
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
            if (this.kfK != null) {
                this.kfK.cancel();
            }
            if (NewWriteModel.this.kfE != null) {
                NewWriteModel.this.kfE.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.kfA = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.kfE != null) {
                    NewWriteModel.this.kfE.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bxZ() {
        if (this.kfA == null) {
            this.kfA = new a();
            this.kfA.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.kfD = bArr;
        this.kfC = str;
    }

    public void a(b bVar) {
        this.kfE = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aF(ar.aDX().getPostImageSize(), ar.aDX().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
