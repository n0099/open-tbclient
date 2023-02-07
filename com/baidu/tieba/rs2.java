package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rs2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qs2 a() {
        InterceptResult invokeV;
        qs2 qs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rs2.class) {
                if (a == null) {
                    a = new qs2();
                }
                qs2Var = a;
            }
            return qs2Var;
        }
        return (qs2) invokeV.objValue;
    }
}
