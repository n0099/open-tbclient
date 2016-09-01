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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    public static int fvp = 10;
    private final h<?> aRe;
    private WriteData fiE;
    private e fvq;
    private a fvr;
    private String fvs;
    private String fvt;
    private byte[] fvu;
    private InterfaceC0080b fvv;
    private c fvw;
    private d fvx;
    private boolean fvy;
    private a.InterfaceC0075a fvz;

    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080b {
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
        this.fvq = null;
        this.fvr = null;
        this.fiE = null;
        this.fvs = null;
        this.fvt = null;
        this.fvu = null;
        this.fvw = null;
        this.fvx = null;
        this.fvy = false;
        this.aRe = baseActivity.getPageContext();
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fvq = null;
        this.fvr = null;
        this.fiE = null;
        this.fvs = null;
        this.fvt = null;
        this.fvu = null;
        this.fvw = null;
        this.fvx = null;
        this.fvy = false;
        this.aRe = tbPageContext;
    }

    public void kN(boolean z) {
        this.fvy = z;
    }

    public void b(d dVar) {
        this.fvx = dVar;
    }

    public void a(c cVar) {
        this.fvw = cVar;
    }

    public void a(a.InterfaceC0075a interfaceC0075a) {
        this.fvz = interfaceC0075a;
    }

    public void d(WriteData writeData) {
        this.fiE = writeData;
    }

    public WriteData beT() {
        return this.fiE;
    }

    public boolean bkn() {
        if (this.fiE == null) {
            return false;
        }
        if (!i.gm() || i.gn() || this.fiE.getWriteImagesInfo() == null || this.fiE.getWriteImagesInfo().size() == 0 || !this.fiE.getWriteImagesInfo().isOriginalImg() || com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("original_img_up_tip", false)) {
            bko();
        } else {
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("original_img_up_tip", true);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRe.getPageActivity());
            aVar.bZ(t.j.original_img_up_no_wifi_tip);
            aVar.a(t.j.alert_yes_button, new com.baidu.tieba.tbadkCore.writeModel.c(this, aVar));
            aVar.b(t.j.alert_no_button, new com.baidu.tieba.tbadkCore.writeModel.d(this, aVar));
            aVar.b(this.aRe);
            aVar.sX();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
        if (this.fvq == null) {
            this.fvq = new e();
            this.fvq.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.fvq != null && !this.fvq.isCancelled()) {
            this.fvq.cancel();
        } else if (this.fvx != null) {
            this.fvx.callback(false, null, null, null, null);
        } else if (this.fvw != null) {
            this.fvw.a(false, null, null, null, null);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.fvq != null && !this.fvq.isCancelled()) {
            this.fvq.cancel();
            return false;
        }
        return false;
    }

    public void bkp() {
        if (this.fvr != null && !this.fvr.isCancelled()) {
            this.fvr.cancel();
        }
    }

    public boolean bkq() {
        if (this.fiE == null) {
            return true;
        }
        int size = (!this.fiE.getIsBaobao() || this.fiE.getBaobaoImagesInfo() == null) ? 0 : this.fiE.getBaobaoImagesInfo().size() + 0;
        if (this.fiE.getWriteImagesInfo() != null) {
            size += this.fiE.getWriteImagesInfo().size();
        }
        return size <= fvp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.e> {
        private com.baidu.tieba.tbadkCore.c.a fvB = null;
        private String fvC = null;
        private boolean cyw = false;

        public e() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
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
            if (this.cyw) {
                return null;
            }
            this.fvB = new com.baidu.tieba.tbadkCore.c.a();
            this.fvB.a(b.this.fvz);
            this.fvC = this.fvB.a(b.this.fiE, b.this.fvy);
            ErrorData bjw = this.fvB.bjw();
            if (this.fvB.oE() && this.fvC != null) {
                AntiData bjv = this.fvB.bjv();
                String error_msg = bjw.getError_msg();
                if (j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m9getInst().getApp().getString(t.j.send_success);
                }
                com.baidu.tieba.tbadkCore.writeModel.e eVar2 = new com.baidu.tieba.tbadkCore.writeModel.e(bjw.getError_code(), error_msg, bjv);
                if (b.this.fiE == null || (!(b.this.fiE.isHasImages() || b.this.fiE.getIsBaobao()) || eVar2.hasError())) {
                    eVar = eVar2;
                } else {
                    b.this.fiE.deleteUploadedTempImages();
                    eVar = eVar2;
                }
            } else if (bjw != null && !StringUtils.isNull(bjw.getError_msg())) {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(bjw.getError_code(), bjw.getError_msg(), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.writeModel.e(-17, TbadkCoreApplication.m9getInst().getApp().getString(t.j.neterror), null);
            }
            if (!eVar.hasError()) {
                try {
                    if (this.fvC != null) {
                        JSONObject jSONObject = new JSONObject(this.fvC);
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
                                            JSONObject optJSONObject = new JSONObject(this.fvC).optJSONObject("twzhibo_info");
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
                    str3 = TbadkCoreApplication.m9getInst().getString(t.j.send_success);
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
            b.this.fvq = null;
            if (eVar != null && eVar.getErrorCode() != 0) {
                com.baidu.tbadk.core.log.b.a("write", 0L, 0, "write_result", eVar.getErrorCode(), eVar.getErrorString(), "tid", eVar.getThreadId(), Info.kBaiduPIDKey, eVar.getPostId());
            }
            if (!this.cyw && eVar != null) {
                if (!eVar.hasError()) {
                    com.baidu.tieba.graffiti.d.b(b.this.fiE);
                    if (b.this.fiE != null && b.this.fiE.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.bis();
                    }
                    if (b.this.fvx == null) {
                        if (b.this.fvw != null) {
                            b.this.fvw.a(true, eVar.getErrorString(), null, null, eVar.getAntiData());
                        }
                    } else {
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), eVar.getPreMsg(), eVar.getColorMsg());
                        postWriteCallBackData.setThreadId(eVar.getThreadId());
                        postWriteCallBackData.setPostId(eVar.getPostId());
                        postWriteCallBackData.setIsCopyTWZhibo(eVar.getIsCopyTWZhibo());
                        s sVar = new s();
                        sVar.parserJson(this.fvC);
                        b.this.fvx.callback(true, postWriteCallBackData, sVar, b.this.fiE, eVar.getAntiData());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NEW_WRITE_POST_SUCCESS, true));
                    return;
                }
                b(eVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cyw = true;
            if (this.fvB != null) {
                this.fvB.cancel();
            }
            if (b.this.fvx == null) {
                if (b.this.fvw != null) {
                    b.this.fvw.a(false, null, null, null, null);
                }
            } else {
                b.this.fvx.callback(false, null, null, null, null);
            }
            super.cancel(true);
            b.this.fvq = null;
        }

        private void b(com.baidu.tieba.tbadkCore.writeModel.e eVar) {
            AntiData antiData = eVar.getAntiData();
            if (eVar.bkr()) {
                s sVar = new s();
                sVar.parserJson(this.fvC);
                if (sVar.getVcode_pic_url() != null && b.this.fiE != null) {
                    b.this.fiE.setVcodeMD5(sVar.getVcode_md5());
                    b.this.fiE.setVcodeUrl(sVar.getVcode_pic_url());
                    if (b.this.fvx == null) {
                        if (b.this.fvw != null) {
                            b.this.fvw.a(false, eVar.getErrorString(), sVar, b.this.fiE, antiData);
                            return;
                        }
                        return;
                    }
                    b.this.fvx.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), sVar, b.this.fiE, antiData);
                }
            } else if (!eVar.bks()) {
                if (b.this.fvx == null) {
                    if (b.this.fvw != null) {
                        b.this.fvw.a(false, eVar.getErrorString(), null, null, eVar.getAntiData());
                        return;
                    }
                    return;
                }
                b.this.fvx.callback(false, new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null), null, null, eVar.getAntiData());
            } else {
                AccessState accessState = new AccessState();
                accessState.parserJson(this.fvC);
                if (b.this.fvx == null) {
                    if (b.this.fvw != null) {
                        b.this.fvw.a(false, eVar.getErrorString(), null, b.this.fiE, antiData);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(eVar.getErrorCode(), eVar.getErrorString(), null, null);
                postWriteCallBackData.setAccessState(accessState);
                b.this.fvx.callback(false, postWriteCallBackData, null, b.this.fiE, antiData);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, ImageUploadResult> {
        private boolean cyw = false;
        com.baidu.tieba.tbadkCore.c.a fvB = new com.baidu.tieba.tbadkCore.c.a();
        Bitmap aFY = null;

        public a() {
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public ImageUploadResult doInBackground(Void... voidArr) {
            boolean df = m.df(b.this.fvt);
            if (this.cyw) {
                return null;
            }
            if (b.this.fvu == null || b.this.fvu.length <= 0) {
                if (TextUtils.isEmpty(b.this.fvt) || !df) {
                    return null;
                }
                Uri parse = Uri.parse(b.this.fvt);
                b.this.fvs = m.b(TbadkCoreApplication.m9getInst().getApp(), parse);
                if (TextUtils.isEmpty(b.this.fvs)) {
                    return null;
                }
                return b.this.a(b.this.fvs, this.fvB);
            }
            this.aFY = BitmapHelper.Bytes2Bitmap(b.this.fvu);
            if (this.aFY != null) {
                b.this.fvs = m.a(TbConfig.IMAGE_RESIZED_FILE, this.aFY, 80);
                if (TextUtils.isEmpty(b.this.fvs)) {
                    if (this.aFY == null || this.aFY.isRecycled()) {
                        return null;
                    }
                    this.aFY.recycle();
                    return null;
                }
                return b.this.a(b.this.fvs, this.fvB);
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.cyw = true;
            if (this.fvB != null) {
                this.fvB.cancel();
            }
            if (b.this.fvv != null) {
                b.this.fvv.a(null, true);
            }
            if (this.aFY != null && !this.aFY.isRecycled()) {
                this.aFY.recycle();
            }
            super.cancel();
            b.this.fvr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (!this.cyw) {
                if (b.this.fvv != null) {
                    b.this.fvv.a(imageUploadResult, false);
                }
                if (this.aFY != null && !this.aFY.isRecycled()) {
                    this.aFY.recycle();
                }
            }
        }
    }

    public void Zp() {
        if (this.fvr == null) {
            this.fvr = new a();
            this.fvr.execute(new Void[0]);
        }
    }

    public void d(byte[] bArr, String str) {
        this.fvu = bArr;
        this.fvt = str;
    }

    public void a(InterfaceC0080b interfaceC0080b) {
        this.fvv = interfaceC0080b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.F(bb.vk().vq(), bb.vk().vq()));
        return aVar.d(imageFileInfo, true);
    }
}
