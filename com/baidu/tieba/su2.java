package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class su2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ru2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ru2 a() {
        InterceptResult invokeV;
        ru2 ru2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (su2.class) {
                if (a == null) {
                    a = new ru2();
                }
                ru2Var = a;
            }
            return ru2Var;
        }
        return (ru2) invokeV.objValue;
    }
}
