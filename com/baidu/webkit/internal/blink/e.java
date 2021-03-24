package com.baidu.webkit.internal.blink;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f26901a;

    public e(d dVar) {
        this.f26901a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.f26888g) {
            if (this.f26901a.f26891c != null) {
                this.f26901a.f26891c.unzipFinished();
                this.f26901a.f26891c = null;
            }
        }
    }
}
