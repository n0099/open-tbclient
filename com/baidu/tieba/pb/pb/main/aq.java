package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.d.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aq implements c.InterfaceC0055c {
    final int bEM;
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.ebT = pbActivity;
        this.bEM = (int) pbActivity.getResources().getDimension(u.e.ds98);
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0055c
    public void K(int i, int i2) {
        ew ewVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        ew ewVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (L(i2)) {
            ewVar = this.ebT.ebb;
            if (ewVar != null) {
                fVar = this.ebT.eaK;
                if (fVar != null) {
                    ewVar2 = this.ebT.ebb;
                    ewVar2.aKZ();
                    fVar2 = this.ebT.eaK;
                    fVar2.dq(false);
                    fVar3 = this.ebT.eaK;
                    fVar3.XC();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.c.InterfaceC0055c
    public void L(int i, int i2) {
        ew ewVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ew ewVar2;
        ew ewVar3;
        ew ewVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (L(i2)) {
            ewVar = this.ebT.ebb;
            if (ewVar != null) {
                fVar = this.ebT.eaK;
                if (fVar != null) {
                    fVar2 = this.ebT.eaK;
                    fVar2.dq(true);
                    if (Math.abs(i2) > this.bEM) {
                        ewVar4 = this.ebT.ebb;
                        ewVar4.aKY();
                        fVar3 = this.ebT.eaK;
                        fVar3.XB();
                    }
                    if (this.ebT.aIg()) {
                        ewVar2 = this.ebT.ebb;
                        ewVar2.aKm();
                        ewVar3 = this.ebT.ebb;
                        ewVar3.aKn();
                    }
                }
            }
        }
    }

    private boolean L(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
