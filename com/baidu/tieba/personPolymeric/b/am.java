package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.InterfaceC0059a {
    final /* synthetic */ aj eLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.eLE = ajVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Y(int i, int i2) {
        as asVar;
        as asVar2;
        as asVar3;
        as asVar4;
        if (S(i2)) {
            asVar = this.eLE.bwG;
            if (asVar != null) {
                asVar2 = this.eLE.bwG;
                if (asVar2.eLJ != null) {
                    asVar3 = this.eLE.bwG;
                    asVar3.eLJ.dO(false);
                    asVar4 = this.eLE.bwG;
                    asVar4.eLJ.Ye();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Z(int i, int i2) {
        as asVar;
        as asVar2;
        as asVar3;
        as asVar4;
        if (S(i2)) {
            asVar = this.eLE.bwG;
            if (asVar != null) {
                asVar2 = this.eLE.bwG;
                if (asVar2.eLJ != null) {
                    asVar3 = this.eLE.bwG;
                    asVar3.eLJ.dO(true);
                    asVar4 = this.eLE.bwG;
                    asVar4.eLJ.Yd();
                }
            }
        }
    }

    private boolean S(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
