package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rd6 {
    public static /* synthetic */ Interceptable $ic;
    public static final ud6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, th) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117829, "Lcom/baidu/tieba/rd6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117829, "Lcom/baidu/tieba/rd6;");
                return;
            }
        }
        a = new ud6() { // from class: com.baidu.tieba.qd6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ud6
            public final void a(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                    rd6.b(th);
                }
            }
        };
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, th) == null) {
            throw new RuntimeException(th);
        }
    }

    public static /* synthetic */ void b(Throwable th) {
        if (!ad6.a()) {
            c(th);
        } else {
            a(th);
            throw null;
        }
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) {
            if (!(th instanceof TbWebViewException)) {
                th = new TbWebViewException(th);
            }
            a.a(th);
        }
    }
}
