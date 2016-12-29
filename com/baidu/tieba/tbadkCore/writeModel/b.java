package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.h;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    public static int fjD = 10;
    private final h<?> aTE;
    private WriteData eWm;
    private e fjE;
    private a fjF;
    private String fjG;
    private String fjH;
    private byte[] fjI;
    private InterfaceC0077b fjJ;
    private c fjK;
    private d fjL;
    private boolean fjM;
    private a.InterfaceC0073a fjN;

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0077b {
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

    public b(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fjE = null;
        this.fjF = null;
        this.eWm = null;
        this.fjG = null;
        this.fjH = null;
        this.fjI = null;
        this.fjK = null;
        this.fjL = null;
        this.fjM = false;
        this.aTE = baseActivity.getPageContext();
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fjE = null;
        this.fjF = null;
        this.eWm = null;
        this.fjG = null;
        this.fjH = null;
        this.fjI = null;
        this.fjK = null;
        this.fjL = null;
        this.fjM = false;
        this.aTE = tbPageContext;
    }

    public void la(boolean z) {
        this.fjM = z;
    }

    public void b(d dVar) {
        this.fjL = dVar;
    }

    public void a(c cVar) {
        this.fjK = cVar;
    }

    public void a(a.InterfaceC0073a interfaceC0073a) {
        this.fjN = interfaceC0073a;
    }

    public void d(WriteData writeData) {
        this.eWm = writeData;
    }

    public WriteData bbN() {
        return this.eWm;
    }

    public boolean bhi() {
        if (this.eWm == null) {
            return false;
        }
        if (!i.gm() || i.gn() || this.eWm.getWriteImagesInfo() == null || this.eWm.getWriteImagesInfo().size() == 0 || !this.eWm.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("original_img_up_tip", false)) {
            bhj();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTE.getPageActivity());
            aVar.cb(r.j.original_img_up_no_wifi_tip);
            aVar.a(r.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(r.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.d(this, aVar));
            aVar.b(this.aTE);
            aVar.tb();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhj() {
        if (this.fjE == null) {
            this.fjE = new e();
            this.fjE.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fjE != null && !this.fjE.isCancelled()) {
            this.fjE.cancel();
        } else if (this.fjL != null) {
            this.fjL.callback(false, null, null, null, null);
        } else if (this.fjK != null) {
            this.fjK.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.fjE != null && !this.fjE.isCancelled()) {
            this.fjE.cancel();
            return false;
        }
        return false;
    }

    public void bhk() {
        if (this.fjF != null && !this.fjF.isCancelled()) {
            this.fjF.cancel();
        }
    }

    public boolean bhl() {
        if (this.eWm == null) {
            return true;
        }
        return (this.eWm.getWriteImagesInfo() != null ? this.eWm.getWriteImagesInfo().size() + 0 : 0) <= fjD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.e> {
        private com.baidu.tieba.tbadkCore.c.a fjP = null;
        private String fjQ = null;
        private boolean cjz = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.e doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.e eVar;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int i;
            String str6;
            String str7;
            String str8 = null;
            if (this.cjz) {
                return null;
            }
            this.fjP = new com.baidu.tieba.tbadkCore.c.a();
            this.fjP.a(b.this.fjN);
            this.fjQ = this.fjP.a(b.this.eWm, b.this.fjM);
            ErrorData bgn = this.fjP.bgn();
            if (this.fjP.oH() && this.fjQ != null) {
                AntiData bgm = this.fjP.bgm();
                String error_msg = bgn.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(r.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.e eVar2 = new com.baidu.tieba.tbadkCore.writeModel.e(bgn.getError_code(), error_msg, bgm);
                if (b.this.eWm == null || !b.this.eWm.isHasImages() || eVar2.hasError()) {
                    eVar = eVar2;
                } else {
                    b.this.eWm.deleteUploadedTempImages();
                    eVar = eVar2;
                }
            } else if (bgn != null && !StringUtils.isNull(bgn.getError_msg())) {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(bgn.getError_code(), bgn.getError_msg(), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(-17, TbadkCoreApplication.m9getInst().getApp().getString(r.j.neterror), null);
            }
            if (!eVar.hasError()) {
                try {
                    if (this.fjQ != null) {
                        JSONObject jSONObject = new JSONObject(this.fjQ);
                        String optString = jSONObject.optString(AddFriendActivityConfig.MSG);
                        try {
                            String optString2 = jSONObject.optString("pre_msg");
                            try {
                                String optString3 = jSONObject.optString("color_msg");
                                try {
                                    String optString4 = jSONObject.optString("tid");
                                    try {
                                        String optString5 = jSONObject.optString(Info.kBaiduPIDKey);
                                        try {
                                            JSONObject optJSONObject = new JSONObject(this.fjQ).optJSONObject("twzhibo_info");
                                            i = optJSONObject != null ? optJSONObject.optInt("is_copytwzhibo", 0) : 0;
                                            try {
                                                JSONObject optJSONObject2 = jSONObject.optJSONObject("exp");
                                                if (optJSONObject2 != null) {
                                                    String optString6 = optJSONObject2.optString("pre_msg");
                                                    try {
                                                        str7 = optJSONObject2.optString("color_msg");
                                                        str8 = optString6;
                                                        str = optString5;
                                                        str2 = optString4;
                                                        str3 = optString3;
                                                        str4 = optString2;
                                                        str5 = optString;
                                                    } catch (JSONException e) {
                                                        str6 = optString6;
                                                        str = optString5;
                                                        str2 = optString4;
                                                        str3 = optString3;
                                                        str4 = optString2;
                                                        str5 = optString;
                                                        jSONException = e;
                                                        jSONException.printStackTrace();
                                                        str8 = str6;
                                                        str7 = null;
                                                        if (StringUtils.isNull(str5)) {
                                                        }
                                                        eVar.setErrorString(str5);
                                                        eVar.setPreMsg(str4);
                                                        eVar.setColorMsg(str3);
                                                        eVar.setThreadId(str2);
                                                        eVar.setPostId(str);
                                                        eVar.setIsCopyTWZhibo(i);
                                                        eVar.qA(str8);
                                                        eVar.qB(str7);
                                                        return eVar;
                                                    }
                                                } else {
                                                    str7 = null;
                                                    str = optString5;
                                                    str2 = optString4;
                                                    str3 = optString3;
                                                    str4 = optString2;
                                                    str5 = optString;
                                                }
                                            } catch (JSONException e2) {
                                                str = optString5;
                                                str2 = optString4;
                                                str3 = optString3;
                                                str4 = optString2;
                                                str5 = optString;
                                                jSONException = e2;
                                                str6 = null;
                                            }
                                        } catch (JSONException e3) {
                                            str = optString5;
                                            str2 = optString4;
                                            str3 = optString3;
                                            str4 = optString2;
                                            str5 = optString;
                                            jSONException = e3;
                                            i = 0;
                                            str6 = null;
                                        }
                                    } catch (JSONException e4) {
                                        str = null;
                                        str2 = optString4;
                                        str3 = optString3;
                                        str4 = optString2;
                                        str5 = optString;
                                        jSONException = e4;
                                        i = 0;
                                        str6 = null;
                                    }
                                } catch (JSONException e5) {
                                    str = null;
                                    str2 = null;
                                    str3 = optString3;
                                    str4 = optString2;
                                    str5 = optString;
                                    jSONException = e5;
                                    i = 0;
                                    str6 = null;
                                }
                            } catch (JSONException e6) {
                                str = null;
                                str2 = null;
                                str3 = null;
                                str4 = optString2;
                                str5 = optString;
                                jSONException = e6;
                                i = 0;
                                str6 = null;
                            }
                        } catch (JSONException e7) {
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = optString;
                            jSONException = e7;
                            i = 0;
                            str6 = null;
                        }
                    } else {
                        i = 0;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str7 = null;
                    }
                } catch (JSONException e8) {
                    jSONException = e8;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    i = 0;
                    str6 = null;
                }
                if (StringUtils.isNull(str5)) {
                    str5 = TbadkCoreApplication.m9getInst().getString(r.j.send_success);
                }
                eVar.setErrorString(str5);
                eVar.setPreMsg(str4);
                eVar.setColorMsg(str3);
                eVar.setThreadId(str2);
                eVar.setPostId(str);
                eVar.setIsCopyTWZhibo(i);
                eVar.qA(str8);
                eVar.qB(str7);
            }
            return eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.e eVar) {
            String bhp;
            String str = null;
            super.onPostExecute(eVar);
            b.this.fjE = null;
            if (eVar != null && eVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", eVar.getErrorCode(), eVar.getErrorString(), "tid", eVar.getThreadId(), Info.kBaiduPIDKey, eVar.getPostId());
            }
            if (!this.cjz && eVar != null) {
                if (!eVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(b.this.eWm);
                    if (b.this.fjL == null) {
                        if (b.this.fjK != null) {
                            b.this.fjK.a(true, eVar.getErrorString(), null, null, eVar.avW());
                        }
                    } else {
                        if (!StringUtils.isNull(eVar.getPreMsg()) && !StringUtils.isNull(eVar.getColorMsg())) {
                            str = eVar.getPreMsg();
                            bhp = eVar.getColorMsg();
                        } else if (StringUtils.isNull(eVar.bhp()) && StringUtils.isNull(eVar.bho())) {
                            bhp = null;
                        } else {
                            str = eVar.bho();
                            bhp = eVar.bhp();
                        }
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), str, bhp);
                        postWriteCallBackData.setThreadId(eVar.getThreadId());
                        postWriteCallBackData.setPostId(eVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(eVar.getIsCopyTWZhibo());
                        q qVar = new q();
                        qVar.parserJson(this.fjQ);
                        b.this.fjL.callback(true, postWriteCallBackData, qVar, b.this.eWm, eVar.avW());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(eVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cjz = true;
            if (this.fjP != null) {
                this.fjP.cancel();
            }
            if (b.this.fjL == null) {
                if (b.this.fjK != null) {
                    b.this.fjK.a(false, null, null, null, null);
                }
            } else {
                b.this.fjL.callback(false, null, null, null, null);
            }
            super.cancel(true);
            b.this.fjE = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.e eVar) {
            AntiData avW = eVar.avW();
            if (eVar.bhm()) {
                q qVar = new q();
                qVar.parserJson(this.fjQ);
                if (qVar.getVcode_pic_url() != null && b.this.eWm != null) {
                    b.this.eWm.setVcodeMD5(qVar.getVcode_md5());
                    b.this.eWm.setVcodeUrl(qVar.getVcode_pic_url());
                    if (b.this.fjL == null) {
                        if (b.this.fjK != null) {
                            b.this.fjK.a(false, eVar.getErrorString(), qVar, b.this.eWm, avW);
                            return;
                        }
                        return;
                    }
                    b.this.fjL.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), qVar, b.this.eWm, avW);
                }
            } else if (!eVar.bhn()) {
                if (b.this.fjL == null) {
                    if (b.this.fjK != null) {
                        b.this.fjK.a(false, eVar.getErrorString(), null, null, eVar.avW());
                        return;
                    }
                    return;
                }
                b.this.fjL.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), null, null, eVar.avW());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.fjQ);
                if (b.this.fjL == null) {
                    if (b.this.fjK != null) {
                        b.this.fjK.a(false, eVar.getErrorString(), null, b.this.eWm, avW);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                b.this.fjL.callback(false, postWriteCallBackData, null, b.this.eWm, avW);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cjz = false;
        com.baidu.tieba.tbadkCore.c.a fjP = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aFH = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dk = m.dk(b.this.fjH);
            if (this.cjz) {
                return null;
            }
            if (b.this.fjI == null || b.this.fjI.length <= 0) {
                if (TextUtils.isEmpty(b.this.fjH) || !dk) {
                    return null;
                }
                Uri parse = Uri.parse(b.this.fjH);
                b.this.fjG = m.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(b.this.fjG)) {
                    return null;
                }
                return b.this.a(b.this.fjG, this.fjP);
            }
            this.aFH = BitmapHelper.Bytes2Bitmap(b.this.fjI);
            if (this.aFH != null) {
                b.this.fjG = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aFH, 80);
                if (TextUtils.isEmpty(b.this.fjG)) {
                    if (this.aFH == null || this.aFH.isRecycled()) {
                        return null;
                    }
                    this.aFH.recycle();
                    return null;
                }
                return b.this.a(b.this.fjG, this.fjP);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cjz = true;
            if (this.fjP != null) {
                this.fjP.cancel();
            }
            if (b.this.fjJ != null) {
                b.this.fjJ.a(null, true);
            }
            if (this.aFH != null && !this.aFH.isRecycled()) {
                this.aFH.recycle();
            }
            super.cancel();
            b.this.fjF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cjz) {
                if (b.this.fjJ != null) {
                    b.this.fjJ.a(imageUploadResult, false);
                }
                if (this.aFH != null && !this.aFH.isRecycled()) {
                    this.aFH.recycle();
                }
            }
        }
    }

    public void UT() {
        if (this.fjF == null) {
            this.fjF = new a();
            this.fjF.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fjI = bArr;
        this.fjH = str;
    }

    public void a(InterfaceC0077b interfaceC0077b) {
        this.fjJ = interfaceC0077b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.F(aw.vm().vs(), aw.vm().vs()));
        return aVar.d(imageFileInfo, true);
    }
}
