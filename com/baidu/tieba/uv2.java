package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tv2 a() {
        InterceptResult invokeV;
        tv2 tv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uv2.class) {
                if (a == null) {
                    a = new tv2();
                }
                tv2Var = a;
            }
            return tv2Var;
        }
        return (tv2) invokeV.objValue;
    }
}
