package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ut0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tt0 a() {
        InterceptResult invokeV;
        tt0 tt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ut0.class) {
                if (a == null) {
                    a = new tt0();
                }
                tt0Var = a;
            }
            return tt0Var;
        }
        return (tt0) invokeV.objValue;
    }
}
