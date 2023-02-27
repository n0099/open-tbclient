package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ox0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nx0 a() {
        InterceptResult invokeV;
        nx0 nx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ox0.class) {
                if (a == null) {
                    a = new nx0();
                }
                nx0Var = a;
            }
            return nx0Var;
        }
        return (nx0) invokeV.objValue;
    }
}
