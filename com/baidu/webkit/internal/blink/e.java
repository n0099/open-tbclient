package com.baidu.webkit.internal.blink;
/* loaded from: classes14.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f5659a;

    public e(d dVar) {
        this.f5659a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f5659a.c != null) {
                this.f5659a.c.unzipFinished();
                this.f5659a.c = null;
            }
        }
    }
}
