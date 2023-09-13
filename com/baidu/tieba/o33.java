package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o33 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n33 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n33 a() {
        InterceptResult invokeV;
        n33 n33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o33.class) {
                if (a == null) {
                    a = new n33();
                }
                n33Var = a;
            }
            return n33Var;
        }
        return (n33) invokeV.objValue;
    }
}
