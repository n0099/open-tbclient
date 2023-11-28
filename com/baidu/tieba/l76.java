package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k76 a() {
        InterceptResult invokeV;
        k76 k76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l76.class) {
                if (a == null) {
                    a = new k76();
                }
                k76Var = a;
            }
            return k76Var;
        }
        return (k76) invokeV.objValue;
    }
}
