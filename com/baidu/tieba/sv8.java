package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sv8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rv8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rv8 a() {
        InterceptResult invokeV;
        rv8 rv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sv8.class) {
                if (a == null) {
                    a = new rv8();
                }
                rv8Var = a;
            }
            return rv8Var;
        }
        return (rv8) invokeV.objValue;
    }
}
