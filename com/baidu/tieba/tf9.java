package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sf9 a() {
        InterceptResult invokeV;
        sf9 sf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tf9.class) {
                if (a == null) {
                    a = new sf9();
                }
                sf9Var = a;
            }
            return sf9Var;
        }
        return (sf9) invokeV.objValue;
    }
}
