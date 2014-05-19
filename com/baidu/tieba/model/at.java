package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.al> {
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
    public com.baidu.tieba.data.al doInBackground(Integer... numArr) {
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
            if (com.baidu.adp.lib.util.g.b(error_msg)) {
                error_msg = com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.send_success);
            }
            com.baidu.tieba.data.al alVar = new com.baidu.tieba.data.al(d.getError_code(), error_msg, c);
            writeData2 = this.a.b;
            if (writeData2 != null) {
                writeData3 = this.a.b;
                if (writeData3.isHasImages() && !alVar.a()) {
                    writeData4 = this.a.b;
                    writeData4.deleteUploadedTempImages();
                }
            }
            return alVar;
        } else if (d != null) {
            return new com.baidu.tieba.data.al(d.getError_code(), d.getError_msg(), null);
        } else {
            return new com.baidu.tieba.data.al(-17, com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.neterror), null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.al alVar) {
        as asVar;
        as asVar2;
        super.onPostExecute(alVar);
        this.a.a = null;
        if (!this.d && alVar != null) {
            if (!alVar.a()) {
                asVar = this.a.c;
                if (asVar != null) {
                    asVar2 = this.a.c;
                    asVar2.a(true, alVar.c(), null, null, alVar.d());
                    return;
                }
                return;
            }
            b(alVar);
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

    private void b(com.baidu.tieba.data.al alVar) {
        as asVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        as asVar2;
        as asVar3;
        WriteData writeData4;
        AntiData d = alVar.d();
        if (!alVar.b()) {
            asVar = this.a.c;
            asVar.a(false, alVar.c(), null, null, alVar.d());
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
                    String c = alVar.c();
                    writeData4 = this.a.b;
                    asVar3.a(false, c, fVar, writeData4, d);
                }
            }
        }
    }
}
