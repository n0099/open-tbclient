package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lx3 a() {
        InterceptResult invokeV;
        lx3 lx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mx3.class) {
                if (a == null) {
                    a = new lx3();
                }
                lx3Var = a;
            }
            return lx3Var;
        }
        return (lx3) invokeV.objValue;
    }
}
