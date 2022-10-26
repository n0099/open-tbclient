package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vm2 a() {
        InterceptResult invokeV;
        vm2 vm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wm2.class) {
                if (a == null) {
                    a = new vm2();
                }
                vm2Var = a;
            }
            return vm2Var;
        }
        return (vm2) invokeV.objValue;
    }
}
