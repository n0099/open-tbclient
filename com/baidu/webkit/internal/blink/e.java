package com.baidu.webkit.internal.blink;
/* loaded from: classes12.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3934a;

    public e(d dVar) {
        this.f3934a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.g) {
            if (this.f3934a.c != null) {
                this.f3934a.c.unzipFinished();
                this.f3934a.c = null;
            }
        }
    }
}
