package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qg8 a() {
        InterceptResult invokeV;
        qg8 qg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rg8.class) {
                if (a == null) {
                    a = new qg8();
                }
                qg8Var = a;
            }
            return qg8Var;
        }
        return (qg8) invokeV.objValue;
    }
}
