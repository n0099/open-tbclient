package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class bw extends com.baidu.adp.a.h {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bn bnVar) {
        this.a = bnVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        ag agVar;
        com.baidu.tieba.model.av avVar;
        ak akVar;
        com.baidu.tieba.model.av avVar2;
        ak akVar2;
        com.baidu.tieba.model.av avVar3;
        ak akVar3;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        com.baidu.tieba.model.av avVar6;
        ak akVar4;
        com.baidu.tbadk.core.e eVar2;
        com.baidu.tbadk.core.e eVar3;
        ag agVar2;
        agVar = this.a.o;
        if (agVar != null) {
            agVar2 = this.a.o;
            agVar2.c();
        }
        avVar = this.a.c;
        if (avVar.getLoadDataMode() != 1) {
            avVar5 = this.a.c;
            if (avVar5.getLoadDataMode() != 2) {
                avVar6 = this.a.c;
                if (avVar6.getLoadDataMode() == 3) {
                    akVar4 = this.a.l;
                    if (akVar4 != null) {
                        if (((Boolean) obj).booleanValue()) {
                            eVar2 = this.a.f;
                            eVar3 = this.a.f;
                            eVar2.a(eVar3.getResources().getString(com.baidu.tieba.a.k.success));
                            this.a.f();
                            return;
                        }
                        eVar = this.a.f;
                        avVar4 = this.a.c;
                        eVar.a(avVar4.getErrorString());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            akVar = this.a.l;
            akVar.g();
            eVar = this.a.f;
            avVar4 = this.a.c;
            eVar.a(avVar4.getErrorString());
            return;
        }
        bn.j(this.a);
        avVar2 = this.a.c;
        if (avVar2.b()) {
            akVar3 = this.a.l;
            akVar3.b();
            return;
        }
        akVar2 = this.a.l;
        avVar3 = this.a.c;
        akVar2.a(avVar3);
    }
}
