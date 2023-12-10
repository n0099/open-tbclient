package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.yrb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes9.dex */
public final class zrb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static yrb.a b;
    public static yrb.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948370975, "Lcom/baidu/tieba/zrb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948370975, "Lcom/baidu/tieba/zrb;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (zrb.class) {
                if (!a) {
                    lsb.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new asb();
                    c = new ksb();
                    yrb.a().c();
                    yrb.a().d(c);
                    yrb.a().d(b);
                    yrb.a().e(context);
                    a = true;
                    return;
                }
                lsb.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
