package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class po6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oo6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oo6 a() {
        InterceptResult invokeV;
        oo6 oo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (po6.class) {
                if (a == null) {
                    a = new oo6();
                }
                oo6Var = a;
            }
            return oo6Var;
        }
        return (oo6) invokeV.objValue;
    }
}
