package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sv2 a() {
        InterceptResult invokeV;
        sv2 sv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tv2.class) {
                if (a == null) {
                    a = new sv2();
                }
                sv2Var = a;
            }
            return sv2Var;
        }
        return (sv2) invokeV.objValue;
    }
}
