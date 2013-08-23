package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1384a;
    private com.baidu.tieba.a.l b = null;
    private String c = null;
    private boolean d = false;

    public bj(bh bhVar) {
        this.f1384a = bhVar;
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
        writeData = this.f1384a.b;
        z = this.f1384a.d;
        this.c = lVar.a(writeData, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bi biVar;
        bi biVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        biVar = this.f1384a.c;
        if (biVar != null) {
            biVar2 = this.f1384a.c;
            biVar2.a(false, null, null, null);
        }
        super.cancel(true);
        this.f1384a.f1383a = null;
    }

    private void a(int i, String str) {
        bi biVar;
        bi biVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bi biVar3;
        bi biVar4;
        WriteData writeData4;
        bi biVar5;
        bi biVar6;
        if (i != 5 && i != 6) {
            biVar5 = this.f1384a.c;
            if (biVar5 != null) {
                biVar6 = this.f1384a.c;
                biVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.data.bj bjVar = new com.baidu.tieba.data.bj();
        bjVar.a(this.c);
        if (bjVar.b() != null) {
            writeData = this.f1384a.b;
            if (writeData != null) {
                writeData2 = this.f1384a.b;
                writeData2.setVcodeMD5(bjVar.a());
                writeData3 = this.f1384a.b;
                writeData3.setVcodeUrl(bjVar.b());
                biVar3 = this.f1384a.c;
                if (biVar3 != null) {
                    biVar4 = this.f1384a.c;
                    writeData4 = this.f1384a.b;
                    biVar4.a(false, str, bjVar, writeData4);
                    return;
                }
                return;
            }
        }
        biVar = this.f1384a.c;
        if (biVar != null) {
            biVar2 = this.f1384a.c;
            biVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        super.a((Object) str);
        com.baidu.tieba.util.aq.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.f1384a.f1383a = null;
        if (!this.d) {
            if (str == null) {
                biVar = this.f1384a.c;
                biVar.a(false, TiebaApplication.g().getString(R.string.neterror), null, null);
            } else if (this.b.a()) {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.c);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    rVar.a(TiebaApplication.g().getString(R.string.send_success));
                    biVar2 = this.f1384a.c;
                    if (biVar2 != null) {
                        biVar3 = this.f1384a.c;
                        biVar3.a(true, rVar.b(), null, null);
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
