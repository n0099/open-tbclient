package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sr9 a() {
        InterceptResult invokeV;
        sr9 sr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tr9.class) {
                if (a == null) {
                    a = new sr9();
                }
                sr9Var = a;
            }
            return sr9Var;
        }
        return (sr9) invokeV.objValue;
    }
}
