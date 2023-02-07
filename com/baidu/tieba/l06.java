package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k06 a() {
        InterceptResult invokeV;
        k06 k06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l06.class) {
                if (a == null) {
                    a = new k06();
                }
                k06Var = a;
            }
            return k06Var;
        }
        return (k06) invokeV.objValue;
    }
}
