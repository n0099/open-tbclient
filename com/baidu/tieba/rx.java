package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rx {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wx a;
    public transient /* synthetic */ FieldHolder $fh;

    public static wx a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new xx();
            }
            return a;
        }
        return (wx) invokeV.objValue;
    }
}
