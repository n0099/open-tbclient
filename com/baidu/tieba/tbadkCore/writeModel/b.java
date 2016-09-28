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
import com.baidu.tbadk.core.util.ba;
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
    public static int fxW = 10;
    private final h<?> aSm;
    private WriteData flk;
    private e fxX;
    private a fxY;
    private String fxZ;
    private String fya;
    private byte[] fyb;
    private InterfaceC0083b fyc;
    private c fyd;
    private d fye;
    private boolean fyf;
    private a.InterfaceC0078a fyg;

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
        this.fxX = null;
        this.fxY = null;
        this.flk = null;
        this.fxZ = null;
        this.fya = null;
        this.fyb = null;
        this.fyd = null;
        this.fye = null;
        this.fyf = false;
        this.aSm = baseActivity.getPageContext();
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fxX = null;
        this.fxY = null;
        this.flk = null;
        this.fxZ = null;
        this.fya = null;
        this.fyb = null;
        this.fyd = null;
        this.fye = null;
        this.fyf = false;
        this.aSm = tbPageContext;
    }

    public void kQ(boolean z) {
        this.fyf = z;
    }

    public void b(d dVar) {
        this.fye = dVar;
    }

    public void a(c cVar) {
        this.fyd = cVar;
    }

    public void a(a.InterfaceC0078a interfaceC0078a) {
        this.fyg = interfaceC0078a;
    }

    public void d(WriteData writeData) {
        this.flk = writeData;
    }

    public WriteData bfE() {
        return this.flk;
    }

    public boolean bkY() {
        if (this.flk == null) {
            return false;
        }
        if (!i.gm() || i.gn() || this.flk.getWriteImagesInfo() == null || this.flk.getWriteImagesInfo().size() == 0 || !this.flk.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("original_img_up_tip", false)) {
            bkZ();
        } else {
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSm.getPageActivity());
            aVar.bZ(r.j.original_img_up_no_wifi_tip);
            aVar.a(r.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(r.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.d(this, aVar));
            aVar.b(this.aSm);
            aVar.tm();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        if (this.fxX == null) {
            this.fxX = new e();
            this.fxX.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fxX != null && !this.fxX.isCancelled()) {
            this.fxX.cancel();
        } else if (this.fye != null) {
            this.fye.callback(false, null, null, null, null);
        } else if (this.fyd != null) {
            this.fyd.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.fxX != null && !this.fxX.isCancelled()) {
            this.fxX.cancel();
            return false;
        }
        return false;
    }

    public void bla() {
        if (this.fxY != null && !this.fxY.isCancelled()) {
            this.fxY.cancel();
        }
    }

    public boolean blb() {
        if (this.flk == null) {
            return true;
        }
        int size = (!this.flk.getIsBaobao() || this.flk.getBaobaoImagesInfo() == null) ? 0 : this.flk.getBaobaoImagesInfo().size() + 0;
        if (this.flk.getWriteImagesInfo() != null) {
            size += this.flk.getWriteImagesInfo().size();
        }
        return size <= fxW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.e> {
        private com.baidu.tieba.tbadkCore.c.a fyi = null;
        private String fyj = null;
        private boolean cza = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
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
            if (this.cza) {
                return null;
            }
            this.fyi = new com.baidu.tieba.tbadkCore.c.a();
            this.fyi.a(b.this.fyg);
            this.fyj = this.fyi.a(b.this.flk, b.this.fyf);
            ErrorData bki = this.fyi.bki();
            if (this.fyi.oF() && this.fyj != null) {
                AntiData bkh = this.fyi.bkh();
                String error_msg = bki.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(r.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.e eVar2 = new com.baidu.tieba.tbadkCore.writeModel.e(bki.getError_code(), error_msg, bkh);
                if (b.this.flk == null || (!(b.this.flk.isHasImages() || b.this.flk.getIsBaobao()) || eVar2.hasError())) {
                    eVar = eVar2;
                } else {
                    b.this.flk.deleteUploadedTempImages();
                    eVar = eVar2;
                }
            } else if (bki != null && !StringUtils.isNull(bki.getError_msg())) {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(bki.getError_code(), bki.getError_msg(), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(-17, TbadkCoreApplication.m9getInst().getApp().getString(r.j.neterror), null);
            }
            if (!eVar.hasError()) {
                try {
                    if (this.fyj != null) {
                        JSONObject jSONObject = new JSONObject(this.fyj);
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
                                            JSONObject optJSONObject = new JSONObject(this.fyj).optJSONObject("twzhibo_info");
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
            b.this.fxX = null;
            if (eVar != null && eVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", eVar.getErrorCode(), eVar.getErrorString(), "tid", eVar.getThreadId(), Info.kBaiduPIDKey, eVar.getPostId());
            }
            if (!this.cza && eVar != null) {
                if (!eVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(b.this.flk);
                    if (b.this.flk != null && b.this.flk.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.bjd();
                    }
                    if (b.this.fye == null) {
                        if (b.this.fyd != null) {
                            b.this.fyd.a(true, eVar.getErrorString(), null, null, eVar.getAntiData());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), eVar.getPreMsg(), eVar.getColorMsg());
                        postWriteCallBackData.setThreadId(eVar.getThreadId());
                        postWriteCallBackData.setPostId(eVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(eVar.getIsCopyTWZhibo());
                        s sVar = new s();
                        sVar.parserJson(this.fyj);
                        b.this.fye.callback(true, postWriteCallBackData, sVar, b.this.flk, eVar.getAntiData());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(eVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cza = true;
            if (this.fyi != null) {
                this.fyi.cancel();
            }
            if (b.this.fye == null) {
                if (b.this.fyd != null) {
                    b.this.fyd.a(false, null, null, null, null);
                }
            } else {
                b.this.fye.callback(false, null, null, null, null);
            }
            super.cancel(true);
            b.this.fxX = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.e eVar) {
            AntiData antiData = eVar.getAntiData();
            if (eVar.blc()) {
                s sVar = new s();
                sVar.parserJson(this.fyj);
                if (sVar.getVcode_pic_url() != null && b.this.flk != null) {
                    b.this.flk.setVcodeMD5(sVar.getVcode_md5());
                    b.this.flk.setVcodeUrl(sVar.getVcode_pic_url());
                    if (b.this.fye == null) {
                        if (b.this.fyd != null) {
                            b.this.fyd.a(false, eVar.getErrorString(), sVar, b.this.flk, antiData);
                            return;
                        }
                        return;
                    }
                    b.this.fye.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), sVar, b.this.flk, antiData);
                }
            } else if (!eVar.bld()) {
                if (b.this.fye == null) {
                    if (b.this.fyd != null) {
                        b.this.fyd.a(false, eVar.getErrorString(), null, null, eVar.getAntiData());
                        return;
                    }
                    return;
                }
                b.this.fye.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), null, null, eVar.getAntiData());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.fyj);
                if (b.this.fye == null) {
                    if (b.this.fyd != null) {
                        b.this.fyd.a(false, eVar.getErrorString(), null, b.this.flk, antiData);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                b.this.fye.callback(false, postWriteCallBackData, null, b.this.flk, antiData);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cza = false;
        com.baidu.tieba.tbadkCore.c.a fyi = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aFx = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean dh = m.dh(b.this.fya);
            if (this.cza) {
                return null;
            }
            if (b.this.fyb == null || b.this.fyb.length <= 0) {
                if (TextUtils.isEmpty(b.this.fya) || !dh) {
                    return null;
                }
                Uri parse = Uri.parse(b.this.fya);
                b.this.fxZ = m.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(b.this.fxZ)) {
                    return null;
                }
                return b.this.a(b.this.fxZ, this.fyi);
            }
            this.aFx = BitmapHelper.Bytes2Bitmap(b.this.fyb);
            if (this.aFx != null) {
                b.this.fxZ = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aFx, 80);
                if (TextUtils.isEmpty(b.this.fxZ)) {
                    if (this.aFx == null || this.aFx.isRecycled()) {
                        return null;
                    }
                    this.aFx.recycle();
                    return null;
                }
                return b.this.a(b.this.fxZ, this.fyi);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cza = true;
            if (this.fyi != null) {
                this.fyi.cancel();
            }
            if (b.this.fyc != null) {
                b.this.fyc.a(null, true);
            }
            if (this.aFx != null && !this.aFx.isRecycled()) {
                this.aFx.recycle();
            }
            super.cancel();
            b.this.fxY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cza) {
                if (b.this.fyc != null) {
                    b.this.fyc.a(imageUploadResult, false);
                }
                if (this.aFx != null && !this.aFx.isRecycled()) {
                    this.aFx.recycle();
                }
            }
        }
    }

    public void ZE() {
        if (this.fxY == null) {
            this.fxY = new a();
            this.fxY.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fyb = bArr;
        this.fya = str;
    }

    public void a(InterfaceC0083b interfaceC0083b) {
        this.fyc = interfaceC0083b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.F(ba.vy().vE(), ba.vy().vE()));
        return aVar.d(imageFileInfo, true);
    }
}
