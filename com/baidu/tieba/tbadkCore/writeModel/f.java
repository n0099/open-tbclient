package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tieba.y;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Integer, Integer, g> {
    final /* synthetic */ a cqu;
    private com.baidu.tieba.tbadkCore.d.a cqt = null;
    private String axk = null;
    private boolean cqs = false;

    public f(a aVar) {
        this.cqu = aVar;
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
        if (this.cqs) {
            return null;
        }
        this.cqt = new com.baidu.tieba.tbadkCore.d.a();
        com.baidu.tieba.tbadkCore.d.a aVar = this.cqt;
        writeData = this.cqu.cqk;
        z = this.cqu.cqr;
        this.axk = aVar.a(writeData, z);
        ErrorData amZ = this.cqt.amZ();
        if (this.cqt.pv() && this.axk != null) {
            AntiData amY = this.cqt.amY();
            String error_msg = amZ.getError_msg();
            if (m.isEmpty(error_msg)) {
                error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.send_success);
            }
            g gVar2 = new g(amZ.getError_code(), error_msg, amY);
            writeData2 = this.cqu.cqk;
            if (writeData2 != null) {
                writeData3 = this.cqu.cqk;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.cqu.cqk;
                }
                if (!gVar2.hasError()) {
                    writeData4 = this.cqu.cqk;
                    writeData4.deleteUploadedTempImages();
                    gVar = gVar2;
                }
            }
            gVar = gVar2;
        } else if (amZ != null && !StringUtils.isNull(amZ.getError_msg())) {
            gVar = new g(amZ.getError_code(), amZ.getError_msg(), null);
        } else {
            gVar = new g(-17, TbadkCoreApplication.m411getInst().getApp().getString(y.neterror), null);
        }
        if (!gVar.hasError()) {
            try {
                String optString2 = new JSONObject(this.axk).optString(AddFriendActivityConfig.MSG);
                try {
                    String optString3 = new JSONObject(this.axk).optString("pre_msg");
                    try {
                        String optString4 = new JSONObject(this.axk).optString("color_msg");
                        try {
                            optString = new JSONObject(this.axk).optString("tid");
                        } catch (JSONException e) {
                            str = optString4;
                            str2 = optString3;
                            str3 = optString2;
                            jSONException = e;
                            str4 = null;
                        }
                        try {
                            str6 = new JSONObject(this.axk).optString("pid");
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
        this.cqu.cqi = null;
        if (!this.cqs && gVar != null) {
            if (!gVar.hasError()) {
                writeData = this.cqu.cqk;
                if (writeData != null) {
                    writeData2 = this.cqu.cqk;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aln();
                    }
                }
                eVar = this.cqu.cqq;
                if (eVar == null) {
                    dVar = this.cqu.cqp;
                    if (dVar != null) {
                        dVar2 = this.cqu.cqp;
                        dVar2.a(true, gVar.getErrorString(), null, null, gVar.Zp());
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                postWriteCallBackData.setThreadId(gVar.getThreadId());
                postWriteCallBackData.setPostId(gVar.getPostId());
                eVar2 = this.cqu.cqq;
                eVar2.a(true, postWriteCallBackData, null, null, gVar.Zp());
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
        this.cqs = true;
        if (this.cqt != null) {
            this.cqt.cancel();
        }
        eVar = this.cqu.cqq;
        if (eVar == null) {
            dVar = this.cqu.cqp;
            if (dVar != null) {
                dVar2 = this.cqu.cqp;
                dVar2.a(false, null, null, null, null);
            }
        } else {
            eVar2 = this.cqu.cqq;
            eVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.cqu.cqi = null;
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
        AntiData Zp = gVar.Zp();
        if (!gVar.anS()) {
            eVar = this.cqu.cqq;
            if (eVar == null) {
                dVar = this.cqu.cqp;
                if (dVar != null) {
                    dVar2 = this.cqu.cqp;
                    dVar2.a(false, gVar.getErrorString(), null, null, gVar.Zp());
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), null, null);
            eVar2 = this.cqu.cqq;
            eVar2.a(false, postWriteCallBackData, null, null, gVar.Zp());
            return;
        }
        l lVar = new l();
        lVar.parserJson(this.axk);
        if (lVar.getVcode_pic_url() != null) {
            writeData = this.cqu.cqk;
            if (writeData != null) {
                writeData2 = this.cqu.cqk;
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData3 = this.cqu.cqk;
                writeData3.setVcodeUrl(lVar.getVcode_pic_url());
                eVar3 = this.cqu.cqq;
                if (eVar3 == null) {
                    dVar3 = this.cqu.cqp;
                    if (dVar3 != null) {
                        dVar4 = this.cqu.cqp;
                        String errorString = gVar.getErrorString();
                        writeData4 = this.cqu.cqk;
                        dVar4.a(false, errorString, lVar, writeData4, Zp);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(gVar.getErrorString(), null, null);
                eVar4 = this.cqu.cqq;
                writeData5 = this.cqu.cqk;
                eVar4.a(false, postWriteCallBackData2, lVar, writeData5, Zp);
            }
        }
    }
}
