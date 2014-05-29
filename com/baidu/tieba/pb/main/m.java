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
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        if (z) {
            bjVar6 = this.a.x;
            bjVar6.b(true);
            return;
        }
        bjVar = this.a.x;
        int d = bjVar.r().d();
        bjVar2 = this.a.x;
        if (d < bjVar2.r().a()) {
            bjVar4 = this.a.x;
            bjVar5 = this.a.x;
            bjVar4.c(bjVar5.r().d() + 1);
            return;
        }
        bjVar3 = this.a.x;
        bjVar3.a(true);
    }
}
