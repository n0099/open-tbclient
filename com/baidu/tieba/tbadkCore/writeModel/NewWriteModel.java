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
import com.baidu.appsearchlib.Info;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
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
    private f.a eVC;
    private String ess;
    private e jjP;
    private a jjQ;
    private String jjR;
    private byte[] jjS;
    private b jjT;
    private c jjU;
    private d jjV;
    private boolean jjW;
    private a.InterfaceC0413a jjX;
    private WriteData mData;
    private final com.baidu.adp.base.e<?> mPageContext;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, x xVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jjP = null;
        this.jjQ = null;
        this.mData = null;
        this.jjR = null;
        this.ess = null;
        this.jjS = null;
        this.jjU = null;
        this.jjV = null;
        this.jjW = false;
        this.eVC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vX(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jjV != null) {
                        NewWriteModel.this.jjV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jjP = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bfg() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.jjP = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.jjV != null) {
                    NewWriteModel.this.jjV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vY(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jjV != null) {
                        NewWriteModel.this.jjV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jjP = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.jjV != null) {
                    NewWriteModel.this.jjV.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jjP = null;
        this.jjQ = null;
        this.mData = null;
        this.jjR = null;
        this.ess = null;
        this.jjS = null;
        this.jjU = null;
        this.jjV = null;
        this.jjW = false;
        this.eVC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vX(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jjV != null) {
                        NewWriteModel.this.jjV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jjP = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bfg() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.jjP = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.jjV != null) {
                    NewWriteModel.this.jjV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vY(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jjV != null) {
                        NewWriteModel.this.jjV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jjP = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.jjV != null) {
                    NewWriteModel.this.jjV.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.jjP = null;
        this.jjQ = null;
        this.mData = null;
        this.jjR = null;
        this.ess = null;
        this.jjS = null;
        this.jjU = null;
        this.jjV = null;
        this.jjW = false;
        this.eVC = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vX(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jjV != null) {
                        NewWriteModel.this.jjV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jjP = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bfg() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.jjP = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.jjV != null) {
                    NewWriteModel.this.jjV.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vY(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jjV != null) {
                        NewWriteModel.this.jjV.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jjP = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.jjV != null) {
                    NewWriteModel.this.jjV.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = null;
    }

    public void rj(boolean z) {
        this.jjW = z;
    }

    public void b(d dVar) {
        this.jjV = dVar;
    }

    public void a(c cVar) {
        this.jjU = cVar;
    }

    public void a(a.InterfaceC0413a interfaceC0413a) {
        this.jjX = interfaceC0413a;
    }

    public void setWriteData(WriteData writeData) {
        this.mData = writeData;
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    public boolean startPostWrite() {
        if (this.mData == null) {
            return false;
        }
        if (!j.kc() || j.kd() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("original_img_up_tip", true);
            if (this.mPageContext == null) {
                dealPost();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.hu(R.string.original_img_up_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dealPost();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.mPageContext);
            aVar.agK();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.jjP == null) {
            this.jjP = new e();
            this.jjP.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.jjP != null && !this.jjP.isCancelled()) {
            this.jjP.cancel();
        } else if (this.jjV != null) {
            this.jjV.callback(false, null, null, null, null);
        } else if (this.jjU != null) {
            this.jjU.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jjP != null && !this.jjP.isCancelled()) {
            this.jjP.cancel();
            return false;
        }
        return false;
    }

    public void aYb() {
        if (this.jjQ != null && !this.jjQ.isCancelled()) {
            this.jjQ.cancel();
        }
    }

    public boolean cqX() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h jhv;
        private l jjZ;
        private com.baidu.tieba.tbadkCore.c.a est = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
            if (runTask != null) {
                this.jjZ = (l) runTask.getData();
            }
            if (this.jjZ != null) {
                this.jhv = this.jjZ.bPk();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0189  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
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
                com.baidu.tbadk.imageManager.d.qI(NewWriteModel.this.mData.getContent());
                this.est = new com.baidu.tieba.tbadkCore.c.a();
                this.est.a(this.jhv);
                this.est.a(NewWriteModel.this.jjX);
                this.mRetData = this.est.a(NewWriteModel.this.mData, NewWriteModel.this.jjW);
                ErrorData errorData = this.est.getErrorData();
                if (this.est.isRequestSuccess() && this.mRetData != null) {
                    AntiData cqc = this.est.cqc();
                    String error_msg = errorData.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, cqc);
                    if (NewWriteModel.this.mData != null && NewWriteModel.this.mData.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.mData.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (errorData != null && errorData.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), errorData.getError_msg(), null);
                    if (this.mRetData != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.mRetData).optJSONObject(Config.LAUNCH_INFO);
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
                } else if (errorData != null && errorData.error_code == 238010) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), errorData.getError_msg(), null);
                    if (this.mRetData != null) {
                        try {
                            JSONObject optJSONObject2 = new JSONObject(this.mRetData).optJSONObject(Config.LAUNCH_INFO);
                            if (optJSONObject2 != null) {
                                bb bbVar = new bb();
                                bbVar.title = optJSONObject2.optString("block_content");
                                bbVar.bIM = optJSONObject2.optString("block_cancel");
                                bbVar.bIN = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(bbVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (errorData != null && errorData.error_code != 0) {
                    String error_msg2 = errorData.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (errorData.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, this.est.cqc());
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
                        if (this.mRetData == null) {
                            customDialogData = null;
                            videoEasterEggData = null;
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            String optString = jSONObject.optString("msg");
                            try {
                                String optString2 = jSONObject.optString("pre_msg");
                                try {
                                    String optString3 = jSONObject.optString("color_msg");
                                    try {
                                        String optString4 = jSONObject.optString("tid");
                                        try {
                                            String optString5 = jSONObject.optString(Info.kBaiduPIDKey);
                                            try {
                                                String optString6 = jSONObject.optString("video_id");
                                                try {
                                                    CustomDialogData bN = com.baidu.tieba.pb.b.bN(jSONObject);
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
                                                                customDialogData = bN;
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
                                                                bVar.Fd(str);
                                                                bVar.Fe(str3);
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
                                                                customDialogData = bN;
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
                                                                    customDialogData = bN;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = bN;
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
                                                                    bVar.Fd(str);
                                                                    bVar.Fe(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = bN;
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
                                                        customDialogData = bN;
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
                    bVar.Fd(str);
                    bVar.Fe(str3);
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
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            String crd;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.jjP = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.jjV == null) {
                        if (NewWriteModel.this.jjU != null) {
                            NewWriteModel.this.jjU.a(true, bVar.getErrorString(), null, null, bVar.bli());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            crd = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.crd()) && StringUtils.isNull(bVar.crc())) {
                            crd = null;
                        } else {
                            str = bVar.crc();
                            crd = bVar.crd();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, crd);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        if (NewWriteModel.this.mData != null) {
                            postWriteCallBackData.setProZone(NewWriteModel.this.mData.getProZone());
                        }
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        x xVar = new x();
                        xVar.parserJson(this.mRetData);
                        NewWriteModel.this.jjV.callback(true, postWriteCallBackData, xVar, NewWriteModel.this.mData, bVar.bli());
                        final CustomDialogData activityDialog = postWriteCallBackData.getActivityDialog();
                        if (activityDialog != null) {
                            if (NewWriteModel.this.mData != null) {
                                switch (NewWriteModel.this.mData.getType()) {
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
                            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.mPageContext, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, true));
                    if (this.jhv != null) {
                        this.jhv.bOQ();
                        return;
                    }
                    return;
                }
                handleRequestFail(bVar);
                if (this.jhv != null) {
                    this.jhv.ay(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.est != null) {
                this.est.cancel();
            }
            if (NewWriteModel.this.jjV != null) {
                NewWriteModel.this.jjV.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.jjU != null) {
                NewWriteModel.this.jjU.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.jjP = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.mRetData), NewWriteModel.this.eVC)) {
                if (bVar.cqZ()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cra()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.cqY()) {
                    x xVar = new x();
                    xVar.parserJson(this.mRetData);
                    if (xVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                        NewWriteModel.this.mData.setVcodeMD5(xVar.getVcode_md5());
                        NewWriteModel.this.mData.setVcodeUrl(xVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, xVar, NewWriteModel.this.mData);
                    }
                } else if (bVar.crb()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.mRetData);
                    NewWriteModel.this.a(bVar, accessState, null, NewWriteModel.this.mData);
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
        if (bVar != null && bVar.bli() != null && bVar.bli().mFrsForbidenDialogInfo != null) {
            AntiHelper.aK(this.mPageContext.getPageActivity(), bVar.bli().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, x xVar, WriteData writeData) {
        if (bVar != null) {
            if (this.jjV != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.jjV.callback(false, postWriteCallBackData, xVar, writeData, bVar.bli());
            } else if (this.jjU != null) {
                this.jjU.a(false, bVar.getErrorString(), xVar, writeData, bVar.bli());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a est = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap cEF = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean nF = m.nF(NewWriteModel.this.ess);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.jjS == null || NewWriteModel.this.jjS.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.ess) || !nF) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.ess);
                NewWriteModel.this.jjR = m.b(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.jjR)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.jjR, this.est);
            }
            this.cEF = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.jjS);
            if (this.cEF != null) {
                NewWriteModel.this.jjR = m.a(TbConfig.IMAGE_RESIZED_FILE, this.cEF, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.jjR)) {
                    return NewWriteModel.this.a(NewWriteModel.this.jjR, this.est);
                }
                if (this.cEF == null || this.cEF.isRecycled()) {
                    return null;
                }
                this.cEF.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.est != null) {
                this.est.cancel();
            }
            if (NewWriteModel.this.jjT != null) {
                NewWriteModel.this.jjT.a(null, true);
            }
            if (this.cEF != null && !this.cEF.isRecycled()) {
                this.cEF.recycle();
            }
            super.cancel();
            NewWriteModel.this.jjQ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.jjT != null) {
                    NewWriteModel.this.jjT.a(imageUploadResult, false);
                }
                if (this.cEF != null && !this.cEF.isRecycled()) {
                    this.cEF.recycle();
                }
            }
        }
    }

    public void bid() {
        if (this.jjQ == null) {
            this.jjQ = new a();
            this.jjQ.execute(new Void[0]);
        }
    }

    public void g(byte[] bArr, String str) {
        this.jjS = bArr;
        this.ess = str;
    }

    public void a(b bVar) {
        this.jjT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.al(as.ajq().ajw(), as.ajq().ajx()));
        return aVar.e(imageFileInfo, true);
    }
}
