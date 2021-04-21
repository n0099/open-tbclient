package com.baidu.webkit.internal.blink;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f26595a;

    public e(d dVar) {
        this.f26595a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.f26582g) {
            if (this.f26595a.f26585c != null) {
                this.f26595a.f26585c.unzipFinished();
                this.f26595a.f26585c = null;
            }
        }
    }
}
