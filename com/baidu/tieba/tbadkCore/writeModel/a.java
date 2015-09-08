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
    public static int cTp = 10;
    private e cTq;
    private C0076a cTr;
    private WriteData cTs;
    private String cTt;
    private String cTu;
    private byte[] cTv;
    private b cTw;
    private c cTx;
    private d cTy;
    private boolean cTz;

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
        this.cTq = null;
        this.cTr = null;
        this.cTs = null;
        this.cTt = null;
        this.cTu = null;
        this.cTv = null;
        this.cTx = null;
        this.cTy = null;
        this.cTz = false;
    }

    public void gm(boolean z) {
        this.cTz = z;
    }

    public void b(d dVar) {
        this.cTy = dVar;
    }

    public void a(c cVar) {
        this.cTx = cVar;
    }

    public void c(WriteData writeData) {
        this.cTs = writeData;
    }

    public WriteData avr() {
        return this.cTs;
    }

    public boolean avs() {
        if (this.cTs == null) {
            return false;
        }
        if (this.cTq == null) {
            this.cTq = new e();
            this.cTq.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cTq != null && !this.cTq.isCancelled()) {
            this.cTq.cancel();
            return false;
        }
        return false;
    }

    public void avt() {
        if (this.cTr != null && !this.cTr.isCancelled()) {
            this.cTr.cancel();
        }
    }

    public boolean avu() {
        if (this.cTs == null) {
            return true;
        }
        int size = (!this.cTs.getIsBaobao() || this.cTs.getBaobaoImagesInfo() == null) ? 0 : this.cTs.getBaobaoImagesInfo().size() + 0;
        if (this.cTs.getWriteImagesInfo() != null) {
            size += this.cTs.getWriteImagesInfo().size();
        }
        return size <= cTp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tieba.tbadkCore.d.a cTB = null;
        private String cTD = null;
        private boolean cTA = false;

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
            if (this.cTA) {
                return null;
            }
            this.cTB = new com.baidu.tieba.tbadkCore.d.a();
            this.cTD = this.cTB.a(a.this.cTs, a.this.cTz);
            ErrorData auy = this.cTB.auy();
            if (this.cTB.qZ() && this.cTD != null) {
                AntiData aux = this.cTB.aux();
                String error_msg = auy.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(auy.getError_code(), error_msg, aux);
                if (a.this.cTs == null || (!(a.this.cTs.isHasImages() || a.this.cTs.getIsBaobao()) || bVar2.hasError())) {
                    bVar = bVar2;
                } else {
                    a.this.cTs.deleteUploadedTempImages();
                    bVar = bVar2;
                }
            } else if (auy != null && !StringUtils.isNull(auy.getError_msg())) {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(auy.getError_code(), auy.getError_msg(), null);
            } else {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(-17, TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror), null);
            }
            if (!bVar.hasError()) {
                try {
                    String optString2 = new JSONObject(this.cTD).optString(AddFriendActivityConfig.MSG);
                    try {
                        String optString3 = new JSONObject(this.cTD).optString("pre_msg");
                        try {
                            String optString4 = new JSONObject(this.cTD).optString("color_msg");
                            try {
                                optString = new JSONObject(this.cTD).optString("tid");
                            } catch (JSONException e) {
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                                jSONException = e;
                                str4 = null;
                            }
                            try {
                                str6 = new JSONObject(this.cTD).optString(Info.kBaiduPIDKey);
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
                    str3 = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
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
            a.this.cTq = null;
            if (!this.cTA && bVar != null) {
                if (!bVar.hasError()) {
                    if (a.this.cTs != null && a.this.cTs.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.atL();
                    }
                    if (a.this.cTy == null) {
                        if (a.this.cTx != null) {
                            a.this.cTx.a(true, bVar.getErrorString(), null, null, bVar.adj());
                            return;
                        }
                        return;
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), bVar.getPreMsg(), bVar.getColorMsg());
                    postWriteCallBackData.setThreadId(bVar.getThreadId());
                    postWriteCallBackData.setPostId(bVar.getPostId());
                    a.this.cTy.a(true, postWriteCallBackData, null, null, bVar.adj());
                    return;
                }
                b(bVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cTA = true;
            if (this.cTB != null) {
                this.cTB.cancel();
            }
            if (a.this.cTy == null) {
                if (a.this.cTx != null) {
                    a.this.cTx.a(false, null, null, null, null);
                }
            } else {
                a.this.cTy.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.cTq = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            AntiData adj = bVar.adj();
            if (!bVar.avv()) {
                if (a.this.cTy == null) {
                    if (a.this.cTx != null) {
                        a.this.cTx.a(false, bVar.getErrorString(), null, null, bVar.adj());
                        return;
                    }
                    return;
                }
                a.this.cTy.a(false, new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null), null, null, bVar.adj());
                return;
            }
            l lVar = new l();
            lVar.parserJson(this.cTD);
            if (lVar.getVcode_pic_url() != null && a.this.cTs != null) {
                a.this.cTs.setVcodeMD5(lVar.getVcode_md5());
                a.this.cTs.setVcodeUrl(lVar.getVcode_pic_url());
                if (a.this.cTy == null) {
                    if (a.this.cTx != null) {
                        a.this.cTx.a(false, bVar.getErrorString(), lVar, a.this.cTs, adj);
                        return;
                    }
                    return;
                }
                a.this.cTy.a(false, new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), null, null), lVar, a.this.cTs, adj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cTA = false;
        com.baidu.tieba.tbadkCore.d.a cTB = new com.baidu.tieba.tbadkCore.d.a();
        Bitmap aBV = null;

        public C0076a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean cR = n.cR(a.this.cTu);
            if (this.cTA) {
                return null;
            }
            if (a.this.cTv == null || a.this.cTv.length <= 0) {
                if (TextUtils.isEmpty(a.this.cTu) || !cR) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.cTu);
                a.this.cTt = n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.cTt)) {
                    return null;
                }
                return a.this.a(a.this.cTt, this.cTB);
            }
            this.aBV = com.baidu.tbadk.core.util.c.N(a.this.cTv);
            if (this.aBV != null) {
                a.this.cTt = n.a(TbConfig.IMAGE_RESIZED_FILE, this.aBV, 80);
                if (TextUtils.isEmpty(a.this.cTt)) {
                    if (this.aBV == null || this.aBV.isRecycled()) {
                        return null;
                    }
                    this.aBV.recycle();
                    return null;
                }
                return a.this.a(a.this.cTt, this.cTB);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cTA = true;
            if (this.cTB != null) {
                this.cTB.cancel();
            }
            if (a.this.cTw != null) {
                a.this.cTw.a(null, true);
            }
            if (this.aBV != null && !this.aBV.isRecycled()) {
                this.aBV.recycle();
            }
            super.cancel();
            a.this.cTr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cTA) {
                if (a.this.cTw != null) {
                    a.this.cTw.a(imageUploadResult, false);
                }
                if (this.aBV != null && !this.aBV.isRecycled()) {
                    this.aBV.recycle();
                }
            }
        }
    }

    public void JN() {
        if (this.cTr == null) {
            this.cTr = new C0076a();
            this.cTr.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.cTv = bArr;
        this.cTu = str;
    }

    public void a(b bVar) {
        this.cTw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(ar.uK().uQ(), ar.uK().uQ()));
        return aVar.b(imageFileInfo);
    }
}
