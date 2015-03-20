package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tieba.y;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Integer, Integer, g> {
    final /* synthetic */ a cqe;
    private com.baidu.tieba.tbadkCore.d.a cqd = null;
    private String axc = null;
    private boolean cqc = false;

    public f(a aVar) {
        this.cqe = aVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        if (r0.getIsBaobao() != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g doInBackground(Integer... numArr) {
        WriteData writeData;
        boolean z;
        g gVar;
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String optString;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        if (this.cqc) {
            return null;
        }
        this.cqd = new com.baidu.tieba.tbadkCore.d.a();
        com.baidu.tieba.tbadkCore.d.a aVar = this.cqd;
        writeData = this.cqe.cpU;
        z = this.cqe.cqb;
        this.axc = aVar.a(writeData, z);
        ErrorData amK = this.cqd.amK();
        if (this.cqd.pv() && this.axc != null) {
            AntiData amJ = this.cqd.amJ();
            String error_msg = amK.getError_msg();
            if (m.isEmpty(error_msg)) {
                error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.send_success);
            }
            g gVar2 = new g(amK.getError_code(), error_msg, amJ);
            writeData2 = this.cqe.cpU;
            if (writeData2 != null) {
                writeData3 = this.cqe.cpU;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.cqe.cpU;
                }
                if (!gVar2.hasError()) {
                    writeData4 = this.cqe.cpU;
                    writeData4.deleteUploadedTempImages();
                    gVar = gVar2;
                }
            }
            gVar = gVar2;
        } else if (amK != null && !StringUtils.isNull(amK.getError_msg())) {
            gVar = new g(amK.getError_code(), amK.getError_msg(), null);
        } else {
            gVar = new g(-17, TbadkCoreApplication.m411getInst().getApp().getString(y.neterror), null);
        }
        if (!gVar.hasError()) {
            try {
                String optString2 = new JSONObject(this.axc).optString(AddFriendActivityConfig.MSG);
                try {
                    String optString3 = new JSONObject(this.axc).optString("pre_msg");
                    try {
                        String optString4 = new JSONObject(this.axc).optString("color_msg");
                        try {
                            optString = new JSONObject(this.axc).optString("tid");
                        } catch (JSONException e) {
                            str = optString4;
                            str2 = optString3;
                            str3 = optString2;
                            jSONException = e;
                            str4 = null;
                        }
                        try {
                            str6 = new JSONObject(this.axc).optString("pid");
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
                            gVar.setErrorString(str3);
                            gVar.setPreMsg(str2);
                            gVar.setColorMsg(str);
                            gVar.setThreadId(str5);
                            gVar.setPostId(str6);
                            return gVar;
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
                str3 = TbadkCoreApplication.m411getInst().getString(y.send_success);
            }
            gVar.setErrorString(str3);
            gVar.setPreMsg(str2);
            gVar.setColorMsg(str);
            gVar.setThreadId(str5);
            gVar.setPostId(str6);
        }
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(g gVar) {
        WriteData writeData;
        e eVar;
        d dVar;
        d dVar2;
        e eVar2;
        WriteData writeData2;
        super.onPostExecute(gVar);
        this.cqe.cpS = null;
        if (!this.cqc && gVar != null) {
            if (!gVar.hasError()) {
                writeData = this.cqe.cpU;
                if (writeData != null) {
                    writeData2 = this.cqe.cpU;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.akY();
                    }
                }
                eVar = this.cqe.cqa;
                if (eVar == null) {
                    dVar = this.cqe.cpZ;
                    if (dVar != null) {
                        dVar2 = this.cqe.cpZ;
                        dVar2.a(true, gVar.getErrorString(), null, null, gVar.Zc());
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                postWriteCallBackData.setThreadId(gVar.getThreadId());
                postWriteCallBackData.setPostId(gVar.getPostId());
                eVar2 = this.cqe.cqa;
                eVar2.a(true, postWriteCallBackData, null, null, gVar.Zc());
                return;
            }
            b(gVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        e eVar;
        d dVar;
        d dVar2;
        e eVar2;
        this.cqc = true;
        if (this.cqd != null) {
            this.cqd.cancel();
        }
        eVar = this.cqe.cqa;
        if (eVar == null) {
            dVar = this.cqe.cpZ;
            if (dVar != null) {
                dVar2 = this.cqe.cpZ;
                dVar2.a(false, null, null, null, null);
            }
        } else {
            eVar2 = this.cqe.cqa;
            eVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.cqe.cpS = null;
    }

    private void b(g gVar) {
        e eVar;
        d dVar;
        d dVar2;
        e eVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        e eVar3;
        d dVar3;
        d dVar4;
        WriteData writeData4;
        e eVar4;
        WriteData writeData5;
        AntiData Zc = gVar.Zc();
        if (!gVar.anD()) {
            eVar = this.cqe.cqa;
            if (eVar == null) {
                dVar = this.cqe.cpZ;
                if (dVar != null) {
                    dVar2 = this.cqe.cpZ;
                    dVar2.a(false, gVar.getErrorString(), null, null, gVar.Zc());
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), null, null);
            eVar2 = this.cqe.cqa;
            eVar2.a(false, postWriteCallBackData, null, null, gVar.Zc());
            return;
        }
        k kVar = new k();
        kVar.parserJson(this.axc);
        if (kVar.getVcode_pic_url() != null) {
            writeData = this.cqe.cpU;
            if (writeData != null) {
                writeData2 = this.cqe.cpU;
                writeData2.setVcodeMD5(kVar.getVcode_md5());
                writeData3 = this.cqe.cpU;
                writeData3.setVcodeUrl(kVar.getVcode_pic_url());
                eVar3 = this.cqe.cqa;
                if (eVar3 == null) {
                    dVar3 = this.cqe.cpZ;
                    if (dVar3 != null) {
                        dVar4 = this.cqe.cpZ;
                        String errorString = gVar.getErrorString();
                        writeData4 = this.cqe.cpU;
                        dVar4.a(false, errorString, kVar, writeData4, Zc);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(gVar.getErrorString(), null, null);
                eVar4 = this.cqe.cqa;
                writeData5 = this.cqe.cpU;
                eVar4.a(false, postWriteCallBackData2, kVar, writeData5, Zc);
            }
        }
    }
}
