package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vx3 a() {
        InterceptResult invokeV;
        vx3 vx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wx3.class) {
                if (a == null) {
                    a = new vx3();
                }
                vx3Var = a;
            }
            return vx3Var;
        }
        return (vx3) invokeV.objValue;
    }
}
