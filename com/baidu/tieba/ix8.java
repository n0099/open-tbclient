package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ix8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hx8 a() {
        InterceptResult invokeV;
        hx8 hx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ix8.class) {
                if (a == null) {
                    a = new hx8();
                }
                hx8Var = a;
            }
            return hx8Var;
        }
        return (hx8) invokeV.objValue;
    }
}
