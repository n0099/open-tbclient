package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.core.view.q {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.q
    public void a(boolean z) {
        boolean z2;
        bl blVar;
        bl blVar2;
        bs bsVar;
        z2 = this.a.f;
        if (!z2 && z) {
            blVar = this.a.x;
            if (!blVar.p()) {
                blVar2 = this.a.x;
                if (blVar2.v()) {
                    bsVar = this.a.D;
                    bsVar.u();
                }
            }
        }
    }
}
