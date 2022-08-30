package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lg8 a() {
        InterceptResult invokeV;
        lg8 lg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mg8.class) {
                if (a == null) {
                    a = new lg8();
                }
                lg8Var = a;
            }
            return lg8Var;
        }
        return (lg8) invokeV.objValue;
    }
}
