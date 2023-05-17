package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i56 a() {
        InterceptResult invokeV;
        i56 i56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j56.class) {
                if (a == null) {
                    a = new i56();
                }
                i56Var = a;
            }
            return i56Var;
        }
        return (i56) invokeV.objValue;
    }
}
