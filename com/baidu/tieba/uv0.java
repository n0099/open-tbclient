package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tv0 a() {
        InterceptResult invokeV;
        tv0 tv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uv0.class) {
                if (a == null) {
                    a = new tv0();
                }
                tv0Var = a;
            }
            return tv0Var;
        }
        return (tv0) invokeV.objValue;
    }
}
