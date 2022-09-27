package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ui8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ti8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ti8 a() {
        InterceptResult invokeV;
        ti8 ti8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ui8.class) {
                if (a == null) {
                    a = new ti8();
                }
                ti8Var = a;
            }
            return ti8Var;
        }
        return (ti8) invokeV.objValue;
    }
}
