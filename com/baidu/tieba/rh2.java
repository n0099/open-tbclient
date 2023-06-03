package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121549, "Lcom/baidu/tieba/rh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121549, "Lcom/baidu/tieba/rh2;");
                return;
            }
        }
        a = is1.a;
    }

    @NonNull
    public static ph2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ph2 b = b(c());
            if (a) {
                Log.d("PrelinkStrategyFactory", "prelink strategy - " + b.getClass().getSimpleName());
            }
            return b;
        }
        return (ph2) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            fv2.g0().getSwitch("swan_prelink_policy_when_prefetch", 0);
            if (a) {
                Log.d("PrelinkStrategyFactory", "swan_prelink_policy_when_prefetch = 0");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static ph2 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 0) {
                return new nh2();
            }
            if (i > 0) {
                return new qh2(i);
            }
            if (i == -1) {
                return new oh2();
            }
            return new nh2();
        }
        return (ph2) invokeI.objValue;
    }
}
