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
import com.baidu.tbadk.core.util.as;
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
    public static int daU = 10;
    private e daV;
    private C0079a daW;
    private WriteData daX;
    private String daY;
    private String daZ;
    private byte[] dba;
    private b dbb;
    private c dbc;
    private d dbd;
    private boolean dbe;
    private final h<?> dbf;

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
        this.daV = null;
        this.daW = null;
        this.daX = null;
        this.daY = null;
        this.daZ = null;
        this.dba = null;
        this.dbc = null;
        this.dbd = null;
        this.dbe = false;
        this.dbf = baseActivity.getPageContext();
    }

    public void gw(boolean z) {
        this.dbe = z;
    }

    public void b(d dVar) {
        this.dbd = dVar;
    }

    public void a(c cVar) {
        this.dbc = cVar;
    }

    public void c(WriteData writeData) {
        this.daX = writeData;
    }

    public WriteData axE() {
        return this.daX;
    }

    public boolean axF() {
        if (this.daX == null) {
            return false;
        }
        if (!i.iM() || i.iN() || com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("original_img_up_tip", false)) {
            axG();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dbf.getPageActivity());
            aVar.bF(i.h.original_img_up_no_wifi_tip);
            aVar.a(i.h.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(i.h.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.dbf);
            aVar.sR();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axG() {
        if (this.daV == null) {
            this.daV = new e();
            this.daV.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.daV != null && !this.daV.isCancelled()) {
            this.daV.cancel();
        } else if (this.dbd != null) {
            this.dbd.a(false, null, null, null, null);
        } else if (this.dbc != null) {
            this.dbc.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.daV != null && !this.daV.isCancelled()) {
            this.daV.cancel();
            return false;
        }
        return false;
    }

    public void axH() {
        if (this.daW != null && !this.daW.isCancelled()) {
            this.daW.cancel();
        }
    }

    public boolean axI() {
        if (this.daX == null) {
            return true;
        }
        int size = (!this.daX.getIsBaobao() || this.daX.getBaobaoImagesInfo() == null) ? 0 : this.daX.getBaobaoImagesInfo().size() + 0;
        if (this.daX.getWriteImagesInfo() != null) {
            size += this.daX.getWriteImagesInfo().size();
        }
        return size <= daU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.d.a dbi = null;
        private String dbj = null;
        private boolean dbh = false;

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
            if (this.dbh) {
                return null;
            }
            this.dbi = new com.baidu.tieba.tbadkCore.d.a();
            this.dbj = this.dbi.a(a.this.daX, a.this.dbe);
            ErrorData awN = this.dbi.awN();
            if (this.dbi.qV() && this.dbj != null) {
                AntiData awM = this.dbi.awM();
                String error_msg = awN.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(awN.getError_code(), error_msg, awM);
                if (a.this.daX == null || (!(a.this.daX.isHasImages() || a.this.daX.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.daX.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (awN != null && !StringUtils.isNull(awN.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(awN.getError_code(), awN.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    String optString2 = new JSONObject(this.dbj).optString(AddFriendActivityConfig.MSG);
                    try {
                        String optString3 = new JSONObject(this.dbj).optString("pre_msg");
                        try {
                            String optString4 = new JSONObject(this.dbj).optString("color_msg");
                            try {
                                optString = new JSONObject(this.dbj).optString("tid");
                            } catch (JSONException e) {
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                                jSONException = e;
                                str4 = null;
                            }
                            try {
                                str6 = new JSONObject(this.dbj).optString(Info.kBaiduPIDKey);
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
            a.this.daV = null;
            if (!this.dbh && dVar != null) {
                if (!dVar.hasError()) {
                    if (a.this.daX != null && a.this.daX.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awb();
                    }
                    if (a.this.dbd == null) {
                        if (a.this.dbc != null) {
                            a.this.dbc.a(true, dVar.getErrorString(), null, null, dVar.afh());
                            return;
                        }
                        return;
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    a.this.dbd.a(true, postWriteCallBackData, null, null, dVar.afh());
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dbh = true;
            if (this.dbi != null) {
                this.dbi.cancel();
            }
            if (a.this.dbd == null) {
                if (a.this.dbc != null) {
                    a.this.dbc.a(false, null, null, null, null);
                }
            } else {
                a.this.dbd.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.daV = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData afh = dVar.afh();
            if (!dVar.axJ()) {
                if (a.this.dbd == null) {
                    if (a.this.dbc != null) {
                        a.this.dbc.a(false, dVar.getErrorString(), null, null, dVar.afh());
                        return;
                    }
                    return;
                }
                a.this.dbd.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.afh());
                return;
            }
            l lVar = new l();
            lVar.parserJson(this.dbj);
            if (lVar.getVcode_pic_url() != null && a.this.daX != null) {
                a.this.daX.setVcodeMD5(lVar.getVcode_md5());
                a.this.daX.setVcodeUrl(lVar.getVcode_pic_url());
                if (a.this.dbd == null) {
                    if (a.this.dbc != null) {
                        a.this.dbc.a(false, dVar.getErrorString(), lVar, a.this.daX, afh);
                        return;
                    }
                    return;
                }
                a.this.dbd.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), lVar, a.this.daX, afh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean dbh = false;
        com.baidu.tieba.tbadkCore.d.a dbi = new com.baidu.tieba.tbadkCore.d.a();
        Bitmap aAz = null;

        public C0079a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean cT = n.cT(a.this.daZ);
            if (this.dbh) {
                return null;
            }
            if (a.this.dba == null || a.this.dba.length <= 0) {
                if (TextUtils.isEmpty(a.this.daZ) || !cT) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.daZ);
                a.this.daY = n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.daY)) {
                    return null;
                }
                return a.this.a(a.this.daY, this.dbi);
            }
            this.aAz = com.baidu.tbadk.core.util.c.N(a.this.dba);
            if (this.aAz != null) {
                a.this.daY = n.a(TbConfig.IMAGE_RESIZED_FILE, this.aAz, 80);
                if (TextUtils.isEmpty(a.this.daY)) {
                    if (this.aAz == null || this.aAz.isRecycled()) {
                        return null;
                    }
                    this.aAz.recycle();
                    return null;
                }
                return a.this.a(a.this.daY, this.dbi);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dbh = true;
            if (this.dbi != null) {
                this.dbi.cancel();
            }
            if (a.this.dbb != null) {
                a.this.dbb.a(null, true);
            }
            if (this.aAz != null && !this.aAz.isRecycled()) {
                this.aAz.recycle();
            }
            super.cancel();
            a.this.daW = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.dbh) {
                if (a.this.dbb != null) {
                    a.this.dbb.a(imageUploadResult, false);
                }
                if (this.aAz != null && !this.aAz.isRecycled()) {
                    this.aAz.recycle();
                }
            }
        }
    }

    public void JI() {
        if (this.daW == null) {
            this.daW = new C0079a();
            this.daW.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.dba = bArr;
        this.daZ = str;
    }

    public void a(b bVar) {
        this.dbb = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(as.uI().uO(), as.uI().uO()));
        return aVar.b(imageFileInfo);
    }
}
