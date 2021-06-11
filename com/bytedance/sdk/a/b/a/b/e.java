package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f26952a;

    /* renamed from: b  reason: collision with root package name */
    public IOException f26953b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f26952a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f26953b = iOException;
    }

    public IOException a() {
        return this.f26953b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f26953b);
        this.f26953b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = f26952a;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
