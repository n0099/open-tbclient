package com.baidu.tieba.pb;

import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.model.be {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1204a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f1204a = newPbActivity;
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
        bkVar = this.f1204a.p;
        bkVar.a(z);
        if (z) {
            bkVar3 = this.f1204a.p;
            bkVar3.O();
            bdVar = this.f1204a.l;
            WriteData a2 = bdVar.a();
            bdVar2 = this.f1204a.l;
            bdVar2.a((WriteData) null);
            bdVar3 = this.f1204a.l;
            bdVar3.a(false);
            bkVar4 = this.f1204a.p;
            bkVar4.d(str);
            if (a2 != null) {
                String floor = a2.getFloor();
                if (a2 == null || a2.getType() != 2) {
                    axVar = this.f1204a.j;
                    if (axVar.l()) {
                        bkVar5 = this.f1204a.p;
                        bkVar5.m();
                        return;
                    }
                    return;
                }
                baVar = this.f1204a.n;
                baVar.f();
                if (floor != null) {
                    axVar2 = this.f1204a.j;
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
                    bkVar6 = this.f1204a.p;
                    bkVar6.a(j);
                }
            }
        } else if (beVar == null || writeData == null || beVar.b() == null) {
            bkVar2 = this.f1204a.p;
            bkVar2.d(str);
        } else {
            writeData.setVcodeMD5(beVar.a());
            writeData.setVcodeUrl(beVar.b());
            if (beVar.c().equals("4")) {
                NewVcodeActivity.a(this.f1204a, writeData, 1200006);
            } else {
                VcodeActivity.a(this.f1204a, writeData, 1200006);
            }
        }
    }
}
