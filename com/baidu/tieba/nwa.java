package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.mwa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes7.dex */
public final class nwa {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static mwa.a b;
    public static mwa.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948018257, "Lcom/baidu/tieba/nwa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948018257, "Lcom/baidu/tieba/nwa;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (nwa.class) {
                if (!a) {
                    zwa.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new owa();
                    c = new ywa();
                    mwa.a().c();
                    mwa.a().d(c);
                    mwa.a().d(b);
                    mwa.a().e(context);
                    a = true;
                    return;
                }
                zwa.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
