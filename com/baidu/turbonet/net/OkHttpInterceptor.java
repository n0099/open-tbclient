package com.baidu.turbonet.net;

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class OkHttpInterceptor implements Interceptor {
    private static Field mep;

    static {
        try {
            mep = RealResponseBody.class.getDeclaredField("source");
            mep.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e);
            mep = null;
        }
    }
}
