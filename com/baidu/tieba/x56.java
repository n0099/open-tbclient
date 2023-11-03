package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class x56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w56 a() {
        InterceptResult invokeV;
        w56 w56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x56.class) {
                if (a == null) {
                    a = new w56();
                }
                w56Var = a;
            }
            return w56Var;
        }
        return (w56) invokeV.objValue;
    }
}
