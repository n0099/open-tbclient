package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k59 a() {
        InterceptResult invokeV;
        k59 k59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l59.class) {
                if (a == null) {
                    a = new k59();
                }
                k59Var = a;
            }
            return k59Var;
        }
        return (k59) invokeV.objValue;
    }
}
