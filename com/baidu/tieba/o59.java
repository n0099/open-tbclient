package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n59 a() {
        InterceptResult invokeV;
        n59 n59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o59.class) {
                if (a == null) {
                    a = new n59();
                }
                n59Var = a;
            }
            return n59Var;
        }
        return (n59) invokeV.objValue;
    }
}
