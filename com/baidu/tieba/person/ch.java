package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ch implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cb cbVar) {
        this.a = cbVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        PersonFriendActivity f;
        cl clVar;
        boolean z2;
        PersonFriendActivity f2;
        int i;
        int i2;
        f = this.a.f();
        if (f != null) {
            this.a.n = 0;
            this.a.l = true;
            clVar = this.a.h;
            z2 = this.a.j;
            f2 = this.a.f();
            String m = f2.m();
            i = this.a.n;
            i2 = this.a.o;
            clVar.a(z2, m, i, i2);
        }
    }
}
