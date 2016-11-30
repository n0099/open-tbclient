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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    public static int fFw = 10;
    private final h<?> aUn;
    private String fFA;
    private byte[] fFB;
    private InterfaceC0083b fFC;
    private c fFD;
    private d fFE;
    private boolean fFF;
    private a.InterfaceC0079a fFG;
    private e fFx;
    private a fFy;
    private String fFz;
    private WriteData fst;

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083b {
        void a(ImageUploadResult imageUploadResult, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, String str, s sVar, WriteData writeData, AntiData antiData);
    }

    /* loaded from: classes.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData);
    }

    public b(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fFx = null;
        this.fFy = null;
        this.fst = null;
        this.fFz = null;
        this.fFA = null;
        this.fFB = null;
        this.fFD = null;
        this.fFE = null;
        this.fFF = false;
        this.aUn = baseActivity.getPageContext();
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fFx = null;
        this.fFy = null;
        this.fst = null;
        this.fFz = null;
        this.fFA = null;
        this.fFB = null;
        this.fFD = null;
        this.fFE = null;
        this.fFF = false;
        this.aUn = tbPageContext;
    }

    public void lp(boolean z) {
        this.fFF = z;
    }

    public void b(d dVar) {
        this.fFE = dVar;
    }

    public void a(c cVar) {
        this.fFD = cVar;
    }

    public void a(a.InterfaceC0079a interfaceC0079a) {
        this.fFG = interfaceC0079a;
    }

    public void d(WriteData writeData) {
        this.fst = writeData;
    }

    public WriteData bia() {
        return this.fst;
    }

    public boolean bno() {
        if (this.fst == null) {
            return false;
        }
        if (!i.gm() || i.gn() || this.fst.getWriteImagesInfo() == null || this.fst.getWriteImagesInfo().size() == 0 || !this.fst.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.um().getBoolean("original_img_up_tip", false)) {
            bnp();
        } else {
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aUn.getPageActivity());
            aVar.ca(r.j.original_img_up_no_wifi_tip);
            aVar.a(r.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(r.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.d(this, aVar));
            aVar.b(this.aUn);
            aVar.tq();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnp() {
        if (this.fFx == null) {
            this.fFx = new e();
            this.fFx.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fFx != null && !this.fFx.isCancelled()) {
            this.fFx.cancel();
        } else if (this.fFE != null) {
            this.fFE.callback(false, null, null, null, null);
        } else if (this.fFD != null) {
            this.fFD.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.fFx != null && !this.fFx.isCancelled()) {
            this.fFx.cancel();
            return false;
        }
        return false;
    }

    public void bnq() {
        if (this.fFy != null && !this.fFy.isCancelled()) {
            this.fFy.cancel();
        }
    }

    public boolean bnr() {
        if (this.fst == null) {
            return true;
        }
        return (this.fst.getWriteImagesInfo() != null ? this.fst.getWriteImagesInfo().size() + 0 : 0) <= fFw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.e> {
        private com.baidu.tieba.tbadkCore.c.a fFI = null;
        private String fFJ = null;
        private boolean cEk = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.e doInBackground(Integer... numArr) {
            com.baidu.tieba.tbadkCore.writeModel.e eVar;
            JSONException jSONException;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int i;
            String str6 = null;
            if (this.cEk) {
                return null;
            }
            this.fFI = new com.baidu.tieba.tbadkCore.c.a();
            this.fFI.a(b.this.fFG);
            this.fFJ = this.fFI.a(b.this.fst, b.this.fFF);
            ErrorData bmy = this.fFI.bmy();
            if (this.fFI.oH() && this.fFJ != null) {
                AntiData bmx = this.fFI.bmx();
                String error_msg = bmy.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(r.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.e eVar2 = new com.baidu.tieba.tbadkCore.writeModel.e(bmy.getError_code(), error_msg, bmx);
                if (b.this.fst == null || !b.this.fst.isHasImages() || eVar2.hasError()) {
                    eVar = eVar2;
                } else {
                    b.this.fst.deleteUploadedTempImages();
                    eVar = eVar2;
                }
            } else if (bmy != null && !StringUtils.isNull(bmy.getError_msg())) {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(bmy.getError_code(), bmy.getError_msg(), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(-17, TbadkCoreApplication.m9getInst().getApp().getString(r.j.neterror), null);
            }
            if (!eVar.hasError()) {
                try {
                    if (this.fFJ != null) {
                        JSONObject jSONObject = new JSONObject(this.fFJ);
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
                                            JSONObject optJSONObject = new JSONObject(this.fFJ).optJSONObject("twzhibo_info");
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
                                            eVar.setErrorString(str3);
                                            eVar.setPreMsg(str2);
                                            eVar.setColorMsg(str);
                                            eVar.setThreadId(str6);
                                            eVar.setPostId(str5);
                                            eVar.setIsCopyTWZhibo(i);
                                            return eVar;
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
                    str3 = TbadkCoreApplication.m9getInst().getString(r.j.send_success);
                }
                eVar.setErrorString(str3);
                eVar.setPreMsg(str2);
                eVar.setColorMsg(str);
                eVar.setThreadId(str6);
                eVar.setPostId(str5);
                eVar.setIsCopyTWZhibo(i);
            }
            return eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.e eVar) {
            super.onPostExecute(eVar);
            b.this.fFx = null;
            if (eVar != null && eVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", eVar.getErrorCode(), eVar.getErrorString(), "tid", eVar.getThreadId(), Info.kBaiduPIDKey, eVar.getPostId());
            }
            if (!this.cEk && eVar != null) {
                if (!eVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(b.this.fst);
                    if (b.this.fFE == null) {
                        if (b.this.fFD != null) {
                            b.this.fFD.a(true, eVar.getErrorString(), null, null, eVar.getAntiData());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), eVar.getPreMsg(), eVar.getColorMsg());
                        postWriteCallBackData.setThreadId(eVar.getThreadId());
                        postWriteCallBackData.setPostId(eVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(eVar.getIsCopyTWZhibo());
                        s sVar = new s();
                        sVar.parserJson(this.fFJ);
                        b.this.fFE.callback(true, postWriteCallBackData, sVar, b.this.fst, eVar.getAntiData());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(eVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cEk = true;
            if (this.fFI != null) {
                this.fFI.cancel();
            }
            if (b.this.fFE == null) {
                if (b.this.fFD != null) {
                    b.this.fFD.a(false, null, null, null, null);
                }
            } else {
                b.this.fFE.callback(false, null, null, null, null);
            }
            super.cancel(true);
            b.this.fFx = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.e eVar) {
            AntiData antiData = eVar.getAntiData();
            if (eVar.bns()) {
                s sVar = new s();
                sVar.parserJson(this.fFJ);
                if (sVar.getVcode_pic_url() != null && b.this.fst != null) {
                    b.this.fst.setVcodeMD5(sVar.getVcode_md5());
                    b.this.fst.setVcodeUrl(sVar.getVcode_pic_url());
                    if (b.this.fFE == null) {
                        if (b.this.fFD != null) {
                            b.this.fFD.a(false, eVar.getErrorString(), sVar, b.this.fst, antiData);
                            return;
                        }
                        return;
                    }
                    b.this.fFE.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), sVar, b.this.fst, antiData);
                }
            } else if (!eVar.bnt()) {
                if (b.this.fFE == null) {
                    if (b.this.fFD != null) {
                        b.this.fFD.a(false, eVar.getErrorString(), null, null, eVar.getAntiData());
                        return;
                    }
                    return;
                }
                b.this.fFE.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), null, null, eVar.getAntiData());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.fFJ);
                if (b.this.fFE == null) {
                    if (b.this.fFD != null) {
                        b.this.fFD.a(false, eVar.getErrorString(), null, b.this.fst, antiData);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                b.this.fFE.callback(false, postWriteCallBackData, null, b.this.fst, antiData);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cEk = false;
        com.baidu.tieba.tbadkCore.c.a fFI = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aGn = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dj = m.dj(b.this.fFA);
            if (this.cEk) {
                return null;
            }
            if (b.this.fFB == null || b.this.fFB.length <= 0) {
                if (TextUtils.isEmpty(b.this.fFA) || !dj) {
                    return null;
                }
                Uri parse = Uri.parse(b.this.fFA);
                b.this.fFz = m.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(b.this.fFz)) {
                    return null;
                }
                return b.this.a(b.this.fFz, this.fFI);
            }
            this.aGn = BitmapHelper.Bytes2Bitmap(b.this.fFB);
            if (this.aGn != null) {
                b.this.fFz = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aGn, 80);
                if (TextUtils.isEmpty(b.this.fFz)) {
                    if (this.aGn == null || this.aGn.isRecycled()) {
                        return null;
                    }
                    this.aGn.recycle();
                    return null;
                }
                return b.this.a(b.this.fFz, this.fFI);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cEk = true;
            if (this.fFI != null) {
                this.fFI.cancel();
            }
            if (b.this.fFC != null) {
                b.this.fFC.a(null, true);
            }
            if (this.aGn != null && !this.aGn.isRecycled()) {
                this.aGn.recycle();
            }
            super.cancel();
            b.this.fFy = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cEk) {
                if (b.this.fFC != null) {
                    b.this.fFC.a(imageUploadResult, false);
                }
                if (this.aGn != null && !this.aGn.isRecycled()) {
                    this.aGn.recycle();
                }
            }
        }
    }

    public void aaG() {
        if (this.fFy == null) {
            this.fFy = new a();
            this.fFy.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fFB = bArr;
        this.fFA = str;
    }

    public void a(InterfaceC0083b interfaceC0083b) {
        this.fFC = interfaceC0083b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.F(ay.vC().vI(), ay.vC().vI()));
        return aVar.d(imageFileInfo, true);
    }
}
