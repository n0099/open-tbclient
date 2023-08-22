package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u96 a() {
        InterceptResult invokeV;
        u96 u96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v96.class) {
                if (a == null) {
                    a = new u96();
                }
                u96Var = a;
            }
            return u96Var;
        }
        return (u96) invokeV.objValue;
    }
}
