package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1924a;
    private com.baidu.tieba.a.n b = null;
    private String c = null;
    private boolean d = false;

    public bt(br brVar) {
        this.f1924a = brVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        WriteData writeData;
        boolean z;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.a.n();
        com.baidu.tieba.a.n nVar = this.b;
        writeData = this.f1924a.b;
        z = this.f1924a.d;
        this.c = nVar.a(writeData, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bs bsVar;
        bs bsVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        bsVar = this.f1924a.c;
        if (bsVar != null) {
            bsVar2 = this.f1924a.c;
            bsVar2.a(false, null, null, null);
        }
        super.cancel(true);
        this.f1924a.f1923a = null;
    }

    private void a(int i, String str) {
        bs bsVar;
        bs bsVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bs bsVar3;
        bs bsVar4;
        WriteData writeData4;
        bs bsVar5;
        bs bsVar6;
        if (i != 5 && i != 6) {
            bsVar5 = this.f1924a.c;
            if (bsVar5 != null) {
                bsVar6 = this.f1924a.c;
                bsVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.data.bh bhVar = new com.baidu.tieba.data.bh();
        bhVar.a(this.c);
        if (bhVar.b() != null) {
            writeData = this.f1924a.b;
            if (writeData != null) {
                writeData2 = this.f1924a.b;
                writeData2.setVcodeMD5(bhVar.a());
                writeData3 = this.f1924a.b;
                writeData3.setVcodeUrl(bhVar.b());
                bsVar3 = this.f1924a.c;
                if (bsVar3 != null) {
                    bsVar4 = this.f1924a.c;
                    writeData4 = this.f1924a.b;
                    bsVar4.a(false, str, bhVar, writeData4);
                    return;
                }
                return;
            }
        }
        bsVar = this.f1924a.c;
        if (bsVar != null) {
            bsVar2 = this.f1924a.c;
            bsVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        super.a((bt) str);
        com.baidu.tieba.util.be.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.f1924a.f1923a = null;
        if (!this.d) {
            if (str == null) {
                bsVar = this.f1924a.c;
                bsVar.a(false, TiebaApplication.g().getString(R.string.neterror), null, null);
            } else if (this.b.a()) {
                com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
                sVar.b(this.c);
                if (sVar.b() == null || sVar.b().length() <= 0) {
                    sVar.a(TiebaApplication.g().getString(R.string.send_success));
                    bsVar2 = this.f1924a.c;
                    if (bsVar2 != null) {
                        bsVar3 = this.f1924a.c;
                        bsVar3.a(true, sVar.b(), null, null);
                        return;
                    }
                    return;
                }
                a(sVar.a(), sVar.b());
            } else {
                a(this.b.b(), this.b.c());
            }
        }
    }
}
