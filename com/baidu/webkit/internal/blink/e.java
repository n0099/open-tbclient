package com.baidu.webkit.internal.blink;
/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f5958a;

    public e(d dVar) {
        this.f5958a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f5958a.c != null) {
                this.f5958a.c.unzipFinished();
                this.f5958a.c = null;
            }
        }
    }
}
