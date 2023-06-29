package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mu3 a() {
        InterceptResult invokeV;
        mu3 mu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nu3.class) {
                if (a == null) {
                    a = new mu3();
                }
                mu3Var = a;
            }
            return mu3Var;
        }
        return (mu3) invokeV.objValue;
    }
}
