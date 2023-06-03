package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ov6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nv6 a() {
        InterceptResult invokeV;
        nv6 nv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ov6.class) {
                if (a == null) {
                    a = new nv6();
                }
                nv6Var = a;
            }
            return nv6Var;
        }
        return (nv6) invokeV.objValue;
    }
}
