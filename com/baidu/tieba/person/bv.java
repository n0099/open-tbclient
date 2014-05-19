package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.base.g {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        af afVar;
        com.baidu.tieba.model.av avVar;
        aj ajVar;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tieba.model.av avVar2;
        com.baidu.tieba.model.av avVar3;
        aj ajVar2;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        com.baidu.tieba.model.av avVar6;
        boolean z;
        com.baidu.tieba.model.e eVar2;
        af afVar2;
        com.baidu.tieba.model.av avVar7;
        aj ajVar3;
        com.baidu.tieba.model.av avVar8;
        com.baidu.tieba.model.av avVar9;
        aj ajVar4;
        com.baidu.tbadk.core.e eVar3;
        com.baidu.tieba.model.av avVar10;
        com.baidu.tbadk.core.e eVar4;
        com.baidu.tbadk.core.e eVar5;
        af afVar3;
        afVar = this.a.n;
        if (afVar != null) {
            afVar3 = this.a.n;
            afVar3.d();
        }
        avVar = this.a.c;
        if (avVar.getLoadDataMode() != 1) {
            avVar8 = this.a.c;
            if (avVar8.getLoadDataMode() != 2) {
                avVar9 = this.a.c;
                if (avVar9.getLoadDataMode() == 3) {
                    ajVar4 = this.a.k;
                    if (ajVar4 != null) {
                        if (((Boolean) obj).booleanValue()) {
                            eVar4 = this.a.f;
                            eVar5 = this.a.f;
                            eVar4.a(eVar5.getResources().getString(com.baidu.tieba.u.success));
                            this.a.h();
                            return;
                        }
                        eVar3 = this.a.f;
                        avVar10 = this.a.c;
                        eVar3.a(avVar10.getErrorString());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            ajVar = this.a.k;
            ajVar.i();
            eVar = this.a.f;
            avVar2 = this.a.c;
            eVar.a(avVar2.getErrorString());
            return;
        }
        this.a.m();
        avVar3 = this.a.c;
        if (avVar3.b()) {
            ajVar3 = this.a.k;
            ajVar3.c();
        } else {
            ajVar2 = this.a.k;
            avVar4 = this.a.c;
            ajVar2.a(avVar4);
        }
        avVar5 = this.a.c;
        if (!avVar5.f()) {
            avVar6 = this.a.c;
            if (avVar6.g() != null) {
                avVar7 = this.a.c;
                z = avVar7.g().isMask();
            } else {
                z = false;
            }
            eVar2 = this.a.d;
            eVar2.a(z ? 1 : 0);
            afVar2 = this.a.n;
            afVar2.b(z);
        }
    }
}
