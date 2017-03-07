package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aq implements a.InterfaceC0056a {
    final int bld;
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.elO = pbActivity;
        this.bld = (int) pbActivity.getResources().getDimension(w.f.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void V(int i, int i2) {
        fa faVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        fa faVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            faVar = this.elO.ekM;
            if (faVar != null) {
                fVar = this.elO.eks;
                if (fVar != null) {
                    faVar2 = this.elO.ekM;
                    faVar2.aNx();
                    fVar2 = this.elO.eks;
                    fVar2.dk(false);
                    fVar3 = this.elO.eks;
                    fVar3.WL();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void W(int i, int i2) {
        fa faVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        fa faVar2;
        fa faVar3;
        fa faVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            faVar = this.elO.ekM;
            if (faVar != null) {
                fVar = this.elO.eks;
                if (fVar != null) {
                    fVar2 = this.elO.eks;
                    fVar2.dk(true);
                    if (Math.abs(i2) > this.bld) {
                        faVar4 = this.elO.ekM;
                        faVar4.aNw();
                        fVar3 = this.elO.eks;
                        fVar3.WK();
                    }
                    if (this.elO.aKC()) {
                        faVar2 = this.elO.ekM;
                        faVar2.aMS();
                        faVar3 = this.elO.ekM;
                        faVar3.aMT();
                    }
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
