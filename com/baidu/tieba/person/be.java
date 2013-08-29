package com.baidu.tieba.person;
/* loaded from: classes.dex */
class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f1627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.f1627a = bdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ba baVar;
        PersonInfoActivity personInfoActivity;
        baVar = this.f1627a.f1626a;
        personInfoActivity = baVar.f1623a;
        personInfoActivity.m();
    }
}
