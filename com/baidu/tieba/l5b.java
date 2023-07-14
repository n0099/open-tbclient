package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.k5b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class l5b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static k5b.a b;
    public static k5b.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947895280, "Lcom/baidu/tieba/l5b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947895280, "Lcom/baidu/tieba/l5b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (l5b.class) {
                if (!a) {
                    x5b.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new m5b();
                    c = new w5b();
                    k5b.a().c();
                    k5b.a().d(c);
                    k5b.a().d(b);
                    k5b.a().e(context);
                    a = true;
                    return;
                }
                x5b.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
