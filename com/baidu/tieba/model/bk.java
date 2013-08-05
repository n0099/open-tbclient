package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f1352a;
    private com.baidu.tieba.a.l b = null;
    private String c = null;
    private boolean d = false;

    public bk(bi biVar) {
        this.f1352a = biVar;
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
        this.b = new com.baidu.tieba.a.l();
        com.baidu.tieba.a.l lVar = this.b;
        writeData = this.f1352a.b;
        z = this.f1352a.d;
        this.c = lVar.a(writeData, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bj bjVar;
        bj bjVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        bjVar = this.f1352a.c;
        if (bjVar != null) {
            bjVar2 = this.f1352a.c;
            bjVar2.a(false, null, null, null);
        }
        super.cancel(true);
        this.f1352a.f1351a = null;
    }

    private void a(int i, String str) {
        bj bjVar;
        bj bjVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bj bjVar3;
        bj bjVar4;
        WriteData writeData4;
        bj bjVar5;
        bj bjVar6;
        if (i != 5 && i != 6) {
            bjVar5 = this.f1352a.c;
            if (bjVar5 != null) {
                bjVar6 = this.f1352a.c;
                bjVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.data.bq bqVar = new com.baidu.tieba.data.bq();
        bqVar.a(this.c);
        if (bqVar.b() != null) {
            writeData = this.f1352a.b;
            if (writeData != null) {
                writeData2 = this.f1352a.b;
                writeData2.setVcodeMD5(bqVar.a());
                writeData3 = this.f1352a.b;
                writeData3.setVcodeUrl(bqVar.b());
                bjVar3 = this.f1352a.c;
                if (bjVar3 != null) {
                    bjVar4 = this.f1352a.c;
                    writeData4 = this.f1352a.b;
                    bjVar4.a(false, str, bqVar, writeData4);
                    return;
                }
                return;
            }
        }
        bjVar = this.f1352a.c;
        if (bjVar != null) {
            bjVar2 = this.f1352a.c;
            bjVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        super.a((Object) str);
        com.baidu.tieba.util.aj.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.f1352a.f1351a = null;
        if (!this.d) {
            if (str == null) {
                bjVar = this.f1352a.c;
                bjVar.a(false, TiebaApplication.f().getString(R.string.neterror), null, null);
            } else if (this.b.a()) {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.c);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    rVar.a(TiebaApplication.f().getString(R.string.send_success));
                    bjVar2 = this.f1352a.c;
                    if (bjVar2 != null) {
                        bjVar3 = this.f1352a.c;
                        bjVar3.a(true, rVar.b(), null, null);
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
