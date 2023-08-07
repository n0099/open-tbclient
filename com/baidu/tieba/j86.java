package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i86 a() {
        InterceptResult invokeV;
        i86 i86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j86.class) {
                if (a == null) {
                    a = new i86();
                }
                i86Var = a;
            }
            return i86Var;
        }
        return (i86) invokeV.objValue;
    }
}
