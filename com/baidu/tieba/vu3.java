package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uu3 a() {
        InterceptResult invokeV;
        uu3 uu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vu3.class) {
                if (a == null) {
                    a = new uu3();
                }
                uu3Var = a;
            }
            return uu3Var;
        }
        return (uu3) invokeV.objValue;
    }
}
