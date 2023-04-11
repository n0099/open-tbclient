package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class si6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ri6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ri6 a() {
        InterceptResult invokeV;
        ri6 ri6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (si6.class) {
                if (a == null) {
                    a = new ri6();
                }
                ri6Var = a;
            }
            return ri6Var;
        }
        return (ri6) invokeV.objValue;
    }
}
