package com.baidu.webkit.internal.blink;
/* loaded from: classes15.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f5959a;

    public e(d dVar) {
        this.f5959a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f5959a.c != null) {
                this.f5959a.c.unzipFinished();
                this.f5959a.c = null;
            }
        }
    }
}
