package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.InterfaceC0055a {
    final /* synthetic */ ab eHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.eHQ = abVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void N(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (af(i2)) {
            afVar = this.eHQ.eHM;
            if (afVar != null) {
                afVar2 = this.eHQ.eHM;
                if (afVar2.eHT != null) {
                    afVar3 = this.eHQ.eHM;
                    afVar3.eHT.dp(false);
                    afVar4 = this.eHQ.eHM;
                    afVar4.eHT.YO();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void O(int i, int i2) {
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        if (af(i2)) {
            afVar = this.eHQ.eHM;
            if (afVar != null) {
                afVar2 = this.eHQ.eHM;
                if (afVar2.eHT != null) {
                    afVar3 = this.eHQ.eHM;
                    afVar3.eHT.dp(true);
                    afVar4 = this.eHQ.eHM;
                    afVar4.eHT.YN();
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
