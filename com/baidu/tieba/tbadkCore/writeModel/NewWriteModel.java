package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.imageManager.f;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewWriteModel extends BdBaseModel {
    public static int MAX_IMG_NUM = 10;
    public static final String THREAD_TYPE_LBS = "7";
    private String bva;
    private a.InterfaceC0084a fPA;
    private e fPs;
    private a fPt;
    private String fPu;
    private byte[] fPv;
    private b fPw;
    private c fPx;
    private d fPy;
    private boolean fPz;
    private WriteData mData;
    private final g<?> mPageContext;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, q qVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData);
    }

    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fPs = null;
        this.fPt = null;
        this.mData = null;
        this.fPu = null;
        this.bva = null;
        this.fPv = null;
        this.fPx = null;
        this.fPy = null;
        this.fPz = false;
        this.mPageContext = baseActivity.getPageContext();
    }

    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fPs = null;
        this.fPt = null;
        this.mData = null;
        this.fPu = null;
        this.bva = null;
        this.fPv = null;
        this.fPx = null;
        this.fPy = null;
        this.fPz = false;
        this.mPageContext = tbPageContext;
    }

    public void lW(boolean z) {
        this.fPz = z;
    }

    public void b(d dVar) {
        this.fPy = dVar;
    }

    public void a(c cVar) {
        this.fPx = cVar;
    }

    public void a(a.InterfaceC0084a interfaceC0084a) {
        this.fPA = interfaceC0084a;
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
        if (!i.hj() || i.hk() || this.mData.getWriteImagesInfo() == null || this.mData.getWriteImagesInfo().size() == 0 || !this.mData.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_up_tip", false)) {
            dealPost();
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.bY(w.l.original_img_up_no_wifi_tip);
            aVar.a(w.l.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(w.l.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.mPageContext);
            aVar.ta();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealPost() {
        if (this.fPs == null) {
            this.fPs = new e();
            this.fPs.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fPs != null && !this.fPs.isCancelled()) {
            this.fPs.cancel();
        } else if (this.fPy != null) {
            this.fPy.callback(false, null, null, null, null);
        } else if (this.fPx != null) {
            this.fPx.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.fPs != null && !this.fPs.isCancelled()) {
            this.fPs.cancel();
            return false;
        }
        return false;
    }

    public void TK() {
        if (this.fPt != null && !this.fPt.isCancelled()) {
            this.fPt.cancel();
        }
    }

    public boolean bnA() {
        if (this.mData == null) {
            return true;
        }
        return (this.mData.getWriteImagesInfo() != null ? this.mData.getWriteImagesInfo().size() + 0 : 0) <= MAX_IMG_NUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a bvb = null;
        private String mRetData = null;
        private boolean isCanceled = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00f8  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.d doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.d dVar;
            JSONException e;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            int i;
            String str7;
            String str8 = null;
            if (this.isCanceled) {
                return null;
            }
            f.gf(NewWriteModel.this.mData.getContent());
            this.bvb = new com.baidu.tieba.tbadkCore.c.a();
            this.bvb.a(NewWriteModel.this.fPA);
            this.mRetData = this.bvb.a(NewWriteModel.this.mData, NewWriteModel.this.fPz);
            ErrorData errorData = this.bvb.getErrorData();
            if (this.bvb.isRequestSuccess() && this.mRetData != null) {
                AntiData bmJ = this.bvb.bmJ();
                String error_msg = errorData.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, bmJ);
                if (NewWriteModel.this.mData == null || !NewWriteModel.this.mData.isHasImages() || dVar2.hasError()) {
                    dVar = dVar2;
                } else {
                    NewWriteModel.this.mData.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (errorData != null && errorData.error_code != 0) {
                String error_msg2 = errorData.getError_msg();
                if (StringUtils.isNull(error_msg2)) {
                    error_msg2 = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                }
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg2, null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m9getInst().getApp().getString(w.l.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.mRetData != null) {
                        JSONObject jSONObject = new JSONObject(this.mRetData);
                        str6 = jSONObject.optString(AddFriendActivityConfig.MSG);
                        try {
                            str5 = jSONObject.optString("pre_msg");
                            try {
                                str4 = jSONObject.optString("color_msg");
                                try {
                                    str3 = jSONObject.optString("tid");
                                    try {
                                        str2 = jSONObject.optString(Info.kBaiduPIDKey);
                                        try {
                                            String G = com.baidu.tieba.pb.d.G(jSONObject);
                                            try {
                                                JSONObject optJSONObject = jSONObject.optJSONObject("twzhibo_info");
                                                i = optJSONObject != null ? optJSONObject.optInt("is_copytwzhibo", 0) : 0;
                                                try {
                                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                                    if (optJSONObject2 != null) {
                                                        String optString = optJSONObject2.optString("pre_msg");
                                                        try {
                                                            str8 = optJSONObject2.optString("color_msg");
                                                            str = optString;
                                                            str7 = G;
                                                        } catch (JSONException e2) {
                                                            e = e2;
                                                            str = optString;
                                                            str7 = G;
                                                            e.printStackTrace();
                                                            if (StringUtils.isNull(str6)) {
                                                            }
                                                            dVar.setErrorString(str6);
                                                            dVar.setPreMsg(str5);
                                                            dVar.setColorMsg(str4);
                                                            dVar.setThreadId(str3);
                                                            dVar.setPostId(str2);
                                                            dVar.setIsCopyTWZhibo(i);
                                                            dVar.rz(str);
                                                            dVar.rA(str8);
                                                            dVar.setNickNameActivityMoney(str7);
                                                            return dVar;
                                                        }
                                                    } else {
                                                        str7 = G;
                                                        str = null;
                                                    }
                                                } catch (JSONException e3) {
                                                    e = e3;
                                                    str7 = G;
                                                    str = null;
                                                }
                                            } catch (JSONException e4) {
                                                e = e4;
                                                i = 0;
                                                str7 = G;
                                                str = null;
                                            }
                                        } catch (JSONException e5) {
                                            e = e5;
                                            str = null;
                                            i = 0;
                                            str7 = null;
                                        }
                                    } catch (JSONException e6) {
                                        e = e6;
                                        str = null;
                                        str2 = null;
                                        i = 0;
                                        str7 = null;
                                    }
                                } catch (JSONException e7) {
                                    e = e7;
                                    str = null;
                                    str2 = null;
                                    str3 = null;
                                    i = 0;
                                    str7 = null;
                                }
                            } catch (JSONException e8) {
                                e = e8;
                                str = null;
                                str2 = null;
                                str3 = null;
                                str4 = null;
                                i = 0;
                                str7 = null;
                            }
                        } catch (JSONException e9) {
                            e = e9;
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            i = 0;
                            str7 = null;
                        }
                    } else {
                        i = 0;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                    }
                } catch (JSONException e10) {
                    e = e10;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    i = 0;
                    str7 = null;
                }
                if (StringUtils.isNull(str6)) {
                    str6 = TbadkCoreApplication.m9getInst().getString(w.l.send_success);
                }
                dVar.setErrorString(str6);
                dVar.setPreMsg(str5);
                dVar.setColorMsg(str4);
                dVar.setThreadId(str3);
                dVar.setPostId(str2);
                dVar.setIsCopyTWZhibo(i);
                dVar.rz(str);
                dVar.rA(str8);
                dVar.setNickNameActivityMoney(str7);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            String bnF;
            String str = null;
            super.onPostExecute((e) dVar);
            NewWriteModel.this.fPs = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.d.a.a(AlbumActivityConfig.FROM_WRITE, 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.isCanceled && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.c.b(NewWriteModel.this.mData);
                    if (NewWriteModel.this.fPy == null) {
                        if (NewWriteModel.this.fPx != null) {
                            NewWriteModel.this.fPx.a(true, dVar.getErrorString(), null, null, dVar.azh());
                        }
                    } else {
                        if (!StringUtils.isNull(dVar.getPreMsg()) && !StringUtils.isNull(dVar.getColorMsg())) {
                            str = dVar.getPreMsg();
                            bnF = dVar.getColorMsg();
                        } else if (StringUtils.isNull(dVar.bnF()) && StringUtils.isNull(dVar.bnE())) {
                            bnF = null;
                        } else {
                            str = dVar.bnE();
                            bnF = dVar.bnF();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), str, bnF);
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        postWriteCallBackData.setErrorString(dVar.getErrorString());
                        postWriteCallBackData.setNickNameActivityMoney(dVar.getNickNameActivityMoney());
                        q qVar = new q();
                        qVar.parserJson(this.mRetData);
                        NewWriteModel.this.fPy.callback(true, postWriteCallBackData, qVar, NewWriteModel.this.mData, dVar.azh());
                        if (!TextUtils.isEmpty(postWriteCallBackData.getNickNameActivityMoney())) {
                            com.baidu.tieba.pb.d.O(2000, postWriteCallBackData.getNickNameActivityMoney());
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                handleRequestFail(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bvb != null) {
                this.bvb.cancel();
            }
            if (NewWriteModel.this.fPy == null) {
                if (NewWriteModel.this.fPx != null) {
                    NewWriteModel.this.fPx.a(false, null, null, null, null);
                }
            } else {
                NewWriteModel.this.fPy.callback(false, null, null, null, null);
            }
            super.cancel(true);
            NewWriteModel.this.fPs = null;
        }

        private void handleRequestFail(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            if (!dVar.bnC()) {
                if (dVar.bnB()) {
                    q qVar = new q();
                    qVar.parserJson(this.mRetData);
                    if (qVar.getVcode_pic_url() != null && NewWriteModel.this.mData != null) {
                        NewWriteModel.this.mData.setVcodeMD5(qVar.getVcode_md5());
                        NewWriteModel.this.mData.setVcodeUrl(qVar.getVcode_pic_url());
                        NewWriteModel.this.a(dVar, null, qVar, NewWriteModel.this.mData);
                        return;
                    }
                    return;
                } else if (dVar.bnD()) {
                    AccessState accessState = new AccessState();
                    accessState.parserJson(this.mRetData);
                    NewWriteModel.this.a(dVar, accessState, null, NewWriteModel.this.mData);
                    return;
                } else {
                    NewWriteModel.this.a(dVar);
                    return;
                }
            }
            NewWriteModel.this.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
        a(dVar, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.writeModel.d dVar, AccessState accessState, q qVar, WriteData writeData) {
        if (dVar != null) {
            if (this.fPy != null) {
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                this.fPy.callback(false, postWriteCallBackData, qVar, writeData, dVar.azh());
            } else if (this.fPx != null) {
                this.fPx.a(false, dVar.getErrorString(), qVar, writeData, dVar.azh());
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean isCanceled = false;
        com.baidu.tieba.tbadkCore.c.a bvb = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aLw = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dx = n.dx(NewWriteModel.this.bva);
            if (this.isCanceled) {
                return null;
            }
            if (NewWriteModel.this.fPv == null || NewWriteModel.this.fPv.length <= 0) {
                if (TextUtils.isEmpty(NewWriteModel.this.bva) || !dx) {
                    return null;
                }
                Uri parse = Uri.parse(NewWriteModel.this.bva);
                NewWriteModel.this.fPu = n.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(NewWriteModel.this.fPu)) {
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fPu, this.bvb);
            }
            this.aLw = BitmapHelper.Bytes2Bitmap(NewWriteModel.this.fPv);
            if (this.aLw != null) {
                NewWriteModel.this.fPu = n.a(TbConfig.IMAGE_RESIZED_FILE, this.aLw, 80);
                if (TextUtils.isEmpty(NewWriteModel.this.fPu)) {
                    if (this.aLw == null || this.aLw.isRecycled()) {
                        return null;
                    }
                    this.aLw.recycle();
                    return null;
                }
                return NewWriteModel.this.a(NewWriteModel.this.fPu, this.bvb);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.isCanceled = true;
            if (this.bvb != null) {
                this.bvb.cancel();
            }
            if (NewWriteModel.this.fPw != null) {
                NewWriteModel.this.fPw.a(null, true);
            }
            if (this.aLw != null && !this.aLw.isRecycled()) {
                this.aLw.recycle();
            }
            super.cancel();
            NewWriteModel.this.fPt = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.isCanceled) {
                if (NewWriteModel.this.fPw != null) {
                    NewWriteModel.this.fPw.a(imageUploadResult, false);
                }
                if (this.aLw != null && !this.aLw.isRecycled()) {
                    this.aLw.recycle();
                }
            }
        }
    }

    public void ace() {
        if (this.fPt == null) {
            this.fPt = new a();
            this.fPt.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.fPv = bArr;
        this.bva = str;
    }

    public void a(b bVar) {
        this.fPw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.L(ax.vA().vG(), ax.vA().vG()));
        return aVar.d(imageFileInfo, true);
    }
}
