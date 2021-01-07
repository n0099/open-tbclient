package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f6165a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f6166b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception e) {
            method = null;
        }
        f6165a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f6166b = iOException;
    }

    public IOException a() {
        return this.f6166b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f6166b);
        this.f6166b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        if (f6165a != null) {
            try {
                f6165a.invoke(iOException, iOException2);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
    }
}
