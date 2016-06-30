package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aq implements c.InterfaceC0054c {
    final int bDC;
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.dPF = pbActivity;
        this.bDC = (int) pbActivity.getResources().getDimension(u.e.ds98);
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0054c
    public void K(int i, int i2) {
        es esVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        es esVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (B(i2)) {
            esVar = this.dPF.dOO;
            if (esVar != null) {
                fVar = this.dPF.dOx;
                if (fVar != null) {
                    esVar2 = this.dPF.dOO;
                    esVar2.aHP();
                    fVar2 = this.dPF.dOx;
                    fVar2.dt(false);
                    fVar3 = this.dPF.dOx;
                    fVar3.Xk();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0054c
    public void L(int i, int i2) {
        es esVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        es esVar2;
        es esVar3;
        es esVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (B(i2)) {
            esVar = this.dPF.dOO;
            if (esVar != null) {
                fVar = this.dPF.dOx;
                if (fVar != null) {
                    fVar2 = this.dPF.dOx;
                    fVar2.dt(true);
                    if (Math.abs(i2) > this.bDC) {
                        esVar4 = this.dPF.dOO;
                        esVar4.aHO();
                        fVar3 = this.dPF.dOx;
                        fVar3.Xj();
                    }
                    if (this.dPF.aEV()) {
                        esVar2 = this.dPF.dOO;
                        esVar2.aGZ();
                        esVar3 = this.dPF.dOO;
                        esVar3.aHa();
                    }
                }
            }
        }
    }

    private boolean B(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
