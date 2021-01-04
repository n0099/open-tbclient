package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.bi;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class al implements bi {

    /* renamed from: a  reason: collision with root package name */
    private static Object f6077a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f6078b;
    private static Method c;

    static {
        try {
            f6078b = Class.forName("com.android.id.impl.IdProviderImpl");
            f6077a = f6078b.newInstance();
            c = f6078b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            bb.c(bh.f6098a, "Api#static reflect exception! " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f6078b == null || f6077a == null || c == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hR(Context context) {
        try {
            bi.a aVar = new bi.a();
            aVar.f6100b = a(context, c);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(Context context, Method method) {
        if (f6077a != null && method != null) {
            try {
                Object invoke = method.invoke(f6077a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
