package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0059a {
    final /* synthetic */ ab eCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eCS = abVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void W(int i, int i2) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        aj ajVar4;
        if (T(i2)) {
            ajVar = this.eCS.eCN;
            if (ajVar != null) {
                ajVar2 = this.eCS.eCN;
                if (ajVar2.eCX != null) {
                    ajVar3 = this.eCS.eCN;
                    ajVar3.eCX.dx(false);
                    ajVar4 = this.eCS.eCN;
                    ajVar4.eCX.Xb();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void X(int i, int i2) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        aj ajVar4;
        if (T(i2)) {
            ajVar = this.eCS.eCN;
            if (ajVar != null) {
                ajVar2 = this.eCS.eCN;
                if (ajVar2.eCX != null) {
                    ajVar3 = this.eCS.eCN;
                    ajVar3.eCX.dx(true);
                    ajVar4 = this.eCS.eCN;
                    ajVar4.eCX.Xa();
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
