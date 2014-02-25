package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends BdAsyncTask<Integer, Integer, com.baidu.tieba.write.ai> {
    final /* synthetic */ bk a;
    private com.baidu.tieba.b.i b = null;
    private String c = null;
    private boolean d = false;

    public bm(bk bkVar) {
        this.a = bkVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.write.ai a(Integer... numArr) {
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
                if (com.baidu.adp.lib.util.h.b(error_msg)) {
                    error_msg = TiebaApplication.g().b().getString(R.string.send_success);
                }
                com.baidu.tieba.write.ai aiVar = new com.baidu.tieba.write.ai(d.getError_code(), error_msg, c);
                writeData2 = this.a.b;
                if (writeData2 != null) {
                    writeData3 = this.a.b;
                    if (writeData3.isHasImages() && !aiVar.a()) {
                        writeData4 = this.a.b;
                        writeData4.deleteUploadedTempImages();
                    }
                }
                return aiVar;
            }
            return new com.baidu.tieba.write.ai(d.getError_code(), d.getError_msg(), null);
        }
        return new com.baidu.tieba.write.ai(-17, TiebaApplication.g().b().getString(R.string.neterror), null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.write.ai aiVar) {
        bl blVar;
        bl blVar2;
        super.a((bm) aiVar);
        this.a.a = null;
        if (!this.d && aiVar != null) {
            if (!aiVar.a()) {
                blVar = this.a.c;
                if (blVar != null) {
                    blVar2 = this.a.c;
                    blVar2.a(true, aiVar.d(), null, null, aiVar.e());
                    return;
                }
                return;
            }
            b(aiVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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

    private void b(com.baidu.tieba.write.ai aiVar) {
        bl blVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bl blVar2;
        bl blVar3;
        WriteData writeData4;
        AntiData e = aiVar.e();
        if (!aiVar.b()) {
            blVar = this.a.c;
            blVar.a(false, aiVar.d(), null, null, aiVar.e());
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
                blVar2 = this.a.c;
                if (blVar2 != null) {
                    blVar3 = this.a.c;
                    String d = aiVar.d();
                    writeData4 = this.a.b;
                    blVar3.a(false, d, bdVar, writeData4, e);
                }
            }
        }
    }
}
