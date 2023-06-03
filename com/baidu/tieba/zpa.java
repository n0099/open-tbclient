package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.ypa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes8.dex */
public final class zpa {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static ypa.a b;
    public static ypa.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948369022, "Lcom/baidu/tieba/zpa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948369022, "Lcom/baidu/tieba/zpa;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (zpa.class) {
                if (!a) {
                    lqa.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new aqa();
                    c = new kqa();
                    ypa.a().c();
                    ypa.a().d(c);
                    ypa.a().d(b);
                    ypa.a().e(context);
                    a = true;
                    return;
                }
                lqa.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
