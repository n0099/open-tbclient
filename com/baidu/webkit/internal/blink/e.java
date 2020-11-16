package com.baidu.webkit.internal.blink;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3931a;

    public e(d dVar) {
        this.f3931a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f3931a.c != null) {
                this.f3931a.c.unzipFinished();
                this.f3931a.c = null;
            }
        }
    }
}
