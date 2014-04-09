package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.ak> {
    final /* synthetic */ ar a;
    private com.baidu.tieba.b.d b = null;
    private String c = null;
    private boolean d = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.ak a(Integer... numArr) {
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.b.d();
        com.baidu.tieba.b.d dVar = this.b;
        writeData = this.a.b;
        z = this.a.d;
        this.c = dVar.a(writeData, z);
        if (this.c == null) {
            com.baidu.tieba.p.c();
            return new com.baidu.tieba.data.ak(-17, com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.neterror), null);
        }
        ErrorData d = this.b.d();
        if (this.b.a()) {
            AntiData c = this.b.c();
            String error_msg = d.getError_msg();
            if (com.baidu.adp.lib.util.h.b(error_msg)) {
                com.baidu.tieba.p.c();
                error_msg = com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.send_success);
            }
            com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak(d.getError_code(), error_msg, c);
            writeData2 = this.a.b;
            if (writeData2 != null) {
                writeData3 = this.a.b;
                if (writeData3.isHasImages() && !akVar.a()) {
                    writeData4 = this.a.b;
                    writeData4.deleteUploadedTempImages();
                }
            }
            return akVar;
        }
        return new com.baidu.tieba.data.ak(d.getError_code(), d.getError_msg(), null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.ak akVar) {
        as asVar;
        as asVar2;
        as asVar3;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        as asVar4;
        as asVar5;
        WriteData writeData4;
        com.baidu.tieba.data.ak akVar2 = akVar;
        super.a((at) akVar2);
        this.a.a = null;
        if (this.d || akVar2 == null) {
            return;
        }
        if (!akVar2.a()) {
            asVar = this.a.c;
            if (asVar != null) {
                asVar2 = this.a.c;
                asVar2.a(true, akVar2.c(), null, null, akVar2.d());
                return;
            }
            return;
        }
        AntiData d = akVar2.d();
        if (!akVar2.b()) {
            asVar3 = this.a.c;
            asVar3.a(false, akVar2.c(), null, null, akVar2.d());
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
                asVar4 = this.a.c;
                if (asVar4 != null) {
                    asVar5 = this.a.c;
                    String c = akVar2.c();
                    writeData4 = this.a.b;
                    asVar5.a(false, c, fVar, writeData4, d);
                }
            }
        }
    }

    public at(ar arVar) {
        this.a = arVar;
        setPriority(3);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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
}
