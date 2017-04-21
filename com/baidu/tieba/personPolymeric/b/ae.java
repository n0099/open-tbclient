package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0055a {
    final /* synthetic */ ab eHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eHA = abVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eHA.eHw;
            if (afVar != null) {
                afVar2 = this.eHA.eHw;
                if (afVar2.eHC != null) {
                    afVar3 = this.eHA.eHw;
                    afVar3.eHC.dw(false);
                    afVar4 = this.eHA.eHw;
                    afVar4.eHC.Yk();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void W(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eHA.eHw;
            if (afVar != null) {
                afVar2 = this.eHA.eHw;
                if (afVar2.eHC != null) {
                    afVar3 = this.eHA.eHw;
                    afVar3.eHC.dw(true);
                    afVar4 = this.eHA.eHw;
                    afVar4.eHC.Yj();
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
