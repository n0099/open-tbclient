package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ef implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ee f2162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar) {
        this.f2162a = eeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2162a.d.f2160a.c(this.f2162a.f2161a);
        this.f2162a.d.f2160a.a(this.f2162a.b, this.f2162a.c);
    }
}
