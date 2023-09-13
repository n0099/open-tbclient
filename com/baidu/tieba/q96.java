package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p96 a() {
        InterceptResult invokeV;
        p96 p96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q96.class) {
                if (a == null) {
                    a = new p96();
                }
                p96Var = a;
            }
            return p96Var;
        }
        return (p96) invokeV.objValue;
    }
}
