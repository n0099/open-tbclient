package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f3953a;
    private IOException b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e) {
            method = null;
        }
        f3953a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.b = iOException;
    }

    public IOException a() {
        return this.b;
    }

    public void a(IOException iOException) {
        a(iOException, this.b);
        this.b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        if (f3953a != null) {
            try {
                f3953a.invoke(iOException, iOException2);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }
}
