package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class nw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448312580, "Lcom/baidu/tieba/nw;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448312580, "Lcom/baidu/tieba/nw;");
        }
    }

    public static int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) {
            return Math.round(f * wv.a().getResources().getDisplayMetrics().density);
        }
        return invokeF.intValue;
    }
}
