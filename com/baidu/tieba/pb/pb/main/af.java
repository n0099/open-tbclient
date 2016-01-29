package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.b.a;
/* loaded from: classes.dex */
class af implements a.InterfaceC0059a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.b.a.InterfaceC0059a
    public void P(int i, int i2) {
        dz dzVar;
        if (F(i2)) {
            dzVar = this.cNq.cMK;
            dzVar.arH();
        }
    }

    @Override // com.baidu.tieba.b.a.InterfaceC0059a
    public void Q(int i, int i2) {
        dz dzVar;
        if (F(i2)) {
            dzVar = this.cNq.cMK;
            dzVar.arG();
        }
    }

    private boolean F(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
