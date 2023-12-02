package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class va4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ua4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ua4 a() {
        InterceptResult invokeV;
        ua4 ua4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (va4.class) {
                if (a == null) {
                    a = new ua4();
                }
                ua4Var = a;
            }
            return ua4Var;
        }
        return (ua4) invokeV.objValue;
    }
}
