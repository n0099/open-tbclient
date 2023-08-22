package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class of4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nf4 a() {
        InterceptResult invokeV;
        nf4 nf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (of4.class) {
                if (a == null) {
                    a = new nf4();
                }
                nf4Var = a;
            }
            return nf4Var;
        }
        return (nf4) invokeV.objValue;
    }
}
