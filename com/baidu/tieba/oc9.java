package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.nc9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class oc9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static nc9.a b;
    public static nc9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948027588, "Lcom/baidu/tieba/oc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948027588, "Lcom/baidu/tieba/oc9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (oc9.class) {
                if (!a) {
                    ad9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new pc9();
                    c = new zc9();
                    nc9.a().c();
                    nc9.a().d(c);
                    nc9.a().d(b);
                    nc9.a().e(context);
                    a = true;
                    return;
                }
                ad9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
