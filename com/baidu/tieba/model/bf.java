package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask {
    final /* synthetic */ bd a;
    private com.baidu.tieba.a.g b = null;
    private String c = null;
    private boolean d = false;

    public bf(bd bdVar) {
        this.a = bdVar;
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
        this.b = new com.baidu.tieba.a.g();
        com.baidu.tieba.a.g gVar = this.b;
        writeData = this.a.b;
        z = this.a.d;
        this.c = gVar.a(writeData, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        be beVar;
        be beVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        beVar = this.a.c;
        if (beVar != null) {
            beVar2 = this.a.c;
            beVar2.a(false, null, null, null);
        }
        super.cancel(true);
        this.a.a = null;
    }

    private void a(int i, String str) {
        be beVar;
        be beVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        be beVar3;
        be beVar4;
        WriteData writeData4;
        be beVar5;
        be beVar6;
        if (i != 5 && i != 6) {
            beVar5 = this.a.c;
            if (beVar5 != null) {
                beVar6 = this.a.c;
                beVar6.a(false, str, null, null);
                return;
            }
            return;
        }
        com.baidu.tieba.data.be beVar7 = new com.baidu.tieba.data.be();
        beVar7.a(this.c);
        if (beVar7.b() != null) {
            writeData = this.a.b;
            if (writeData != null) {
                writeData2 = this.a.b;
                writeData2.setVcodeMD5(beVar7.a());
                writeData3 = this.a.b;
                writeData3.setVcodeUrl(beVar7.b());
                beVar3 = this.a.c;
                if (beVar3 != null) {
                    beVar4 = this.a.c;
                    writeData4 = this.a.b;
                    beVar4.a(false, str, beVar7, writeData4);
                    return;
                }
                return;
            }
        }
        beVar = this.a.c;
        if (beVar != null) {
            beVar2 = this.a.c;
            beVar2.a(false, str, null, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        be beVar;
        be beVar2;
        be beVar3;
        super.a((Object) str);
        com.baidu.tieba.util.z.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.a.a = null;
        if (!this.d) {
            if (str == null) {
                beVar = this.a.c;
                beVar.a(false, TiebaApplication.f().getString(R.string.neterror), null, null);
            } else if (this.b.a()) {
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.b(this.c);
                if (nVar.b() == null || nVar.b().length() <= 0) {
                    nVar.a(TiebaApplication.f().getString(R.string.send_success));
                    beVar2 = this.a.c;
                    if (beVar2 != null) {
                        beVar3 = this.a.c;
                        beVar3.a(true, nVar.b(), null, null);
                        return;
                    }
                    return;
                }
                a(nVar.a(), nVar.b());
            } else {
                a(this.b.b(), this.b.c());
            }
        }
    }
}
