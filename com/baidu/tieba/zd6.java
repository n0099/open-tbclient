package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zd6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yd6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yd6 a() {
        InterceptResult invokeV;
        yd6 yd6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zd6.class) {
                if (a == null) {
                    a = new yd6();
                }
                yd6Var = a;
            }
            return yd6Var;
        }
        return (yd6) invokeV.objValue;
    }
}
