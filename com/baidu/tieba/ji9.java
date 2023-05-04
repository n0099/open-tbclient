package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ji9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ii9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ii9 a() {
        InterceptResult invokeV;
        ii9 ii9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ji9.class) {
                if (a == null) {
                    a = new ii9();
                }
                ii9Var = a;
            }
            return ii9Var;
        }
        return (ii9) invokeV.objValue;
    }
}
