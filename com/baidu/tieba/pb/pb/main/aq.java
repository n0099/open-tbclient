package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.f.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aq implements a.InterfaceC0057a {
    final int beq;
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.eiV = pbActivity;
        this.beq = (int) pbActivity.getResources().getDimension(r.f.ds98);
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void Q(int i, int i2) {
        ez ezVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        ez ezVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            ezVar = this.eiV.ehV;
            if (ezVar != null) {
                fVar = this.eiV.ehA;
                if (fVar != null) {
                    ezVar2 = this.eiV.ehV;
                    ezVar2.aOd();
                    fVar2 = this.eiV.ehA;
                    fVar2.dk(false);
                    fVar3 = this.eiV.ehA;
                    fVar3.VN();
                }
            }
        }
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void R(int i, int i2) {
        ez ezVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ez ezVar2;
        ez ezVar3;
        ez ezVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            ezVar = this.eiV.ehV;
            if (ezVar != null) {
                fVar = this.eiV.ehA;
                if (fVar != null) {
                    fVar2 = this.eiV.ehA;
                    fVar2.dk(true);
                    if (Math.abs(i2) > this.beq) {
                        ezVar4 = this.eiV.ehV;
                        ezVar4.aOc();
                        fVar3 = this.eiV.ehA;
                        fVar3.VM();
                    }
                    if (this.eiV.aLh()) {
                        ezVar2 = this.eiV.ehV;
                        ezVar2.aNz();
                        ezVar3 = this.eiV.ehV;
                        ezVar3.aNA();
                    }
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
