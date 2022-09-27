package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sv0 a() {
        InterceptResult invokeV;
        sv0 sv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tv0.class) {
                if (a == null) {
                    a = new sv0();
                }
                sv0Var = a;
            }
            return sv0Var;
        }
        return (sv0) invokeV.objValue;
    }
}
