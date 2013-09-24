package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ap implements bm {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.f1535a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.bm
    public void a(boolean z) {
        com.baidu.tieba.model.bd bdVar;
        com.baidu.tieba.model.bd bdVar2;
        com.baidu.tieba.model.bd bdVar3;
        com.baidu.tieba.model.bd bdVar4;
        com.baidu.tieba.model.bd bdVar5;
        com.baidu.tieba.model.bd bdVar6;
        if (z) {
            bdVar6 = this.f1535a.n;
            bdVar6.b(true);
            return;
        }
        bdVar = this.f1535a.n;
        int d = bdVar.l().d();
        bdVar2 = this.f1535a.n;
        if (d < bdVar2.l().a()) {
            bdVar4 = this.f1535a.n;
            bdVar5 = this.f1535a.n;
            bdVar4.c(bdVar5.l().d() + 1);
            return;
        }
        bdVar3 = this.f1535a.n;
        bdVar3.a(true);
    }
}
