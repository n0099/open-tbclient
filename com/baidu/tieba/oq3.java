package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nq3 a() {
        InterceptResult invokeV;
        nq3 nq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oq3.class) {
                if (a == null) {
                    a = new nq3();
                }
                nq3Var = a;
            }
            return nq3Var;
        }
        return (nq3) invokeV.objValue;
    }
}
