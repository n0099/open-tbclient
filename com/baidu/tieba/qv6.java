package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qv6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pv6 a() {
        InterceptResult invokeV;
        pv6 pv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qv6.class) {
                if (a == null) {
                    a = new pv6();
                }
                pv6Var = a;
            }
            return pv6Var;
        }
        return (pv6) invokeV.objValue;
    }
}
