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
    final /* synthetic */ a cbE;
    private com.baidu.tieba.tbadkCore.c.a cbC = null;
    private String QK = null;
    private boolean cbD = false;

    public d(a aVar) {
        this.cbE = aVar;
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
        if (this.cbD) {
            return null;
        }
        this.cbC = new com.baidu.tieba.tbadkCore.c.a();
        com.baidu.tieba.tbadkCore.c.a aVar = this.cbC;
        writeData = this.cbE.bPp;
        z = this.cbE.cbB;
        this.QK = aVar.a(writeData, z);
        ErrorData ahO = this.cbC.ahO();
        if (this.cbC.ma() && this.QK != null) {
            AntiData ahN = this.cbC.ahN();
            String error_msg = ahO.getError_msg();
            if (k.isEmpty(error_msg)) {
                error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_success);
            }
            e eVar2 = new e(ahO.getError_code(), error_msg, ahN);
            writeData2 = this.cbE.bPp;
            if (writeData2 != null) {
                writeData3 = this.cbE.bPp;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.cbE.bPp;
                }
                if (!eVar2.hasError()) {
                    writeData4 = this.cbE.bPp;
                    writeData4.deleteUploadedTempImages();
                    eVar = eVar2;
                }
            }
            eVar = eVar2;
        } else if (ahO != null && !StringUtils.isNull(ahO.getError_msg())) {
            eVar = new e(ahO.getError_code(), ahO.getError_msg(), null);
        } else {
            eVar = new e(-17, TbadkCoreApplication.m255getInst().getApp().getString(z.neterror), null);
        }
        if (!eVar.hasError()) {
            try {
                String optString = new JSONObject(this.QK).optString(AddFriendActivityConfig.MSG);
                try {
                    String optString2 = new JSONObject(this.QK).optString("pre_msg");
                    try {
                        str4 = new JSONObject(this.QK).optString("color_msg");
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
                        eVar.ix(str3);
                        eVar.iy(str4);
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
            eVar.ix(str3);
            eVar.iy(str4);
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
        this.cbE.cby = null;
        if (!this.cbD && eVar != null) {
            if (!eVar.hasError()) {
                writeData = this.cbE.bPp;
                if (writeData != null) {
                    writeData2 = this.cbE.bPp;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.afo();
                    }
                }
                cVar = this.cbE.cbA;
                if (cVar == null) {
                    bVar = this.cbE.cbz;
                    if (bVar != null) {
                        bVar2 = this.cbE.cbz;
                        bVar2.a(true, eVar.getErrorString(), null, null, eVar.abT());
                        return;
                    }
                    return;
                }
                f fVar = new f(eVar.getErrorString(), eVar.aiI(), eVar.aiJ());
                cVar2 = this.cbE.cbA;
                cVar2.a(true, fVar, null, null, eVar.abT());
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
        this.cbD = true;
        if (this.cbC != null) {
            this.cbC.cancel();
        }
        cVar = this.cbE.cbA;
        if (cVar == null) {
            bVar = this.cbE.cbz;
            if (bVar != null) {
                bVar2 = this.cbE.cbz;
                bVar2.a(false, null, null, null, null);
            }
        } else {
            cVar2 = this.cbE.cbA;
            cVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.cbE.cby = null;
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
        AntiData abT = eVar.abT();
        if (!eVar.aiH()) {
            cVar = this.cbE.cbA;
            if (cVar == null) {
                bVar = this.cbE.cbz;
                if (bVar != null) {
                    bVar2 = this.cbE.cbz;
                    bVar2.a(false, eVar.getErrorString(), null, null, eVar.abT());
                    return;
                }
                return;
            }
            f fVar = new f(eVar.getErrorString(), null, null);
            cVar2 = this.cbE.cbA;
            cVar2.a(false, fVar, null, null, eVar.abT());
            return;
        }
        j jVar = new j();
        jVar.parserJson(this.QK);
        if (jVar.getVcode_pic_url() != null) {
            writeData = this.cbE.bPp;
            if (writeData != null) {
                writeData2 = this.cbE.bPp;
                writeData2.setVcodeMD5(jVar.getVcode_md5());
                writeData3 = this.cbE.bPp;
                writeData3.setVcodeUrl(jVar.getVcode_pic_url());
                cVar3 = this.cbE.cbA;
                if (cVar3 == null) {
                    bVar3 = this.cbE.cbz;
                    if (bVar3 != null) {
                        bVar4 = this.cbE.cbz;
                        String errorString = eVar.getErrorString();
                        writeData4 = this.cbE.bPp;
                        bVar4.a(false, errorString, jVar, writeData4, abT);
                        return;
                    }
                    return;
                }
                f fVar2 = new f(eVar.getErrorString(), null, null);
                cVar4 = this.cbE.cbA;
                writeData5 = this.cbE.bPp;
                cVar4.a(false, fVar2, jVar, writeData5, abT);
            }
        }
    }
}
