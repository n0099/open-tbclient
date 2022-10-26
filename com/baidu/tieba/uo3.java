package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile to3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized to3 a() {
        InterceptResult invokeV;
        to3 to3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uo3.class) {
                if (a == null) {
                    a = new to3();
                }
                to3Var = a;
            }
            return to3Var;
        }
        return (to3) invokeV.objValue;
    }
}
