package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.am> {
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.am doInBackground(Integer... numArr) {
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.a.d();
        com.baidu.tieba.a.d dVar = this.b;
        writeData = this.a.b;
        z = this.a.d;
        this.c = dVar.a(writeData, z);
        ErrorData d = this.b.d();
        if (this.b.a() && this.c != null) {
            AntiData c = this.b.c();
            String error_msg = d.getError_msg();
            if (com.baidu.adp.lib.util.j.b(error_msg)) {
                error_msg = com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.send_success);
            }
            com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am(d.getError_code(), error_msg, c);
            writeData2 = this.a.b;
            if (writeData2 != null) {
                writeData3 = this.a.b;
                if (writeData3.isHasImages() && !amVar.a()) {
                    writeData4 = this.a.b;
                    writeData4.deleteUploadedTempImages();
                }
            }
            return amVar;
        } else if (d != null) {
            return new com.baidu.tieba.data.am(d.getError_code(), d.getError_msg(), null);
        } else {
            return new com.baidu.tieba.data.am(-17, com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.neterror), null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.am amVar) {
        as asVar;
        as asVar2;
        super.onPostExecute(amVar);
        this.a.a = null;
        if (!this.d && amVar != null) {
            if (!amVar.a()) {
                asVar = this.a.c;
                if (asVar != null) {
                    asVar2 = this.a.c;
                    asVar2.a(true, amVar.c(), null, null, amVar.d());
                    return;
                }
                return;
            }
            b(amVar);
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
        asVar = this.a.c;
        if (asVar != null) {
            asVar2 = this.a.c;
            asVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.a.a = null;
    }

    private void b(com.baidu.tieba.data.am amVar) {
        as asVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        as asVar2;
        as asVar3;
        WriteData writeData4;
        AntiData d = amVar.d();
        if (!amVar.b()) {
            asVar = this.a.c;
            asVar.a(false, amVar.c(), null, null, amVar.d());
            return;
        }
        com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
        fVar.a(this.c);
        if (fVar.b() != null) {
            writeData = this.a.b;
            if (writeData != null) {
                writeData2 = this.a.b;
                writeData2.setVcodeMD5(fVar.a());
                writeData3 = this.a.b;
                writeData3.setVcodeUrl(fVar.b());
                asVar2 = this.a.c;
                if (asVar2 != null) {
                    asVar3 = this.a.c;
                    String c = amVar.c();
                    writeData4 = this.a.b;
                    asVar3.a(false, c, fVar, writeData4, d);
                }
            }
        }
    }
}
