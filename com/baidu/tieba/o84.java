package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n84 a() {
        InterceptResult invokeV;
        n84 n84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o84.class) {
                if (a == null) {
                    a = new n84();
                }
                n84Var = a;
            }
            return n84Var;
        }
        return (n84) invokeV.objValue;
    }
}
