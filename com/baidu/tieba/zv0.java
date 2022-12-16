package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yv0 a() {
        InterceptResult invokeV;
        yv0 yv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zv0.class) {
                if (a == null) {
                    a = new yv0();
                }
                yv0Var = a;
            }
            return yv0Var;
        }
        return (yv0) invokeV.objValue;
    }
}
