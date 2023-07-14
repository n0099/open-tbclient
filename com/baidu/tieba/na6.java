package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class na6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ma6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ma6 a() {
        InterceptResult invokeV;
        ma6 ma6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (na6.class) {
                if (a == null) {
                    a = new ma6();
                }
                ma6Var = a;
            }
            return ma6Var;
        }
        return (ma6) invokeV.objValue;
    }
}
