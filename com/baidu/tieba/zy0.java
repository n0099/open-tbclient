package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yy0 a() {
        InterceptResult invokeV;
        yy0 yy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zy0.class) {
                if (a == null) {
                    a = new yy0();
                }
                yy0Var = a;
            }
            return yy0Var;
        }
        return (yy0) invokeV.objValue;
    }
}
