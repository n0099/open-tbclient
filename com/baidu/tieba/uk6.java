package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uk6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tk6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tk6 a() {
        InterceptResult invokeV;
        tk6 tk6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uk6.class) {
                if (a == null) {
                    a = new tk6();
                }
                tk6Var = a;
            }
            return tk6Var;
        }
        return (tk6) invokeV.objValue;
    }
}
