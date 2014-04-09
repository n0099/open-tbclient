package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class aa implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public final void a(boolean z) {
        boolean z2;
        bf bfVar;
        bf bfVar2;
        bm bmVar;
        z2 = this.a.e;
        if (!z2 && z) {
            bfVar = this.a.x;
            if (!bfVar.n()) {
                bfVar2 = this.a.x;
                if (bfVar2.s()) {
                    bmVar = this.a.D;
                    bmVar.t();
                }
            }
        }
    }
}
