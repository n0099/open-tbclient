package com.baidu.tieba;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes9.dex */
public class zz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static a04 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return a84.a();
        }
        return (a04) invokeV.objValue;
    }

    @Inject
    public static b04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return tu2.a();
        }
        return (b04) invokeV.objValue;
    }

    @Inject
    public static c04 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new uu2();
        }
        return (c04) invokeV.objValue;
    }
}
