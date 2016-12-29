package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0057a {
    final /* synthetic */ ab etS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.etS = abVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void P(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (aa(i2)) {
            afVar = this.etS.etO;
            if (afVar != null) {
                afVar2 = this.etS.etO;
                if (afVar2.etU != null) {
                    afVar3 = this.etS.etO;
                    afVar3.etU.dd(false);
                    afVar4 = this.etS.etO;
                    afVar4.etU.Us();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void Q(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (aa(i2)) {
            afVar = this.etS.etO;
            if (afVar != null) {
                afVar2 = this.etS.etO;
                if (afVar2.etU != null) {
                    afVar3 = this.etS.etO;
                    afVar3.etU.dd(true);
                    afVar4 = this.etS.etO;
                    afVar4.etU.Ur();
                }
            }
        }
    }

    private boolean aa(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
