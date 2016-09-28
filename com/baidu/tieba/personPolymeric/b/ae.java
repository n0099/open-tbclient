package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0058a {
    final /* synthetic */ ab eJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eJU = abVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void O(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (af(i2)) {
            afVar = this.eJU.eJQ;
            if (afVar != null) {
                afVar2 = this.eJU.eJQ;
                if (afVar2.eJX != null) {
                    afVar3 = this.eJU.eJQ;
                    afVar3.eJX.dq(false);
                    afVar4 = this.eJU.eJQ;
                    afVar4.eJX.Zd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (af(i2)) {
            afVar = this.eJU.eJQ;
            if (afVar != null) {
                afVar2 = this.eJU.eJQ;
                if (afVar2.eJX != null) {
                    afVar3 = this.eJU.eJQ;
                    afVar3.eJX.dq(true);
                    afVar4 = this.eJU.eJQ;
                    afVar4.eJX.Zc();
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
