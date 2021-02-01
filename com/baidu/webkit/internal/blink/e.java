package com.baidu.webkit.internal.blink;
/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f5661a;

    public e(d dVar) {
        this.f5661a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f5661a.c != null) {
                this.f5661a.c.unzipFinished();
                this.f5661a.c = null;
            }
        }
    }
}
