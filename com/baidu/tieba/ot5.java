package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ot5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nt5 a() {
        InterceptResult invokeV;
        nt5 nt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ot5.class) {
                if (a == null) {
                    a = new nt5();
                }
                nt5Var = a;
            }
            return nt5Var;
        }
        return (nt5) invokeV.objValue;
    }
}
