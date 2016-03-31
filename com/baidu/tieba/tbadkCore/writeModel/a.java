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
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static int ess = 10;
    private final h<?> bLb;
    private c esA;
    private d esB;
    private boolean esC;
    private a.InterfaceC0082a esD;
    private e est;
    private C0087a esu;
    private WriteData esv;
    private String esw;
    private String esx;
    private byte[] esy;
    private b esz;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, n nVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n nVar, WriteData writeData, AntiData antiData);
    }

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.est = null;
        this.esu = null;
        this.esv = null;
        this.esw = null;
        this.esx = null;
        this.esy = null;
        this.esA = null;
        this.esB = null;
        this.esC = false;
        this.bLb = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.est = null;
        this.esu = null;
        this.esv = null;
        this.esw = null;
        this.esx = null;
        this.esy = null;
        this.esA = null;
        this.esB = null;
        this.esC = false;
        this.bLb = tbPageContext;
    }

    public void iN(boolean z) {
        this.esC = z;
    }

    public void b(d dVar) {
        this.esB = dVar;
    }

    public void a(c cVar) {
        this.esA = cVar;
    }

    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.esD = interfaceC0082a;
    }

    public void d(WriteData writeData) {
        this.esv = writeData;
    }

    public WriteData aUF() {
        return this.esv;
    }

    public boolean aUG() {
        if (this.esv == null) {
            return false;
        }
        if (!i.jf() || i.jg() || this.esv.getWriteImagesInfo() == null || this.esv.getWriteImagesInfo().size() == 0 || !this.esv.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("original_img_up_tip", false)) {
            aUH();
        } else {
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bLb.getPageActivity());
            aVar.ca(t.j.original_img_up_no_wifi_tip);
            aVar.a(t.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(t.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.bLb);
            aVar.up();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUH() {
        if (this.est == null) {
            this.est = new e();
            this.est.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.est != null && !this.est.isCancelled()) {
            this.est.cancel();
        } else if (this.esB != null) {
            this.esB.callback(false, null, null, null, null);
        } else if (this.esA != null) {
            this.esA.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.est != null && !this.est.isCancelled()) {
            this.est.cancel();
            return false;
        }
        return false;
    }

    public void aUI() {
        if (this.esu != null && !this.esu.isCancelled()) {
            this.esu.cancel();
        }
    }

    public boolean aUJ() {
        if (this.esv == null) {
            return true;
        }
        int size = (!this.esv.getIsBaobao() || this.esv.getBaobaoImagesInfo() == null) ? 0 : this.esv.getBaobaoImagesInfo().size() + 0;
        if (this.esv.getWriteImagesInfo() != null) {
            size += this.esv.getWriteImagesInfo().size();
        }
        return size <= ess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a esF = null;
        private String esG = null;
        private boolean bMJ = false;

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
            if (this.bMJ) {
                return null;
            }
            this.esF = new com.baidu.tieba.tbadkCore.c.a();
            this.esF.a(a.this.esD);
            this.esG = this.esF.a(a.this.esv, a.this.esC);
            ErrorData aTM = this.esF.aTM();
            if (this.esF.qC() && this.esG != null) {
                AntiData aTL = this.esF.aTL();
                String error_msg = aTM.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(aTM.getError_code(), error_msg, aTL);
                if (a.this.esv == null || (!(a.this.esv.isHasImages() || a.this.esv.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.esv.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (aTM != null && !StringUtils.isNull(aTM.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(aTM.getError_code(), aTM.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(t.j.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.esG != null) {
                        JSONObject jSONObject = new JSONObject(this.esG);
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
                                            JSONObject optJSONObject = new JSONObject(this.esG).optJSONObject("twzhibo_info");
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
                    str3 = TbadkCoreApplication.m411getInst().getString(t.j.send_success);
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
            a.this.est = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.bMJ && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(a.this.esv);
                    if (a.this.esv != null && a.this.esv.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aSG();
                    }
                    if (a.this.esB == null) {
                        if (a.this.esA != null) {
                            a.this.esA.a(true, dVar.getErrorString(), null, null, dVar.amu());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        a.this.esB.callback(true, postWriteCallBackData, null, a.this.esv, dVar.amu());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.bMJ = true;
            if (this.esF != null) {
                this.esF.cancel();
            }
            if (a.this.esB == null) {
                if (a.this.esA != null) {
                    a.this.esA.a(false, null, null, null, null);
                }
            } else {
                a.this.esB.callback(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.est = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData amu = dVar.amu();
            if (!dVar.aUK()) {
                if (a.this.esB == null) {
                    if (a.this.esA != null) {
                        a.this.esA.a(false, dVar.getErrorString(), null, null, dVar.amu());
                        return;
                    }
                    return;
                }
                a.this.esB.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.amu());
                return;
            }
            n nVar = new n();
            nVar.parserJson(this.esG);
            if (nVar.getVcode_pic_url() != null && a.this.esv != null) {
                a.this.esv.setVcodeMD5(nVar.getVcode_md5());
                a.this.esv.setVcodeUrl(nVar.getVcode_pic_url());
                if (a.this.esB == null) {
                    if (a.this.esA != null) {
                        a.this.esA.a(false, dVar.getErrorString(), nVar, a.this.esv, amu);
                        return;
                    }
                    return;
                }
                a.this.esB.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), nVar, a.this.esv, amu);
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0087a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean bMJ = false;
        com.baidu.tieba.tbadkCore.c.a esF = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aFr = null;

        public C0087a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dg = m.dg(a.this.esx);
            if (this.bMJ) {
                return null;
            }
            if (a.this.esy == null || a.this.esy.length <= 0) {
                if (TextUtils.isEmpty(a.this.esx) || !dg) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.esx);
                a.this.esw = m.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.esw)) {
                    return null;
                }
                return a.this.a(a.this.esw, this.esF);
            }
            this.aFr = BitmapHelper.Bytes2Bitmap(a.this.esy);
            if (this.aFr != null) {
                a.this.esw = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aFr, 80);
                if (TextUtils.isEmpty(a.this.esw)) {
                    if (this.aFr == null || this.aFr.isRecycled()) {
                        return null;
                    }
                    this.aFr.recycle();
                    return null;
                }
                return a.this.a(a.this.esw, this.esF);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.bMJ = true;
            if (this.esF != null) {
                this.esF.cancel();
            }
            if (a.this.esz != null) {
                a.this.esz.a(null, true);
            }
            if (this.aFr != null && !this.aFr.isRecycled()) {
                this.aFr.recycle();
            }
            super.cancel();
            a.this.esu = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.bMJ) {
                if (a.this.esz != null) {
                    a.this.esz.a(imageUploadResult, false);
                }
                if (this.aFr != null && !this.aFr.isRecycled()) {
                    this.aFr.recycle();
                }
            }
        }
    }

    public void Po() {
        if (this.esu == null) {
            this.esu = new C0087a();
            this.esu.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.esy = bArr;
        this.esx = str;
    }

    public void a(b bVar) {
        this.esz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(az.wz().wF(), az.wz().wF()));
        return aVar.d(imageFileInfo, true);
    }
}
