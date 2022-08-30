package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ot0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ot0 a() {
        InterceptResult invokeV;
        ot0 ot0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pt0.class) {
                if (a == null) {
                    a = new ot0();
                }
                ot0Var = a;
            }
            return ot0Var;
        }
        return (ot0) invokeV.objValue;
    }
}
