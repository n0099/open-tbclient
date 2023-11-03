package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k74 a() {
        InterceptResult invokeV;
        k74 k74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l74.class) {
                if (a == null) {
                    a = new k74();
                }
                k74Var = a;
            }
            return k74Var;
        }
        return (k74) invokeV.objValue;
    }
}
