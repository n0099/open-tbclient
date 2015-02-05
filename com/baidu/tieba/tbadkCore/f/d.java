package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.z;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Integer, Integer, e> {
    final /* synthetic */ a cbD;
    private com.baidu.tieba.tbadkCore.c.a cbB = null;
    private String QH = null;
    private boolean cbC = false;

    public d(a aVar) {
        this.cbD = aVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        if (r0.getIsBaobao() != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e doInBackground(Integer... numArr) {
        WriteData writeData;
        boolean z;
        e eVar;
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        String str4;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        if (this.cbC) {
            return null;
        }
        this.cbB = new com.baidu.tieba.tbadkCore.c.a();
        com.baidu.tieba.tbadkCore.c.a aVar = this.cbB;
        writeData = this.cbD.bPo;
        z = this.cbD.cbA;
        this.QH = aVar.a(writeData, z);
        ErrorData ahJ = this.cbB.ahJ();
        if (this.cbB.lT() && this.QH != null) {
            AntiData ahI = this.cbB.ahI();
            String error_msg = ahJ.getError_msg();
            if (k.isEmpty(error_msg)) {
                error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_success);
            }
            e eVar2 = new e(ahJ.getError_code(), error_msg, ahI);
            writeData2 = this.cbD.bPo;
            if (writeData2 != null) {
                writeData3 = this.cbD.bPo;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.cbD.bPo;
                }
                if (!eVar2.hasError()) {
                    writeData4 = this.cbD.bPo;
                    writeData4.deleteUploadedTempImages();
                    eVar = eVar2;
                }
            }
            eVar = eVar2;
        } else if (ahJ != null && !StringUtils.isNull(ahJ.getError_msg())) {
            eVar = new e(ahJ.getError_code(), ahJ.getError_msg(), null);
        } else {
            eVar = new e(-17, TbadkCoreApplication.m255getInst().getApp().getString(z.neterror), null);
        }
        if (!eVar.hasError()) {
            try {
                String optString = new JSONObject(this.QH).optString(AddFriendActivityConfig.MSG);
                try {
                    String optString2 = new JSONObject(this.QH).optString("pre_msg");
                    try {
                        str4 = new JSONObject(this.QH).optString("color_msg");
                        str3 = optString2;
                        str = optString;
                    } catch (JSONException e) {
                        str2 = optString2;
                        str = optString;
                        jSONException = e;
                        jSONException.printStackTrace();
                        str3 = str2;
                        str4 = null;
                        if (StringUtils.isNull(str)) {
                        }
                        eVar.setErrorString(str);
                        eVar.iv(str3);
                        eVar.iw(str4);
                        return eVar;
                    }
                } catch (JSONException e2) {
                    str = optString;
                    jSONException = e2;
                    str2 = null;
                }
            } catch (JSONException e3) {
                jSONException = e3;
                str = null;
                str2 = null;
            }
            if (StringUtils.isNull(str)) {
                str = TbadkCoreApplication.m255getInst().getString(z.send_success);
            }
            eVar.setErrorString(str);
            eVar.iv(str3);
            eVar.iw(str4);
        }
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(e eVar) {
        WriteData writeData;
        c cVar;
        b bVar;
        b bVar2;
        c cVar2;
        WriteData writeData2;
        super.onPostExecute(eVar);
        this.cbD.cbx = null;
        if (!this.cbC && eVar != null) {
            if (!eVar.hasError()) {
                writeData = this.cbD.bPo;
                if (writeData != null) {
                    writeData2 = this.cbD.bPo;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.afj();
                    }
                }
                cVar = this.cbD.cbz;
                if (cVar == null) {
                    bVar = this.cbD.cby;
                    if (bVar != null) {
                        bVar2 = this.cbD.cby;
                        bVar2.a(true, eVar.getErrorString(), null, null, eVar.abO());
                        return;
                    }
                    return;
                }
                f fVar = new f(eVar.getErrorString(), eVar.aiD(), eVar.aiE());
                cVar2 = this.cbD.cbz;
                cVar2.a(true, fVar, null, null, eVar.abO());
                return;
            }
            b(eVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        c cVar;
        b bVar;
        b bVar2;
        c cVar2;
        this.cbC = true;
        if (this.cbB != null) {
            this.cbB.cancel();
        }
        cVar = this.cbD.cbz;
        if (cVar == null) {
            bVar = this.cbD.cby;
            if (bVar != null) {
                bVar2 = this.cbD.cby;
                bVar2.a(false, null, null, null, null);
            }
        } else {
            cVar2 = this.cbD.cbz;
            cVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.cbD.cbx = null;
    }

    private void b(e eVar) {
        c cVar;
        b bVar;
        b bVar2;
        c cVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        c cVar3;
        b bVar3;
        b bVar4;
        WriteData writeData4;
        c cVar4;
        WriteData writeData5;
        AntiData abO = eVar.abO();
        if (!eVar.aiC()) {
            cVar = this.cbD.cbz;
            if (cVar == null) {
                bVar = this.cbD.cby;
                if (bVar != null) {
                    bVar2 = this.cbD.cby;
                    bVar2.a(false, eVar.getErrorString(), null, null, eVar.abO());
                    return;
                }
                return;
            }
            f fVar = new f(eVar.getErrorString(), null, null);
            cVar2 = this.cbD.cbz;
            cVar2.a(false, fVar, null, null, eVar.abO());
            return;
        }
        j jVar = new j();
        jVar.parserJson(this.QH);
        if (jVar.getVcode_pic_url() != null) {
            writeData = this.cbD.bPo;
            if (writeData != null) {
                writeData2 = this.cbD.bPo;
                writeData2.setVcodeMD5(jVar.getVcode_md5());
                writeData3 = this.cbD.bPo;
                writeData3.setVcodeUrl(jVar.getVcode_pic_url());
                cVar3 = this.cbD.cbz;
                if (cVar3 == null) {
                    bVar3 = this.cbD.cby;
                    if (bVar3 != null) {
                        bVar4 = this.cbD.cby;
                        String errorString = eVar.getErrorString();
                        writeData4 = this.cbD.bPo;
                        bVar4.a(false, errorString, jVar, writeData4, abO);
                        return;
                    }
                    return;
                }
                f fVar2 = new f(eVar.getErrorString(), null, null);
                cVar4 = this.cbD.cbz;
                writeData5 = this.cbD.bPo;
                cVar4.a(false, fVar2, jVar, writeData5, abO);
            }
        }
    }
}
