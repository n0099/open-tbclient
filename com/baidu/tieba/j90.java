package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i90 a() {
        InterceptResult invokeV;
        i90 i90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j90.class) {
                if (a == null) {
                    a = new i90();
                }
                i90Var = a;
            }
            return i90Var;
        }
        return (i90) invokeV.objValue;
    }
}
