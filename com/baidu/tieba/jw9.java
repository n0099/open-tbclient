package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.iw9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes5.dex */
public final class jw9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static iw9.a b;
    public static iw9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947897853, "Lcom/baidu/tieba/jw9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947897853, "Lcom/baidu/tieba/jw9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (jw9.class) {
                if (!a) {
                    vw9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new kw9();
                    c = new uw9();
                    iw9.a().c();
                    iw9.a().d(c);
                    iw9.a().d(b);
                    iw9.a().e(context);
                    a = true;
                    return;
                }
                vw9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
