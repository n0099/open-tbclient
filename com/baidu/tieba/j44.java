package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i44 a() {
        InterceptResult invokeV;
        i44 i44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j44.class) {
                if (a == null) {
                    a = new i44();
                }
                i44Var = a;
            }
            return i44Var;
        }
        return (i44) invokeV.objValue;
    }
}
