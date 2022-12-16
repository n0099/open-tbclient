package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uv5 a() {
        InterceptResult invokeV;
        uv5 uv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vv5.class) {
                if (a == null) {
                    a = new uv5();
                }
                uv5Var = a;
            }
            return uv5Var;
        }
        return (uv5) invokeV.objValue;
    }
}
