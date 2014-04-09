package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class bt implements com.baidu.adp.widget.ListView.a {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bn bnVar) {
        this.a = bnVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public final void b() {
        ag agVar;
        if (!this.a.a()) {
            agVar = this.a.o;
            agVar.d();
            this.a.a(true);
            this.a.c.a(false, true, 2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.a
    public final void a(float f) {
        ag agVar;
        agVar = this.a.o;
        agVar.a(f);
    }

    @Override // com.baidu.adp.widget.ListView.a
    public final void a() {
        ag agVar;
        agVar = this.a.o;
        agVar.b();
    }
}
