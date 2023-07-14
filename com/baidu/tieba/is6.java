package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class is6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hs6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hs6 a() {
        InterceptResult invokeV;
        hs6 hs6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (is6.class) {
                if (a == null) {
                    a = new hs6();
                }
                hs6Var = a;
            }
            return hs6Var;
        }
        return (hs6) invokeV.objValue;
    }
}
