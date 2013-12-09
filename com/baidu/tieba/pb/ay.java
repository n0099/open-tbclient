package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ay implements bw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2173a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.f2173a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.bw
    public void a(boolean z) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bm bmVar6;
        if (z) {
            bmVar6 = this.f2173a.s;
            bmVar6.b(true);
            return;
        }
        bmVar = this.f2173a.s;
        int d = bmVar.m().d();
        bmVar2 = this.f2173a.s;
        if (d < bmVar2.m().a()) {
            bmVar4 = this.f2173a.s;
            bmVar5 = this.f2173a.s;
            bmVar4.c(bmVar5.m().d() + 1);
            return;
        }
        bmVar3 = this.f2173a.s;
        bmVar3.a(true);
    }
}
