package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l69 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k69 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k69 a() {
        InterceptResult invokeV;
        k69 k69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l69.class) {
                if (a == null) {
                    a = new k69();
                }
                k69Var = a;
            }
            return k69Var;
        }
        return (k69) invokeV.objValue;
    }
}
