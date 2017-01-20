package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0057a {
    final /* synthetic */ ab eDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eDM = abVar;
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void Q(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eDM.eDI;
            if (afVar != null) {
                afVar2 = this.eDM.eDI;
                if (afVar2.eDO != null) {
                    afVar3 = this.eDM.eDI;
                    afVar3.eDO.dk(false);
                    afVar4 = this.eDM.eDI;
                    afVar4.eDO.VN();
                }
            }
        }
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void R(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eDM.eDI;
            if (afVar != null) {
                afVar2 = this.eDM.eDI;
                if (afVar2.eDO != null) {
                    afVar3 = this.eDM.eDI;
                    afVar3.eDO.dk(true);
                    afVar4 = this.eDM.eDI;
                    afVar4.eDO.VM();
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
