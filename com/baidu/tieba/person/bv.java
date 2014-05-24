package com.baidu.tieba.person;

import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.base.e {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        af afVar;
        com.baidu.tieba.model.av avVar;
        aj ajVar;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.model.av avVar2;
        com.baidu.tieba.model.av avVar3;
        aj ajVar2;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        com.baidu.tieba.model.av avVar6;
        boolean z;
        com.baidu.tieba.model.e eVar;
        af afVar2;
        com.baidu.tieba.model.av avVar7;
        aj ajVar3;
        com.baidu.tieba.model.av avVar8;
        com.baidu.tieba.model.av avVar9;
        aj ajVar4;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.av avVar10;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
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
                            baseFragmentActivity3 = this.a.f;
                            baseFragmentActivity4 = this.a.f;
                            baseFragmentActivity3.a(baseFragmentActivity4.getResources().getString(com.baidu.tieba.y.success));
                            this.a.h();
                            return;
                        }
                        baseFragmentActivity2 = this.a.f;
                        avVar10 = this.a.c;
                        baseFragmentActivity2.a(avVar10.getErrorString());
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
            baseFragmentActivity = this.a.f;
            avVar2 = this.a.c;
            baseFragmentActivity.a(avVar2.getErrorString());
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
            eVar = this.a.d;
            eVar.a(z ? 1 : 0);
            afVar2 = this.a.n;
            afVar2.b(z);
        }
    }
}
