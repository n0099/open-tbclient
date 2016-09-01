package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ar implements a.InterfaceC0055a {
    final int bQq;
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.eob = pbActivity;
        this.bQq = (int) pbActivity.getResources().getDimension(t.e.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void N(int i, int i2) {
        ex exVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        ex exVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (af(i2)) {
            exVar = this.eob.enh;
            if (exVar != null) {
                fVar = this.eob.emP;
                if (fVar != null) {
                    exVar2 = this.eob.enh;
                    exVar2.aPQ();
                    fVar2 = this.eob.emP;
                    fVar2.dp(false);
                    fVar3 = this.eob.emP;
                    fVar3.YO();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void O(int i, int i2) {
        ex exVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        ex exVar2;
        ex exVar3;
        ex exVar4;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (af(i2)) {
            exVar = this.eob.enh;
            if (exVar != null) {
                fVar = this.eob.emP;
                if (fVar != null) {
                    fVar2 = this.eob.emP;
                    fVar2.dp(true);
                    if (Math.abs(i2) > this.bQq) {
                        exVar4 = this.eob.enh;
                        exVar4.aPP();
                        fVar3 = this.eob.emP;
                        fVar3.YN();
                    }
                    if (this.eob.aMY()) {
                        exVar2 = this.eob.enh;
                        exVar2.aPd();
                        exVar3 = this.eob.enh;
                        exVar3.aPe();
                    }
                }
            }
        }
    }

    private boolean af(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
