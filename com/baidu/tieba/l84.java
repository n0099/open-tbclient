package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k84 a() {
        InterceptResult invokeV;
        k84 k84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l84.class) {
                if (a == null) {
                    a = new k84();
                }
                k84Var = a;
            }
            return k84Var;
        }
        return (k84) invokeV.objValue;
    }
}
