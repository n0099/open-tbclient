package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hy0 a() {
        InterceptResult invokeV;
        hy0 hy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iy0.class) {
                if (a == null) {
                    a = new hy0();
                }
                hy0Var = a;
            }
            return hy0Var;
        }
        return (hy0) invokeV.objValue;
    }
}
