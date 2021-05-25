package com.baidu.turbonet.net;

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class OkHttpInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static Field f22358a;

    static {
        try {
            Field declaredField = RealResponseBody.class.getDeclaredField("source");
            f22358a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e2);
            f22358a = null;
        }
    }
}
