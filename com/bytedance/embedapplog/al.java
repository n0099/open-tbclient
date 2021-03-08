package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.bi;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class al implements bi {

    /* renamed from: a  reason: collision with root package name */
    private static Object f3901a;
    private static Class<?> b;
    private static Method c;

    static {
        try {
            b = Class.forName("com.android.id.impl.IdProviderImpl");
            f3901a = b.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            bb.c(bh.f3915a, "Api#static reflect exception! " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (b == null || f3901a == null || c == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hR(Context context) {
        try {
            bi.a aVar = new bi.a();
            aVar.b = a(context, c);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(Context context, Method method) {
        if (f3901a != null && method != null) {
            try {
                Object invoke = method.invoke(f3901a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
