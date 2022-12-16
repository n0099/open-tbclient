package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class su5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ru5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ru5 a() {
        InterceptResult invokeV;
        ru5 ru5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (su5.class) {
                if (a == null) {
                    a = new ru5();
                }
                ru5Var = a;
            }
            return ru5Var;
        }
        return (ru5) invokeV.objValue;
    }
}
