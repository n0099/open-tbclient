package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yu5 a() {
        InterceptResult invokeV;
        yu5 yu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zu5.class) {
                if (a == null) {
                    a = new yu5();
                }
                yu5Var = a;
            }
            return yu5Var;
        }
        return (yu5) invokeV.objValue;
    }
}
