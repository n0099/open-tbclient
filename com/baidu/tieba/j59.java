package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class j59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i59 a() {
        InterceptResult invokeV;
        i59 i59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j59.class) {
                if (a == null) {
                    a = new i59();
                }
                i59Var = a;
            }
            return i59Var;
        }
        return (i59) invokeV.objValue;
    }
}
