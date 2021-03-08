package com.bytedance.embedapplog;
/* loaded from: classes6.dex */
public abstract class aw<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f3908a;

    protected abstract T L(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f3908a == null) {
            synchronized (this) {
                if (this.f3908a == null) {
                    this.f3908a = L(objArr);
                }
            }
        }
        return this.f3908a;
    }
}
