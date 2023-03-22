package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t59 a() {
        InterceptResult invokeV;
        t59 t59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u59.class) {
                if (a == null) {
                    a = new t59();
                }
                t59Var = a;
            }
            return t59Var;
        }
        return (t59) invokeV.objValue;
    }
}
