package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0056a {
    final /* synthetic */ ab eHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eHo = abVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void V(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eHo.eHk;
            if (afVar != null) {
                afVar2 = this.eHo.eHk;
                if (afVar2.eHq != null) {
                    afVar3 = this.eHo.eHk;
                    afVar3.eHq.dk(false);
                    afVar4 = this.eHo.eHk;
                    afVar4.eHq.WL();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void W(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eHo.eHk;
            if (afVar != null) {
                afVar2 = this.eHo.eHk;
                if (afVar2.eHq != null) {
                    afVar3 = this.eHo.eHk;
                    afVar3.eHq.dk(true);
                    afVar4 = this.eHo.eHk;
                    afVar4.eHq.WK();
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
