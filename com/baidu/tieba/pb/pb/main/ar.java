package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ar implements a.InterfaceC0059a {
    final int bnK;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.ehy = pbActivity;
        this.bnK = (int) pbActivity.getResources().getDimension(w.f.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void W(int i, int i2) {
        fm fmVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            fmVar = this.ehy.egt;
            if (fmVar != null) {
                fVar = this.ehy.efX;
                if (fVar != null) {
                    fVar2 = this.ehy.efX;
                    fVar2.dx(false);
                    fVar3 = this.ehy.efX;
                    fVar3.Xb();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void X(int i, int i2) {
        fm fmVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        fm fmVar2;
        fm fmVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (T(i2)) {
            fmVar = this.ehy.egt;
            if (fmVar != null) {
                fVar = this.ehy.efX;
                if (fVar != null) {
                    fVar2 = this.ehy.efX;
                    fVar2.dx(true);
                    if (Math.abs(i2) > this.bnK) {
                        fVar3 = this.ehy.efX;
                        fVar3.Xa();
                    }
                    if (this.ehy.aJf()) {
                        fmVar2 = this.ehy.egt;
                        fmVar2.aLt();
                        fmVar3 = this.ehy.egt;
                        fmVar3.aLu();
                    }
                }
            }
        }
    }

    private boolean T(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
