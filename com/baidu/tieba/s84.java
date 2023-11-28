package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r84 a() {
        InterceptResult invokeV;
        r84 r84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s84.class) {
                if (a == null) {
                    a = new r84();
                }
                r84Var = a;
            }
            return r84Var;
        }
        return (r84) invokeV.objValue;
    }
}
