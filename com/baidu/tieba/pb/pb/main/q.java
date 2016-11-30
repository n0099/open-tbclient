package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.j;
/* loaded from: classes.dex */
class q implements j.a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.j.a
    public void dx(boolean z) {
        ey eyVar;
        ey eyVar2;
        this.evL.iv(z);
        eyVar = this.evL.euP;
        if (eyVar.aSx() != null && z) {
            eyVar2 = this.evL.euP;
            eyVar2.iT(false);
        }
    }
}
