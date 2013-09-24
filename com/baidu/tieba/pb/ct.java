package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ct implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f1591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.f1591a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        db dbVar;
        br brVar2;
        db dbVar2;
        br brVar3;
        db dbVar3;
        brVar = this.f1591a.f1589a;
        dbVar = brVar.E;
        if (dbVar.l().getVisibility() != 0) {
            brVar2 = this.f1591a.f1589a;
            dbVar2 = brVar2.E;
            if (dbVar2.k().getVisibility() != 0) {
                brVar3 = this.f1591a.f1589a;
                dbVar3 = brVar3.E;
                dbVar3.m();
            }
        }
    }
}
