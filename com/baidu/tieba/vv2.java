package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uv2 a() {
        InterceptResult invokeV;
        uv2 uv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vv2.class) {
                if (a == null) {
                    a = new uv2();
                }
                uv2Var = a;
            }
            return uv2Var;
        }
        return (uv2) invokeV.objValue;
    }
}
