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
    final /* synthetic */ ar bpA;
    private com.baidu.tieba.a.c bpy = null;
    private String KX = null;
    private boolean bpz = false;

    public at(ar arVar) {
        this.bpA = arVar;
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
        if (this.bpz) {
            return null;
        }
        this.bpy = new com.baidu.tieba.a.c();
        com.baidu.tieba.a.c cVar = this.bpy;
        writeData = this.bpA.bpv;
        z = this.bpA.bpx;
        this.KX = cVar.a(writeData, z);
        ErrorData AF = this.bpy.AF();
        if (this.bpy.jq() && this.KX != null) {
            AntiData AE = this.bpy.AE();
            String error_msg = AF.getError_msg();
            if (com.baidu.adp.lib.util.l.aA(error_msg)) {
                error_msg = com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.send_success);
            }
            com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao(AF.getError_code(), error_msg, AE);
            writeData2 = this.bpA.bpv;
            if (writeData2 != null) {
                writeData3 = this.bpA.bpv;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.bpA.bpv;
                }
                if (!aoVar2.hasError()) {
                    writeData4 = this.bpA.bpv;
                    writeData4.deleteUploadedTempImages();
                    aoVar = aoVar2;
                }
            }
            aoVar = aoVar2;
        } else if (AF != null) {
            aoVar = new com.baidu.tieba.data.ao(AF.getError_code(), AF.getError_msg(), null);
        } else {
            aoVar = new com.baidu.tieba.data.ao(-17, com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.neterror), null);
        }
        if (!aoVar.hasError()) {
            try {
                str = new JSONObject(this.KX).optString(AddFriendActivityConfig.MSG);
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
        this.bpA.bpu = null;
        if (!this.bpz && aoVar != null) {
            if (!aoVar.hasError()) {
                writeData = this.bpA.bpv;
                if (writeData != null) {
                    writeData2 = this.bpA.bpv;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.e.a.adI();
                    }
                }
                asVar = this.bpA.bpw;
                if (asVar != null) {
                    asVar2 = this.bpA.bpw;
                    asVar2.a(true, aoVar.getErrorString(), null, null, aoVar.An());
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
        this.bpz = true;
        if (this.bpy != null) {
            this.bpy.cancel();
        }
        asVar = this.bpA.bpw;
        if (asVar != null) {
            asVar2 = this.bpA.bpw;
            asVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.bpA.bpu = null;
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
        AntiData An = aoVar.An();
        if (!aoVar.Am()) {
            asVar = this.bpA.bpw;
            if (asVar != null) {
                asVar2 = this.bpA.bpw;
                asVar2.a(false, aoVar.getErrorString(), null, null, aoVar.An());
                return;
            }
            return;
        }
        com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
        fVar.parserJson(this.KX);
        if (fVar.getVcode_pic_url() != null) {
            writeData = this.bpA.bpv;
            if (writeData != null) {
                writeData2 = this.bpA.bpv;
                writeData2.setVcodeMD5(fVar.getVcode_md5());
                writeData3 = this.bpA.bpv;
                writeData3.setVcodeUrl(fVar.getVcode_pic_url());
                asVar3 = this.bpA.bpw;
                if (asVar3 != null) {
                    asVar4 = this.bpA.bpw;
                    String errorString = aoVar.getErrorString();
                    writeData4 = this.bpA.bpv;
                    asVar4.a(false, errorString, fVar, writeData4, An);
                }
            }
        }
    }
}
