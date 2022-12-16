package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile on8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized on8 a() {
        InterceptResult invokeV;
        on8 on8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pn8.class) {
                if (a == null) {
                    a = new on8();
                }
                on8Var = a;
            }
            return on8Var;
        }
        return (on8) invokeV.objValue;
    }
}
