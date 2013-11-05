package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class at implements bn {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2056a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.f2056a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.bn
    public void a(boolean z) {
        com.baidu.tieba.model.bl blVar;
        com.baidu.tieba.model.bl blVar2;
        com.baidu.tieba.model.bl blVar3;
        com.baidu.tieba.model.bl blVar4;
        com.baidu.tieba.model.bl blVar5;
        com.baidu.tieba.model.bl blVar6;
        if (z) {
            blVar6 = this.f2056a.o;
            blVar6.b(true);
            return;
        }
        blVar = this.f2056a.o;
        int d = blVar.l().d();
        blVar2 = this.f2056a.o;
        if (d < blVar2.l().a()) {
            blVar4 = this.f2056a.o;
            blVar5 = this.f2056a.o;
            blVar4.c(blVar5.l().d() + 1);
            return;
        }
        blVar3 = this.f2056a.o;
        blVar3.a(true);
    }
}
