package com.baidu.tieba;

import com.baidu.tieba.g21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f)) == null) ? g21.c.a(mi0.b(), f) : invokeF.intValue;
    }

    public static int b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) ? g21.c.a(mi0.b(), f) : invokeF.intValue;
    }

    public static int c(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f)) == null) ? Math.round(f / 1.5f) : invokeF.intValue;
    }

    public static int d(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) ? b(f / 1.5f) : invokeF.intValue;
    }
}
