package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jn8 a() {
        InterceptResult invokeV;
        jn8 jn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kn8.class) {
                if (a == null) {
                    a = new jn8();
                }
                jn8Var = a;
            }
            return jn8Var;
        }
        return (jn8) invokeV.objValue;
    }
}
