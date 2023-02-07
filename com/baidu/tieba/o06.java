package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n06 a() {
        InterceptResult invokeV;
        n06 n06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o06.class) {
                if (a == null) {
                    a = new n06();
                }
                n06Var = a;
            }
            return n06Var;
        }
        return (n06) invokeV.objValue;
    }
}
