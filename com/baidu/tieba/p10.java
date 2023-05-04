package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p10 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static t10 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new u10();
            }
            return a;
        }
        return (t10) invokeV.objValue;
    }
}
