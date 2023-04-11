package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yt3 a() {
        InterceptResult invokeV;
        yt3 yt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zt3.class) {
                if (a == null) {
                    a = new yt3();
                }
                yt3Var = a;
            }
            return yt3Var;
        }
        return (yt3) invokeV.objValue;
    }
}
