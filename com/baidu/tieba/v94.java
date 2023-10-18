package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u94 a() {
        InterceptResult invokeV;
        u94 u94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v94.class) {
                if (a == null) {
                    a = new u94();
                }
                u94Var = a;
            }
            return u94Var;
        }
        return (u94) invokeV.objValue;
    }
}
