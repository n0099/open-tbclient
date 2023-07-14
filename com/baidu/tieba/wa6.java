package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile va6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized va6 a() {
        InterceptResult invokeV;
        va6 va6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wa6.class) {
                if (a == null) {
                    a = new va6();
                }
                va6Var = a;
            }
            return va6Var;
        }
        return (va6) invokeV.objValue;
    }
}
