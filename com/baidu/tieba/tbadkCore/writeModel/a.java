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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static int evB = 10;
    private final h<?> bLj;
    private e evC;
    private C0079a evD;
    private WriteData evE;
    private String evF;
    private String evG;
    private byte[] evH;
    private b evI;
    private c evJ;
    private d evK;
    private boolean evL;
    private a.InterfaceC0074a evM;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, o oVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o oVar, WriteData writeData, AntiData antiData);
    }

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.evC = null;
        this.evD = null;
        this.evE = null;
        this.evF = null;
        this.evG = null;
        this.evH = null;
        this.evJ = null;
        this.evK = null;
        this.evL = false;
        this.bLj = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.evC = null;
        this.evD = null;
        this.evE = null;
        this.evF = null;
        this.evG = null;
        this.evH = null;
        this.evJ = null;
        this.evK = null;
        this.evL = false;
        this.bLj = tbPageContext;
    }

    public void jC(boolean z) {
        this.evL = z;
    }

    public void b(d dVar) {
        this.evK = dVar;
    }

    public void a(c cVar) {
        this.evJ = cVar;
    }

    public void a(a.InterfaceC0074a interfaceC0074a) {
        this.evM = interfaceC0074a;
    }

    public void d(WriteData writeData) {
        this.evE = writeData;
    }

    public WriteData aVg() {
        return this.evE;
    }

    public boolean aVh() {
        if (this.evE == null) {
            return false;
        }
        if (!i.fq() || i.fr() || this.evE.getWriteImagesInfo() == null || this.evE.getWriteImagesInfo().size() == 0 || !this.evE.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("original_img_up_tip", false)) {
            aVi();
        } else {
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bLj.getPageActivity());
            aVar.bL(t.j.original_img_up_no_wifi_tip);
            aVar.a(t.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(t.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.bLj);
            aVar.rV();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVi() {
        if (this.evC == null) {
            this.evC = new e();
            this.evC.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.evC != null && !this.evC.isCancelled()) {
            this.evC.cancel();
        } else if (this.evK != null) {
            this.evK.callback(false, null, null, null, null);
        } else if (this.evJ != null) {
            this.evJ.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.evC != null && !this.evC.isCancelled()) {
            this.evC.cancel();
            return false;
        }
        return false;
    }

    public void aVj() {
        if (this.evD != null && !this.evD.isCancelled()) {
            this.evD.cancel();
        }
    }

    public boolean aVk() {
        if (this.evE == null) {
            return true;
        }
        int size = (!this.evE.getIsBaobao() || this.evE.getBaobaoImagesInfo() == null) ? 0 : this.evE.getBaobaoImagesInfo().size() + 0;
        if (this.evE.getWriteImagesInfo() != null) {
            size += this.evE.getWriteImagesInfo().size();
        }
        return size <= evB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a evO = null;
        private String evP = null;
        private boolean bMU = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.d doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.d dVar;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int i;
            String str6 = null;
            if (this.bMU) {
                return null;
            }
            this.evO = new com.baidu.tieba.tbadkCore.c.a();
            this.evO.a(a.this.evM);
            this.evP = this.evO.a(a.this.evE, a.this.evL);
            ErrorData aUs = this.evO.aUs();
            if (this.evO.nZ() && this.evP != null) {
                AntiData aUr = this.evO.aUr();
                String error_msg = aUs.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m11getInst().getApp().getString(t.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(aUs.getError_code(), error_msg, aUr);
                if (a.this.evE == null || (!(a.this.evE.isHasImages() || a.this.evE.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.evE.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (aUs != null && !StringUtils.isNull(aUs.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(aUs.getError_code(), aUs.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m11getInst().getApp().getString(t.j.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.evP != null) {
                        JSONObject jSONObject = new JSONObject(this.evP);
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
                                            JSONObject optJSONObject = new JSONObject(this.evP).optJSONObject("twzhibo_info");
                                            if (optJSONObject != null) {
                                                i = optJSONObject.optInt("is_copytwzhibo", 0);
                                                str5 = optString5;
                                                str6 = optString4;
                                                str = optString3;
                                                str2 = optString2;
                                                str3 = optString;
                                            } else {
                                                i = 0;
                                                str5 = optString5;
                                                str6 = optString4;
                                                str = optString3;
                                                str2 = optString2;
                                                str3 = optString;
                                            }
                                        } catch (JSONException e) {
                                            str4 = optString5;
                                            str6 = optString4;
                                            str = optString3;
                                            str2 = optString2;
                                            str3 = optString;
                                            jSONException = e;
                                            jSONException.printStackTrace();
                                            str5 = str4;
                                            i = 0;
                                            if (StringUtils.isNull(str3)) {
                                            }
                                            dVar.setErrorString(str3);
                                            dVar.setPreMsg(str2);
                                            dVar.setColorMsg(str);
                                            dVar.setThreadId(str6);
                                            dVar.setPostId(str5);
                                            dVar.setIsCopyTWZhibo(i);
                                            return dVar;
                                        }
                                    } catch (JSONException e2) {
                                        str4 = null;
                                        str6 = optString4;
                                        str = optString3;
                                        str2 = optString2;
                                        str3 = optString;
                                        jSONException = e2;
                                    }
                                } catch (JSONException e3) {
                                    str = optString3;
                                    str2 = optString2;
                                    str3 = optString;
                                    jSONException = e3;
                                    str4 = null;
                                }
                            } catch (JSONException e4) {
                                str = null;
                                str2 = optString2;
                                str3 = optString;
                                jSONException = e4;
                                str4 = null;
                            }
                        } catch (JSONException e5) {
                            str = null;
                            str2 = null;
                            str3 = optString;
                            jSONException = e5;
                            str4 = null;
                        }
                    } else {
                        i = 0;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str5 = null;
                    }
                } catch (JSONException e6) {
                    jSONException = e6;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (StringUtils.isNull(str3)) {
                    str3 = TbadkCoreApplication.m11getInst().getString(t.j.send_success);
                }
                dVar.setErrorString(str3);
                dVar.setPreMsg(str2);
                dVar.setColorMsg(str);
                dVar.setThreadId(str6);
                dVar.setPostId(str5);
                dVar.setIsCopyTWZhibo(i);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            super.onPostExecute(dVar);
            a.this.evC = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.bMU && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(a.this.evE);
                    if (a.this.evE != null && a.this.evE.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aTl();
                    }
                    if (a.this.evK == null) {
                        if (a.this.evJ != null) {
                            a.this.evJ.a(true, dVar.getErrorString(), null, null, dVar.getAntiData());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        a.this.evK.callback(true, postWriteCallBackData, null, a.this.evE, dVar.getAntiData());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.bMU = true;
            if (this.evO != null) {
                this.evO.cancel();
            }
            if (a.this.evK == null) {
                if (a.this.evJ != null) {
                    a.this.evJ.a(false, null, null, null, null);
                }
            } else {
                a.this.evK.callback(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.evC = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData antiData = dVar.getAntiData();
            if (!dVar.aVl()) {
                if (a.this.evK == null) {
                    if (a.this.evJ != null) {
                        a.this.evJ.a(false, dVar.getErrorString(), null, null, dVar.getAntiData());
                        return;
                    }
                    return;
                }
                a.this.evK.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.getAntiData());
                return;
            }
            o oVar = new o();
            oVar.parserJson(this.evP);
            if (oVar.getVcode_pic_url() != null && a.this.evE != null) {
                a.this.evE.setVcodeMD5(oVar.getVcode_md5());
                a.this.evE.setVcodeUrl(oVar.getVcode_pic_url());
                if (a.this.evK == null) {
                    if (a.this.evJ != null) {
                        a.this.evJ.a(false, dVar.getErrorString(), oVar, a.this.evE, antiData);
                        return;
                    }
                    return;
                }
                a.this.evK.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), oVar, a.this.evE, antiData);
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0079a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean bMU = false;
        com.baidu.tieba.tbadkCore.c.a evO = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aBB = null;

        public C0079a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean de = m.de(a.this.evG);
            if (this.bMU) {
                return null;
            }
            if (a.this.evH == null || a.this.evH.length <= 0) {
                if (TextUtils.isEmpty(a.this.evG) || !de) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.evG);
                a.this.evF = m.a(TbadkCoreApplication.m11getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.evF)) {
                    return null;
                }
                return a.this.a(a.this.evF, this.evO);
            }
            this.aBB = BitmapHelper.Bytes2Bitmap(a.this.evH);
            if (this.aBB != null) {
                a.this.evF = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aBB, 80);
                if (TextUtils.isEmpty(a.this.evF)) {
                    if (this.aBB == null || this.aBB.isRecycled()) {
                        return null;
                    }
                    this.aBB.recycle();
                    return null;
                }
                return a.this.a(a.this.evF, this.evO);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.bMU = true;
            if (this.evO != null) {
                this.evO.cancel();
            }
            if (a.this.evI != null) {
                a.this.evI.a(null, true);
            }
            if (this.aBB != null && !this.aBB.isRecycled()) {
                this.aBB.recycle();
            }
            super.cancel();
            a.this.evD = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.bMU) {
                if (a.this.evI != null) {
                    a.this.evI.a(imageUploadResult, false);
                }
                if (this.aBB != null && !this.aBB.isRecycled()) {
                    this.aBB.recycle();
                }
            }
        }
    }

    public void Ok() {
        if (this.evD == null) {
            this.evD = new C0079a();
            this.evD.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.evH = bArr;
        this.evG = str;
    }

    public void a(b bVar) {
        this.evI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(az.ug().um(), az.ug().um()));
        return aVar.d(imageFileInfo, true);
    }
}
