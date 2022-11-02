package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vj8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uj8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uj8 a() {
        InterceptResult invokeV;
        uj8 uj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vj8.class) {
                if (a == null) {
                    a = new uj8();
                }
                uj8Var = a;
            }
            return uj8Var;
        }
        return (uj8) invokeV.objValue;
    }
}
