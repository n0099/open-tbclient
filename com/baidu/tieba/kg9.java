package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kg9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jg9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jg9 a() {
        InterceptResult invokeV;
        jg9 jg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kg9.class) {
                if (a == null) {
                    a = new jg9();
                }
                jg9Var = a;
            }
            return jg9Var;
        }
        return (jg9) invokeV.objValue;
    }
}
