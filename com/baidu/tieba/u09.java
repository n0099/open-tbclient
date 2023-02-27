package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t09 a() {
        InterceptResult invokeV;
        t09 t09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u09.class) {
                if (a == null) {
                    a = new t09();
                }
                t09Var = a;
            }
            return t09Var;
        }
        return (t09) invokeV.objValue;
    }
}
