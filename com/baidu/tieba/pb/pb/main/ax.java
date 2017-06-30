package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ax implements a.InterfaceC0062a {
    final int bsH;
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.ewh = pbActivity;
        this.bsH = (int) pbActivity.getResources().getDimension(w.f.ds98);
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ah(int i, int i2) {
        gg ggVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (Y(i2)) {
            ggVar = this.ewh.euU;
            if (ggVar != null) {
                fVar = this.ewh.euw;
                if (fVar != null) {
                    fVar2 = this.ewh.euw;
                    fVar2.ee(false);
                    fVar3 = this.ewh.euw;
                    fVar3.showFloatingView();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ai(int i, int i2) {
        gg ggVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        gg ggVar2;
        gg ggVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar3;
        if (Y(i2)) {
            ggVar = this.ewh.euU;
            if (ggVar != null) {
                fVar = this.ewh.euw;
                if (fVar != null) {
                    fVar2 = this.ewh.euw;
                    fVar2.ee(true);
                    if (Math.abs(i2) > this.bsH) {
                        fVar3 = this.ewh.euw;
                        fVar3.hideFloatingView();
                    }
                    if (this.ewh.aNU()) {
                        ggVar2 = this.ewh.euU;
                        ggVar2.aQn();
                        ggVar3 = this.ewh.euU;
                        ggVar3.aQo();
                    }
                }
            }
        }
    }

    private boolean Y(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
