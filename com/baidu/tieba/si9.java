package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class si9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ri9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ri9 a() {
        InterceptResult invokeV;
        ri9 ri9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (si9.class) {
                if (a == null) {
                    a = new ri9();
                }
                ri9Var = a;
            }
            return ri9Var;
        }
        return (ri9) invokeV.objValue;
    }
}
