package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.ao> {
    final /* synthetic */ ar bpO;
    private com.baidu.tieba.a.c bpM = null;
    private String KY = null;
    private boolean bpN = false;

    public at(ar arVar) {
        this.bpO = arVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        if (r0.getIsBaobao() != false) goto L18;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tieba.data.ao doInBackground(Integer... numArr) {
        WriteData writeData;
        boolean z;
        com.baidu.tieba.data.ao aoVar;
        String str;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        if (this.bpN) {
            return null;
        }
        this.bpM = new com.baidu.tieba.a.c();
        com.baidu.tieba.a.c cVar = this.bpM;
        writeData = this.bpO.bpJ;
        z = this.bpO.bpL;
        this.KY = cVar.a(writeData, z);
        ErrorData AH = this.bpM.AH();
        if (this.bpM.jq() && this.KY != null) {
            AntiData AG = this.bpM.AG();
            String error_msg = AH.getError_msg();
            if (com.baidu.adp.lib.util.l.aA(error_msg)) {
                error_msg = com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.send_success);
            }
            com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao(AH.getError_code(), error_msg, AG);
            writeData2 = this.bpO.bpJ;
            if (writeData2 != null) {
                writeData3 = this.bpO.bpJ;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.bpO.bpJ;
                }
                if (!aoVar2.hasError()) {
                    writeData4 = this.bpO.bpJ;
                    writeData4.deleteUploadedTempImages();
                    aoVar = aoVar2;
                }
            }
            aoVar = aoVar2;
        } else if (AH != null) {
            aoVar = new com.baidu.tieba.data.ao(AH.getError_code(), AH.getError_msg(), null);
        } else {
            aoVar = new com.baidu.tieba.data.ao(-17, com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.neterror), null);
        }
        if (!aoVar.hasError()) {
            try {
                str = new JSONObject(this.KY).optString(AddFriendActivityConfig.MSG);
            } catch (JSONException e) {
                e.printStackTrace();
                str = null;
            }
            if (StringUtils.isNull(str)) {
                str = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.send_success);
            }
            aoVar.setErrorString(str);
        }
        return aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.ao aoVar) {
        WriteData writeData;
        as asVar;
        as asVar2;
        WriteData writeData2;
        super.onPostExecute(aoVar);
        this.bpO.bpI = null;
        if (!this.bpN && aoVar != null) {
            if (!aoVar.hasError()) {
                writeData = this.bpO.bpJ;
                if (writeData != null) {
                    writeData2 = this.bpO.bpJ;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.e.a.adL();
                    }
                }
                asVar = this.bpO.bpK;
                if (asVar != null) {
                    asVar2 = this.bpO.bpK;
                    asVar2.a(true, aoVar.getErrorString(), null, null, aoVar.Ap());
                    return;
                }
                return;
            }
            b(aoVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        as asVar;
        as asVar2;
        this.bpN = true;
        if (this.bpM != null) {
            this.bpM.cancel();
        }
        asVar = this.bpO.bpK;
        if (asVar != null) {
            asVar2 = this.bpO.bpK;
            asVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.bpO.bpI = null;
    }

    private void b(com.baidu.tieba.data.ao aoVar) {
        as asVar;
        as asVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        as asVar3;
        as asVar4;
        WriteData writeData4;
        AntiData Ap = aoVar.Ap();
        if (!aoVar.Ao()) {
            asVar = this.bpO.bpK;
            if (asVar != null) {
                asVar2 = this.bpO.bpK;
                asVar2.a(false, aoVar.getErrorString(), null, null, aoVar.Ap());
                return;
            }
            return;
        }
        com.baidu.tbadk.coreExtra.data.g gVar = new com.baidu.tbadk.coreExtra.data.g();
        gVar.parserJson(this.KY);
        if (gVar.getVcode_pic_url() != null) {
            writeData = this.bpO.bpJ;
            if (writeData != null) {
                writeData2 = this.bpO.bpJ;
                writeData2.setVcodeMD5(gVar.getVcode_md5());
                writeData3 = this.bpO.bpJ;
                writeData3.setVcodeUrl(gVar.getVcode_pic_url());
                asVar3 = this.bpO.bpK;
                if (asVar3 != null) {
                    asVar4 = this.bpO.bpK;
                    String errorString = aoVar.getErrorString();
                    writeData4 = this.bpO.bpJ;
                    asVar4.a(false, errorString, gVar, writeData4, Ap);
                }
            }
        }
    }
}
