package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.bi;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class al implements bi {

    /* renamed from: a  reason: collision with root package name */
    private static Object f5778a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f5779b;
    private static Method c;

    static {
        try {
            f5779b = Class.forName("com.android.id.impl.IdProviderImpl");
            f5778a = f5779b.newInstance();
            c = f5779b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            bb.c(bh.f5799a, "Api#static reflect exception! " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f5779b == null || f5778a == null || c == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hP(Context context) {
        try {
            bi.a aVar = new bi.a();
            aVar.f5801b = a(context, c);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(Context context, Method method) {
        if (f5778a != null && method != null) {
            try {
                Object invoke = method.invoke(f5778a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
