package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pw5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ow5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ow5 a() {
        InterceptResult invokeV;
        ow5 ow5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pw5.class) {
                if (a == null) {
                    a = new ow5();
                }
                ow5Var = a;
            }
            return ow5Var;
        }
        return (ow5) invokeV.objValue;
    }
}
