package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ky0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jy0 a() {
        InterceptResult invokeV;
        jy0 jy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ky0.class) {
                if (a == null) {
                    a = new jy0();
                }
                jy0Var = a;
            }
            return jy0Var;
        }
        return (jy0) invokeV.objValue;
    }
}
