package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wr3 a() {
        InterceptResult invokeV;
        wr3 wr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xr3.class) {
                if (a == null) {
                    a = new wr3();
                }
                wr3Var = a;
            }
            return wr3Var;
        }
        return (wr3) invokeV.objValue;
    }
}
