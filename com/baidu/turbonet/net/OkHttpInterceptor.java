package com.baidu.turbonet.net;

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes12.dex */
public class OkHttpInterceptor implements Interceptor {
    private static Field nmO;

    static {
        try {
            nmO = RealResponseBody.class.getDeclaredField("source");
            nmO.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e);
            nmO = null;
        }
    }
}
