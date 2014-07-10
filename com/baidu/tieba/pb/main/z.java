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
        bm bmVar;
        bm bmVar2;
        bt btVar;
        z2 = this.a.f;
        if (!z2 && z) {
            bmVar = this.a.x;
            if (!bmVar.p()) {
                bmVar2 = this.a.x;
                if (bmVar2.v()) {
                    btVar = this.a.D;
                    btVar.u();
                }
            }
        }
    }
}
