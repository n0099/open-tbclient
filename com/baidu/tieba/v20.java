package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static z20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new a30();
            }
            return a;
        }
        return (z20) invokeV.objValue;
    }
}
