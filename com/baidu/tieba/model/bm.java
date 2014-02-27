package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bm extends BdAsyncTask<Integer, Integer, com.baidu.tieba.write.ah> {
    final /* synthetic */ bk a;
    private com.baidu.tieba.b.i b = null;
    private String c = null;
    private boolean d = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.write.ah a(Integer... numArr) {
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.b.i();
        com.baidu.tieba.b.i iVar = this.b;
        writeData = this.a.b;
        z = this.a.d;
        this.c = iVar.a(writeData, z);
        if (this.c != null) {
            ErrorData d = this.b.d();
            if (this.b.a()) {
                AntiData c = this.b.c();
                String error_msg = d.getError_msg();
                if (com.baidu.adp.lib.util.g.b(error_msg)) {
                    error_msg = TiebaApplication.g().b().getString(R.string.send_success);
                }
                com.baidu.tieba.write.ah ahVar = new com.baidu.tieba.write.ah(d.getError_code(), error_msg, c);
                writeData2 = this.a.b;
                if (writeData2 != null) {
                    writeData3 = this.a.b;
                    if (writeData3.isHasImages() && !ahVar.a()) {
                        writeData4 = this.a.b;
                        writeData4.deleteUploadedTempImages();
                    }
                }
                return ahVar;
            }
            return new com.baidu.tieba.write.ah(d.getError_code(), d.getError_msg(), null);
        }
        return new com.baidu.tieba.write.ah(-17, TiebaApplication.g().b().getString(R.string.neterror), null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.write.ah ahVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bl blVar4;
        bl blVar5;
        WriteData writeData4;
        com.baidu.tieba.write.ah ahVar2 = ahVar;
        super.a((bm) ahVar2);
        this.a.a = null;
        if (this.d || ahVar2 == null) {
            return;
        }
        if (!ahVar2.a()) {
            blVar = this.a.c;
            if (blVar != null) {
                blVar2 = this.a.c;
                blVar2.a(true, ahVar2.c(), null, null, ahVar2.d());
                return;
            }
            return;
        }
        AntiData d = ahVar2.d();
        if (!ahVar2.b()) {
            blVar3 = this.a.c;
            blVar3.a(false, ahVar2.c(), null, null, ahVar2.d());
            return;
        }
        com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
        bdVar.a(this.c);
        if (bdVar.b() != null) {
            writeData = this.a.b;
            if (writeData != null) {
                writeData2 = this.a.b;
                writeData2.setVcodeMD5(bdVar.a());
                writeData3 = this.a.b;
                writeData3.setVcodeUrl(bdVar.b());
                blVar4 = this.a.c;
                if (blVar4 != null) {
                    blVar5 = this.a.c;
                    String c = ahVar2.c();
                    writeData4 = this.a.b;
                    blVar5.a(false, c, bdVar, writeData4, d);
                }
            }
        }
    }

    public bm(bk bkVar) {
        this.a = bkVar;
        setPriority(3);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        bl blVar;
        bl blVar2;
        this.d = true;
        if (this.b != null) {
            this.b.b();
        }
        blVar = this.a.c;
        if (blVar != null) {
            blVar2 = this.a.c;
            blVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.a.a = null;
    }
}
