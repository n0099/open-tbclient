package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f27675a;

    /* renamed from: b  reason: collision with root package name */
    public IOException f27676b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f27675a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f27676b = iOException;
    }

    public IOException a() {
        return this.f27676b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f27676b);
        this.f27676b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = f27675a;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
