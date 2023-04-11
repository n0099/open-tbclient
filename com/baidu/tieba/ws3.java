package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ws3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vs3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vs3 a() {
        InterceptResult invokeV;
        vs3 vs3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ws3.class) {
                if (a == null) {
                    a = new vs3();
                }
                vs3Var = a;
            }
            return vs3Var;
        }
        return (vs3) invokeV.objValue;
    }
}
