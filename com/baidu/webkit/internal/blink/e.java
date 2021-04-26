package com.baidu.webkit.internal.blink;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f27402a;

    public e(d dVar) {
        this.f27402a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.f27389g) {
            if (this.f27402a.f27392c != null) {
                this.f27402a.f27392c.unzipFinished();
                this.f27402a.f27392c = null;
            }
        }
    }
}
