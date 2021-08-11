package com.bytedance.sdk.component.image.c.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.image.IMemoryCache;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IMemoryCache a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? new d(new b(i2, Integer.MAX_VALUE)) : (IMemoryCache) invokeI.objValue;
    }

    public static IMemoryCache a(IMemoryCache iMemoryCache) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iMemoryCache)) == null) ? new d(iMemoryCache) : (IMemoryCache) invokeL.objValue;
    }
}
