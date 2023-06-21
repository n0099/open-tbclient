package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vv6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uv6 a() {
        InterceptResult invokeV;
        uv6 uv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vv6.class) {
                if (a == null) {
                    a = new uv6();
                }
                uv6Var = a;
            }
            return uv6Var;
        }
        return (uv6) invokeV.objValue;
    }
}
