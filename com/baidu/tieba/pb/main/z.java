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
        bj bjVar;
        bj bjVar2;
        bq bqVar;
        z2 = this.a.e;
        if (!z2 && z) {
            bjVar = this.a.x;
            if (!bjVar.n()) {
                bjVar2 = this.a.x;
                if (bjVar2.s()) {
                    bqVar = this.a.D;
                    bqVar.t();
                }
            }
        }
    }
}
