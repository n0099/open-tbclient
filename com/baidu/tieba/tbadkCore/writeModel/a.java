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
import com.baidu.tbadk.core.util.ax;
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
    public static int dZz = 10;
    private final h<?> cMk;
    private e dZA;
    private C0089a dZB;
    private WriteData dZC;
    private String dZD;
    private String dZE;
    private byte[] dZF;
    private b dZG;
    private c dZH;
    private d dZI;
    private boolean dZJ;
    private a.InterfaceC0085a dZK;

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
        void a(boolean z, PostWriteCallBackData postWriteCallBackData, n nVar, WriteData writeData, AntiData antiData);
    }

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dZA = null;
        this.dZB = null;
        this.dZC = null;
        this.dZD = null;
        this.dZE = null;
        this.dZF = null;
        this.dZH = null;
        this.dZI = null;
        this.dZJ = false;
        this.cMk = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dZA = null;
        this.dZB = null;
        this.dZC = null;
        this.dZD = null;
        this.dZE = null;
        this.dZF = null;
        this.dZH = null;
        this.dZI = null;
        this.dZJ = false;
        this.cMk = tbPageContext;
    }

    public void hX(boolean z) {
        this.dZJ = z;
    }

    public void b(d dVar) {
        this.dZI = dVar;
    }

    public void a(c cVar) {
        this.dZH = cVar;
    }

    public void a(a.InterfaceC0085a interfaceC0085a) {
        this.dZK = interfaceC0085a;
    }

    public void c(WriteData writeData) {
        this.dZC = writeData;
    }

    public WriteData aND() {
        return this.dZC;
    }

    public boolean aNE() {
        if (this.dZC == null) {
            return false;
        }
        if (!i.iZ() || i.ja() || this.dZC.getWriteImagesInfo() == null || this.dZC.getWriteImagesInfo().size() == 0 || !this.dZC.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("original_img_up_tip", false)) {
            aNF();
        } else {
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cMk.getPageActivity());
            aVar.bY(t.j.original_img_up_no_wifi_tip);
            aVar.a(t.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(t.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.cMk);
            aVar.uj();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNF() {
        if (this.dZA == null) {
            this.dZA = new e();
            this.dZA.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.dZA != null && !this.dZA.isCancelled()) {
            this.dZA.cancel();
        } else if (this.dZI != null) {
            this.dZI.a(false, null, null, null, null);
        } else if (this.dZH != null) {
            this.dZH.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dZA != null && !this.dZA.isCancelled()) {
            this.dZA.cancel();
            return false;
        }
        return false;
    }

    public void aNG() {
        if (this.dZB != null && !this.dZB.isCancelled()) {
            this.dZB.cancel();
        }
    }

    public boolean aNH() {
        if (this.dZC == null) {
            return true;
        }
        int size = (!this.dZC.getIsBaobao() || this.dZC.getBaobaoImagesInfo() == null) ? 0 : this.dZC.getBaobaoImagesInfo().size() + 0;
        if (this.dZC.getWriteImagesInfo() != null) {
            size += this.dZC.getWriteImagesInfo().size();
        }
        return size <= dZz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a dZN = null;
        private String dZO = null;
        private boolean dZM = false;

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
            if (this.dZM) {
                return null;
            }
            this.dZN = new com.baidu.tieba.tbadkCore.c.a();
            this.dZN.a(a.this.dZK);
            this.dZO = this.dZN.a(a.this.dZC, a.this.dZJ);
            ErrorData aMM = this.dZN.aMM();
            if (this.dZN.rl() && this.dZO != null) {
                AntiData aML = this.dZN.aML();
                String error_msg = aMM.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(aMM.getError_code(), error_msg, aML);
                if (a.this.dZC == null || (!(a.this.dZC.isHasImages() || a.this.dZC.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.dZC.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (aMM != null && !StringUtils.isNull(aMM.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(aMM.getError_code(), aMM.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(t.j.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.dZO != null) {
                        JSONObject jSONObject = new JSONObject(this.dZO);
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
                                            JSONObject optJSONObject = new JSONObject(this.dZO).optJSONObject("twzhibo_info");
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
            a.this.dZA = null;
            if (!this.dZM && dVar != null) {
                if (!dVar.hasError()) {
                    if (a.this.dZC != null && a.this.dZC.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aLM();
                    }
                    if (a.this.dZI == null) {
                        if (a.this.dZH != null) {
                            a.this.dZH.a(true, dVar.getErrorString(), null, null, dVar.ajb());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        a.this.dZI.a(true, postWriteCallBackData, null, null, dVar.ajb());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dZM = true;
            if (this.dZN != null) {
                this.dZN.cancel();
            }
            if (a.this.dZI == null) {
                if (a.this.dZH != null) {
                    a.this.dZH.a(false, null, null, null, null);
                }
            } else {
                a.this.dZI.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.dZA = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData ajb = dVar.ajb();
            if (!dVar.aNI()) {
                if (a.this.dZI == null) {
                    if (a.this.dZH != null) {
                        a.this.dZH.a(false, dVar.getErrorString(), null, null, dVar.ajb());
                        return;
                    }
                    return;
                }
                a.this.dZI.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.ajb());
                return;
            }
            n nVar = new n();
            nVar.parserJson(this.dZO);
            if (nVar.getVcode_pic_url() != null && a.this.dZC != null) {
                a.this.dZC.setVcodeMD5(nVar.getVcode_md5());
                a.this.dZC.setVcodeUrl(nVar.getVcode_pic_url());
                if (a.this.dZI == null) {
                    if (a.this.dZH != null) {
                        a.this.dZH.a(false, dVar.getErrorString(), nVar, a.this.dZC, ajb);
                        return;
                    }
                    return;
                }
                a.this.dZI.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), nVar, a.this.dZC, ajb);
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0089a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean dZM = false;
        com.baidu.tieba.tbadkCore.c.a dZN = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aEb = null;

        public C0089a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dc = m.dc(a.this.dZE);
            if (this.dZM) {
                return null;
            }
            if (a.this.dZF == null || a.this.dZF.length <= 0) {
                if (TextUtils.isEmpty(a.this.dZE) || !dc) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.dZE);
                a.this.dZD = m.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.dZD)) {
                    return null;
                }
                return a.this.a(a.this.dZD, this.dZN);
            }
            this.aEb = BitmapHelper.Bytes2Bitmap(a.this.dZF);
            if (this.aEb != null) {
                a.this.dZD = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aEb, 80);
                if (TextUtils.isEmpty(a.this.dZD)) {
                    if (this.aEb == null || this.aEb.isRecycled()) {
                        return null;
                    }
                    this.aEb.recycle();
                    return null;
                }
                return a.this.a(a.this.dZD, this.dZN);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dZM = true;
            if (this.dZN != null) {
                this.dZN.cancel();
            }
            if (a.this.dZG != null) {
                a.this.dZG.a(null, true);
            }
            if (this.aEb != null && !this.aEb.isRecycled()) {
                this.aEb.recycle();
            }
            super.cancel();
            a.this.dZB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.dZM) {
                if (a.this.dZG != null) {
                    a.this.dZG.a(imageUploadResult, false);
                }
                if (this.aEb != null && !this.aEb.isRecycled()) {
                    this.aEb.recycle();
                }
            }
        }
    }

    public void NA() {
        if (this.dZB == null) {
            this.dZB = new C0089a();
            this.dZB.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.dZF = bArr;
        this.dZE = str;
    }

    public void a(b bVar) {
        this.dZG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.G(ax.wg().wm(), ax.wg().wm()));
        return aVar.d(imageFileInfo, true);
    }
}
