package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f1593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cr crVar) {
        this.f1593a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        db dbVar;
        br brVar2;
        db dbVar2;
        brVar = this.f1593a.f1589a;
        dbVar = brVar.E;
        dbVar.f();
        brVar2 = this.f1593a.f1589a;
        dbVar2 = brVar2.E;
        dbVar2.d();
    }
}
