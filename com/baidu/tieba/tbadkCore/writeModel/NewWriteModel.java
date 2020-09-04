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
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    private final com.baidu.adp.base.e<?> efO;
    private f.a htx;
    private WriteData lUv;
    private SpanGroupManager mSpanGroupManager;
    private e miV;
    private a miW;
    private String miX;
    private String miY;
    private byte[] miZ;
    private b mja;
    private c mjb;
    private d mjc;
    private boolean mjd;
    private a.InterfaceC0807a mje;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, ag agVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.miV = null;
        this.miW = null;
        this.lUv = null;
        this.miX = null;
        this.miY = null;
        this.miZ = null;
        this.mjb = null;
        this.mjc = null;
        this.mjd = false;
        this.htx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cew() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.miV = null;
                    NewWriteModel.this.lUv.setAuthSid(null);
                    NewWriteModel.this.dxX();
                } else if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hu(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.lUv.setAuthSid(null);
                }
                if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }
        };
        this.efO = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.miV = null;
        this.miW = null;
        this.lUv = null;
        this.miX = null;
        this.miY = null;
        this.miZ = null;
        this.mjb = null;
        this.mjc = null;
        this.mjd = false;
        this.htx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cew() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.miV = null;
                    NewWriteModel.this.lUv.setAuthSid(null);
                    NewWriteModel.this.dxX();
                } else if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hu(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.lUv.setAuthSid(null);
                }
                if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }
        };
        this.efO = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.miV = null;
        this.miW = null;
        this.lUv = null;
        this.miX = null;
        this.miY = null;
        this.miZ = null;
        this.mjb = null;
        this.mjc = null;
        this.mjd = false;
        this.htx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cew() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.miV = null;
                    NewWriteModel.this.lUv.setAuthSid(null);
                    NewWriteModel.this.dxX();
                } else if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hu(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.lUv.setAuthSid(null);
                }
                if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }
        };
        this.efO = tbPageContext;
    }

    public NewWriteModel() {
        this.miV = null;
        this.miW = null;
        this.lUv = null;
        this.miX = null;
        this.miY = null;
        this.miZ = null;
        this.mjb = null;
        this.mjc = null;
        this.mjd = false;
        this.htx = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Ht(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void cew() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.miV = null;
                    NewWriteModel.this.lUv.setAuthSid(null);
                    NewWriteModel.this.dxX();
                } else if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void Hu(String str) {
                if (NewWriteModel.this.lUv == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.mjc != null) {
                        NewWriteModel.this.mjc.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.miV = null;
                NewWriteModel.this.lUv.setAuthSid(str);
                NewWriteModel.this.dxX();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lUv != null) {
                    NewWriteModel.this.lUv.setAuthSid(null);
                }
                if (NewWriteModel.this.mjc != null) {
                    NewWriteModel.this.mjc.callback(false, null, null, null, null);
                }
            }
        };
        this.efO = null;
    }

    public void wi(boolean z) {
        this.mjd = z;
    }

    public void b(d dVar) {
        this.mjc = dVar;
    }

    public void a(c cVar) {
        this.mjb = cVar;
    }

    public void a(a.InterfaceC0807a interfaceC0807a) {
        this.mje = interfaceC0807a;
    }

    public void d(WriteData writeData) {
        this.lUv = writeData;
    }

    public WriteData cLa() {
        return this.lUv;
    }

    public boolean dxX() {
        if (this.lUv == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.lUv.getWriteImagesInfo() == null || this.lUv.getWriteImagesInfo().size() == 0 || !this.lUv.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dxY();
        } else {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.efO == null) {
                dxY();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efO.getPageActivity());
            aVar.nt(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dxY();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.efO);
            aVar.bhg();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxY() {
        if (this.miV == null) {
            this.miV = new e();
            this.miV.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.miV != null && !this.miV.isCancelled()) {
            this.miV.cancel();
        } else if (this.mjc != null) {
            this.mjc.callback(false, null, null, null, null);
        } else if (this.mjb != null) {
            this.mjb.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.miV != null && !this.miV.isCancelled()) {
            this.miV.cancel();
            return false;
        }
        return false;
    }

    public void dxZ() {
        if (this.miW != null && !this.miW.isCancelled()) {
            this.miW.cancel();
        }
    }

    public boolean dya() {
        if (this.lUv == null) {
            return true;
        }
        return (this.lUv.getWriteImagesInfo() != null ? this.lUv.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h mgu;
        private l mji;
        private com.baidu.tieba.tbadkCore.c.a mjg = null;
        private String mjh = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.mji = (l) runTask.getData();
            }
            if (this.mji != null) {
                this.mgu = this.mji.cRu();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.lUv.getContent());
                this.mjg = new com.baidu.tieba.tbadkCore.c.a();
                this.mjg.setSpanGroupManager(NewWriteModel.this.mSpanGroupManager);
                this.mjg.a(this.mgu);
                this.mjg.a(NewWriteModel.this.mje);
                this.mjh = this.mjg.a(NewWriteModel.this.lUv, NewWriteModel.this.mjd);
                ErrorData dxa = this.mjg.dxa();
                if (this.mjg.isRequestSuccess() && this.mjh != null) {
                    AntiData dwZ = this.mjg.dwZ();
                    String error_msg = dxa.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dxa.getError_code(), error_msg, dwZ);
                    if (NewWriteModel.this.lUv != null && NewWriteModel.this.lUv.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.lUv.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dxa != null && dxa.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dxa.getError_code(), dxa.getError_msg(), null);
                    if (this.mjh != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.mjh).optJSONObject("info");
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
                } else if (dxa != null && dxa.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dxa.getError_code(), dxa.getError_msg(), null);
                    if (this.mjh != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.mjh).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                bp bpVar = new bp();
                                bpVar.title = optJSONObject2.optString("block_content");
                                bpVar.eam = optJSONObject2.optString("block_cancel");
                                bpVar.ean = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bpVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dxa != null && dxa.error_code != 0) {
                    String error_msg2 = dxa.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dxa.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dxa.getError_code(), error_msg2, this.mjg.dwZ());
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
                        if (this.mjh == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.mjh);
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
            String dyg;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.miV = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.mjc == null) {
                        if (NewWriteModel.this.mjb != null) {
                            NewWriteModel.this.mjb.a(true, bVar.getErrorString(), null, null, bVar.ckU());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            dyg = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dyg()) && StringUtils.isNull(bVar.dyf())) {
                            dyg = null;
                        } else {
                            str = bVar.dyf();
                            dyg = bVar.dyg();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, dyg);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.lUv != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.lUv.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.lUv.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        ag agVar = new ag();
                        agVar.parserJson(this.mjh);
                        NewWriteModel.this.mjc.callback(true, postWriteCallBackData, agVar, NewWriteModel.this.lUv, bVar.ckU());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.lUv != null) {
                                switch (NewWriteModel.this.lUv.getType()) {
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
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.efO, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.mgu != null) {
                        this.mgu.cRf();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.mgu != null) {
                    this.mgu.bp(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.mjg != null) {
                this.mjg.cancel();
            }
            if (NewWriteModel.this.mjc != null) {
                NewWriteModel.this.mjc.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.mjb != null) {
                NewWriteModel.this.mjb.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.miV = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.mjh), NewWriteModel.this.htx)) {
                if (bVar.dyc()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dyd()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dyb()) {
                    ag agVar = new ag();
                    agVar.parserJson(this.mjh);
                    if (agVar.getVcode_pic_url() != null && NewWriteModel.this.lUv != null) {
                        NewWriteModel.this.lUv.setVcodeMD5(agVar.getVcode_md5());
                        NewWriteModel.this.lUv.setVcodeUrl(agVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, agVar, NewWriteModel.this.lUv);
                    }
                } else if (bVar.dye()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.mjh);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.lUv);
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
        if (bVar != null && bVar.ckU() != null && bVar.ckU().mFrsForbidenDialogInfo != null) {
            AntiHelper.bc(this.efO.getPageActivity(), bVar.ckU().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ag agVar, WriteData writeData) {
        if (bVar != null) {
            if (this.mjc != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.mjc.callback(false, postWriteCallBackData, agVar, writeData, bVar.ckU());
            } else if (this.mjb != null) {
                this.mjb.a(false, bVar.getErrorString(), agVar, writeData, bVar.ckU());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a mjg = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = n.isLocalImagePath(NewWriteModel.this.miY);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.miZ == null || NewWriteModel.this.miZ.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.miY) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.miY);
                NewWriteModel.this.miX = n.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.miX)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.miX, this.mjg);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.miZ);
            if (this.bm != null) {
                NewWriteModel.this.miX = n.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.miX)) {
                    return NewWriteModel.this.a(NewWriteModel.this.miX, this.mjg);
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
            if (this.mjg != null) {
                this.mjg.cancel();
            }
            if (NewWriteModel.this.mja != null) {
                NewWriteModel.this.mja.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.miW = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.mja != null) {
                    NewWriteModel.this.mja.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void civ() {
        if (this.miW == null) {
            this.miW = new a();
            this.miW.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.miZ = bArr;
        this.miY = str;
    }

    public void a(b bVar) {
        this.mja = bVar;
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
