package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class we1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ve1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ve1 a() {
        InterceptResult invokeV;
        ve1 ve1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (we1.class) {
                if (a == null) {
                    a = new ve1();
                }
                ve1Var = a;
            }
            return ve1Var;
        }
        return (ve1) invokeV.objValue;
    }
}
