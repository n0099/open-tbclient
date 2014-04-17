package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class bs implements com.baidu.adp.widget.ListView.t {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bn bnVar) {
        this.a = bnVar;
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        com.baidu.tieba.model.av avVar;
        ak akVar;
        ak akVar2;
        if (!this.a.a()) {
            avVar = this.a.c;
            if (avVar.b()) {
                akVar2 = this.a.l;
                akVar2.b();
                return;
            }
            this.a.a(true);
            akVar = this.a.l;
            akVar.f();
            this.a.c.a(false, true, 2);
        }
    }
}
