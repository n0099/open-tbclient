package com.baidu.tieba;
/* loaded from: classes.dex */
class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f2135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LogoActivity logoActivity) {
        this.f2135a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2135a.a_();
        this.f2135a.a(this.f2135a.getBaseContext());
    }
}
