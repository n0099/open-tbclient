package com.bytedance.embedapplog;
/* loaded from: classes4.dex */
public abstract class aw<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f5789a;

    protected abstract T M(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f5789a == null) {
            synchronized (this) {
                if (this.f5789a == null) {
                    this.f5789a = M(objArr);
                }
            }
        }
        return this.f5789a;
    }
}
