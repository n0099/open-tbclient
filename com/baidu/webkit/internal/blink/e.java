package com.baidu.webkit.internal.blink;
/* loaded from: classes19.dex */
public final class e implements Runnable {
    final /* synthetic */ d a;

    public e(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.a.c != null) {
                this.a.c.unzipFinished();
                this.a.c = null;
            }
        }
    }
}
