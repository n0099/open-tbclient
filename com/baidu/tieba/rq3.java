package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qq3 a() {
        InterceptResult invokeV;
        qq3 qq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rq3.class) {
                if (a == null) {
                    a = new qq3();
                }
                qq3Var = a;
            }
            return qq3Var;
        }
        return (qq3) invokeV.objValue;
    }
}
