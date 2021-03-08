package com.baidu.webkit.internal.blink;
/* loaded from: classes14.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3826a;

    public e(d dVar) {
        this.f3826a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f3826a.c != null) {
                this.f3826a.c.unzipFinished();
                this.f3826a.c = null;
            }
        }
    }
}
