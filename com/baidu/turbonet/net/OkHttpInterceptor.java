package com.baidu.turbonet.net;

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes15.dex */
public class OkHttpInterceptor implements Interceptor {
    private static Field opv;

    static {
        try {
            opv = RealResponseBody.class.getDeclaredField("source");
            opv.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e);
            opv = null;
        }
    }
}
