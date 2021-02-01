package com.bytedance.embedapplog;
/* loaded from: classes6.dex */
public abstract class aw<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f5791a;

    protected abstract T M(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f5791a == null) {
            synchronized (this) {
                if (this.f5791a == null) {
                    this.f5791a = M(objArr);
                }
            }
        }
        return this.f5791a;
    }
}
