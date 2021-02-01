package com.bytedance.sdk.a.b.a;
/* loaded from: classes6.dex */
public abstract class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    protected final String f5860b;

    protected abstract void b();

    public b(String str, Object... objArr) {
        this.f5860b = c.a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f5860b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
