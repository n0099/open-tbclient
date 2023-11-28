package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yu6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xu6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xu6 a() {
        InterceptResult invokeV;
        xu6 xu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yu6.class) {
                if (a == null) {
                    a = new xu6();
                }
                xu6Var = a;
            }
            return xu6Var;
        }
        return (xu6) invokeV.objValue;
    }
}
