package com.baidu.webkit.internal.blink;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f26587a;

    public e(d dVar) {
        this.f26587a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.f26574g) {
            if (this.f26587a.f26577c != null) {
                this.f26587a.f26577c.unzipFinished();
                this.f26587a.f26577c = null;
            }
        }
    }
}
