package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xt3 a() {
        InterceptResult invokeV;
        xt3 xt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yt3.class) {
                if (a == null) {
                    a = new xt3();
                }
                xt3Var = a;
            }
            return xt3Var;
        }
        return (xt3) invokeV.objValue;
    }
}
