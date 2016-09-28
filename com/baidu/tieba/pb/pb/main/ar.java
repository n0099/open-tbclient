package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ar implements a.InterfaceC0058a {
    final int bQj;
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.eqa = pbActivity;
        this.bQj = (int) pbActivity.getResources().getDimension(r.e.ds98);
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void O(int i, int i2) {
        ex exVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        ex exVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (af(i2)) {
            exVar = this.eqa.epe;
            if (exVar != null) {
                fVar = this.eqa.eoN;
                if (fVar != null) {
                    exVar2 = this.eqa.epe;
                    exVar2.aQz();
                    fVar2 = this.eqa.eoN;
                    fVar2.dq(false);
                    fVar3 = this.eqa.eoN;
                    fVar3.Zd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        ex exVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ex exVar2;
        ex exVar3;
        ex exVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (af(i2)) {
            exVar = this.eqa.epe;
            if (exVar != null) {
                fVar = this.eqa.eoN;
                if (fVar != null) {
                    fVar2 = this.eqa.eoN;
                    fVar2.dq(true);
                    if (Math.abs(i2) > this.bQj) {
                        exVar4 = this.eqa.epe;
                        exVar4.aQy();
                        fVar3 = this.eqa.eoN;
                        fVar3.Zc();
                    }
                    if (this.eqa.aNE()) {
                        exVar2 = this.eqa.epe;
                        exVar2.aPM();
                        exVar3 = this.eqa.epe;
                        exVar3.aPN();
                    }
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
