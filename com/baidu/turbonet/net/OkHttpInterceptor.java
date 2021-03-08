package com.baidu.turbonet.net;

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class OkHttpInterceptor implements Interceptor {
    private static Field oTk;

    static {
        try {
            oTk = RealResponseBody.class.getDeclaredField("source");
            oTk.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e);
            oTk = null;
        }
    }
}
