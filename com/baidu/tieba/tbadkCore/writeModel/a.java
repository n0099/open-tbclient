package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ar;
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
    public static int cKP = 10;
    private e cKQ;
    private C0074a cKR;
    private WriteData cKS;
    private String cKT;
    private String cKU;
    private byte[] cKV;
    private b cKW;
    private c cKX;
    private d cKY;
    private boolean cKZ;

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
        this.cKQ = null;
        this.cKR = null;
        this.cKS = null;
        this.cKT = null;
        this.cKU = null;
        this.cKV = null;
        this.cKX = null;
        this.cKY = null;
        this.cKZ = false;
    }

    public void fB(boolean z) {
        this.cKZ = z;
    }

    public void b(d dVar) {
        this.cKY = dVar;
    }

    public void a(c cVar) {
        this.cKX = cVar;
    }

    public void c(WriteData writeData) {
        this.cKS = writeData;
    }

    public WriteData ard() {
        return this.cKS;
    }

    public boolean are() {
        if (this.cKS == null) {
            return false;
        }
        if (this.cKQ == null) {
            this.cKQ = new e();
            this.cKQ.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cKQ != null && !this.cKQ.isCancelled()) {
            this.cKQ.cancel();
            return false;
        }
        return false;
    }

    public void arf() {
        if (this.cKR != null && !this.cKR.isCancelled()) {
            this.cKR.cancel();
        }
    }

    public boolean arg() {
        if (this.cKS == null) {
            return true;
        }
        int size = (!this.cKS.getIsBaobao() || this.cKS.getBaobaoImagesInfo() == null) ? 0 : this.cKS.getBaobaoImagesInfo().size() + 0;
        if (this.cKS.getWriteImagesInfo() != null) {
            size += this.cKS.getWriteImagesInfo().size();
        }
        return size <= cKP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tieba.tbadkCore.d.a cLb = null;
        private String aGk = null;
        private boolean cLa = false;

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
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String optString;
            if (this.cLa) {
                return null;
            }
            this.cLb = new com.baidu.tieba.tbadkCore.d.a();
            this.aGk = this.cLb.a(a.this.cKS, a.this.cKZ);
            ErrorData aqk = this.cLb.aqk();
            if (this.cLb.rb() && this.aGk != null) {
                AntiData aqj = this.cLb.aqj();
                String error_msg = aqk.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(aqk.getError_code(), error_msg, aqj);
                if (a.this.cKS == null || (!(a.this.cKS.isHasImages() || a.this.cKS.getIsBaobao()) || bVar2.hasError())) {
                    bVar = bVar2;
                } else {
                    a.this.cKS.deleteUploadedTempImages();
                    bVar = bVar2;
                }
            } else if (aqk != null && !StringUtils.isNull(aqk.getError_msg())) {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(aqk.getError_code(), aqk.getError_msg(), null);
            } else {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.neterror), null);
            }
            if (!bVar.hasError()) {
                try {
                    String optString2 = new JSONObject(this.aGk).optString(AddFriendActivityConfig.MSG);
                    try {
                        String optString3 = new JSONObject(this.aGk).optString("pre_msg");
                        try {
                            String optString4 = new JSONObject(this.aGk).optString("color_msg");
                            try {
                                optString = new JSONObject(this.aGk).optString("tid");
                            } catch (JSONException e) {
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                                jSONException = e;
                                str4 = null;
                            }
                            try {
                                str6 = new JSONObject(this.aGk).optString(Info.kBaiduPIDKey);
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
                                bVar.setErrorString(str3);
                                bVar.setPreMsg(str2);
                                bVar.setColorMsg(str);
                                bVar.setThreadId(str5);
                                bVar.setPostId(str6);
                                return bVar;
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
                    str3 = TbadkCoreApplication.m411getInst().getString(i.C0057i.send_success);
                }
                bVar.setErrorString(str3);
                bVar.setPreMsg(str2);
                bVar.setColorMsg(str);
                bVar.setThreadId(str5);
                bVar.setPostId(str6);
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            super.onPostExecute(bVar);
            a.this.cKQ = null;
            if (!this.cLa && bVar != null) {
                if (!bVar.hasError()) {
                    if (a.this.cKS != null && a.this.cKS.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.apy();
                    }
                    if (a.this.cKY == null) {
                        if (a.this.cKX != null) {
                            a.this.cKX.a(true, bVar.getErrorString(), null, null, bVar.acW());
                            return;
                        }
                        return;
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), bVar.getPreMsg(), bVar.getColorMsg());
                    postWriteCallBackData.setThreadId(bVar.getThreadId());
                    postWriteCallBackData.setPostId(bVar.getPostId());
                    a.this.cKY.a(true, postWriteCallBackData, null, null, bVar.acW());
                    return;
                }
                b(bVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cLa = true;
            if (this.cLb != null) {
                this.cLb.cancel();
            }
            if (a.this.cKY == null) {
                if (a.this.cKX != null) {
                    a.this.cKX.a(false, null, null, null, null);
                }
            } else {
                a.this.cKY.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.cKQ = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            AntiData acW = bVar.acW();
            if (!bVar.arh()) {
                if (a.this.cKY == null) {
                    if (a.this.cKX != null) {
                        a.this.cKX.a(false, bVar.getErrorString(), null, null, bVar.acW());
                        return;
                    }
                    return;
                }
                a.this.cKY.a(false, new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null), null, null, bVar.acW());
                return;
            }
            l lVar = new l();
            lVar.parserJson(this.aGk);
            if (lVar.getVcode_pic_url() != null && a.this.cKS != null) {
                a.this.cKS.setVcodeMD5(lVar.getVcode_md5());
                a.this.cKS.setVcodeUrl(lVar.getVcode_pic_url());
                if (a.this.cKY == null) {
                    if (a.this.cKX != null) {
                        a.this.cKX.a(false, bVar.getErrorString(), lVar, a.this.cKS, acW);
                        return;
                    }
                    return;
                }
                a.this.cKY.a(false, new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null), lVar, a.this.cKS, acW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cLa = false;
        com.baidu.tieba.tbadkCore.d.a cLb = new com.baidu.tieba.tbadkCore.d.a();
        Bitmap aAn = null;

        public C0074a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean cL = n.cL(a.this.cKU);
            if (this.cLa) {
                return null;
            }
            if (a.this.cKV == null || a.this.cKV.length <= 0) {
                if (TextUtils.isEmpty(a.this.cKU) || !cL) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.cKU);
                a.this.cKT = n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.cKT)) {
                    return null;
                }
                return a.this.a(a.this.cKT, this.cLb);
            }
            this.aAn = com.baidu.tbadk.core.util.c.N(a.this.cKV);
            if (this.aAn != null) {
                a.this.cKT = n.a(TbConfig.IMAGE_RESIZED_FILE, this.aAn, 80);
                if (TextUtils.isEmpty(a.this.cKT)) {
                    if (this.aAn == null || this.aAn.isRecycled()) {
                        return null;
                    }
                    this.aAn.recycle();
                    return null;
                }
                return a.this.a(a.this.cKT, this.cLb);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cLa = true;
            if (this.cLb != null) {
                this.cLb.cancel();
            }
            if (a.this.cKW != null) {
                a.this.cKW.a(null, true);
            }
            if (this.aAn != null && !this.aAn.isRecycled()) {
                this.aAn.recycle();
            }
            super.cancel();
            a.this.cKR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cLa) {
                if (a.this.cKW != null) {
                    a.this.cKW.a(imageUploadResult, false);
                }
                if (this.aAn != null && !this.aAn.isRecycled()) {
                    this.aAn.recycle();
                }
            }
        }
    }

    public void JZ() {
        if (this.cKR == null) {
            this.cKR = new C0074a();
            this.cKR.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.cKV = bArr;
        this.cKU = str;
    }

    public void a(b bVar) {
        this.cKW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(ar.uE().uK(), ar.uE().uK()));
        return aVar.b(imageFileInfo);
    }
}
