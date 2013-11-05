package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ce implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cd f2092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar) {
        this.f2092a = cdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        db dbVar;
        dd ddVar;
        db dbVar2;
        dbVar = this.f2092a.d.au;
        if (dbVar != null) {
            dbVar2 = this.f2092a.d.au;
            dbVar2.a(this.f2092a.f2091a);
        }
        if (this.f2092a.b) {
            ddVar = this.f2092a.d.E;
            ddVar.b(this.f2092a.c);
        }
    }
}
