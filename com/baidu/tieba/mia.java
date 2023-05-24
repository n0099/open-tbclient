package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.lia;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes6.dex */
public final class mia {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static lia.a b;
    public static lia.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947975012, "Lcom/baidu/tieba/mia;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947975012, "Lcom/baidu/tieba/mia;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (mia.class) {
                if (!a) {
                    yia.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new nia();
                    c = new xia();
                    lia.a().c();
                    lia.a().d(c);
                    lia.a().d(b);
                    lia.a().e(context);
                    a = true;
                    return;
                }
                yia.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
