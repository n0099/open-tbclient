package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y10 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static d20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new e20();
            }
            return a;
        }
        return (d20) invokeV.objValue;
    }
}
