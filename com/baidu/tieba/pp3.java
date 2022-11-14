package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile op3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized op3 a() {
        InterceptResult invokeV;
        op3 op3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pp3.class) {
                if (a == null) {
                    a = new op3();
                }
                op3Var = a;
            }
            return op3Var;
        }
        return (op3) invokeV.objValue;
    }
}
