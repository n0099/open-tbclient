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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static int fnv = 10;
    private final h<?> aLK;
    private WriteData faq;
    private byte[] fnA;
    private b fnB;
    private c fnC;
    private d fnD;
    private boolean fnE;
    private a.InterfaceC0075a fnF;
    private e fnw;
    private C0080a fnx;
    private String fny;
    private String fnz;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, p pVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData);
    }

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fnw = null;
        this.fnx = null;
        this.faq = null;
        this.fny = null;
        this.fnz = null;
        this.fnA = null;
        this.fnC = null;
        this.fnD = null;
        this.fnE = false;
        this.aLK = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fnw = null;
        this.fnx = null;
        this.faq = null;
        this.fny = null;
        this.fnz = null;
        this.fnA = null;
        this.fnC = null;
        this.fnD = null;
        this.fnE = false;
        this.aLK = tbPageContext;
    }

    public void kB(boolean z) {
        this.fnE = z;
    }

    public void b(d dVar) {
        this.fnD = dVar;
    }

    public void a(c cVar) {
        this.fnC = cVar;
    }

    public void a(a.InterfaceC0075a interfaceC0075a) {
        this.fnF = interfaceC0075a;
    }

    public void d(WriteData writeData) {
        this.faq = writeData;
    }

    public WriteData bbo() {
        return this.faq;
    }

    public boolean bgM() {
        if (this.faq == null) {
            return false;
        }
        if (!i.fq() || i.fr() || this.faq.getWriteImagesInfo() == null || this.faq.getWriteImagesInfo().size() == 0 || !this.faq.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("original_img_up_tip", false)) {
            bgN();
        } else {
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aLK.getPageActivity());
            aVar.bM(u.j.original_img_up_no_wifi_tip);
            aVar.a(u.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(u.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.aLK);
            aVar.rS();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgN() {
        if (this.fnw == null) {
            this.fnw = new e();
            this.fnw.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fnw != null && !this.fnw.isCancelled()) {
            this.fnw.cancel();
        } else if (this.fnD != null) {
            this.fnD.callback(false, null, null, null, null);
        } else if (this.fnC != null) {
            this.fnC.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.fnw != null && !this.fnw.isCancelled()) {
            this.fnw.cancel();
            return false;
        }
        return false;
    }

    public void bgO() {
        if (this.fnx != null && !this.fnx.isCancelled()) {
            this.fnx.cancel();
        }
    }

    public boolean bgP() {
        if (this.faq == null) {
            return true;
        }
        int size = (!this.faq.getIsBaobao() || this.faq.getBaobaoImagesInfo() == null) ? 0 : this.faq.getBaobaoImagesInfo().size() + 0;
        if (this.faq.getWriteImagesInfo() != null) {
            size += this.faq.getWriteImagesInfo().size();
        }
        return size <= fnv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a fnH = null;
        private String fnI = null;
        private boolean cnm = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
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
            if (this.cnm) {
                return null;
            }
            this.fnH = new com.baidu.tieba.tbadkCore.c.a();
            this.fnH.a(a.this.fnF);
            this.fnI = this.fnH.a(a.this.faq, a.this.fnE);
            ErrorData bfV = this.fnH.bfV();
            if (this.fnH.nJ() && this.fnI != null) {
                AntiData bfU = this.fnH.bfU();
                String error_msg = bfV.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m10getInst().getApp().getString(u.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(bfV.getError_code(), error_msg, bfU);
                if (a.this.faq == null || (!(a.this.faq.isHasImages() || a.this.faq.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.faq.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (bfV != null && !StringUtils.isNull(bfV.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(bfV.getError_code(), bfV.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m10getInst().getApp().getString(u.j.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.fnI != null) {
                        JSONObject jSONObject = new JSONObject(this.fnI);
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
                                            JSONObject optJSONObject = new JSONObject(this.fnI).optJSONObject("twzhibo_info");
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
                    str3 = TbadkCoreApplication.m10getInst().getString(u.j.send_success);
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
            a.this.fnw = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.cnm && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(a.this.faq);
                    if (a.this.faq != null && a.this.faq.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.beN();
                    }
                    if (a.this.fnD == null) {
                        if (a.this.fnC != null) {
                            a.this.fnC.a(true, dVar.getErrorString(), null, null, dVar.getAntiData());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        p pVar = new p();
                        pVar.parserJson(this.fnI);
                        a.this.fnD.callback(true, postWriteCallBackData, pVar, a.this.faq, dVar.getAntiData());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cnm = true;
            if (this.fnH != null) {
                this.fnH.cancel();
            }
            if (a.this.fnD == null) {
                if (a.this.fnC != null) {
                    a.this.fnC.a(false, null, null, null, null);
                }
            } else {
                a.this.fnD.callback(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.fnw = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData antiData = dVar.getAntiData();
            if (dVar.bgQ()) {
                p pVar = new p();
                pVar.parserJson(this.fnI);
                if (pVar.getVcode_pic_url() != null && a.this.faq != null) {
                    a.this.faq.setVcodeMD5(pVar.getVcode_md5());
                    a.this.faq.setVcodeUrl(pVar.getVcode_pic_url());
                    if (a.this.fnD == null) {
                        if (a.this.fnC != null) {
                            a.this.fnC.a(false, dVar.getErrorString(), pVar, a.this.faq, antiData);
                            return;
                        }
                        return;
                    }
                    a.this.fnD.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), pVar, a.this.faq, antiData);
                }
            } else if (!dVar.bgR()) {
                if (a.this.fnD == null) {
                    if (a.this.fnC != null) {
                        a.this.fnC.a(false, dVar.getErrorString(), null, null, dVar.getAntiData());
                        return;
                    }
                    return;
                }
                a.this.fnD.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.getAntiData());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.fnI);
                if (a.this.fnD == null) {
                    if (a.this.fnC != null) {
                        a.this.fnC.a(false, dVar.getErrorString(), null, a.this.faq, antiData);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                a.this.fnD.callback(false, postWriteCallBackData, null, a.this.faq, antiData);
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0080a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cnm = false;
        com.baidu.tieba.tbadkCore.c.a fnH = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aCR = null;

        public C0080a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dc = m.dc(a.this.fnz);
            if (this.cnm) {
                return null;
            }
            if (a.this.fnA == null || a.this.fnA.length <= 0) {
                if (TextUtils.isEmpty(a.this.fnz) || !dc) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.fnz);
                a.this.fny = m.b(TbadkCoreApplication.m10getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.fny)) {
                    return null;
                }
                return a.this.a(a.this.fny, this.fnH);
            }
            this.aCR = BitmapHelper.Bytes2Bitmap(a.this.fnA);
            if (this.aCR != null) {
                a.this.fny = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aCR, 80);
                if (TextUtils.isEmpty(a.this.fny)) {
                    if (this.aCR == null || this.aCR.isRecycled()) {
                        return null;
                    }
                    this.aCR.recycle();
                    return null;
                }
                return a.this.a(a.this.fny, this.fnH);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cnm = true;
            if (this.fnH != null) {
                this.fnH.cancel();
            }
            if (a.this.fnB != null) {
                a.this.fnB.a(null, true);
            }
            if (this.aCR != null && !this.aCR.isRecycled()) {
                this.aCR.recycle();
            }
            super.cancel();
            a.this.fnx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cnm) {
                if (a.this.fnB != null) {
                    a.this.fnB.a(imageUploadResult, false);
                }
                if (this.aCR != null && !this.aCR.isRecycled()) {
                    this.aCR.recycle();
                }
            }
        }
    }

    public void Uu() {
        if (this.fnx == null) {
            this.fnx = new C0080a();
            this.fnx.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fnA = bArr;
        this.fnz = str;
    }

    public void a(b bVar) {
        this.fnB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(bb.ue().ul(), bb.ue().ul()));
        return aVar.d(imageFileInfo, true);
    }
}
