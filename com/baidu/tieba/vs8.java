package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vs8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile us8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized us8 a() {
        InterceptResult invokeV;
        us8 us8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vs8.class) {
                if (a == null) {
                    a = new us8();
                }
                us8Var = a;
            }
            return us8Var;
        }
        return (us8) invokeV.objValue;
    }
}
