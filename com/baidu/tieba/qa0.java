package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qa0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pa0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pa0 a() {
        InterceptResult invokeV;
        pa0 pa0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qa0.class) {
                if (a == null) {
                    a = new pa0();
                }
                pa0Var = a;
            }
            return pa0Var;
        }
        return (pa0) invokeV.objValue;
    }
}
