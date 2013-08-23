package com.baidu.tieba;
/* loaded from: classes.dex */
class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LogoActivity logoActivity) {
        this.f1814a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1814a.a_();
        this.f1814a.a(this.f1814a.getBaseContext());
    }
}
