package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tk9 a() {
        InterceptResult invokeV;
        tk9 tk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uk9.class) {
                if (a == null) {
                    a = new tk9();
                }
                tk9Var = a;
            }
            return tk9Var;
        }
        return (tk9) invokeV.objValue;
    }
}
