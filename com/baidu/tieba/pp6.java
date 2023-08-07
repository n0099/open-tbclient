package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pp6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile op6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized op6 a() {
        InterceptResult invokeV;
        op6 op6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pp6.class) {
                if (a == null) {
                    a = new op6();
                }
                op6Var = a;
            }
            return op6Var;
        }
        return (op6) invokeV.objValue;
    }
}
