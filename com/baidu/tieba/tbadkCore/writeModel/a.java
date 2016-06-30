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
    public static int far = 10;
    private final h<?> aKR;
    private d faA;
    private boolean faB;
    private a.InterfaceC0076a faC;
    private e fas;
    private C0081a fat;
    private WriteData fau;
    private String fav;
    private String faw;
    private byte[] fax;
    private b fay;
    private c faz;

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
        this.fas = null;
        this.fat = null;
        this.fau = null;
        this.fav = null;
        this.faw = null;
        this.fax = null;
        this.faz = null;
        this.faA = null;
        this.faB = false;
        this.aKR = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fas = null;
        this.fat = null;
        this.fau = null;
        this.fav = null;
        this.faw = null;
        this.fax = null;
        this.faz = null;
        this.faA = null;
        this.faB = false;
        this.aKR = tbPageContext;
    }

    public void kn(boolean z) {
        this.faB = z;
    }

    public void b(d dVar) {
        this.faA = dVar;
    }

    public void a(c cVar) {
        this.faz = cVar;
    }

    public void a(a.InterfaceC0076a interfaceC0076a) {
        this.faC = interfaceC0076a;
    }

    public void d(WriteData writeData) {
        this.fau = writeData;
    }

    public WriteData bdu() {
        return this.fau;
    }

    public boolean bdv() {
        if (this.fau == null) {
            return false;
        }
        if (!i.fr() || i.fs() || this.fau.getWriteImagesInfo() == null || this.fau.getWriteImagesInfo().size() == 0 || !this.fau.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("original_img_up_tip", false)) {
            bdw();
        } else {
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aKR.getPageActivity());
            aVar.bM(u.j.original_img_up_no_wifi_tip);
            aVar.a(u.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(u.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.aKR);
            aVar.rT();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdw() {
        if (this.fas == null) {
            this.fas = new e();
            this.fas.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fas != null && !this.fas.isCancelled()) {
            this.fas.cancel();
        } else if (this.faA != null) {
            this.faA.callback(false, null, null, null, null);
        } else if (this.faz != null) {
            this.faz.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.fas != null && !this.fas.isCancelled()) {
            this.fas.cancel();
            return false;
        }
        return false;
    }

    public void bdx() {
        if (this.fat != null && !this.fat.isCancelled()) {
            this.fat.cancel();
        }
    }

    public boolean bdy() {
        if (this.fau == null) {
            return true;
        }
        int size = (!this.fau.getIsBaobao() || this.fau.getBaobaoImagesInfo() == null) ? 0 : this.fau.getBaobaoImagesInfo().size() + 0;
        if (this.fau.getWriteImagesInfo() != null) {
            size += this.fau.getWriteImagesInfo().size();
        }
        return size <= far;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a faE = null;
        private String faF = null;
        private boolean ckY = false;

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
            if (this.ckY) {
                return null;
            }
            this.faE = new com.baidu.tieba.tbadkCore.c.a();
            this.faE.a(a.this.faC);
            this.faF = this.faE.a(a.this.fau, a.this.faB);
            ErrorData bcG = this.faE.bcG();
            if (this.faE.nU() && this.faF != null) {
                AntiData bcF = this.faE.bcF();
                String error_msg = bcG.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(u.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(bcG.getError_code(), error_msg, bcF);
                if (a.this.fau == null || (!(a.this.fau.isHasImages() || a.this.fau.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.fau.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (bcG != null && !StringUtils.isNull(bcG.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(bcG.getError_code(), bcG.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m9getInst().getApp().getString(u.j.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.faF != null) {
                        JSONObject jSONObject = new JSONObject(this.faF);
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
                                            JSONObject optJSONObject = new JSONObject(this.faF).optJSONObject("twzhibo_info");
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
                    str3 = TbadkCoreApplication.m9getInst().getString(u.j.send_success);
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
            a.this.fas = null;
            if (dVar != null && dVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", dVar.getErrorCode(), dVar.getErrorString(), "tid", dVar.getThreadId(), Info.kBaiduPIDKey, dVar.getPostId());
            }
            if (!this.ckY && dVar != null) {
                if (!dVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(a.this.fau);
                    if (a.this.fau != null && a.this.fau.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.bby();
                    }
                    if (a.this.faA == null) {
                        if (a.this.faz != null) {
                            a.this.faz.a(true, dVar.getErrorString(), null, null, dVar.getAntiData());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        p pVar = new p();
                        pVar.parserJson(this.faF);
                        a.this.faA.callback(true, postWriteCallBackData, pVar, a.this.fau, dVar.getAntiData());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.ckY = true;
            if (this.faE != null) {
                this.faE.cancel();
            }
            if (a.this.faA == null) {
                if (a.this.faz != null) {
                    a.this.faz.a(false, null, null, null, null);
                }
            } else {
                a.this.faA.callback(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.fas = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData antiData = dVar.getAntiData();
            if (!dVar.bdz()) {
                if (a.this.faA == null) {
                    if (a.this.faz != null) {
                        a.this.faz.a(false, dVar.getErrorString(), null, null, dVar.getAntiData());
                        return;
                    }
                    return;
                }
                a.this.faA.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.getAntiData());
                return;
            }
            p pVar = new p();
            pVar.parserJson(this.faF);
            if (pVar.getVcode_pic_url() != null && a.this.fau != null) {
                a.this.fau.setVcodeMD5(pVar.getVcode_md5());
                a.this.fau.setVcodeUrl(pVar.getVcode_pic_url());
                if (a.this.faA == null) {
                    if (a.this.faz != null) {
                        a.this.faz.a(false, dVar.getErrorString(), pVar, a.this.fau, antiData);
                        return;
                    }
                    return;
                }
                a.this.faA.callback(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), pVar, a.this.fau, antiData);
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0081a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean ckY = false;
        com.baidu.tieba.tbadkCore.c.a faE = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aCb = null;

        public C0081a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dd = m.dd(a.this.faw);
            if (this.ckY) {
                return null;
            }
            if (a.this.fax == null || a.this.fax.length <= 0) {
                if (TextUtils.isEmpty(a.this.faw) || !dd) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.faw);
                a.this.fav = m.a(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.fav)) {
                    return null;
                }
                return a.this.a(a.this.fav, this.faE);
            }
            this.aCb = BitmapHelper.Bytes2Bitmap(a.this.fax);
            if (this.aCb != null) {
                a.this.fav = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aCb, 80);
                if (TextUtils.isEmpty(a.this.fav)) {
                    if (this.aCb == null || this.aCb.isRecycled()) {
                        return null;
                    }
                    this.aCb.recycle();
                    return null;
                }
                return a.this.a(a.this.fav, this.faE);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.ckY = true;
            if (this.faE != null) {
                this.faE.cancel();
            }
            if (a.this.fay != null) {
                a.this.fay.a(null, true);
            }
            if (this.aCb != null && !this.aCb.isRecycled()) {
                this.aCb.recycle();
            }
            super.cancel();
            a.this.fat = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.ckY) {
                if (a.this.fay != null) {
                    a.this.fay.a(imageUploadResult, false);
                }
                if (this.aCb != null && !this.aCb.isRecycled()) {
                    this.aCb.recycle();
                }
            }
        }
    }

    public void TM() {
        if (this.fat == null) {
            this.fat = new C0081a();
            this.fat.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fax = bArr;
        this.faw = str;
    }

    public void a(b bVar) {
        this.fay = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.D(bb.uf().ul(), bb.uf().ul()));
        return aVar.d(imageFileInfo, true);
    }
}
