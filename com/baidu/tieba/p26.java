package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o26 a() {
        InterceptResult invokeV;
        o26 o26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p26.class) {
                if (a == null) {
                    a = new o26();
                }
                o26Var = a;
            }
            return o26Var;
        }
        return (o26) invokeV.objValue;
    }
}
