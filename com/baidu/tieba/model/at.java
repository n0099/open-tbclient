package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.ar> {
    final /* synthetic */ ar a;
    private com.baidu.tieba.a.d b = null;
    private String c = null;
    private boolean d = false;

    public at(ar arVar) {
        this.a = arVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        if (r0.getIsBaobao() != false) goto L18;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tieba.data.ar doInBackground(Integer... numArr) {
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.a.d();
        com.baidu.tieba.a.d dVar = this.b;
        writeData = this.a.c;
        z = this.a.e;
        this.c = dVar.a(writeData, z);
        ErrorData d = this.b.d();
        if (this.b.a() && this.c != null) {
            AntiData c = this.b.c();
            String error_msg = d.getError_msg();
            if (com.baidu.adp.lib.util.i.c(error_msg)) {
                error_msg = com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.x.send_success);
            }
            com.baidu.tieba.data.ar arVar = new com.baidu.tieba.data.ar(d.getError_code(), error_msg, c);
            writeData2 = this.a.c;
            if (writeData2 != null) {
                writeData3 = this.a.c;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.a.c;
                }
                if (!arVar.a()) {
                    writeData4 = this.a.c;
                    writeData4.deleteUploadedTempImages();
                }
            }
            return arVar;
        } else if (d != null) {
            return new com.baidu.tieba.data.ar(d.getError_code(), d.getError_msg(), null);
        } else {
            return new com.baidu.tieba.data.ar(-17, com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.x.neterror), null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.ar arVar) {
        WriteData writeData;
        as asVar;
        as asVar2;
        WriteData writeData2;
        super.onPostExecute(arVar);
        this.a.b = null;
        if (!this.d && arVar != null) {
            if (!arVar.a()) {
                writeData = this.a.c;
                if (writeData != null) {
                    writeData2 = this.a.c;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.e.a.d();
                    }
                }
                asVar = this.a.d;
                if (asVar != null) {
                    asVar2 = this.a.d;
                    asVar2.a(true, arVar.c(), null, null, arVar.d());
                    return;
                }
                return;
            }
            b(arVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        as asVar;
        as asVar2;
        this.d = true;
        if (this.b != null) {
            this.b.b();
        }
        asVar = this.a.d;
        if (asVar != null) {
            asVar2 = this.a.d;
            asVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.a.b = null;
    }

    private void b(com.baidu.tieba.data.ar arVar) {
        as asVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        as asVar2;
        as asVar3;
        WriteData writeData4;
        AntiData d = arVar.d();
        if (!arVar.b()) {
            asVar = this.a.d;
            asVar.a(false, arVar.c(), null, null, arVar.d());
            return;
        }
        com.baidu.tbadk.coreExtra.data.e eVar = new com.baidu.tbadk.coreExtra.data.e();
        eVar.a(this.c);
        if (eVar.b() != null) {
            writeData = this.a.c;
            if (writeData != null) {
                writeData2 = this.a.c;
                writeData2.setVcodeMD5(eVar.a());
                writeData3 = this.a.c;
                writeData3.setVcodeUrl(eVar.b());
                asVar2 = this.a.d;
                if (asVar2 != null) {
                    asVar3 = this.a.d;
                    String c = arVar.c();
                    writeData4 = this.a.c;
                    asVar3.a(false, c, eVar, writeData4, d);
                }
            }
        }
    }
}
