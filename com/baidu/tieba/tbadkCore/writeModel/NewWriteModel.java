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
import com.baidu.tbadk.coreExtra.data.aa;
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
    private final com.baidu.adp.base.e<?> cVE;
    private f.a fTE;
    private WriteData jWW;
    private a.InterfaceC0611a kkA;
    private e kkr;
    private a kks;
    private String kkt;
    private String kku;
    private byte[] kkv;
    private b kkw;
    private c kkx;
    private d kky;
    private boolean kkz;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.kkr = null;
        this.kks = null;
        this.jWW = null;
        this.kkt = null;
        this.kku = null;
        this.kkv = null;
        this.kkx = null;
        this.kky = null;
        this.kkz = false;
        this.fTE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void An(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bxH() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.kkr = null;
                    NewWriteModel.this.jWW.setAuthSid(null);
                    NewWriteModel.this.cMk();
                } else if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ao(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.jWW.setAuthSid(null);
                }
                if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }
        };
        this.cVE = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.kkr = null;
        this.kks = null;
        this.jWW = null;
        this.kkt = null;
        this.kku = null;
        this.kkv = null;
        this.kkx = null;
        this.kky = null;
        this.kkz = false;
        this.fTE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void An(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bxH() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.kkr = null;
                    NewWriteModel.this.jWW.setAuthSid(null);
                    NewWriteModel.this.cMk();
                } else if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ao(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.jWW.setAuthSid(null);
                }
                if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }
        };
        this.cVE = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.kkr = null;
        this.kks = null;
        this.jWW = null;
        this.kkt = null;
        this.kku = null;
        this.kkv = null;
        this.kkx = null;
        this.kky = null;
        this.kkz = false;
        this.fTE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void An(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bxH() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.kkr = null;
                    NewWriteModel.this.jWW.setAuthSid(null);
                    NewWriteModel.this.cMk();
                } else if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ao(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.jWW.setAuthSid(null);
                }
                if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }
        };
        this.cVE = tbPageContext;
    }

    public NewWriteModel() {
        this.kkr = null;
        this.kks = null;
        this.jWW = null;
        this.kkt = null;
        this.kku = null;
        this.kkv = null;
        this.kkx = null;
        this.kky = null;
        this.kkz = false;
        this.fTE = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void An(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bxH() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.kkr = null;
                    NewWriteModel.this.jWW.setAuthSid(null);
                    NewWriteModel.this.cMk();
                } else if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ao(String str) {
                if (NewWriteModel.this.jWW == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.kky != null) {
                        NewWriteModel.this.kky.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.kkr = null;
                NewWriteModel.this.jWW.setAuthSid(str);
                NewWriteModel.this.cMk();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.jWW != null) {
                    NewWriteModel.this.jWW.setAuthSid(null);
                }
                if (NewWriteModel.this.kky != null) {
                    NewWriteModel.this.kky.callback(false, null, null, null, null);
                }
            }
        };
        this.cVE = null;
    }

    public void sS(boolean z) {
        this.kkz = z;
    }

    public void b(d dVar) {
        this.kky = dVar;
    }

    public void a(c cVar) {
        this.kkx = cVar;
    }

    public void a(a.InterfaceC0611a interfaceC0611a) {
        this.kkA = interfaceC0611a;
    }

    public void d(WriteData writeData) {
        this.jWW = writeData;
    }

    public WriteData cHV() {
        return this.jWW;
    }

    public boolean cMk() {
        if (this.jWW == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.jWW.getWriteImagesInfo() == null || this.jWW.getWriteImagesInfo().size() == 0 || !this.jWW.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            cMl();
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.cVE == null) {
                cMl();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVE.getPageActivity());
            aVar.jW(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cMl();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.cVE);
            aVar.aEC();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMl() {
        if (this.kkr == null) {
            this.kkr = new e();
            this.kkr.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.kkr != null && !this.kkr.isCancelled()) {
            this.kkr.cancel();
        } else if (this.kky != null) {
            this.kky.callback(false, null, null, null, null);
        } else if (this.kkx != null) {
            this.kkx.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.kkr != null && !this.kkr.isCancelled()) {
            this.kkr.cancel();
            return false;
        }
        return false;
    }

    public void cMm() {
        if (this.kks != null && !this.kks.isCancelled()) {
            this.kks.cancel();
        }
    }

    public boolean cMn() {
        if (this.jWW == null) {
            return true;
        }
        return (this.jWW.getWriteImagesInfo() != null ? this.jWW.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h khZ;
        private l kkE;
        private com.baidu.tieba.tbadkCore.c.a kkC = null;
        private String kkD = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.kkE = (l) runTask.getData();
            }
            if (this.kkE != null) {
                this.khZ = this.kkE.cgZ();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.jWW.getContent());
                this.kkC = new com.baidu.tieba.tbadkCore.c.a();
                this.kkC.a(this.khZ);
                this.kkC.a(NewWriteModel.this.kkA);
                this.kkD = this.kkC.a(NewWriteModel.this.jWW, NewWriteModel.this.kkz);
                ErrorData cLs = this.kkC.cLs();
                if (this.kkC.isRequestSuccess() && this.kkD != null) {
                    AntiData cLr = this.kkC.cLr();
                    String error_msg = cLs.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(cLs.getError_code(), error_msg, cLr);
                    if (NewWriteModel.this.jWW != null && NewWriteModel.this.jWW.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.jWW.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (cLs != null && cLs.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cLs.getError_code(), cLs.getError_msg(), null);
                    if (this.kkD != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.kkD).optJSONObject("info");
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
                } else if (cLs != null && cLs.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cLs.getError_code(), cLs.getError_msg(), null);
                    if (this.kkD != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.kkD).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bd bdVar = new bd();
                                bdVar.title = optJSONObject2.optString("block_content");
                                bdVar.cQG = optJSONObject2.optString("block_cancel");
                                bdVar.cQH = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bdVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (cLs != null && cLs.error_code != 0) {
                    String error_msg2 = cLs.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (cLs.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(cLs.getError_code(), error_msg2, this.kkC.cLr());
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
                        if (this.kkD == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.kkD);
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
                                                    CustomDialogData dd = com.baidu.tieba.pb.b.dd(jSONObject);
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
                                                                bVar.Ju(str);
                                                                bVar.Jv(str3);
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
                                                                    bVar.Ju(str);
                                                                    bVar.Jv(str3);
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
                    bVar.Ju(str);
                    bVar.Jv(str3);
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
            String cMt;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.kkr = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.kky == null) {
                        if (NewWriteModel.this.kkx != null) {
                            NewWriteModel.this.kkx.a(true, bVar.getErrorString(), null, null, bVar.bCZ());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            cMt = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.cMt()) && StringUtils.isNull(bVar.cMs())) {
                            cMt = null;
                        } else {
                            str = bVar.cMs();
                            cMt = bVar.cMt();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, cMt);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.jWW != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.jWW.getProZone());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        aa aaVar = new aa();
                        aaVar.parserJson(this.kkD);
                        NewWriteModel.this.kky.callback(true, postWriteCallBackData, aaVar, NewWriteModel.this.jWW, bVar.bCZ());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.jWW != null) {
                                switch (NewWriteModel.this.jWW.getType()) {
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
                            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.cVE, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.khZ != null) {
                        this.khZ.cgD();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.khZ != null) {
                    this.khZ.aS(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.kkC != null) {
                this.kkC.cancel();
            }
            if (NewWriteModel.this.kky != null) {
                NewWriteModel.this.kky.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.kkx != null) {
                NewWriteModel.this.kkx.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.kkr = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.kkD), NewWriteModel.this.fTE)) {
                if (bVar.cMp()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cMq()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cMo()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(this.kkD);
                    if (aaVar.getVcode_pic_url() != null && NewWriteModel.this.jWW != null) {
                        NewWriteModel.this.jWW.setVcodeMD5(aaVar.getVcode_md5());
                        NewWriteModel.this.jWW.setVcodeUrl(aaVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, aaVar, NewWriteModel.this.jWW);
                    }
                } else if (bVar.cMr()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.kkD);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.jWW);
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
        if (bVar != null && bVar.bCZ() != null && bVar.bCZ().mFrsForbidenDialogInfo != null) {
            AntiHelper.bo(this.cVE.getPageActivity(), bVar.bCZ().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, aa aaVar, WriteData writeData) {
        if (bVar != null) {
            if (this.kky != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.kky.callback(false, postWriteCallBackData, aaVar, writeData, bVar.bCZ());
            } else if (this.kkx != null) {
                this.kkx.a(false, bVar.getErrorString(), aaVar, writeData, bVar.bCZ());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a kkC = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = m.isLocalImagePath(NewWriteModel.this.kku);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.kkv == null || NewWriteModel.this.kkv.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.kku) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.kku);
                NewWriteModel.this.kkt = m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.kkt)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.kkt, this.kkC);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.kkv);
            if (this.bm != null) {
                NewWriteModel.this.kkt = m.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.kkt)) {
                    return NewWriteModel.this.a(NewWriteModel.this.kkt, this.kkC);
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
            if (this.kkC != null) {
                this.kkC.cancel();
            }
            if (NewWriteModel.this.kkw != null) {
                NewWriteModel.this.kkw.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.kks = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.kkw != null) {
                    NewWriteModel.this.kkw.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bAG() {
        if (this.kks == null) {
            this.kks = new a();
            this.kks.execute(new Void[0]);
        }
    }

    public void e(byte[] bArr, String str) {
        this.kkv = bArr;
        this.kku = str;
    }

    public void a(b bVar) {
        this.kkw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aJ(ar.aGD().getPostImageSize(), ar.aGD().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
