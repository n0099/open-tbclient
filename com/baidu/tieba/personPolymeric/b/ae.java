package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0055a {
    final /* synthetic */ ab eFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eFk = abVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (T(i2)) {
            afVar = this.eFk.eFg;
            if (afVar != null) {
                afVar2 = this.eFk.eFg;
                if (afVar2.eFm != null) {
                    afVar3 = this.eFk.eFg;
                    afVar3.eFm.dm(false);
                    afVar4 = this.eFk.eFg;
                    afVar4.eFm.Xj();
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
            afVar = this.eFk.eFg;
            if (afVar != null) {
                afVar2 = this.eFk.eFg;
                if (afVar2.eFm != null) {
                    afVar3 = this.eFk.eFg;
                    afVar3.eFm.dm(true);
                    afVar4 = this.eFk.eFg;
                    afVar4.eFm.Xi();
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
