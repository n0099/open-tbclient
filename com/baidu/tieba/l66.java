package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k66 a() {
        InterceptResult invokeV;
        k66 k66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l66.class) {
                if (a == null) {
                    a = new k66();
                }
                k66Var = a;
            }
            return k66Var;
        }
        return (k66) invokeV.objValue;
    }
}
