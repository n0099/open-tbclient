package com.baidu.tieba.pb;

import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.c.be {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.be
    public void a(boolean z, String str, com.baidu.tieba.a.bf bfVar, com.baidu.tieba.a.bi biVar) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.c.bd bdVar;
        com.baidu.tieba.c.bd bdVar2;
        com.baidu.tieba.c.bd bdVar3;
        bk bkVar4;
        com.baidu.tieba.c.ax axVar;
        bk bkVar5;
        com.baidu.tieba.c.ba baVar;
        com.baidu.tieba.c.ax axVar2;
        bk bkVar6;
        bkVar = this.a.o;
        bkVar.o();
        if (z) {
            bkVar3 = this.a.o;
            bkVar3.O();
            bdVar = this.a.k;
            com.baidu.tieba.a.bi d = bdVar.d();
            bdVar2 = this.a.k;
            bdVar2.a((com.baidu.tieba.a.bi) null);
            bdVar3 = this.a.k;
            bdVar3.a(false);
            bkVar4 = this.a.o;
            bkVar4.d(str);
            if (d != null) {
                String f = d.f();
                if (d == null || d.b() != 2) {
                    axVar = this.a.i;
                    if (axVar.o()) {
                        bkVar5 = this.a.o;
                        bkVar5.m();
                        return;
                    }
                    return;
                }
                baVar = this.a.m;
                baVar.j();
                if (f != null) {
                    axVar2 = this.a.i;
                    com.baidu.tieba.a.am m = axVar2.m();
                    Iterator it = m.d().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.a.ar arVar = (com.baidu.tieba.a.ar) it.next();
                        if (f.equals(arVar.d())) {
                            arVar.b();
                            break;
                        }
                    }
                    bkVar6 = this.a.o;
                    bkVar6.a(m);
                }
            }
        } else if (bfVar == null || biVar == null || bfVar.b() == null) {
            bkVar2 = this.a.o;
            bkVar2.d(str);
        } else {
            biVar.h(bfVar.a());
            biVar.i(bfVar.b());
            if (bfVar.c().equals("4")) {
                NewVcodeActivity.a(this.a, biVar, 1200006);
            } else {
                VcodeActivity.a(this.a, biVar, 1200006);
            }
        }
    }
}
