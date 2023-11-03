package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nu6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mu6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mu6 a() {
        InterceptResult invokeV;
        mu6 mu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nu6.class) {
                if (a == null) {
                    a = new mu6();
                }
                mu6Var = a;
            }
            return mu6Var;
        }
        return (mu6) invokeV.objValue;
    }
}
