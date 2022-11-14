package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class un2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tn2 a() {
        InterceptResult invokeV;
        tn2 tn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (un2.class) {
                if (a == null) {
                    a = new tn2();
                }
                tn2Var = a;
            }
            return tn2Var;
        }
        return (tn2) invokeV.objValue;
    }
}
