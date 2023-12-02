package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 102400;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216750, "Lcom/baidu/tieba/w04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216750, "Lcom/baidu/tieba/w04;");
                return;
            }
        }
        a = vm1.a;
        b = -1;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b < 0) {
                rp2.g0().getSwitch("minigame_code_cache_max_count", 20);
                b = 20;
            }
            return b;
        }
        return invokeV.intValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b() * 6 * 1048576;
        }
        return invokeV.longValue;
    }

    public static v04 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            v04 v04Var = new v04();
            v04Var.a = b();
            v04Var.b = c();
            v04Var.c = d();
            if (a) {
                Log.d("GameCodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + v04Var.a + " ,sizeLimit: " + v04Var.b);
            }
            return v04Var;
        }
        return (v04) invokeV.objValue;
    }
}
