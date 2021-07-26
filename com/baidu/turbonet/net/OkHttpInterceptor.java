package com.baidu.turbonet.net;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.internal.http.RealResponseBody;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class OkHttpInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Field f23327a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1809424302, "Lcom/baidu/turbonet/net/OkHttpInterceptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1809424302, "Lcom/baidu/turbonet/net/OkHttpInterceptor;");
                return;
            }
        }
        try {
            Field declaredField = RealResponseBody.class.getDeclaredField("source");
            f23327a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("tn_OkHttpIntercept", "Can not find source field from RealResponseBody.", e2);
            f23327a = null;
        }
    }
}
