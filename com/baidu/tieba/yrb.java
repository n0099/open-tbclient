package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.xrb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes9.dex */
public final class yrb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static xrb.a b;
    public static xrb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948341184, "Lcom/baidu/tieba/yrb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948341184, "Lcom/baidu/tieba/yrb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (yrb.class) {
                if (!a) {
                    ksb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new zrb();
                    c = new jsb();
                    xrb.a().c();
                    xrb.a().d(c);
                    xrb.a().d(b);
                    xrb.a().e(context);
                    a = true;
                    return;
                }
                ksb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
