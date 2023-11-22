package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n66 a() {
        InterceptResult invokeV;
        n66 n66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o66.class) {
                if (a == null) {
                    a = new n66();
                }
                n66Var = a;
            }
            return n66Var;
        }
        return (n66) invokeV.objValue;
    }
}
