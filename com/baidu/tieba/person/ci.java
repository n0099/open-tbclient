package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ci implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cb cbVar) {
        this.a = cbVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        boolean z;
        cl clVar;
        z = this.a.m;
        if (!z) {
            this.a.l = false;
            cb cbVar = this.a;
            clVar = this.a.h;
            cbVar.n = clVar.b().a().c() + 1;
            this.a.m = true;
            this.a.g();
        }
    }
}
