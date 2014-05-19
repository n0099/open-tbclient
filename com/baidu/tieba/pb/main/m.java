package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class m implements ay {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.ay
    public void a(boolean z) {
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        bc bcVar6;
        if (z) {
            bcVar6 = this.a.y;
            bcVar6.b(true);
            return;
        }
        bcVar = this.a.y;
        int d = bcVar.q().d();
        bcVar2 = this.a.y;
        if (d < bcVar2.q().a()) {
            bcVar4 = this.a.y;
            bcVar5 = this.a.y;
            bcVar4.c(bcVar5.q().d() + 1);
            return;
        }
        bcVar3 = this.a.y;
        bcVar3.a(true);
    }
}
