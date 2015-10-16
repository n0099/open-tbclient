package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static int dbu = 10;
    private byte[] dbA;
    private b dbB;
    private c dbC;
    private d dbD;
    private boolean dbE;
    private final h<?> dbF;
    private e dbv;
    private C0079a dbw;
    private WriteData dbx;
    private String dby;
    private String dbz;

    /* loaded from: classes.dex */
    public interface b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, l lVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(boolean z, PostWriteCallBackData postWriteCallBackData, l lVar, WriteData writeData, AntiData antiData);
    }

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dbv = null;
        this.dbw = null;
        this.dbx = null;
        this.dby = null;
        this.dbz = null;
        this.dbA = null;
        this.dbC = null;
        this.dbD = null;
        this.dbE = false;
        this.dbF = baseActivity.getPageContext();
    }

    public void gw(boolean z) {
        this.dbE = z;
    }

    public void b(d dVar) {
        this.dbD = dVar;
    }

    public void a(c cVar) {
        this.dbC = cVar;
    }

    public void c(WriteData writeData) {
        this.dbx = writeData;
    }

    public WriteData axO() {
        return this.dbx;
    }

    public boolean axP() {
        if (this.dbx == null) {
            return false;
        }
        if (!i.iM() || i.iN() || com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("original_img_up_tip", false)) {
            axQ();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dbF.getPageActivity());
            aVar.bF(i.h.original_img_up_no_wifi_tip);
            aVar.a(i.h.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(i.h.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.dbF);
            aVar.sR();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axQ() {
        if (this.dbv == null) {
            this.dbv = new e();
            this.dbv.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.dbv != null && !this.dbv.isCancelled()) {
            this.dbv.cancel();
        } else if (this.dbD != null) {
            this.dbD.a(false, null, null, null, null);
        } else if (this.dbC != null) {
            this.dbC.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dbv != null && !this.dbv.isCancelled()) {
            this.dbv.cancel();
            return false;
        }
        return false;
    }

    public void axR() {
        if (this.dbw != null && !this.dbw.isCancelled()) {
            this.dbw.cancel();
        }
    }

    public boolean axS() {
        if (this.dbx == null) {
            return true;
        }
        int size = (!this.dbx.getIsBaobao() || this.dbx.getBaobaoImagesInfo() == null) ? 0 : this.dbx.getBaobaoImagesInfo().size() + 0;
        if (this.dbx.getWriteImagesInfo() != null) {
            size += this.dbx.getWriteImagesInfo().size();
        }
        return size <= dbu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.d.a dbI = null;
        private String dbJ = null;
        private boolean dbH = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
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
            String str6;
            String optString;
            if (this.dbH) {
                return null;
            }
            this.dbI = new com.baidu.tieba.tbadkCore.d.a();
            this.dbJ = this.dbI.a(a.this.dbx, a.this.dbE);
            ErrorData awX = this.dbI.awX();
            if (this.dbI.qV() && this.dbJ != null) {
                AntiData awW = this.dbI.awW();
                String error_msg = awX.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(awX.getError_code(), error_msg, awW);
                if (a.this.dbx == null || (!(a.this.dbx.isHasImages() || a.this.dbx.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.dbx.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (awX != null && !StringUtils.isNull(awX.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(awX.getError_code(), awX.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    String optString2 = new JSONObject(this.dbJ).optString(AddFriendActivityConfig.MSG);
                    try {
                        String optString3 = new JSONObject(this.dbJ).optString("pre_msg");
                        try {
                            String optString4 = new JSONObject(this.dbJ).optString("color_msg");
                            try {
                                optString = new JSONObject(this.dbJ).optString("tid");
                            } catch (JSONException e) {
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                                jSONException = e;
                                str4 = null;
                            }
                            try {
                                str6 = new JSONObject(this.dbJ).optString(Info.kBaiduPIDKey);
                                str5 = optString;
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                            } catch (JSONException e2) {
                                str4 = optString;
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                                jSONException = e2;
                                jSONException.printStackTrace();
                                str5 = str4;
                                str6 = null;
                                if (StringUtils.isNull(str3)) {
                                }
                                dVar.setErrorString(str3);
                                dVar.setPreMsg(str2);
                                dVar.setColorMsg(str);
                                dVar.setThreadId(str5);
                                dVar.setPostId(str6);
                                return dVar;
                            }
                        } catch (JSONException e3) {
                            str = null;
                            str2 = optString3;
                            str3 = optString2;
                            jSONException = e3;
                            str4 = null;
                        }
                    } catch (JSONException e4) {
                        str = null;
                        str2 = null;
                        str3 = optString2;
                        jSONException = e4;
                        str4 = null;
                    }
                } catch (JSONException e5) {
                    jSONException = e5;
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (StringUtils.isNull(str3)) {
                    str3 = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                }
                dVar.setErrorString(str3);
                dVar.setPreMsg(str2);
                dVar.setColorMsg(str);
                dVar.setThreadId(str5);
                dVar.setPostId(str6);
            }
            return dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            super.onPostExecute(dVar);
            a.this.dbv = null;
            if (!this.dbH && dVar != null) {
                if (!dVar.hasError()) {
                    if (a.this.dbx != null && a.this.dbx.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awj();
                    }
                    if (a.this.dbD == null) {
                        if (a.this.dbC != null) {
                            a.this.dbC.a(true, dVar.getErrorString(), null, null, dVar.afh());
                            return;
                        }
                        return;
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    a.this.dbD.a(true, postWriteCallBackData, null, null, dVar.afh());
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dbH = true;
            if (this.dbI != null) {
                this.dbI.cancel();
            }
            if (a.this.dbD == null) {
                if (a.this.dbC != null) {
                    a.this.dbC.a(false, null, null, null, null);
                }
            } else {
                a.this.dbD.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.dbv = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData afh = dVar.afh();
            if (!dVar.axT()) {
                if (a.this.dbD == null) {
                    if (a.this.dbC != null) {
                        a.this.dbC.a(false, dVar.getErrorString(), null, null, dVar.afh());
                        return;
                    }
                    return;
                }
                a.this.dbD.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.afh());
                return;
            }
            l lVar = new l();
            lVar.parserJson(this.dbJ);
            if (lVar.getVcode_pic_url() != null && a.this.dbx != null) {
                a.this.dbx.setVcodeMD5(lVar.getVcode_md5());
                a.this.dbx.setVcodeUrl(lVar.getVcode_pic_url());
                if (a.this.dbD == null) {
                    if (a.this.dbC != null) {
                        a.this.dbC.a(false, dVar.getErrorString(), lVar, a.this.dbx, afh);
                        return;
                    }
                    return;
                }
                a.this.dbD.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), lVar, a.this.dbx, afh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean dbH = false;
        com.baidu.tieba.tbadkCore.d.a dbI = new com.baidu.tieba.tbadkCore.d.a();
        Bitmap aAK = null;

        public C0079a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean cU = n.cU(a.this.dbz);
            if (this.dbH) {
                return null;
            }
            if (a.this.dbA == null || a.this.dbA.length <= 0) {
                if (TextUtils.isEmpty(a.this.dbz) || !cU) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.dbz);
                a.this.dby = n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.dby)) {
                    return null;
                }
                return a.this.a(a.this.dby, this.dbI);
            }
            this.aAK = com.baidu.tbadk.core.util.c.N(a.this.dbA);
            if (this.aAK != null) {
                a.this.dby = n.a(TbConfig.IMAGE_RESIZED_FILE, this.aAK, 80);
                if (TextUtils.isEmpty(a.this.dby)) {
                    if (this.aAK == null || this.aAK.isRecycled()) {
                        return null;
                    }
                    this.aAK.recycle();
                    return null;
                }
                return a.this.a(a.this.dby, this.dbI);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dbH = true;
            if (this.dbI != null) {
                this.dbI.cancel();
            }
            if (a.this.dbB != null) {
                a.this.dbB.a(null, true);
            }
            if (this.aAK != null && !this.aAK.isRecycled()) {
                this.aAK.recycle();
            }
            super.cancel();
            a.this.dbw = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.dbH) {
                if (a.this.dbB != null) {
                    a.this.dbB.a(imageUploadResult, false);
                }
                if (this.aAK != null && !this.aAK.isRecycled()) {
                    this.aAK.recycle();
                }
            }
        }
    }

    public void JI() {
        if (this.dbw == null) {
            this.dbw = new C0079a();
            this.dbw.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.dbA = bArr;
        this.dbz = str;
    }

    public void a(b bVar) {
        this.dbB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(at.uJ().uP(), at.uJ().uP()));
        return aVar.b(imageFileInfo);
    }
}
