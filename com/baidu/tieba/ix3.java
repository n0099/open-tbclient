package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ix3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hx3 a() {
        InterceptResult invokeV;
        hx3 hx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ix3.class) {
                if (a == null) {
                    a = new hx3();
                }
                hx3Var = a;
            }
            return hx3Var;
        }
        return (hx3) invokeV.objValue;
    }
}
