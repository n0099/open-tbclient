package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wx2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vx2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vx2 a() {
        InterceptResult invokeV;
        vx2 vx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wx2.class) {
                if (a == null) {
                    a = new vx2();
                }
                vx2Var = a;
            }
            return vx2Var;
        }
        return (vx2) invokeV.objValue;
    }
}
