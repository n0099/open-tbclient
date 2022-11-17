package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ok8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ok8 a() {
        InterceptResult invokeV;
        ok8 ok8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pk8.class) {
                if (a == null) {
                    a = new ok8();
                }
                ok8Var = a;
            }
            return ok8Var;
        }
        return (ok8) invokeV.objValue;
    }
}
