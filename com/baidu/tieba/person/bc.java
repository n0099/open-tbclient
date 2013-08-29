package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f1625a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.f1625a = bbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba baVar;
        PersonInfoActivity personInfoActivity;
        baVar = this.f1625a.f1624a;
        personInfoActivity = baVar.f1623a;
        personInfoActivity.m();
    }
}
