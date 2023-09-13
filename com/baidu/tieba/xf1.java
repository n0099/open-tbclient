package com.baidu.tieba;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes8.dex */
public final class xf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject
    public static hg1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return gg1.a();
        }
        return (hg1) invokeV.objValue;
    }
}
