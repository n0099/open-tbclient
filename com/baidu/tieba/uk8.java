package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tk8 a() {
        InterceptResult invokeV;
        tk8 tk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uk8.class) {
                if (a == null) {
                    a = new tk8();
                }
                tk8Var = a;
            }
            return tk8Var;
        }
        return (tk8) invokeV.objValue;
    }
}
