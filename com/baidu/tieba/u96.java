package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t96 a() {
        InterceptResult invokeV;
        t96 t96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u96.class) {
                if (a == null) {
                    a = new t96();
                }
                t96Var = a;
            }
            return t96Var;
        }
        return (t96) invokeV.objValue;
    }
}
