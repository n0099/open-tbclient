package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t84 a() {
        InterceptResult invokeV;
        t84 t84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u84.class) {
                if (a == null) {
                    a = new t84();
                }
                t84Var = a;
            }
            return t84Var;
        }
        return (t84) invokeV.objValue;
    }
}
