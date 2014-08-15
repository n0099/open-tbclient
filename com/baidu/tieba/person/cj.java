package com.baidu.tieba.person;
/* loaded from: classes.dex */
class cj implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cd cdVar) {
        this.a = cdVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        PersonFriendActivity f;
        cn cnVar;
        boolean z2;
        PersonFriendActivity f2;
        int i;
        int i2;
        f = this.a.f();
        if (f != null) {
            this.a.n = 0;
            this.a.l = true;
            cnVar = this.a.h;
            z2 = this.a.j;
            f2 = this.a.f();
            String m = f2.m();
            i = this.a.n;
            i2 = this.a.o;
            cnVar.a(z2, m, i, i2);
        }
    }
}
