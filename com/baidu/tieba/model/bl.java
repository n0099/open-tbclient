package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bj f1421a;
    private com.baidu.tieba.a.n b = null;
    private String c = null;
    private boolean d = false;

    public bl(bj bjVar) {
        this.f1421a = bjVar;
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
        writeData = this.f1421a.b;
        z = this.f1421a.d;
        this.c = nVar.a(writeData, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bk bkVar;
        bk bkVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        bkVar = this.f1421a.c;
        if (bkVar != null) {
            bkVar2 = this.f1421a.c;
            bkVar2.a(false, null, null, null);
        }
        super.cancel(true);
        this.f1421a.f1420a = null;
    }

    private void a(int i, String str) {
        bk bkVar;
        bk bkVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bk bkVar3;
        bk bkVar4;
        WriteData writeData4;
        bk bkVar5;
        bk bkVar6;
        if (i != 5 && i != 6) {
            bkVar5 = this.f1421a.c;
            if (bkVar5 != null) {
                bkVar6 = this.f1421a.c;
                bkVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.data.bj bjVar = new com.baidu.tieba.data.bj();
        bjVar.a(this.c);
        if (bjVar.b() != null) {
            writeData = this.f1421a.b;
            if (writeData != null) {
                writeData2 = this.f1421a.b;
                writeData2.setVcodeMD5(bjVar.a());
                writeData3 = this.f1421a.b;
                writeData3.setVcodeUrl(bjVar.b());
                bkVar3 = this.f1421a.c;
                if (bkVar3 != null) {
                    bkVar4 = this.f1421a.c;
                    writeData4 = this.f1421a.b;
                    bkVar4.a(false, str, bjVar, writeData4);
                    return;
                }
                return;
            }
        }
        bkVar = this.f1421a.c;
        if (bkVar != null) {
            bkVar2 = this.f1421a.c;
            bkVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        super.a((bl) str);
        com.baidu.tieba.util.av.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.f1421a.f1420a = null;
        if (!this.d) {
            if (str == null) {
                bkVar = this.f1421a.c;
                bkVar.a(false, TiebaApplication.g().getString(R.string.neterror), null, null);
            } else if (this.b.a()) {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.c);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    rVar.a(TiebaApplication.g().getString(R.string.send_success));
                    bkVar2 = this.f1421a.c;
                    if (bkVar2 != null) {
                        bkVar3 = this.f1421a.c;
                        bkVar3.a(true, rVar.b(), null, null);
                        return;
                    }
                    return;
                }
                a(rVar.a(), rVar.b());
            } else {
                a(this.b.b(), this.b.c());
            }
        }
    }
}
