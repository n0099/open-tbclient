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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.e;
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
    private String cFZ;
    private e hgp;
    private a hgq;
    private String hgr;
    private byte[] hgs;
    private b hgt;
    private c hgu;
    private d hgv;
    private boolean hgw;
    private a.InterfaceC0276a hgx;
    private f.a hgy;
    private WriteData mData;
    private final com.baidu.adp.base.e<?> mPageContext;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, v vVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hgp = null;
        this.hgq = null;
        this.mData = null;
        this.hgr = null;
        this.cFZ = null;
        this.hgs = null;
        this.hgu = null;
        this.hgv = null;
        this.hgw = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vn(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.hgv != null) {
                        NewWriteModel.this.hgv.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.hgp = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bDf() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.hgp = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.hgv != null) {
                    NewWriteModel.this.hgv.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vo(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.hgv != null) {
                        NewWriteModel.this.hgv.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.hgp = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.hgv != null) {
                    NewWriteModel.this.hgv.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hgp = null;
        this.hgq = null;
        this.mData = null;
        this.hgr = null;
        this.cFZ = null;
        this.hgs = null;
        this.hgu = null;
        this.hgv = null;
        this.hgw = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vn(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.hgv != null) {
                        NewWriteModel.this.hgv.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.hgp = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bDf() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.hgp = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.hgv != null) {
                    NewWriteModel.this.hgv.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vo(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.hgv != null) {
                        NewWriteModel.this.hgv.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.hgp = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.hgv != null) {
                    NewWriteModel.this.hgv.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public NewWriteModel() {
        this.hgp = null;
        this.hgq = null;
        this.mData = null;
        this.hgr = null;
        this.cFZ = null;
        this.hgs = null;
        this.hgu = null;
        this.hgv = null;
        this.hgw = false;
        this.hgy = new f.a() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.3
            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vn(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.hgv != null) {
                        NewWriteModel.this.hgv.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.hgp = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void bDf() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.hgp = null;
                    NewWriteModel.this.mData.setAuthSid(null);
                    NewWriteModel.this.startPostWrite();
                } else if (NewWriteModel.this.hgv != null) {
                    NewWriteModel.this.hgv.callback(false, null, null, null, null);
                }
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void vo(String str) {
                if (NewWriteModel.this.mData == null || TextUtils.isEmpty(str)) {
                    if (NewWriteModel.this.hgv != null) {
                        NewWriteModel.this.hgv.callback(false, null, null, null, null);
                        return;
                    }
                    return;
                }
                NewWriteModel.this.hgp = null;
                NewWriteModel.this.mData.setAuthSid(str);
                NewWriteModel.this.startPostWrite();
            }

            @Override // com.baidu.tieba.tbadkCore.util.f.a
            public void onFail() {
                if (NewWriteModel.this.mData != null) {
                    NewWriteModel.this.mData.setAuthSid(null);
                }
                if (NewWriteModel.this.hgv != null) {
                    NewWriteModel.this.hgv.callback(false, null, null, null, null);
                }
            }
        };
        this.mPageContext = null;
    }

    public void nm(boolean z) {
        this.hgw = z;
    }

    public void b(d dVar) {
        this.hgv = dVar;
    }

    public void a(c cVar) {
        this.hgu = cVar;
    }

    public void a(a.InterfaceC0276a interfaceC0276a) {
        this.hgx = interfaceC0276a;
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
        if (!j.kX() || j.kY() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_up_tip", true);
            if (this.mPageContext == null) {
                dealPost();
                return true;
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.cz(e.j.original_img_up_no_wifi_tip);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.dealPost();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    NewWriteModel.this.cancel();
                }
            });
            aVar.b(this.mPageContext);
            aVar.Au();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.hgp == null) {
            this.hgp = new e();
            this.hgp.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.hgp != null && !this.hgp.isCancelled()) {
            this.hgp.cancel();
        } else if (this.hgv != null) {
            this.hgv.callback(false, null, null, null, null);
        } else if (this.hgu != null) {
            this.hgu.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.hgp != null && !this.hgp.isCancelled()) {
            this.hgp.cancel();
            return false;
        }
        return false;
    }

    public void amX() {
        if (this.hgq != null && !this.hgq.isCancelled()) {
            this.hgq.cancel();
        }
    }

    public boolean bDo() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private h heb;
        private l hgA;
        private com.baidu.tieba.tbadkCore.c.a cGa = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
            if (runTask != null) {
                this.hgA = (l) runTask.getData();
            }
            if (this.hgA != null) {
                this.heb = this.hgA.bbw();
            }
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0188  */
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
                com.baidu.tbadk.imageManager.d.hP(NewWriteModel.this.mData.getContent());
                this.cGa = new com.baidu.tieba.tbadkCore.c.a();
                this.cGa.a(this.heb);
                this.cGa.a(NewWriteModel.this.hgx);
                this.mRetData = this.cGa.a(NewWriteModel.this.mData, NewWriteModel.this.hgw);
                ErrorData errorData = this.cGa.getErrorData();
                if (this.cGa.isRequestSuccess() && this.mRetData != null) {
                    AntiData bCr = this.cGa.bCr();
                    String error_msg = errorData.getError_msg();
                    if (k.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_success);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, bCr);
                    if (NewWriteModel.this.mData != null && NewWriteModel.this.mData.isHasImages() && !bVar2.hasError()) {
                        NewWriteModel.this.mData.deleteUploadedTempImages();
                    }
                    bVar = bVar2;
                } else if (errorData != null && errorData.error_code == 220015) {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), errorData.getError_msg(), null);
                    if (this.mRetData != null) {
                        try {
                            JSONObject optJSONObject = new JSONObject(this.mRetData).optJSONObject("info");
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
                            JSONObject optJSONObject2 = new JSONObject(this.mRetData).optJSONObject("info");
                            if (optJSONObject2 != null) {
                                aw awVar = new aw();
                                awVar.title = optJSONObject2.optString("block_content");
                                awVar.aoC = optJSONObject2.optString("block_cancel");
                                awVar.aoD = optJSONObject2.optString("block_confirm");
                                bVar.setReplyPrivacyTip(awVar);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (errorData != null && errorData.error_code != 0) {
                    String error_msg2 = errorData.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (errorData.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(e.j.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                        }
                    }
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg2, this.cGa.bCr());
                } else {
                    bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.getInst().getApp().getString(e.j.neterror), null);
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
                                                    CustomDialogData aq = com.baidu.tieba.pb.b.aq(jSONObject);
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
                                                                customDialogData = aq;
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
                                                                bVar.vs(str);
                                                                bVar.vt(str3);
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
                                                                customDialogData = aq;
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
                                                                    customDialogData = aq;
                                                                    str10 = optString6;
                                                                    str3 = str9;
                                                                    str = str8;
                                                                    str2 = optString5;
                                                                    str7 = optString4;
                                                                    str6 = optString3;
                                                                    str5 = optString2;
                                                                    str4 = optString;
                                                                } catch (JSONException e4) {
                                                                    customDialogData = aq;
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
                                                                    bVar.vs(str);
                                                                    bVar.vt(str3);
                                                                    bVar.setActivityDialog(customDialogData);
                                                                    bVar.setVideoId(str10);
                                                                    bVar.setContriInfo(contriInfo);
                                                                    bVar.setVideoEasterEggData(videoEasterEggData);
                                                                    return bVar;
                                                                }
                                                            }
                                                        } catch (JSONException e5) {
                                                            videoEasterEggData = null;
                                                            customDialogData = aq;
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
                                                        customDialogData = aq;
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
                        str4 = TbadkCoreApplication.getInst().getString(e.j.send_success);
                    }
                    bVar.setErrorString(str4);
                    bVar.setPreMsg(str5);
                    bVar.setColorMsg(str6);
                    bVar.setThreadId(str7);
                    bVar.setPostId(str2);
                    bVar.setIsCopyTWZhibo(i2);
                    bVar.vs(str);
                    bVar.vt(str3);
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
            String bDu;
            String str = null;
            super.onPostExecute((e) bVar);
            NewWriteModel.this.hgp = null;
            if (bVar != null && bVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a("write", 0L, 0, "write_result", bVar.getErrorCode(), bVar.getErrorString(), "tid", bVar.getThreadId(), Info.kBaiduPIDKey, bVar.getPostId());
            }
            if (!this.isCanceled && bVar != null) {
                if (!bVar.hasError()) {
                    if (NewWriteModel.this.hgv == null) {
                        if (NewWriteModel.this.hgu != null) {
                            NewWriteModel.this.hgu.a(true, bVar.getErrorString(), null, null, bVar.ayQ());
                        }
                    } else {
                        if (!StringUtils.isNull(bVar.getPreMsg()) && !StringUtils.isNull(bVar.getColorMsg())) {
                            str = bVar.getPreMsg();
                            bDu = bVar.getColorMsg();
                        } else if (StringUtils.isNull(bVar.bDu()) && StringUtils.isNull(bVar.bDt())) {
                            bDu = null;
                        } else {
                            str = bVar.bDt();
                            bDu = bVar.bDu();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), str, bDu);
                        postWriteCallBackData.setThreadId(bVar.getThreadId());
                        postWriteCallBackData.setPostId(bVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(bVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(bVar.getErrorString());
                        postWriteCallBackData.setActivityDialog(bVar.getActivityDialog());
                        postWriteCallBackData.setVideoid(bVar.getVideoId());
                        postWriteCallBackData.setContriInfo(bVar.getContriInfo());
                        postWriteCallBackData.setVideoEasterEggData(bVar.getVideoEasterEggData());
                        v vVar = new v();
                        vVar.parserJson(this.mRetData);
                        NewWriteModel.this.hgv.callback(true, postWriteCallBackData, vVar, NewWriteModel.this.mData, bVar.ayQ());
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
                            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a((TbPageContext) NewWriteModel.this.mPageContext, activityDialog).show();
                                }
                            }, 1000L);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001375, true));
                    if (this.heb != null) {
                        this.heb.bbe();
                        return;
                    }
                    return;
                }
                handleRequestFail(bVar);
                if (this.heb != null) {
                    this.heb.ae(bVar.errorCode, bVar.getErrorString());
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.cGa != null) {
                this.cGa.cancel();
            }
            if (NewWriteModel.this.hgv != null) {
                NewWriteModel.this.hgv.callback(false, null, null, null, null);
            } else if (NewWriteModel.this.hgu != null) {
                NewWriteModel.this.hgu.a(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.hgp = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            if (!f.a(bVar.getErrorCode(), AuthTokenData.parse(this.mRetData), NewWriteModel.this.hgy)) {
                if (bVar.bDq()) {
                    NewWriteModel.this.a(bVar);
                } else if (bVar.bDr()) {
                    NewWriteModel.this.b(bVar);
                    NewWriteModel.this.a(bVar);
                } else if (bVar.bDp()) {
                    v vVar = new v();
                    vVar.parserJson(this.mRetData);
                    if (vVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                        NewWriteModel.this.mData.setVcodeMD5(vVar.getVcode_md5());
                        NewWriteModel.this.mData.setVcodeUrl(vVar.getVcode_pic_url());
                        NewWriteModel.this.a(bVar, null, vVar, NewWriteModel.this.mData);
                    }
                } else if (bVar.bDs()) {
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
        if (bVar != null && bVar.ayQ() != null && bVar.ayQ().mFrsForbidenDialogInfo != null) {
            AntiHelper.aJ(this.mPageContext.getPageActivity(), bVar.ayQ().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.b bVar, AccessState accessState, v vVar, WriteData writeData) {
        if (bVar != null) {
            if (this.hgv != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                postWriteCallBackData.setSensitiveWords(bVar.getSensitiveWords());
                postWriteCallBackData.setReplyPrivacyTip(bVar.getReplyPrivacyTip());
                this.hgv.callback(false, postWriteCallBackData, vVar, writeData, bVar.ayQ());
            } else if (this.hgu != null) {
                this.hgu.a(false, bVar.getErrorString(), vVar, writeData, bVar.ayQ());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a cGa = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap bfJ = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean eX = com.baidu.tbadk.core.util.l.eX(NewWriteModel.this.cFZ);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.hgs == null || NewWriteModel.this.hgs.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.cFZ) || !eX) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.cFZ);
                NewWriteModel.this.hgr = com.baidu.tbadk.core.util.l.b(TbadkCoreApplication.getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.hgr)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.hgr, this.cGa);
            }
            this.bfJ = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.hgs);
            if (this.bfJ != null) {
                NewWriteModel.this.hgr = com.baidu.tbadk.core.util.l.a(TbConfig.IMAGE_RESIZED_FILE, this.bfJ, 85);
                if (!TextUtils.isEmpty(NewWriteModel.this.hgr)) {
                    return NewWriteModel.this.a(NewWriteModel.this.hgr, this.cGa);
                }
                if (this.bfJ == null || this.bfJ.isRecycled()) {
                    return null;
                }
                this.bfJ.recycle();
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.cGa != null) {
                this.cGa.cancel();
            }
            if (NewWriteModel.this.hgt != null) {
                NewWriteModel.this.hgt.a(null, true);
            }
            if (this.bfJ != null && !this.bfJ.isRecycled()) {
                this.bfJ.recycle();
            }
            super.cancel();
            NewWriteModel.this.hgq = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.hgt != null) {
                    NewWriteModel.this.hgt.a(imageUploadResult, false);
                }
                if (this.bfJ != null && !this.bfJ.isRecycled()) {
                    this.bfJ.recycle();
                }
            }
        }
    }

    public void avB() {
        if (this.hgq == null) {
            this.hgq = new a();
            this.hgq.execute(new Void[0]);
        }
    }

    public void f(byte[] bArr, String str) {
        this.hgs = bArr;
        this.cFZ = str;
    }

    public void a(b bVar) {
        this.hgt = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(aq.CG().CM(), aq.CG().CN()));
        return aVar.e(imageFileInfo, true);
    }
}
