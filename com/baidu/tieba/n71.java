package com.baidu.tieba;

import com.baidu.tieba.d61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f)) == null) {
            return d61.c.a(lk0.b(), f);
        }
        return invokeF.intValue;
    }

    public static int b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) {
            return d61.c.a(lk0.b(), f);
        }
        return invokeF.intValue;
    }

    public static int c(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f)) == null) {
            return Math.round(f / 1.5f);
        }
        return invokeF.intValue;
    }

    public static int d(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) {
            return b(f / 1.5f);
        }
        return invokeF.intValue;
    }
}
