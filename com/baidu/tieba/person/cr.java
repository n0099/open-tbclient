package com.baidu.tieba.person;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class cr extends com.baidu.adp.a.g {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        bj bjVar;
        com.baidu.tieba.model.bp bpVar;
        bj bjVar2;
        com.baidu.tieba.model.bp bpVar2;
        bj bjVar3;
        com.baidu.tieba.model.bp bpVar3;
        bj bjVar4;
        com.baidu.tieba.k kVar;
        com.baidu.tieba.model.bp bpVar4;
        com.baidu.tieba.model.bp bpVar5;
        com.baidu.tieba.model.bp bpVar6;
        bj bjVar5;
        com.baidu.tieba.k kVar2;
        com.baidu.tieba.k kVar3;
        bj bjVar6;
        bjVar = this.a.m;
        if (bjVar != null) {
            bjVar6 = this.a.m;
            bjVar6.b();
        }
        bpVar = this.a.c;
        if (bpVar.getLoadDataMode() != 1) {
            bpVar5 = this.a.c;
            if (bpVar5.getLoadDataMode() != 2) {
                bpVar6 = this.a.c;
                if (bpVar6.getLoadDataMode() == 3) {
                    bjVar5 = this.a.m;
                    if (bjVar5 != null) {
                        if (((Boolean) obj).booleanValue()) {
                            kVar2 = this.a.f;
                            kVar3 = this.a.f;
                            kVar2.a(kVar3.getResources().getString(R.string.success));
                            this.a.e();
                            return;
                        }
                        kVar = this.a.f;
                        bpVar4 = this.a.c;
                        kVar.a(bpVar4.getErrorString());
                    }
                    return;
                }
                return;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            bpVar2 = this.a.c;
            if (bpVar2.b()) {
                bjVar4 = this.a.m;
                bjVar4.a();
                return;
            }
            cm.d(this.a);
            bjVar3 = this.a.m;
            bpVar3 = this.a.c;
            bjVar3.a(bpVar3);
            return;
        }
        bjVar2 = this.a.m;
        bjVar2.f();
        kVar = this.a.f;
        bpVar4 = this.a.c;
        kVar.a(bpVar4.getErrorString());
    }
}
