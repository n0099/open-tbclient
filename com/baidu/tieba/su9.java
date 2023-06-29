package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class su9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ru9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ru9 a() {
        InterceptResult invokeV;
        ru9 ru9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (su9.class) {
                if (a == null) {
                    a = new ru9();
                }
                ru9Var = a;
            }
            return ru9Var;
        }
        return (ru9) invokeV.objValue;
    }
}
