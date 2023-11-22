package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ou6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nu6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nu6 a() {
        InterceptResult invokeV;
        nu6 nu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ou6.class) {
                if (a == null) {
                    a = new nu6();
                }
                nu6Var = a;
            }
            return nu6Var;
        }
        return (nu6) invokeV.objValue;
    }
}
