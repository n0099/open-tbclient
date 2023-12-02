package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k34 a() {
        InterceptResult invokeV;
        k34 k34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l34.class) {
                if (a == null) {
                    a = new k34();
                }
                k34Var = a;
            }
            return k34Var;
        }
        return (k34) invokeV.objValue;
    }
}
