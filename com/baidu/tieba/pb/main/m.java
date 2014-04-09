package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class m implements az {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.az
    public final void a(boolean z) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        if (z) {
            bfVar6 = this.a.x;
            bfVar6.b(true);
            return;
        }
        bfVar = this.a.x;
        int d = bfVar.q().d();
        bfVar2 = this.a.x;
        if (d < bfVar2.q().a()) {
            bfVar4 = this.a.x;
            bfVar5 = this.a.x;
            bfVar4.c(bfVar5.q().d() + 1);
            return;
        }
        bfVar3 = this.a.x;
        bfVar3.a(true);
    }
}
