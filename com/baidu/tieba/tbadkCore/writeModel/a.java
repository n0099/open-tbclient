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
    public static int dJv = 10;
    private final h<?> cET;
    private String dJA;
    private byte[] dJB;
    private b dJC;
    private c dJD;
    private d dJE;
    private boolean dJF;
    private e dJw;
    private C0084a dJx;
    private WriteData dJy;
    private String dJz;

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
        this.dJw = null;
        this.dJx = null;
        this.dJy = null;
        this.dJz = null;
        this.dJA = null;
        this.dJB = null;
        this.dJD = null;
        this.dJE = null;
        this.dJF = false;
        this.cET = baseActivity.getPageContext();
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dJw = null;
        this.dJx = null;
        this.dJy = null;
        this.dJz = null;
        this.dJA = null;
        this.dJB = null;
        this.dJD = null;
        this.dJE = null;
        this.dJF = false;
        this.cET = tbPageContext;
    }

    public void hw(boolean z) {
        this.dJF = z;
    }

    public void b(d dVar) {
        this.dJE = dVar;
    }

    public void a(c cVar) {
        this.dJD = cVar;
    }

    public void c(WriteData writeData) {
        this.dJy = writeData;
    }

    public WriteData aGz() {
        return this.dJy;
    }

    public boolean aGA() {
        if (this.dJy == null) {
            return false;
        }
        if (!i.iQ() || i.iR() || this.dJy.getWriteImagesInfo() == null || this.dJy.getWriteImagesInfo().size() == 0 || !this.dJy.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("original_img_up_tip", false)) {
            aGB();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cET.getPageActivity());
            aVar.bG(n.j.original_img_up_no_wifi_tip);
            aVar.a(n.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.b(this, aVar));
            aVar.b(n.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(this.cET);
            aVar.tf();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGB() {
        if (this.dJw == null) {
            this.dJw = new e();
            this.dJw.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.dJw != null && !this.dJw.isCancelled()) {
            this.dJw.cancel();
        } else if (this.dJE != null) {
            this.dJE.a(false, null, null, null, null);
        } else if (this.dJD != null) {
            this.dJD.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.dJw != null && !this.dJw.isCancelled()) {
            this.dJw.cancel();
            return false;
        }
        return false;
    }

    public void aGC() {
        if (this.dJx != null && !this.dJx.isCancelled()) {
            this.dJx.cancel();
        }
    }

    public boolean aGD() {
        if (this.dJy == null) {
            return true;
        }
        int size = (!this.dJy.getIsBaobao() || this.dJy.getBaobaoImagesInfo() == null) ? 0 : this.dJy.getBaobaoImagesInfo().size() + 0;
        if (this.dJy.getWriteImagesInfo() != null) {
            size += this.dJy.getWriteImagesInfo().size();
        }
        return size <= dJv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tieba.tbadkCore.c.a dJI = null;
        private String dJJ = null;
        private boolean dJH = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
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
            if (this.dJH) {
                return null;
            }
            this.dJI = new com.baidu.tieba.tbadkCore.c.a();
            this.dJJ = this.dJI.a(a.this.dJy, a.this.dJF);
            ErrorData aFH = this.dJI.aFH();
            if (this.dJI.qO() && this.dJJ != null) {
                AntiData aFG = this.dJI.aFG();
                String error_msg = aFH.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getApp().getString(n.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(aFH.getError_code(), error_msg, aFG);
                if (a.this.dJy == null || (!(a.this.dJy.isHasImages() || a.this.dJy.getIsBaobao()) || dVar2.hasError())) {
                    dVar = dVar2;
                } else {
                    a.this.dJy.deleteUploadedTempImages();
                    dVar = dVar2;
                }
            } else if (aFH != null && !StringUtils.isNull(aFH.getError_msg())) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(aFH.getError_code(), aFH.getError_msg(), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(-17, TbadkCoreApplication.m411getInst().getApp().getString(n.j.neterror), null);
            }
            if (!dVar.hasError()) {
                try {
                    if (this.dJJ != null) {
                        JSONObject jSONObject = new JSONObject(this.dJJ);
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
                                            JSONObject optJSONObject = new JSONObject(this.dJJ).optJSONObject("twzhibo_info");
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
                    str3 = TbadkCoreApplication.m411getInst().getString(n.j.send_success);
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
            a.this.dJw = null;
            if (!this.dJH && dVar != null) {
                if (!dVar.hasError()) {
                    if (a.this.dJy != null && a.this.dJy.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aEG();
                    }
                    if (a.this.dJE == null) {
                        if (a.this.dJD != null) {
                            a.this.dJD.a(true, dVar.getErrorString(), null, null, dVar.ala());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        postWriteCallBackData.setThreadId(dVar.getThreadId());
                        postWriteCallBackData.setPostId(dVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                        a.this.dJE.a(true, postWriteCallBackData, null, null, dVar.ala());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(dVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dJH = true;
            if (this.dJI != null) {
                this.dJI.cancel();
            }
            if (a.this.dJE == null) {
                if (a.this.dJD != null) {
                    a.this.dJD.a(false, null, null, null, null);
                }
            } else {
                a.this.dJE.a(false, null, null, null, null);
            }
            super.cancel(true);
            a.this.dJw = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            AntiData ala = dVar.ala();
            if (!dVar.aGE()) {
                if (a.this.dJE == null) {
                    if (a.this.dJD != null) {
                        a.this.dJD.a(false, dVar.getErrorString(), null, null, dVar.ala());
                        return;
                    }
                    return;
                }
                a.this.dJE.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), null, null, dVar.ala());
                return;
            }
            com.baidu.tbadk.coreExtra.data.n nVar = new com.baidu.tbadk.coreExtra.data.n();
            nVar.parserJson(this.dJJ);
            if (nVar.getVcode_pic_url() != null && a.this.dJy != null) {
                a.this.dJy.setVcodeMD5(nVar.getVcode_md5());
                a.this.dJy.setVcodeUrl(nVar.getVcode_pic_url());
                if (a.this.dJE == null) {
                    if (a.this.dJD != null) {
                        a.this.dJD.a(false, dVar.getErrorString(), nVar, a.this.dJy, ala);
                        return;
                    }
                    return;
                }
                a.this.dJE.a(false, new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), null, null), nVar, a.this.dJy, ala);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0084a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean dJH = false;
        com.baidu.tieba.tbadkCore.c.a dJI = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aDl = null;

        public C0084a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean df = com.baidu.tbadk.core.util.n.df(a.this.dJA);
            if (this.dJH) {
                return null;
            }
            if (a.this.dJB == null || a.this.dJB.length <= 0) {
                if (TextUtils.isEmpty(a.this.dJA) || !df) {
                    return null;
                }
                Uri parse = Uri.parse(a.this.dJA);
                a.this.dJz = com.baidu.tbadk.core.util.n.a(TbadkCoreApplication.m411getInst().getApp(), parse);
                if (TextUtils.isEmpty(a.this.dJz)) {
                    return null;
                }
                return a.this.a(a.this.dJz, this.dJI);
            }
            this.aDl = com.baidu.tbadk.core.util.c.N(a.this.dJB);
            if (this.aDl != null) {
                a.this.dJz = com.baidu.tbadk.core.util.n.a(TbConfig.IMAGE_RESIZED_FILE, this.aDl, 80);
                if (TextUtils.isEmpty(a.this.dJz)) {
                    if (this.aDl == null || this.aDl.isRecycled()) {
                        return null;
                    }
                    this.aDl.recycle();
                    return null;
                }
                return a.this.a(a.this.dJz, this.dJI);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.dJH = true;
            if (this.dJI != null) {
                this.dJI.cancel();
            }
            if (a.this.dJC != null) {
                a.this.dJC.a(null, true);
            }
            if (this.aDl != null && !this.aDl.isRecycled()) {
                this.aDl.recycle();
            }
            super.cancel();
            a.this.dJx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.dJH) {
                if (a.this.dJC != null) {
                    a.this.dJC.a(imageUploadResult, false);
                }
                if (this.aDl != null && !this.aDl.isRecycled()) {
                    this.aDl.recycle();
                }
            }
        }
    }

    public void LH() {
        if (this.dJx == null) {
            this.dJx = new C0084a();
            this.dJx.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.dJB = bArr;
        this.dJA = str;
    }

    public void a(b bVar) {
        this.dJC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.K(ay.va().vg(), ay.va().vg()));
        return aVar.d(imageFileInfo, true);
    }
}
