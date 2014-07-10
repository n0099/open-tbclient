package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.aq> {
    final /* synthetic */ aq a;
    private com.baidu.tieba.a.d b = null;
    private String c = null;
    private boolean d = false;

    public as(aq aqVar) {
        this.a = aqVar;
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
    public com.baidu.tieba.data.aq doInBackground(Integer... numArr) {
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
            if (com.baidu.adp.lib.util.i.b(error_msg)) {
                error_msg = com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.send_success);
            }
            com.baidu.tieba.data.aq aqVar = new com.baidu.tieba.data.aq(d.getError_code(), error_msg, c);
            writeData2 = this.a.c;
            if (writeData2 != null) {
                writeData3 = this.a.c;
                if (!writeData3.isHasImages()) {
                    writeData5 = this.a.c;
                }
                if (!aqVar.a()) {
                    writeData4 = this.a.c;
                    writeData4.deleteUploadedTempImages();
                }
            }
            return aqVar;
        } else if (d != null) {
            return new com.baidu.tieba.data.aq(d.getError_code(), d.getError_msg(), null);
        } else {
            return new com.baidu.tieba.data.aq(-17, com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.neterror), null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.aq aqVar) {
        WriteData writeData;
        ar arVar;
        ar arVar2;
        WriteData writeData2;
        super.onPostExecute(aqVar);
        this.a.b = null;
        if (!this.d && aqVar != null) {
            if (!aqVar.a()) {
                writeData = this.a.c;
                if (writeData != null) {
                    writeData2 = this.a.c;
                    if (writeData2.isBabaoPosted()) {
                        com.baidu.tieba.d.a.d();
                    }
                }
                arVar = this.a.d;
                if (arVar != null) {
                    arVar2 = this.a.d;
                    arVar2.a(true, aqVar.c(), null, null, aqVar.d());
                    return;
                }
                return;
            }
            b(aqVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ar arVar;
        ar arVar2;
        this.d = true;
        if (this.b != null) {
            this.b.b();
        }
        arVar = this.a.d;
        if (arVar != null) {
            arVar2 = this.a.d;
            arVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.a.b = null;
    }

    private void b(com.baidu.tieba.data.aq aqVar) {
        ar arVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        ar arVar2;
        ar arVar3;
        WriteData writeData4;
        AntiData d = aqVar.d();
        if (!aqVar.b()) {
            arVar = this.a.d;
            arVar.a(false, aqVar.c(), null, null, aqVar.d());
            return;
        }
        com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
        fVar.a(this.c);
        if (fVar.b() != null) {
            writeData = this.a.c;
            if (writeData != null) {
                writeData2 = this.a.c;
                writeData2.setVcodeMD5(fVar.a());
                writeData3 = this.a.c;
                writeData3.setVcodeUrl(fVar.b());
                arVar2 = this.a.d;
                if (arVar2 != null) {
                    arVar3 = this.a.d;
                    String c = aqVar.c();
                    writeData4 = this.a.c;
                    arVar3.a(false, c, fVar, writeData4, d);
                }
            }
        }
    }
}
