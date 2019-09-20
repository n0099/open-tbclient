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
    private f.a eXi;
    private String eud;
    private e jmk;
    private a jml;
    private String jmm;
    private byte[] jmn;
    private b jmo;
    private c jmq;
    private d jmr;
    private boolean jms;
    private a.InterfaceC0424a jmt;
    private WriteData mData;
    private final com.baidu.adp.base.e<?> mPageContext;

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
        this.jmk = null;
        this.jml = null;
        this.mData = null;
        this.jmm = null;
        this.eud = null;
        this.jmn = null;
        this.jmq = null;
        this.jmr = null;
        this.jms = false;
        this.eXi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ww(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmr != null) {
                        NewWriteModel.this.jmr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmk = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bfK() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.jmk = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.jmr != null) {
                    NewWriteModel.this.jmr.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void wx(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmr != null) {
                        NewWriteModel.this.jmr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmk = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.jmr != null) {
                    NewWriteModel.this.jmr.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jmk = null;
        this.jml = null;
        this.mData = null;
        this.jmm = null;
        this.eud = null;
        this.jmn = null;
        this.jmq = null;
        this.jmr = null;
        this.jms = false;
        this.eXi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ww(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmr != null) {
                        NewWriteModel.this.jmr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmk = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bfK() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.jmk = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.jmr != null) {
                    NewWriteModel.this.jmr.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void wx(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmr != null) {
                        NewWriteModel.this.jmr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmk = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.jmr != null) {
                    NewWriteModel.this.jmr.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.jmk = null;
        this.jml = null;
        this.mData = null;
        this.jmm = null;
        this.eud = null;
        this.jmn = null;
        this.jmq = null;
        this.jmr = null;
        this.jms = false;
        this.eXi = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void ww(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmr != null) {
                        NewWriteModel.this.jmr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmk = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bfK() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.jmk = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.jmr != null) {
                    NewWriteModel.this.jmr.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void wx(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.jmr != null) {
                        NewWriteModel.this.jmr.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.jmk = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.jmr != null) {
                    NewWriteModel.this.jmr.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = null;
    }

    public void rm(boolean z) {
        this.jms = z;
    }

    public void b(d dVar) {
        this.jmr = dVar;
    }

    public void a(c cVar) {
        this.jmq = cVar;
    }

    public void a(a.InterfaceC0424a interfaceC0424a) {
        this.jmt = interfaceC0424a;
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
        if (!j.kc() || j.kd() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("original_img_up_tip", true);
            if (this.mPageContext == null) {
                dealPost();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.hv(R.string.original_img_up_no_wifi_tip);
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
            aVar.agO();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.jmk == null) {
            this.jmk = new e();
            this.jmk.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.jmk != null && !this.jmk.isCancelled()) {
            this.jmk.cancel();
        } else if (this.jmr != null) {
            this.jmr.callback(false, null, null, null, null);
        } else if (this.jmq != null) {
            this.jmq.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jmk != null && !this.jmk.isCancelled()) {
            this.jmk.cancel();
            return false;
        }
        return false;
    }

    public void aYF() {
        if (this.jml != null && !this.jml.isCancelled()) {
            this.jml.cancel();
        }
    }

    public boolean crL() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h jjR;
        private l jmv;
        private com.baidu.tieba.tbadkCore.c.a eue = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
            if (runTask != null) {
                this.jmv = (l) runTask.getData();
            }
            if (this.jmv != null) {
                this.jjR = this.jmv.bPY();
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
                com.baidu.tbadk.imageManager.d.qT(NewWriteModel.this.mData.getContent());
                this.eue = new com.baidu.tieba.tbadkCore.c.a();
                this.eue.a(this.jjR);
                this.eue.a(NewWriteModel.this.jmt);
                this.mRetData = this.eue.a(NewWriteModel.this.mData, NewWriteModel.this.jms);
                ErrorData errorData = this.eue.getErrorData();
                if (this.eue.isRequestSuccess() && this.mRetData != null) {
                    AntiData cqQ = this.eue.cqQ();
                    String error_msg = errorData.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, cqQ);
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
                                bbVar.bJk = optJSONObject2.optString("block_cancel");
                                bbVar.bJl = optJSONObject2.optString("block_confirm");
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
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, this.eue.cqQ());
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
                                                                bVar.FD(str);
                                                                bVar.FE(str3);
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
                                                                    bVar.FD(str);
                                                                    bVar.FE(str3);
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
                    bVar.FD(str);
                    bVar.FE(str3);
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
            String crR;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.jmk = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.e.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.jmr == null) {
                        if (NewWriteModel.this.jmq != null) {
                            NewWriteModel.this.jmq.a(true, bVar.getErrorString(), null, null, bVar.blT());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            crR = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.crR()) && StringUtils.isNull(bVar.crQ())) {
                            crR = null;
                        } else {
                            str = bVar.crQ();
                            crR = bVar.crR();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, crR);
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
                        y yVar = new y();
                        yVar.parserJson(this.mRetData);
                        NewWriteModel.this.jmr.callback(true, postWriteCallBackData, yVar, NewWriteModel.this.mData, bVar.blT());
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
                    if (this.jjR != null) {
                        this.jjR.bPD();
                        return;
                    }
                    return;
                }
                handleRequestFail(bVar);
                if (this.jjR != null) {
                    this.jjR.ay(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.eue != null) {
                this.eue.cancel();
            }
            if (NewWriteModel.this.jmr != null) {
                NewWriteModel.this.jmr.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.jmq != null) {
                NewWriteModel.this.jmq.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.jmk = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.mRetData), NewWriteModel.this.eXi)) {
                if (bVar.crN()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.crO()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.crM()) {
                    y yVar = new y();
                    yVar.parserJson(this.mRetData);
                    if (yVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                        NewWriteModel.this.mData.setVcodeMD5(yVar.getVcode_md5());
                        NewWriteModel.this.mData.setVcodeUrl(yVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, yVar, NewWriteModel.this.mData);
                    }
                } else if (bVar.crP()) {
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
        if (bVar != null && bVar.blT() != null && bVar.blT().mFrsForbidenDialogInfo != null) {
            AntiHelper.aR(this.mPageContext.getPageActivity(), bVar.blT().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, y yVar, WriteData writeData) {
        if (bVar != null) {
            if (this.jmr != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.jmr.callback(false, postWriteCallBackData, yVar, writeData, bVar.blT());
            } else if (this.jmq != null) {
                this.jmq.a(false, bVar.getErrorString(), yVar, writeData, bVar.blT());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a eue = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap cFw = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean nH = m.nH(NewWriteModel.this.eud);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.jmn == null || NewWriteModel.this.jmn.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.eud) || !nH) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.eud);
                NewWriteModel.this.jmm = m.d(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.jmm)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.jmm, this.eue);
            }
            this.cFw = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.jmn);
            if (this.cFw != null) {
                NewWriteModel.this.jmm = m.a(TbConfig.IMAGE_RESIZED_FILE, this.cFw, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.jmm)) {
                    return NewWriteModel.this.a(NewWriteModel.this.jmm, this.eue);
                }
                if (this.cFw == null || this.cFw.isRecycled()) {
                    return null;
                }
                this.cFw.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.eue != null) {
                this.eue.cancel();
            }
            if (NewWriteModel.this.jmo != null) {
                NewWriteModel.this.jmo.a(null, true);
            }
            if (this.cFw != null && !this.cFw.isRecycled()) {
                this.cFw.recycle();
            }
            super.cancel();
            NewWriteModel.this.jml = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.jmo != null) {
                    NewWriteModel.this.jmo.a(imageUploadResult, false);
                }
                if (this.cFw != null && !this.cFw.isRecycled()) {
                    this.cFw.recycle();
                }
            }
        }
    }

    public void biO() {
        if (this.jml == null) {
            this.jml = new a();
            this.jml.execute(new Void[0]);
        }
    }

    public void g(byte[] bArr, String str) {
        this.jmn = bArr;
        this.eud = str;
    }

    public void a(b bVar) {
        this.jmo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.al(ar.ajw().ajC(), ar.ajw().ajD()));
        return aVar.e(imageFileInfo, true);
    }
}
