package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i96 a() {
        InterceptResult invokeV;
        i96 i96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j96.class) {
                if (a == null) {
                    a = new i96();
                }
                i96Var = a;
            }
            return i96Var;
        }
        return (i96) invokeV.objValue;
    }
}
