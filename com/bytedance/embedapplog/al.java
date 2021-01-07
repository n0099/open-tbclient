package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.bi;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class al implements bi {

    /* renamed from: a  reason: collision with root package name */
    private static Object f6078a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f6079b;
    private static Method c;

    static {
        try {
            f6079b = Class.forName("com.android.id.impl.IdProviderImpl");
            f6078a = f6079b.newInstance();
            c = f6079b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            bb.c(bh.f6099a, "Api#static reflect exception! " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f6079b == null || f6078a == null || c == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hR(Context context) {
        try {
            bi.a aVar = new bi.a();
            aVar.f6101b = a(context, c);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(Context context, Method method) {
        if (f6078a != null && method != null) {
            try {
                Object invoke = method.invoke(f6078a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
