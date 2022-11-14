package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lu5 a() {
        InterceptResult invokeV;
        lu5 lu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mu5.class) {
                if (a == null) {
                    a = new lu5();
                }
                lu5Var = a;
            }
            return lu5Var;
        }
        return (lu5) invokeV.objValue;
    }
}
