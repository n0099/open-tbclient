package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k90 a() {
        InterceptResult invokeV;
        k90 k90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l90.class) {
                if (a == null) {
                    a = new k90();
                }
                k90Var = a;
            }
            return k90Var;
        }
        return (k90) invokeV.objValue;
    }
}
