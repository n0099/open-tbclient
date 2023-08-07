package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i80 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i80 a() {
        InterceptResult invokeV;
        i80 i80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j80.class) {
                if (a == null) {
                    a = new i80();
                }
                i80Var = a;
            }
            return i80Var;
        }
        return (i80) invokeV.objValue;
    }
}
