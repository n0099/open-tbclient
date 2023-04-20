package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n44 a() {
        InterceptResult invokeV;
        n44 n44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o44.class) {
                if (a == null) {
                    a = new n44();
                }
                n44Var = a;
            }
            return n44Var;
        }
        return (n44) invokeV.objValue;
    }
}
