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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.n;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static int dBT = 10;
    private final h<?> cBo;
    private e dBU;
    private C0088a dBV;
    private WriteData dBW;
    private String dBX;
    private String dBY;
    private byte[] dBZ;
    private b dCa;
    private c dCb;
    private d dCc;
    private boolean dCd;

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
        this.dBU = null;
        this.dBV = null;
        this.dBW = null;
        this.dBX = null;
        this.dBY = null;
        this.dBZ = null;
        this.dCb = null;
        this.dCc = null;
        this.dCd = false;
        this.cBo = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBU = null;
        this.dBV = null;
        this.dBW = null;
        this.dBX = null;
        this.dBY = null;
        this.dBZ = null;
        this.dCb = null;
        this.dCc = null;
        this.dCd = false;
        this.cBo = tbPageContext;
    }

    public void hn(boolean z) {
        this.dCd = z;
    }

    public void b(d dVar) {
        this.dCc = dVar;
    }

    public void a(c cVar) {
        this.dCb = cVar;
    }

    public void c(WriteData writeData) {
        this.dBW = writeData;
    }

    public WriteData aEl() {
        return this.dBW;
    }

    public boolean aEm() {
        if (this.dBW == null) {
            return false;
        }
        if (!i.iP() || i.iQ() || this.dBW.getWriteImagesInfo() == null || this.dBW.getWriteImagesInfo().size() == 0 || !this.dBW.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("original_img_up_tip", false)) {
            aEn();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cBo.getPageActivity());
            aVar.bN(n.i.original_img_up_no_wifi_tip);
            aVar.a(n.i.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(n.i.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.cBo);
            aVar.tv();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEn() {
        if (this.dBU == null) {
            this.dBU = new e();
            this.dBU.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.dBU != null && !this.dBU.isCancelled()) {
            this.dBU.cancel();
        } else if (this.dCc != null) {
            this.dCc.a(false, null, null, null, null);
        } else if (this.dCb != null) {
            this.dCb.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dBU != null && !this.dBU.isCancelled()) {
            this.dBU.cancel();
            return false;
        }
        return false;
    }

    public void aEo() {
        if (this.dBV != null && !this.dBV.isCancelled()) {
            this.dBV.cancel();
        }
    }

    public boolean aEp() {
        if (this.dBW == null) {
            return true;
        }
        int size = (!this.dBW.getIsBaobao() || this.dBW.getBaobaoImagesInfo() == null) ? 0 : this.dBW.getBaobaoImagesInfo().size() + 0;
        if (this.dBW.getWriteImagesInfo() != null) {
            size += this.dBW.getWriteImagesInfo().size();
        }
        return size <= dBT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a dCg = null;
        private String dCh = null;
        private boolean dCf = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
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
            String str6 = null;
            if (this.dCf) {
                return null;
            }
            this.dCg = new com.baidu.tieba.tbadkCore.c.a();
            this.dCh = this.dCg.a(a.this.dBW, a.this.dCd);
            ErrorData aDu = this.dCg.aDu();
            if (this.dCg.rf() && this.dCh != null) {
                AntiData aDt = this.dCg.aDt();
                String error_msg = aDu.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(n.i.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(aDu.getError_code(), error_msg, aDt);
                if (a.this.dBW == null || (!(a.this.dBW.isHasImages() || a.this.dBW.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.dBW.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (aDu != null && !StringUtils.isNull(aDu.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(aDu.getError_code(), aDu.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(n.i.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.dCh != null) {
                        JSONObject jSONObject = new JSONObject(this.dCh);
                        String optString = jSONObject.optString(AddFriendActivityConfig.MSG);
                        try {
                            String optString2 = jSONObject.optString("pre_msg");
                            try {
                                String optString3 = jSONObject.optString("color_msg");
                                try {
                                    String optString4 = jSONObject.optString("tid");
                                    try {
                                        str5 = jSONObject.optString(Info.kBaiduPIDKey);
                                        str6 = optString4;
                                        str = optString3;
                                        str2 = optString2;
                                        str3 = optString;
                                    } catch (JSONException e) {
                                        str4 = optString4;
                                        str = optString3;
                                        str2 = optString2;
                                        str3 = optString;
                                        jSONException = e;
                                        jSONException.printStackTrace();
                                        str6 = str4;
                                        str5 = null;
                                        if (StringUtils.isNull(str3)) {
                                        }
                                        dVar.setErrorString(str3);
                                        dVar.setPreMsg(str2);
                                        dVar.setColorMsg(str);
                                        dVar.setThreadId(str6);
                                        dVar.setPostId(str5);
                                        return dVar;
                                    }
                                } catch (JSONException e2) {
                                    str = optString3;
                                    str2 = optString2;
                                    str3 = optString;
                                    jSONException = e2;
                                    str4 = null;
                                }
                            } catch (JSONException e3) {
                                str = null;
                                str2 = optString2;
                                str3 = optString;
                                jSONException = e3;
                                str4 = null;
                            }
                        } catch (JSONException e4) {
                            str = null;
                            str2 = null;
                            str3 = optString;
                            jSONException = e4;
                            str4 = null;
                        }
                    } else {
                        str5 = null;
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                } catch (JSONException e5) {
                    jSONException = e5;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (StringUtils.isNull(str3)) {
                    str3 = TbadkCoreApplication.m411getInst().getString(n.i.send_success);
                }
                dVar.setErrorString(str3);
                dVar.setPreMsg(str2);
                dVar.setColorMsg(str);
                dVar.setThreadId(str6);
                dVar.setPostId(str5);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            super.onPostExecute(dVar);
            a.this.dBU = null;
            if (!this.dCf && dVar != null) {
                if (!dVar.hasError()) {
                    if (a.this.dBW != null && a.this.dBW.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aCz();
                    }
                    if (a.this.dCc == null) {
                        if (a.this.dCb != null) {
                            a.this.dCb.a(true, dVar.getErrorString(), null, null, dVar.ajS());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        a.this.dCc.a(true, postWriteCallBackData, null, null, dVar.ajS());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dCf = true;
            if (this.dCg != null) {
                this.dCg.cancel();
            }
            if (a.this.dCc == null) {
                if (a.this.dCb != null) {
                    a.this.dCb.a(false, null, null, null, null);
                }
            } else {
                a.this.dCc.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.dBU = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData ajS = dVar.ajS();
            if (!dVar.aEq()) {
                if (a.this.dCc == null) {
                    if (a.this.dCb != null) {
                        a.this.dCb.a(false, dVar.getErrorString(), null, null, dVar.ajS());
                        return;
                    }
                    return;
                }
                a.this.dCc.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.ajS());
                return;
            }
            com.baidu.tbadk.coreExtra.data.n nVar = new com.baidu.tbadk.coreExtra.data.n();
            nVar.parserJson(this.dCh);
            if (nVar.getVcode_pic_url() != null && a.this.dBW != null) {
                a.this.dBW.setVcodeMD5(nVar.getVcode_md5());
                a.this.dBW.setVcodeUrl(nVar.getVcode_pic_url());
                if (a.this.dCc == null) {
                    if (a.this.dCb != null) {
                        a.this.dCb.a(false, dVar.getErrorString(), nVar, a.this.dBW, ajS);
                        return;
                    }
                    return;
                }
                a.this.dCc.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), nVar, a.this.dBW, ajS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0088a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean dCf = false;
        com.baidu.tieba.tbadkCore.c.a dCg = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aBE = null;

        public C0088a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dc = com.baidu.tbadk.core.util.n.dc(a.this.dBY);
            if (this.dCf) {
                return null;
            }
            if (a.this.dBZ == null || a.this.dBZ.length <= 0) {
                if (TextUtils.isEmpty(a.this.dBY) || !dc) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.dBY);
                a.this.dBX = com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.dBX)) {
                    return null;
                }
                return a.this.a(a.this.dBX, this.dCg);
            }
            this.aBE = com.baidu.tbadk.core.util.c.N(a.this.dBZ);
            if (this.aBE != null) {
                a.this.dBX = com.baidu.tbadk.core.util.n.a(TbConfig.IMAGE_RESIZED_FILE, this.aBE, 80);
                if (TextUtils.isEmpty(a.this.dBX)) {
                    if (this.aBE == null || this.aBE.isRecycled()) {
                        return null;
                    }
                    this.aBE.recycle();
                    return null;
                }
                return a.this.a(a.this.dBX, this.dCg);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dCf = true;
            if (this.dCg != null) {
                this.dCg.cancel();
            }
            if (a.this.dCa != null) {
                a.this.dCa.a(null, true);
            }
            if (this.aBE != null && !this.aBE.isRecycled()) {
                this.aBE.recycle();
            }
            super.cancel();
            a.this.dBV = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.dCf) {
                if (a.this.dCa != null) {
                    a.this.dCa.a(imageUploadResult, false);
                }
                if (this.aBE != null && !this.aBE.isRecycled()) {
                    this.aBE.recycle();
                }
            }
        }
    }

    public void Lo() {
        if (this.dBV == null) {
            this.dBV = new C0088a();
            this.dBV.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.dBZ = bArr;
        this.dBY = str;
    }

    public void a(b bVar) {
        this.dCa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(ay.vq().vw(), ay.vq().vw()));
        return aVar.d(imageFileInfo, true);
    }
}
