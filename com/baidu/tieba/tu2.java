package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile su2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized su2 a() {
        InterceptResult invokeV;
        su2 su2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tu2.class) {
                if (a == null) {
                    a = new su2();
                }
                su2Var = a;
            }
            return su2Var;
        }
        return (su2) invokeV.objValue;
    }
}
