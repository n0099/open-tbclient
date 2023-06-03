package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static e30 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new f30();
            }
            return a;
        }
        return (e30) invokeV.objValue;
    }
}
