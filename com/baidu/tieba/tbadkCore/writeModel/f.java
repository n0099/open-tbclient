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
    final /* synthetic */ a cuz;
    private com.baidu.tieba.tbadkCore.d.a cuy = null;
    private String ayS = null;
    private boolean cux = false;

    public f(a aVar) {
        this.cuz = aVar;
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
        if (this.cux) {
            return null;
        }
        this.cuy = new com.baidu.tieba.tbadkCore.d.a();
        com.baidu.tieba.tbadkCore.d.a aVar = this.cuy;
        writeData = this.cuz.cup;
        z = this.cuz.cuw;
        this.ayS = aVar.a(writeData, z);
        ErrorData aoR = this.cuy.aoR();
        if (this.cuy.qa() && this.ayS != null) {
            AntiData aoQ = this.cuy.aoQ();
            String error_msg = aoR.getError_msg();
            if (m.isEmpty(error_msg)) {
                error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.send_success);
            }
            g gVar2 = new g(aoR.getError_code(), error_msg, aoQ);
            writeData2 = this.cuz.cup;
            if (writeData2 != null) {
                writeData3 = this.cuz.cup;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.cuz.cup;
                }
                if (!gVar2.hasError()) {
                    writeData4 = this.cuz.cup;
                    writeData4.deleteUploadedTempImages();
                    gVar = gVar2;
                }
            }
            gVar = gVar2;
        } else if (aoR != null && !StringUtils.isNull(aoR.getError_msg())) {
            gVar = new g(aoR.getError_code(), aoR.getError_msg(), null);
        } else {
            gVar = new g(-17, TbadkCoreApplication.m411getInst().getApp().getString(t.neterror), null);
        }
        if (!gVar.hasError()) {
            try {
                String optString2 = new JSONObject(this.ayS).optString(AddFriendActivityConfig.MSG);
                try {
                    String optString3 = new JSONObject(this.ayS).optString("pre_msg");
                    try {
                        String optString4 = new JSONObject(this.ayS).optString("color_msg");
                        try {
                            optString = new JSONObject(this.ayS).optString("tid");
                        } catch (JSONException e) {
                            str = optString4;
                            str2 = optString3;
                            str3 = optString2;
                            jSONException = e;
                            str4 = null;
                        }
                        try {
                            str6 = new JSONObject(this.ayS).optString(Info.kBaiduPIDKey);
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
        this.cuz.cun = null;
        if (!this.cux && gVar != null) {
            if (!gVar.hasError()) {
                writeData = this.cuz.cup;
                if (writeData != null) {
                    writeData2 = this.cuz.cup;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.amZ();
                    }
                }
                eVar = this.cuz.cuv;
                if (eVar == null) {
                    dVar = this.cuz.cuu;
                    if (dVar != null) {
                        dVar2 = this.cuz.cuu;
                        dVar2.a(true, gVar.getErrorString(), null, null, gVar.aaH());
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                postWriteCallBackData.setThreadId(gVar.getThreadId());
                postWriteCallBackData.setPostId(gVar.getPostId());
                eVar2 = this.cuz.cuv;
                eVar2.a(true, postWriteCallBackData, null, null, gVar.aaH());
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
        this.cux = true;
        if (this.cuy != null) {
            this.cuy.cancel();
        }
        eVar = this.cuz.cuv;
        if (eVar == null) {
            dVar = this.cuz.cuu;
            if (dVar != null) {
                dVar2 = this.cuz.cuu;
                dVar2.a(false, null, null, null, null);
            }
        } else {
            eVar2 = this.cuz.cuv;
            eVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.cuz.cun = null;
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
        AntiData aaH = gVar.aaH();
        if (!gVar.apL()) {
            eVar = this.cuz.cuv;
            if (eVar == null) {
                dVar = this.cuz.cuu;
                if (dVar != null) {
                    dVar2 = this.cuz.cuu;
                    dVar2.a(false, gVar.getErrorString(), null, null, gVar.aaH());
                    return;
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), null, null);
            eVar2 = this.cuz.cuv;
            eVar2.a(false, postWriteCallBackData, null, null, gVar.aaH());
            return;
        }
        l lVar = new l();
        lVar.parserJson(this.ayS);
        if (lVar.getVcode_pic_url() != null) {
            writeData = this.cuz.cup;
            if (writeData != null) {
                writeData2 = this.cuz.cup;
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData3 = this.cuz.cup;
                writeData3.setVcodeUrl(lVar.getVcode_pic_url());
                eVar3 = this.cuz.cuv;
                if (eVar3 == null) {
                    dVar3 = this.cuz.cuu;
                    if (dVar3 != null) {
                        dVar4 = this.cuz.cuu;
                        String errorString = gVar.getErrorString();
                        writeData4 = this.cuz.cup;
                        dVar4.a(false, errorString, lVar, writeData4, aaH);
                        return;
                    }
                    return;
                }
                PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(gVar.getErrorString(), null, null);
                eVar4 = this.cuz.cuv;
                writeData5 = this.cuz.cup;
                eVar4.a(false, postWriteCallBackData2, lVar, writeData5, aaH);
            }
        }
    }
}
