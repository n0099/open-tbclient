package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uv8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tv8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tv8 a() {
        InterceptResult invokeV;
        tv8 tv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uv8.class) {
                if (a == null) {
                    a = new tv8();
                }
                tv8Var = a;
            }
            return tv8Var;
        }
        return (tv8) invokeV.objValue;
    }
}
