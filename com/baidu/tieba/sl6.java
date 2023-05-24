package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sl6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rl6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rl6 a() {
        InterceptResult invokeV;
        rl6 rl6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sl6.class) {
                if (a == null) {
                    a = new rl6();
                }
                rl6Var = a;
            }
            return rl6Var;
        }
        return (rl6) invokeV.objValue;
    }
}
