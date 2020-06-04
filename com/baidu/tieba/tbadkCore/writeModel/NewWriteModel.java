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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
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
    private final com.baidu.adp.base.e<?> dJb;
    private f.a gNX;
    private WriteData lbl;
    private e lpU;
    private a lpV;
    private String lpW;
    private String lpX;
    private byte[] lpY;
    private b lpZ;
    private c lqa;
    private d lqb;
    private boolean lqc;
    private a.InterfaceC0728a lqd;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, ab abVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.lpU = null;
        this.lpV = null;
        this.lbl = null;
        this.lpW = null;
        this.lpX = null;
        this.lpY = null;
        this.lqa = null;
        this.lqb = null;
        this.lqc = false;
        this.gNX = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DH(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bNS() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lpU = null;
                    NewWriteModel.this.lbl.setAuthSid(null);
                    NewWriteModel.this.dfc();
                } else if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DI(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lbl.setAuthSid(null);
                }
                if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }
        };
        this.dJb = baseFragmentActivity.getPageContext();
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.lpU = null;
        this.lpV = null;
        this.lbl = null;
        this.lpW = null;
        this.lpX = null;
        this.lpY = null;
        this.lqa = null;
        this.lqb = null;
        this.lqc = false;
        this.gNX = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DH(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bNS() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lpU = null;
                    NewWriteModel.this.lbl.setAuthSid(null);
                    NewWriteModel.this.dfc();
                } else if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DI(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lbl.setAuthSid(null);
                }
                if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }
        };
        this.dJb = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.lpU = null;
        this.lpV = null;
        this.lbl = null;
        this.lpW = null;
        this.lpX = null;
        this.lpY = null;
        this.lqa = null;
        this.lqb = null;
        this.lqc = false;
        this.gNX = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DH(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bNS() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lpU = null;
                    NewWriteModel.this.lbl.setAuthSid(null);
                    NewWriteModel.this.dfc();
                } else if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DI(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lbl.setAuthSid(null);
                }
                if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }
        };
        this.dJb = tbPageContext;
    }

    public NewWriteModel() {
        this.lpU = null;
        this.lpV = null;
        this.lbl = null;
        this.lpW = null;
        this.lpX = null;
        this.lpY = null;
        this.lqa = null;
        this.lqb = null;
        this.lqc = false;
        this.gNX = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DH(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bNS() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lpU = null;
                    NewWriteModel.this.lbl.setAuthSid(null);
                    NewWriteModel.this.dfc();
                } else if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void DI(String str) {
                if (NewWriteModel.this.lbl == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.lqb != null) {
                        NewWriteModel.this.lqb.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.lpU = null;
                NewWriteModel.this.lbl.setAuthSid(str);
                NewWriteModel.this.dfc();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.lbl != null) {
                    NewWriteModel.this.lbl.setAuthSid(null);
                }
                if (NewWriteModel.this.lqb != null) {
                    NewWriteModel.this.lqb.callback(false, null, null, null, null);
                }
            }
        };
        this.dJb = null;
    }

    public void uy(boolean z) {
        this.lqc = z;
    }

    public void b(d dVar) {
        this.lqb = dVar;
    }

    public void a(c cVar) {
        this.lqa = cVar;
    }

    public void a(a.InterfaceC0728a interfaceC0728a) {
        this.lqd = interfaceC0728a;
    }

    public void d(WriteData writeData) {
        this.lbl = writeData;
    }

    public WriteData daf() {
        return this.lbl;
    }

    public boolean dfc() {
        if (this.lbl == null) {
            return false;
        }
        if (!j.isNetWorkAvailable() || j.isWifiNet() || this.lbl.getWriteImagesInfo() == null || this.lbl.getWriteImagesInfo().size() == 0 || !this.lbl.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, false)) {
            dfd();
        } else {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ORIGINAL_IMG_UP_TIP, true);
            if (this.dJb == null) {
                dfd();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dJb.getPageActivity());
            aVar.kF(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dfd();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.dJb);
            aVar.aST();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfd() {
        if (this.lpU == null) {
            this.lpU = new e();
            this.lpU.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.lpU != null && !this.lpU.isCancelled()) {
            this.lpU.cancel();
        } else if (this.lqb != null) {
            this.lqb.callback(false, null, null, null, null);
        } else if (this.lqa != null) {
            this.lqa.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.lpU != null && !this.lpU.isCancelled()) {
            this.lpU.cancel();
            return false;
        }
        return false;
    }

    public void dfe() {
        if (this.lpV != null && !this.lpV.isCancelled()) {
            this.lpV.cancel();
        }
    }

    public boolean dff() {
        if (this.lbl == null) {
            return true;
        }
        return (this.lbl.getWriteImagesInfo() != null ? this.lbl.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h lnq;
        private l lqh;
        private com.baidu.tieba.tbadkCore.c.a lqf = null;
        private String lqg = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
            if (runTask != null) {
                this.lqh = (l) runTask.getData();
            }
            if (this.lqh != null) {
                this.lnq = this.lqh.cyS();
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
                com.baidu.tbadk.imageManager.d.statisticsNum(NewWriteModel.this.lbl.getContent());
                this.lqf = new com.baidu.tieba.tbadkCore.c.a();
                this.lqf.a(this.lnq);
                this.lqf.a(NewWriteModel.this.lqd);
                this.lqg = this.lqf.a(NewWriteModel.this.lbl, NewWriteModel.this.lqc);
                ErrorData dec = this.lqf.dec();
                if (this.lqf.isRequestSuccess() && this.lqg != null) {
                    AntiData deb = this.lqf.deb();
                    String error_msg = dec.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(dec.getError_code(), error_msg, deb);
                    if (NewWriteModel.this.lbl != null && NewWriteModel.this.lbl.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.lbl.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (dec != null && dec.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dec.getError_code(), dec.getError_msg(), null);
                    if (this.lqg != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.lqg).optJSONObject("info");
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
                } else if (dec != null && dec.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dec.getError_code(), dec.getError_msg(), null);
                    if (this.lqg != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.lqg).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                be beVar = new be();
                                beVar.title = optJSONObject2.optString("block_content");
                                beVar.dEa = optJSONObject2.optString("block_cancel");
                                beVar.dEb = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(beVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (dec != null && dec.error_code != 0) {
                    String error_msg2 = dec.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (dec.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(dec.getError_code(), error_msg2, this.lqf.deb());
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
                        if (this.lqg == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.lqg);
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
                                                    CustomDialogData dv = com.baidu.tieba.pb.b.dv(jSONObject);
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
                                                                customDialogData = dv;
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
                                                                bVar.MU(str);
                                                                bVar.MV(str3);
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
                                                                customDialogData = dv;
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
                                                                    customDialogData = dv;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = dv;
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
                                                                    bVar.MU(str);
                                                                    bVar.MV(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = dv;
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
                                                        customDialogData = dv;
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
                    bVar.MU(str);
                    bVar.MV(str3);
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
            String dfl;
            String str = null;
            super.onPostExecute(bVar);
            NewWriteModel.this.lpU = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), "pid", bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.lqb == null) {
                        if (NewWriteModel.this.lqa != null) {
                            NewWriteModel.this.lqa.a(true, bVar.getErrorString(), null, null, bVar.bUc());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            dfl = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.dfl()) && StringUtils.isNull(bVar.dfk())) {
                            dfl = null;
                        } else {
                            str = bVar.dfk();
                            dfl = bVar.dfl();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, dfl);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.lbl != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.lbl.getProZone());
                            postWriteCallBackData.setGeneralTabId(NewWriteModel.this.lbl.getTabId());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        ab abVar = new ab();
                        abVar.parserJson(this.lqg);
                        NewWriteModel.this.lqb.callback(true, postWriteCallBackData, abVar, NewWriteModel.this.lbl, bVar.bUc());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.lbl != null) {
                                switch (NewWriteModel.this.lbl.getType()) {
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
                            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.dJb, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    if (this.lnq != null) {
                        this.lnq.cyw();
                        return;
                    }
                    return;
                }
                d(bVar);
                if (this.lnq != null) {
                    this.lnq.bm(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.lqf != null) {
                this.lqf.cancel();
            }
            if (NewWriteModel.this.lqb != null) {
                NewWriteModel.this.lqb.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.lqa != null) {
                NewWriteModel.this.lqa.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.lpU = null;
        }

        private void d(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.lqg), NewWriteModel.this.gNX)) {
                if (bVar.dfh()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dfi()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.dfg()) {
                    ab abVar = new ab();
                    abVar.parserJson(this.lqg);
                    if (abVar.getVcode_pic_url() != null && NewWriteModel.this.lbl != null) {
                        NewWriteModel.this.lbl.setVcodeMD5(abVar.getVcode_md5());
                        NewWriteModel.this.lbl.setVcodeUrl(abVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, abVar, NewWriteModel.this.lbl);
                    }
                } else if (bVar.dfj()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.lqg);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.lbl);
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
        if (bVar != null && bVar.bUc() != null && bVar.bUc().mFrsForbidenDialogInfo != null) {
            AntiHelper.aY(this.dJb.getPageActivity(), bVar.bUc().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, ab abVar, WriteData writeData) {
        if (bVar != null) {
            if (this.lqb != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.lqb.callback(false, postWriteCallBackData, abVar, writeData, bVar.bUc());
            } else if (this.lqa != null) {
                this.lqa.a(false, bVar.getErrorString(), abVar, writeData, bVar.bUc());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a lqf = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bm = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean isLocalImagePath = m.isLocalImagePath(NewWriteModel.this.lpX);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.lpY == null || NewWriteModel.this.lpY.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.lpX) || !isLocalImagePath) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.lpX);
                NewWriteModel.this.lpW = m.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.lpW)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.lpW, this.lqf);
            }
            this.bm = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.lpY);
            if (this.bm != null) {
                NewWriteModel.this.lpW = m.saveFileToSDOrMemory(TbConfig.IMAGE_RESIZED_FILE, this.bm, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.lpW)) {
                    return NewWriteModel.this.a(NewWriteModel.this.lpW, this.lqf);
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
            if (this.lqf != null) {
                this.lqf.cancel();
            }
            if (NewWriteModel.this.lpZ != null) {
                NewWriteModel.this.lpZ.a(null, true);
            }
            if (this.bm != null && !this.bm.isRecycled()) {
                this.bm.recycle();
            }
            super.cancel();
            NewWriteModel.this.lpV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.lpZ != null) {
                    NewWriteModel.this.lpZ.a(imageUploadResult, false);
                }
                if (this.bm != null && !this.bm.isRecycled()) {
                    this.bm.recycle();
                }
            }
        }
    }

    public void bRI() {
        if (this.lpV == null) {
            this.lpV = new a();
            this.lpV.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.lpY = bArr;
        this.lpX = str;
    }

    public void a(b bVar) {
        this.lpZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.aS(ar.aUX().getPostImageSize(), ar.aUX().getPostImageHeightLimit()));
        return aVar.e(imageFileInfo, true);
    }
}
