package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class m implements bb {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bb
    public void a(boolean z) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        if (z) {
            bmVar6 = this.a.x;
            bmVar6.b(true);
            return;
        }
        bmVar = this.a.x;
        int c = bmVar.s().c();
        bmVar2 = this.a.x;
        if (c < bmVar2.s().a()) {
            bmVar4 = this.a.x;
            bmVar5 = this.a.x;
            bmVar4.c(bmVar5.s().c() + 1);
            return;
        }
        bmVar3 = this.a.x;
        bmVar3.a(true);
    }
}
