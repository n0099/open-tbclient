package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile na6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized na6 a() {
        InterceptResult invokeV;
        na6 na6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oa6.class) {
                if (a == null) {
                    a = new na6();
                }
                na6Var = a;
            }
            return na6Var;
        }
        return (na6) invokeV.objValue;
    }
}
