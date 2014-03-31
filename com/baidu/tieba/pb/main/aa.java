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
        bd bdVar;
        bd bdVar2;
        bk bkVar;
        z2 = this.a.e;
        if (!z2 && z) {
            bdVar = this.a.x;
            if (!bdVar.n()) {
                bdVar2 = this.a.x;
                if (bdVar2.s()) {
                    bkVar = this.a.D;
                    bkVar.t();
                }
            }
        }
    }
}
