package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ar implements a.InterfaceC0058a {
    final int bVH;
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.evL = pbActivity;
        this.bVH = (int) pbActivity.getResources().getDimension(r.e.ds98);
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        ey eyVar;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        ey eyVar2;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        com.baidu.tieba.pb.pb.main.a.j jVar3;
        if (af(i2)) {
            eyVar = this.evL.euP;
            if (eyVar != null) {
                jVar = this.evL.eux;
                if (jVar != null) {
                    eyVar2 = this.evL.euP;
                    eyVar2.aSu();
                    jVar2 = this.evL.eux;
                    jVar2.dv(false);
                    jVar3 = this.evL.eux;
                    jVar3.aaf();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void Q(int i, int i2) {
        ey eyVar;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        com.baidu.tieba.pb.pb.main.a.j jVar3;
        if (af(i2)) {
            eyVar = this.evL.euP;
            if (eyVar != null) {
                jVar = this.evL.eux;
                if (jVar != null) {
                    jVar2 = this.evL.eux;
                    jVar2.dv(true);
                    if (Math.abs(i2) > this.bVH) {
                        eyVar4 = this.evL.euP;
                        eyVar4.aSt();
                        jVar3 = this.evL.eux;
                        jVar3.aae();
                    }
                    if (this.evL.aPv()) {
                        eyVar2 = this.evL.euP;
                        eyVar2.aRR();
                        eyVar3 = this.evL.euP;
                        eyVar3.aRS();
                    }
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
