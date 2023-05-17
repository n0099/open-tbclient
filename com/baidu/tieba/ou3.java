package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ou3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nu3 a() {
        InterceptResult invokeV;
        nu3 nu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ou3.class) {
                if (a == null) {
                    a = new nu3();
                }
                nu3Var = a;
            }
            return nu3Var;
        }
        return (nu3) invokeV.objValue;
    }
}
