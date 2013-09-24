package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f1674a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        az azVar;
        PersonInfoActivity personInfoActivity;
        azVar = this.f1674a.f1673a;
        personInfoActivity = azVar.f1671a;
        personInfoActivity.m();
    }
}
