package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ws2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vs2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vs2 a() {
        InterceptResult invokeV;
        vs2 vs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ws2.class) {
                if (a == null) {
                    a = new vs2();
                }
                vs2Var = a;
            }
            return vs2Var;
        }
        return (vs2) invokeV.objValue;
    }
}
