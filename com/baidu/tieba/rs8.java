package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
/* loaded from: classes7.dex */
public final class rs8 {
    public static /* synthetic */ Interceptable $ic;
    public static final rs8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132306, "Lcom/baidu/tieba/rs8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132306, "Lcom/baidu/tieba/rs8;");
                return;
            }
        }
        a = new rs8();
    }

    public rs8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, runnable) == null) && runnable != null) {
            SafeHandler.getInst().removeCallbacks(runnable);
            SafeHandler.getInst().post(runnable);
        }
    }

    @JvmStatic
    public static final void d(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, runnable) == null) && runnable != null) {
            SafeHandler.getInst().removeCallbacks(runnable);
        }
    }

    @JvmStatic
    public static final void b(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65539, null, runnable, j) == null) && runnable != null) {
            if (j <= 0) {
                SafeHandler.getInst().post(runnable);
            } else {
                SafeHandler.getInst().postDelayed(runnable, j);
            }
        }
    }

    @JvmStatic
    public static final void c(boolean z, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, null, z, runnable) == null) {
            if (z) {
                a(runnable);
            } else {
                d(runnable);
            }
        }
    }
}
