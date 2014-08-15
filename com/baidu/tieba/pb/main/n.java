package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class n implements be {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.be
    public void a(boolean z) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        if (z) {
            blVar6 = this.a.x;
            blVar6.b(true);
            return;
        }
        blVar = this.a.x;
        int d = blVar.s().d();
        blVar2 = this.a.x;
        if (d < blVar2.s().a()) {
            blVar4 = this.a.x;
            blVar5 = this.a.x;
            blVar4.c(blVar5.s().d() + 1);
            return;
        }
        blVar3 = this.a.x;
        blVar3.a(true);
    }
}
