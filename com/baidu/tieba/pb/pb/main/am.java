package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.c.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class am implements c.InterfaceC0053c {
    final int bhm;
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.djE = pbActivity;
        this.bhm = (int) pbActivity.getResources().getDimension(t.e.ds98);
    }

    @Override // com.baidu.tieba.c.c.InterfaceC0053c
    public void O(int i, int i2) {
        el elVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        el elVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (v(i2)) {
            elVar = this.djE.diR;
            if (elVar != null) {
                fVar = this.djE.diy;
                if (fVar != null) {
                    elVar2 = this.djE.diR;
                    elVar2.azD();
                    fVar2 = this.djE.diy;
                    fVar2.cX(false);
                    fVar3 = this.djE.diy;
                    fVar3.RS();
                }
            }
        }
    }

    @Override // com.baidu.tieba.c.c.InterfaceC0053c
    public void P(int i, int i2) {
        el elVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        el elVar2;
        el elVar3;
        el elVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (v(i2)) {
            elVar = this.djE.diR;
            if (elVar != null) {
                fVar = this.djE.diy;
                if (fVar != null) {
                    fVar2 = this.djE.diy;
                    fVar2.cX(true);
                    if (Math.abs(i2) > this.bhm) {
                        elVar4 = this.djE.diR;
                        elVar4.azC();
                        fVar3 = this.djE.diy;
                        fVar3.RR();
                    }
                    if (this.djE.awP()) {
                        elVar2 = this.djE.diR;
                        elVar2.ayQ();
                        elVar3 = this.djE.diR;
                        elVar3.ayR();
                    }
                }
            }
        }
    }

    private boolean v(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
