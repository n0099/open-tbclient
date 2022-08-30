package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ok2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ok2 a() {
        InterceptResult invokeV;
        ok2 ok2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pk2.class) {
                if (a == null) {
                    a = new ok2();
                }
                ok2Var = a;
            }
            return ok2Var;
        }
        return (ok2) invokeV.objValue;
    }
}
