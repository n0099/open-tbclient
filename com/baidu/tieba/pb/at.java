package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class at implements cc {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cc
    public final void a(boolean z) {
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        com.baidu.tieba.model.bb bbVar3;
        com.baidu.tieba.model.bb bbVar4;
        com.baidu.tieba.model.bb bbVar5;
        com.baidu.tieba.model.bb bbVar6;
        if (z) {
            bbVar6 = this.a.w;
            bbVar6.b(true);
            return;
        }
        bbVar = this.a.w;
        int d = bbVar.r().d();
        bbVar2 = this.a.w;
        if (d < bbVar2.r().a()) {
            bbVar4 = this.a.w;
            bbVar5 = this.a.w;
            bbVar4.c(bbVar5.r().d() + 1);
            return;
        }
        bbVar3 = this.a.w;
        bbVar3.a(true);
    }
}
