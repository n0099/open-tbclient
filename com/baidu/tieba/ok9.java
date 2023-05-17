package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ok9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nk9 a() {
        InterceptResult invokeV;
        nk9 nk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ok9.class) {
                if (a == null) {
                    a = new nk9();
                }
                nk9Var = a;
            }
            return nk9Var;
        }
        return (nk9) invokeV.objValue;
    }
}
