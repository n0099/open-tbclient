package com.bytedance.embedapplog;
/* loaded from: classes4.dex */
public abstract class aw<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f6089a;

    protected abstract T M(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f6089a == null) {
            synchronized (this) {
                if (this.f6089a == null) {
                    this.f6089a = M(objArr);
                }
            }
        }
        return this.f6089a;
    }
}
