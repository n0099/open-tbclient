package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mu5 a() {
        InterceptResult invokeV;
        mu5 mu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nu5.class) {
                if (a == null) {
                    a = new mu5();
                }
                mu5Var = a;
            }
            return mu5Var;
        }
        return (mu5) invokeV.objValue;
    }
}
