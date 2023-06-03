package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zb0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yb0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yb0 a() {
        InterceptResult invokeV;
        yb0 yb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zb0.class) {
                if (a == null) {
                    a = new yb0();
                }
                yb0Var = a;
            }
            return yb0Var;
        }
        return (yb0) invokeV.objValue;
    }
}
