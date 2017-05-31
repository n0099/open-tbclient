package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class au implements a.InterfaceC0059a {
    final int boR;
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.enc = pbActivity;
        this.boR = (int) pbActivity.getResources().getDimension(w.f.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Y(int i, int i2) {
        fx fxVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (S(i2)) {
            fxVar = this.enc.elU;
            if (fxVar != null) {
                fVar = this.enc.elw;
                if (fVar != null) {
                    fVar2 = this.enc.elw;
                    fVar2.dO(false);
                    fVar3 = this.enc.elw;
                    fVar3.Ye();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Z(int i, int i2) {
        fx fxVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        fx fxVar2;
        fx fxVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (S(i2)) {
            fxVar = this.enc.elU;
            if (fxVar != null) {
                fVar = this.enc.elw;
                if (fVar != null) {
                    fVar2 = this.enc.elw;
                    fVar2.dO(true);
                    if (Math.abs(i2) > this.boR) {
                        fVar3 = this.enc.elw;
                        fVar3.Yd();
                    }
                    if (this.enc.aJX()) {
                        fxVar2 = this.enc.elU;
                        fxVar2.aMp();
                        fxVar3 = this.enc.elU;
                        fxVar3.aMq();
                    }
                }
            }
        }
    }

    private boolean S(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
