package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u06 a() {
        InterceptResult invokeV;
        u06 u06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v06.class) {
                if (a == null) {
                    a = new u06();
                }
                u06Var = a;
            }
            return u06Var;
        }
        return (u06) invokeV.objValue;
    }
}
