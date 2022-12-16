package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yv5 a() {
        InterceptResult invokeV;
        yv5 yv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zv5.class) {
                if (a == null) {
                    a = new yv5();
                }
                yv5Var = a;
            }
            return yv5Var;
        }
        return (yv5) invokeV.objValue;
    }
}
