package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u84 a() {
        InterceptResult invokeV;
        u84 u84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v84.class) {
                if (a == null) {
                    a = new u84();
                }
                u84Var = a;
            }
            return u84Var;
        }
        return (u84) invokeV.objValue;
    }
}
