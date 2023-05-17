package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t56 a() {
        InterceptResult invokeV;
        t56 t56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u56.class) {
                if (a == null) {
                    a = new t56();
                }
                t56Var = a;
            }
            return t56Var;
        }
        return (t56) invokeV.objValue;
    }
}
