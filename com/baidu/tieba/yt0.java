package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xt0 a() {
        InterceptResult invokeV;
        xt0 xt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yt0.class) {
                if (a == null) {
                    a = new xt0();
                }
                xt0Var = a;
            }
            return xt0Var;
        }
        return (xt0) invokeV.objValue;
    }
}
