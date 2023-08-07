package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rv6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qv6 a() {
        InterceptResult invokeV;
        qv6 qv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rv6.class) {
                if (a == null) {
                    a = new qv6();
                }
                qv6Var = a;
            }
            return qv6Var;
        }
        return (qv6) invokeV.objValue;
    }
}
