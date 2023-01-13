package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.browser.exception.TbWebViewException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r76 {
    public static /* synthetic */ Interceptable $ic;
    public static final u76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
        }
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074584, "Lcom/baidu/tieba/r76;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074584, "Lcom/baidu/tieba/r76;");
                return;
            }
        }
        a = new u76() { // from class: com.baidu.tieba.p76
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.u76
            public final void a(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                    r76.c(th);
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

    public static /* synthetic */ void c(Throwable th) {
        if (!e76.a()) {
            d(th);
        } else {
            a(th);
            throw null;
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, th) == null) {
            if (!(th instanceof TbWebViewException)) {
                th = new TbWebViewException(th);
            }
            a.a(th);
        }
    }
}
