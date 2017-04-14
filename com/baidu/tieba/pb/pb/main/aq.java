package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aq implements a.InterfaceC0055a {
    final int bkW;
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.ejU = pbActivity;
        this.bkW = (int) pbActivity.getResources().getDimension(w.f.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        ey eyVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        ey eyVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            eyVar = this.ejU.eiS;
            if (eyVar != null) {
                fVar = this.ejU.eiy;
                if (fVar != null) {
                    eyVar2 = this.ejU.eiS;
                    eyVar2.aNG();
                    fVar2 = this.ejU.eiy;
                    fVar2.dm(false);
                    fVar3 = this.ejU.eiy;
                    fVar3.Xj();
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
            eyVar = this.ejU.eiS;
            if (eyVar != null) {
                fVar = this.ejU.eiy;
                if (fVar != null) {
                    fVar2 = this.ejU.eiy;
                    fVar2.dm(true);
                    if (Math.abs(i2) > this.bkW) {
                        eyVar4 = this.ejU.eiS;
                        eyVar4.aNF();
                        fVar3 = this.ejU.eiy;
                        fVar3.Xi();
                    }
                    if (this.ejU.aKI()) {
                        eyVar2 = this.ejU.eiS;
                        eyVar2.aNb();
                        eyVar3 = this.ejU.eiS;
                        eyVar3.aNc();
                    }
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
