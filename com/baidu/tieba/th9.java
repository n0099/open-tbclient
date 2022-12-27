package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.sh9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class th9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static sh9.a b;
    public static sh9.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948181348, "Lcom/baidu/tieba/th9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948181348, "Lcom/baidu/tieba/th9;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (th9.class) {
                if (!a) {
                    fi9.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new uh9();
                    c = new ei9();
                    sh9.a().c();
                    sh9.a().d(c);
                    sh9.a().d(b);
                    sh9.a().e(context);
                    a = true;
                    return;
                }
                fi9.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
