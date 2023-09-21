package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yu2 a() {
        InterceptResult invokeV;
        yu2 yu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zu2.class) {
                if (a == null) {
                    a = new yu2();
                }
                yu2Var = a;
            }
            return yu2Var;
        }
        return (yu2) invokeV.objValue;
    }
}
