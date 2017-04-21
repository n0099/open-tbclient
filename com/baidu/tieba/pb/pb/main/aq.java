package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aq implements a.InterfaceC0055a {
    final int bnn;
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.emk = pbActivity;
        this.bnn = (int) pbActivity.getResources().getDimension(w.f.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        ey eyVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        ey eyVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            eyVar = this.emk.eli;
            if (eyVar != null) {
                fVar = this.emk.ekO;
                if (fVar != null) {
                    eyVar2 = this.emk.eli;
                    eyVar2.aOH();
                    fVar2 = this.emk.ekO;
                    fVar2.dw(false);
                    fVar3 = this.emk.ekO;
                    fVar3.Yk();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void W(int i, int i2) {
        ey eyVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            eyVar = this.emk.eli;
            if (eyVar != null) {
                fVar = this.emk.ekO;
                if (fVar != null) {
                    fVar2 = this.emk.ekO;
                    fVar2.dw(true);
                    if (Math.abs(i2) > this.bnn) {
                        eyVar4 = this.emk.eli;
                        eyVar4.aOG();
                        fVar3 = this.emk.ekO;
                        fVar3.Yj();
                    }
                    if (this.emk.aLI()) {
                        eyVar2 = this.emk.eli;
                        eyVar2.aOc();
                        eyVar3 = this.emk.eli;
                        eyVar3.aOd();
                    }
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
