package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.m;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tieba.t;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Integer, Integer, g> {
    final /* synthetic */ a cuy;
    private com.baidu.tieba.tbadkCore.d.a cux = null;
    private String ayR = null;
    private boolean cuw = false;

    public f(a aVar) {
        this.cuy = aVar;
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
        if (this.cuw) {
            return null;
        }
        this.cux = new com.baidu.tieba.tbadkCore.d.a();
        com.baidu.tieba.tbadkCore.d.a aVar = this.cux;
        writeData = this.cuy.cuo;
        z = this.cuy.cuv;
        this.ayR = aVar.a(writeData, z);
        ErrorData aoQ = this.cux.aoQ();
        if (this.cux.qa() && this.ayR != null) {
            AntiData aoP = this.cux.aoP();
            String error_msg = aoQ.getError_msg();
            if (m.isEmpty(error_msg)) {
                error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.send_success);
            }
            g gVar2 = new g(aoQ.getError_code(), error_msg, aoP);
            writeData2 = this.cuy.cuo;
            if (writeData2 != null) {
                writeData3 = this.cuy.cuo;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.cuy.cuo;
                }
                if (!gVar2.hasError()) {
                    writeData4 = this.cuy.cuo;
                    writeData4.deleteUploadedTempImages();
                    gVar = gVar2;
                }
            }
            gVar = gVar2;
        } else if (aoQ != null && !StringUtils.isNull(aoQ.getError_msg())) {
            gVar = new g(aoQ.getError_code(), aoQ.getError_msg(), null);
        } else {
            gVar = new g(-17, TbadkCoreApplication.m411getInst().getApp().getString(t.neterror), null);
        }
        if (!gVar.hasError()) {
            try {
                String optString2 = new JSONObject(this.ayR).optString(AddFriendActivityConfig.MSG);
                try {
                    String optString3 = new JSONObject(this.ayR).optString("pre_msg");
                    try {
                        String optString4 = new JSONObject(this.ayR).optString("color_msg");
                        try {
                            optString = new JSONObject(this.ayR).optString("tid");
                        } catch (JSONException e) {
                            str = optString4;
                            str2 = optString3;
                            str3 = optString2;
                            jSONException = e;
                            str4 = null;
                        }
                        try {
                            str6 = new JSONObject(this.ayR).optString(Info.kBaiduPIDKey);
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
                str3 = TbadkCoreApplication.m411getInst().getString(t.send_success);
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
        this.cuy.cum = null;
        if (!this.cuw && gVar != null) {
            if (!gVar.hasError()) {
                writeData = this.cuy.cuo;
                if (writeData != null) {
                    writeData2 = this.cuy.cuo;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.amY();
                    }
                }
                eVar = this.cuy.cuu;
                if (eVar == null) {
                    dVar = this.cuy.cut;
                    if (dVar != null) {
                        dVar2 = this.cuy.cut;
                        dVar2.a(true, gVar.getErrorString(), null, null, gVar.aaG());
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                postWriteCallBackData.setThreadId(gVar.getThreadId());
                postWriteCallBackData.setPostId(gVar.getPostId());
                eVar2 = this.cuy.cuu;
                eVar2.a(true, postWriteCallBackData, null, null, gVar.aaG());
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
        this.cuw = true;
        if (this.cux != null) {
            this.cux.cancel();
        }
        eVar = this.cuy.cuu;
        if (eVar == null) {
            dVar = this.cuy.cut;
            if (dVar != null) {
                dVar2 = this.cuy.cut;
                dVar2.a(false, null, null, null, null);
            }
        } else {
            eVar2 = this.cuy.cuu;
            eVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.cuy.cum = null;
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
        AntiData aaG = gVar.aaG();
        if (!gVar.apK()) {
            eVar = this.cuy.cuu;
            if (eVar == null) {
                dVar = this.cuy.cut;
                if (dVar != null) {
                    dVar2 = this.cuy.cut;
                    dVar2.a(false, gVar.getErrorString(), null, null, gVar.aaG());
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), null, null);
            eVar2 = this.cuy.cuu;
            eVar2.a(false, postWriteCallBackData, null, null, gVar.aaG());
            return;
        }
        l lVar = new l();
        lVar.parserJson(this.ayR);
        if (lVar.getVcode_pic_url() != null) {
            writeData = this.cuy.cuo;
            if (writeData != null) {
                writeData2 = this.cuy.cuo;
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData3 = this.cuy.cuo;
                writeData3.setVcodeUrl(lVar.getVcode_pic_url());
                eVar3 = this.cuy.cuu;
                if (eVar3 == null) {
                    dVar3 = this.cuy.cut;
                    if (dVar3 != null) {
                        dVar4 = this.cuy.cut;
                        String errorString = gVar.getErrorString();
                        writeData4 = this.cuy.cuo;
                        dVar4.a(false, errorString, lVar, writeData4, aaG);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(gVar.getErrorString(), null, null);
                eVar4 = this.cuy.cuu;
                writeData5 = this.cuy.cuo;
                eVar4.a(false, postWriteCallBackData2, lVar, writeData5, aaG);
            }
        }
    }
}
