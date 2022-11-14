package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xt5 a() {
        InterceptResult invokeV;
        xt5 xt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yt5.class) {
                if (a == null) {
                    a = new xt5();
                }
                xt5Var = a;
            }
            return xt5Var;
        }
        return (xt5) invokeV.objValue;
    }
}
