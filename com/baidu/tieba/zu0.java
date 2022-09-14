package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yu0 a() {
        InterceptResult invokeV;
        yu0 yu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zu0.class) {
                if (a == null) {
                    a = new yu0();
                }
                yu0Var = a;
            }
            return yu0Var;
        }
        return (yu0) invokeV.objValue;
    }
}
