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
    public static int ddF = 10;
    private final h<?> ciS;
    private e ddG;
    private C0079a ddH;
    private WriteData ddI;
    private String ddJ;
    private String ddK;
    private byte[] ddL;
    private b ddM;
    private c ddN;
    private d ddO;
    private boolean ddP;

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
        this.ddG = null;
        this.ddH = null;
        this.ddI = null;
        this.ddJ = null;
        this.ddK = null;
        this.ddL = null;
        this.ddN = null;
        this.ddO = null;
        this.ddP = false;
        this.ciS = baseActivity.getPageContext();
    }

    public void gC(boolean z) {
        this.ddP = z;
    }

    public void b(d dVar) {
        this.ddO = dVar;
    }

    public void a(c cVar) {
        this.ddN = cVar;
    }

    public void c(WriteData writeData) {
        this.ddI = writeData;
    }

    public WriteData ayT() {
        return this.ddI;
    }

    public boolean ayU() {
        if (this.ddI == null) {
            return false;
        }
        if (!i.iN() || i.iO() || com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("original_img_up_tip", false)) {
            ayV();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ciS.getPageActivity());
            aVar.bF(i.h.original_img_up_no_wifi_tip);
            aVar.a(i.h.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(i.h.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.ciS);
            aVar.sR();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayV() {
        if (this.ddG == null) {
            this.ddG = new e();
            this.ddG.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.ddG != null && !this.ddG.isCancelled()) {
            this.ddG.cancel();
        } else if (this.ddO != null) {
            this.ddO.a(false, null, null, null, null);
        } else if (this.ddN != null) {
            this.ddN.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.ddG != null && !this.ddG.isCancelled()) {
            this.ddG.cancel();
            return false;
        }
        return false;
    }

    public void ayW() {
        if (this.ddH != null && !this.ddH.isCancelled()) {
            this.ddH.cancel();
        }
    }

    public boolean ayX() {
        if (this.ddI == null) {
            return true;
        }
        int size = (!this.ddI.getIsBaobao() || this.ddI.getBaobaoImagesInfo() == null) ? 0 : this.ddI.getBaobaoImagesInfo().size() + 0;
        if (this.ddI.getWriteImagesInfo() != null) {
            size += this.ddI.getWriteImagesInfo().size();
        }
        return size <= ddF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.d.a ddS = null;
        private String ddT = null;
        private boolean ddR = false;

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
            if (this.ddR) {
                return null;
            }
            this.ddS = new com.baidu.tieba.tbadkCore.d.a();
            this.ddT = this.ddS.a(a.this.ddI, a.this.ddP);
            ErrorData axJ = this.ddS.axJ();
            if (this.ddS.qT() && this.ddT != null) {
                AntiData axI = this.ddS.axI();
                String error_msg = axJ.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(axJ.getError_code(), error_msg, axI);
                if (a.this.ddI == null || (!(a.this.ddI.isHasImages() || a.this.ddI.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.ddI.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (axJ != null && !StringUtils.isNull(axJ.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(axJ.getError_code(), axJ.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    String optString2 = new JSONObject(this.ddT).optString(AddFriendActivityConfig.MSG);
                    try {
                        String optString3 = new JSONObject(this.ddT).optString("pre_msg");
                        try {
                            String optString4 = new JSONObject(this.ddT).optString("color_msg");
                            try {
                                optString = new JSONObject(this.ddT).optString("tid");
                            } catch (JSONException e) {
                                str = optString4;
                                str2 = optString3;
                                str3 = optString2;
                                jSONException = e;
                                str4 = null;
                            }
                            try {
                                str6 = new JSONObject(this.ddT).optString(Info.kBaiduPIDKey);
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
            a.this.ddG = null;
            if (!this.ddR && dVar != null) {
                if (!dVar.hasError()) {
                    if (a.this.ddI != null && a.this.ddI.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awN();
                    }
                    if (a.this.ddO == null) {
                        if (a.this.ddN != null) {
                            a.this.ddN.a(true, dVar.getErrorString(), null, null, dVar.afA());
                            return;
                        }
                        return;
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    a.this.ddO.a(true, postWriteCallBackData, null, null, dVar.afA());
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.ddR = true;
            if (this.ddS != null) {
                this.ddS.cancel();
            }
            if (a.this.ddO == null) {
                if (a.this.ddN != null) {
                    a.this.ddN.a(false, null, null, null, null);
                }
            } else {
                a.this.ddO.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.ddG = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData afA = dVar.afA();
            if (!dVar.ayY()) {
                if (a.this.ddO == null) {
                    if (a.this.ddN != null) {
                        a.this.ddN.a(false, dVar.getErrorString(), null, null, dVar.afA());
                        return;
                    }
                    return;
                }
                a.this.ddO.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.afA());
                return;
            }
            l lVar = new l();
            lVar.parserJson(this.ddT);
            if (lVar.getVcode_pic_url() != null && a.this.ddI != null) {
                a.this.ddI.setVcodeMD5(lVar.getVcode_md5());
                a.this.ddI.setVcodeUrl(lVar.getVcode_pic_url());
                if (a.this.ddO == null) {
                    if (a.this.ddN != null) {
                        a.this.ddN.a(false, dVar.getErrorString(), lVar, a.this.ddI, afA);
                        return;
                    }
                    return;
                }
                a.this.ddO.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), lVar, a.this.ddI, afA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean ddR = false;
        com.baidu.tieba.tbadkCore.d.a ddS = new com.baidu.tieba.tbadkCore.d.a();
        Bitmap azy = null;

        public C0079a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean cU = n.cU(a.this.ddK);
            if (this.ddR) {
                return null;
            }
            if (a.this.ddL == null || a.this.ddL.length <= 0) {
                if (TextUtils.isEmpty(a.this.ddK) || !cU) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.ddK);
                a.this.ddJ = n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.ddJ)) {
                    return null;
                }
                return a.this.a(a.this.ddJ, this.ddS);
            }
            this.azy = com.baidu.tbadk.core.util.c.N(a.this.ddL);
            if (this.azy != null) {
                a.this.ddJ = n.a(TbConfig.IMAGE_RESIZED_FILE, this.azy, 80);
                if (TextUtils.isEmpty(a.this.ddJ)) {
                    if (this.azy == null || this.azy.isRecycled()) {
                        return null;
                    }
                    this.azy.recycle();
                    return null;
                }
                return a.this.a(a.this.ddJ, this.ddS);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.ddR = true;
            if (this.ddS != null) {
                this.ddS.cancel();
            }
            if (a.this.ddM != null) {
                a.this.ddM.a(null, true);
            }
            if (this.azy != null && !this.azy.isRecycled()) {
                this.azy.recycle();
            }
            super.cancel();
            a.this.ddH = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.ddR) {
                if (a.this.ddM != null) {
                    a.this.ddM.a(imageUploadResult, false);
                }
                if (this.azy != null && !this.azy.isRecycled()) {
                    this.azy.recycle();
                }
            }
        }
    }

    public void JU() {
        if (this.ddH == null) {
            this.ddH = new C0079a();
            this.ddH.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.ddL = bArr;
        this.ddK = str;
    }

    public void a(b bVar) {
        this.ddM = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.J(at.uK().uQ(), at.uK().uQ()));
        return aVar.b(imageFileInfo);
    }
}
