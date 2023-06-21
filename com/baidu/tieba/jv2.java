package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iv2 a() {
        InterceptResult invokeV;
        iv2 iv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jv2.class) {
                if (a == null) {
                    a = new iv2();
                }
                iv2Var = a;
            }
            return iv2Var;
        }
        return (iv2) invokeV.objValue;
    }
}
