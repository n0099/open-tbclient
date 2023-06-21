package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.wra;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes8.dex */
public final class xra {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static wra.a b;
    public static wra.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948311362, "Lcom/baidu/tieba/xra;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948311362, "Lcom/baidu/tieba/xra;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (xra.class) {
                if (!a) {
                    jsa.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new yra();
                    c = new isa();
                    wra.a().c();
                    wra.a().d(c);
                    wra.a().d(b);
                    wra.a().e(context);
                    a = true;
                    return;
                }
                jsa.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
