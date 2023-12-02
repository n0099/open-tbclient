package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j76 a() {
        InterceptResult invokeV;
        j76 j76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k76.class) {
                if (a == null) {
                    a = new j76();
                }
                j76Var = a;
            }
            return j76Var;
        }
        return (j76) invokeV.objValue;
    }
}
