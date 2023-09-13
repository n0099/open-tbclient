package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class va6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ua6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ua6 a() {
        InterceptResult invokeV;
        ua6 ua6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (va6.class) {
                if (a == null) {
                    a = new ua6();
                }
                ua6Var = a;
            }
            return ua6Var;
        }
        return (ua6) invokeV.objValue;
    }
}
