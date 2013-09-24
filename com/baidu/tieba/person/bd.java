package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bc f1676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.f1676a = bcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        az azVar;
        PersonInfoActivity personInfoActivity;
        azVar = this.f1676a.f1675a;
        personInfoActivity = azVar.f1671a;
        personInfoActivity.m();
    }
}
