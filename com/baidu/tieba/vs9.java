package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vs9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile us9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized us9 a() {
        InterceptResult invokeV;
        us9 us9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vs9.class) {
                if (a == null) {
                    a = new us9();
                }
                us9Var = a;
            }
            return us9Var;
        }
        return (us9) invokeV.objValue;
    }
}
