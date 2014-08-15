package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ck implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cd cdVar) {
        this.a = cdVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        boolean z;
        cn cnVar;
        z = this.a.m;
        if (!z) {
            this.a.l = false;
            cd cdVar = this.a;
            cnVar = this.a.h;
            cdVar.n = cnVar.b().a().d() + 1;
            this.a.m = true;
            this.a.g();
        }
    }
}
