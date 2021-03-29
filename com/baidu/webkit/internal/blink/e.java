package com.baidu.webkit.internal.blink;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f26902a;

    public e(d dVar) {
        this.f26902a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.f26889g) {
            if (this.f26902a.f26892c != null) {
                this.f26902a.f26892c.unzipFinished();
                this.f26902a.f26892c = null;
            }
        }
    }
}
