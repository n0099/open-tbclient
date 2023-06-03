package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class my0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ly0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ly0 a() {
        InterceptResult invokeV;
        ly0 ly0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (my0.class) {
                if (a == null) {
                    a = new ly0();
                }
                ly0Var = a;
            }
            return ly0Var;
        }
        return (ly0) invokeV.objValue;
    }
}
