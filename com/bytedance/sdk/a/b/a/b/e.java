package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f5865a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f5866b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e) {
            method = null;
        }
        f5865a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f5866b = iOException;
    }

    public IOException a() {
        return this.f5866b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f5866b);
        this.f5866b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        if (f5865a != null) {
            try {
                f5865a.invoke(iOException, iOException2);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }
}
