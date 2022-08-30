package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o49 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n49 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n49 a() {
        InterceptResult invokeV;
        n49 n49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o49.class) {
                if (a == null) {
                    a = new n49();
                }
                n49Var = a;
            }
            return n49Var;
        }
        return (n49) invokeV.objValue;
    }
}
