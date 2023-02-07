package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class is2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hs2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hs2 a() {
        InterceptResult invokeV;
        hs2 hs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (is2.class) {
                if (a == null) {
                    a = new hs2();
                }
                hs2Var = a;
            }
            return hs2Var;
        }
        return (hs2) invokeV.objValue;
    }
}
