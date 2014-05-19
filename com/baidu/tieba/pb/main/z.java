package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public void a(boolean z) {
        boolean z2;
        bc bcVar;
        bc bcVar2;
        bj bjVar;
        z2 = this.a.e;
        if (!z2 && z) {
            bcVar = this.a.y;
            if (!bcVar.n()) {
                bcVar2 = this.a.y;
                if (bcVar2.s()) {
                    bjVar = this.a.E;
                    bjVar.t();
                }
            }
        }
    }
}
