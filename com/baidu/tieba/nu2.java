package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mu2 a() {
        InterceptResult invokeV;
        mu2 mu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nu2.class) {
                if (a == null) {
                    a = new mu2();
                }
                mu2Var = a;
            }
            return mu2Var;
        }
        return (mu2) invokeV.objValue;
    }
}
