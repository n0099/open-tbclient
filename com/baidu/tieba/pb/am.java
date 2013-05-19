package com.baidu.tieba.pb;

import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.c.bb {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.bb
    public void a(boolean z, String str, com.baidu.tieba.a.be beVar, com.baidu.tieba.a.bh bhVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        com.baidu.tieba.c.ba baVar;
        com.baidu.tieba.c.ba baVar2;
        bl blVar4;
        com.baidu.tieba.c.au auVar;
        bl blVar5;
        com.baidu.tieba.c.ax axVar;
        com.baidu.tieba.c.au auVar2;
        bl blVar6;
        blVar = this.a.o;
        blVar.o();
        if (z) {
            blVar3 = this.a.o;
            blVar3.N();
            baVar = this.a.k;
            com.baidu.tieba.a.bh d = baVar.d();
            baVar2 = this.a.k;
            baVar2.a((com.baidu.tieba.a.bh) null);
            blVar4 = this.a.o;
            blVar4.d(str);
            if (d != null) {
                String f = d.f();
                if (d == null || d.b() != 2) {
                    auVar = this.a.i;
                    if (auVar.n()) {
                        blVar5 = this.a.o;
                        blVar5.m();
                        return;
                    }
                    return;
                }
                axVar = this.a.m;
                axVar.j();
                if (f != null) {
                    auVar2 = this.a.i;
                    com.baidu.tieba.a.al l = auVar2.l();
                    Iterator it = l.d().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) it.next();
                        if (f.equals(aqVar.d())) {
                            aqVar.b();
                            break;
                        }
                    }
                    blVar6 = this.a.o;
                    blVar6.a(l);
                }
            }
        } else if (beVar == null || bhVar == null || beVar.b() == null) {
            blVar2 = this.a.o;
            blVar2.d(str);
        } else {
            bhVar.h(beVar.a());
            bhVar.i(beVar.b());
            if (beVar.c().equals("4")) {
                NewVcodeActivity.a(this.a, bhVar, 1200006);
            } else {
                VcodeActivity.a(this.a, bhVar, 1200006);
            }
        }
    }
}
