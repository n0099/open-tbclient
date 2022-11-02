package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ym3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ym3 a() {
        InterceptResult invokeV;
        ym3 ym3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zm3.class) {
                if (a == null) {
                    a = new ym3();
                }
                ym3Var = a;
            }
            return ym3Var;
        }
        return (ym3) invokeV.objValue;
    }
}
