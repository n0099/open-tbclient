package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ti6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile si6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized si6 a() {
        InterceptResult invokeV;
        si6 si6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ti6.class) {
                if (a == null) {
                    a = new si6();
                }
                si6Var = a;
            }
            return si6Var;
        }
        return (si6) invokeV.objValue;
    }
}
