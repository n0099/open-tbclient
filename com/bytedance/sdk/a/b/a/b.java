package com.bytedance.sdk.a.b.a;
/* loaded from: classes4.dex */
public abstract class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    protected final String f6157b;

    protected abstract void b();

    public b(String str, Object... objArr) {
        this.f6157b = c.a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f6157b);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
