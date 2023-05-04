package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j46 a() {
        InterceptResult invokeV;
        j46 j46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k46.class) {
                if (a == null) {
                    a = new j46();
                }
                j46Var = a;
            }
            return j46Var;
        }
        return (j46) invokeV.objValue;
    }
}
