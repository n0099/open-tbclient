package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aq implements a.InterfaceC0057a {
    final int bBP;
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.eah = pbActivity;
        this.bBP = (int) pbActivity.getResources().getDimension(r.e.ds98);
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void P(int i, int i2) {
        er erVar;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        er erVar2;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        com.baidu.tieba.pb.pb.main.a.j jVar3;
        if (aa(i2)) {
            erVar = this.eah.dZk;
            if (erVar != null) {
                jVar = this.eah.dYS;
                if (jVar != null) {
                    erVar2 = this.eah.dZk;
                    erVar2.aMn();
                    jVar2 = this.eah.dYS;
                    jVar2.dd(false);
                    jVar3 = this.eah.dYS;
                    jVar3.Us();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void Q(int i, int i2) {
        er erVar;
        com.baidu.tieba.pb.pb.main.a.j jVar;
        com.baidu.tieba.pb.pb.main.a.j jVar2;
        er erVar2;
        er erVar3;
        er erVar4;
        com.baidu.tieba.pb.pb.main.a.j jVar3;
        if (aa(i2)) {
            erVar = this.eah.dZk;
            if (erVar != null) {
                jVar = this.eah.dYS;
                if (jVar != null) {
                    jVar2 = this.eah.dYS;
                    jVar2.dd(true);
                    if (Math.abs(i2) > this.bBP) {
                        erVar4 = this.eah.dZk;
                        erVar4.aMm();
                        jVar3 = this.eah.dYS;
                        jVar3.Ur();
                    }
                    if (this.eah.aJu()) {
                        erVar2 = this.eah.dZk;
                        erVar2.aLL();
                        erVar3 = this.eah.dZk;
                        erVar3.aLM();
                    }
                }
            }
        }
    }

    private boolean aa(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
