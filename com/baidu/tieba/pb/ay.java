package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ay implements by {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.by
    public void a(boolean z) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bm bmVar6;
        if (z) {
            bmVar6 = this.a.u;
            bmVar6.b(true);
            return;
        }
        bmVar = this.a.u;
        int d = bmVar.m().d();
        bmVar2 = this.a.u;
        if (d < bmVar2.m().a()) {
            bmVar4 = this.a.u;
            bmVar5 = this.a.u;
            bmVar4.c(bmVar5.m().d() + 1);
            return;
        }
        bmVar3 = this.a.u;
        bmVar3.a(true);
    }
}
