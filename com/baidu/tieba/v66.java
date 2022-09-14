package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u66 a() {
        InterceptResult invokeV;
        u66 u66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v66.class) {
                if (a == null) {
                    a = new u66();
                }
                u66Var = a;
            }
            return u66Var;
        }
        return (u66) invokeV.objValue;
    }
}
