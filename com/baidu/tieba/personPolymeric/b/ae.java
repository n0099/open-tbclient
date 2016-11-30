package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0058a {
    final /* synthetic */ ab eQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eQt = abVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (af(i2)) {
            afVar = this.eQt.eQp;
            if (afVar != null) {
                afVar2 = this.eQt.eQp;
                if (afVar2.eQv != null) {
                    afVar3 = this.eQt.eQp;
                    afVar3.eQv.dv(false);
                    afVar4 = this.eQt.eQp;
                    afVar4.eQv.aaf();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void Q(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (af(i2)) {
            afVar = this.eQt.eQp;
            if (afVar != null) {
                afVar2 = this.eQt.eQp;
                if (afVar2.eQv != null) {
                    afVar3 = this.eQt.eQp;
                    afVar3.eQv.dv(true);
                    afVar4 = this.eQt.eQp;
                    afVar4.eQv.aae();
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
