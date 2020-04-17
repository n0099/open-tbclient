package com.baidu.turbonet.net;

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class OkHttpInterceptor implements Interceptor {
    private static Field lKW;

    static {
        try {
            lKW = RealResponseBody.class.getDeclaredField("source");
            lKW.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e);
            lKW = null;
        }
    }
}
