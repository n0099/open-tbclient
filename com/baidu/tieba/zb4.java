package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yb4 a() {
        InterceptResult invokeV;
        yb4 yb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zb4.class) {
                if (a == null) {
                    a = new yb4();
                }
                yb4Var = a;
            }
            return yb4Var;
        }
        return (yb4) invokeV.objValue;
    }
}
