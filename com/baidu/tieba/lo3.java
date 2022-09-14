package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class lo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ko3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ko3 a() {
        InterceptResult invokeV;
        ko3 ko3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lo3.class) {
                if (a == null) {
                    a = new ko3();
                }
                ko3Var = a;
            }
            return ko3Var;
        }
        return (ko3) invokeV.objValue;
    }
}
