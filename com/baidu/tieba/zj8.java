package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zj8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yj8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yj8 a() {
        InterceptResult invokeV;
        yj8 yj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zj8.class) {
                if (a == null) {
                    a = new yj8();
                }
                yj8Var = a;
            }
            return yj8Var;
        }
        return (yj8) invokeV.objValue;
    }
}
