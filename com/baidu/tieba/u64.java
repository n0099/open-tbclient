package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t64 a() {
        InterceptResult invokeV;
        t64 t64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u64.class) {
                if (a == null) {
                    a = new t64();
                }
                t64Var = a;
            }
            return t64Var;
        }
        return (t64) invokeV.objValue;
    }
}
