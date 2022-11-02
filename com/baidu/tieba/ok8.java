package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ok8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nk8 a() {
        InterceptResult invokeV;
        nk8 nk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ok8.class) {
                if (a == null) {
                    a = new nk8();
                }
                nk8Var = a;
            }
            return nk8Var;
        }
        return (nk8) invokeV.objValue;
    }
}
