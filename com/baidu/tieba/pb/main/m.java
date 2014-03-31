package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class m implements ax {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.ax
    public final void a(boolean z) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        bd bdVar5;
        bd bdVar6;
        if (z) {
            bdVar6 = this.a.x;
            bdVar6.b(true);
            return;
        }
        bdVar = this.a.x;
        int d = bdVar.q().d();
        bdVar2 = this.a.x;
        if (d < bdVar2.q().a()) {
            bdVar4 = this.a.x;
            bdVar5 = this.a.x;
            bdVar4.c(bdVar5.q().d() + 1);
            return;
        }
        bdVar3 = this.a.x;
        bdVar3.a(true);
    }
}
