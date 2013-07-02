package com.baidu.tieba.pb;

import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.model.be {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.be
    public void a(boolean z, String str, com.baidu.tieba.data.be beVar, WriteData writeData) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.model.bd bdVar;
        com.baidu.tieba.model.bd bdVar2;
        com.baidu.tieba.model.bd bdVar3;
        bk bkVar4;
        com.baidu.tieba.model.ax axVar;
        bk bkVar5;
        com.baidu.tieba.model.ba baVar;
        com.baidu.tieba.model.ax axVar2;
        bk bkVar6;
        bkVar = this.a.p;
        bkVar.a(z);
        if (z) {
            bkVar3 = this.a.p;
            bkVar3.O();
            bdVar = this.a.l;
            WriteData a = bdVar.a();
            bdVar2 = this.a.l;
            bdVar2.a((WriteData) null);
            bdVar3 = this.a.l;
            bdVar3.a(false);
            bkVar4 = this.a.p;
            bkVar4.d(str);
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    axVar = this.a.j;
                    if (axVar.l()) {
                        bkVar5 = this.a.p;
                        bkVar5.m();
                        return;
                    }
                    return;
                }
                baVar = this.a.n;
                baVar.f();
                if (floor != null) {
                    axVar2 = this.a.j;
                    com.baidu.tieba.data.aj j = axVar2.j();
                    Iterator it = j.d().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) it.next();
                        if (floor.equals(anVar.d())) {
                            anVar.b();
                            break;
                        }
                    }
                    bkVar6 = this.a.p;
                    bkVar6.a(j);
                }
            }
        } else if (beVar == null || writeData == null || beVar.b() == null) {
            bkVar2 = this.a.p;
            bkVar2.d(str);
        } else {
            writeData.setVcodeMD5(beVar.a());
            writeData.setVcodeUrl(beVar.b());
            if (beVar.c().equals("4")) {
                NewVcodeActivity.a(this.a, writeData, 1200006);
            } else {
                VcodeActivity.a(this.a, writeData, 1200006);
            }
        }
    }
}
