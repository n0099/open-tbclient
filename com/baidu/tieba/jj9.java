package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jj9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ij9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ij9 a() {
        InterceptResult invokeV;
        ij9 ij9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jj9.class) {
                if (a == null) {
                    a = new ij9();
                }
                ij9Var = a;
            }
            return ij9Var;
        }
        return (ij9) invokeV.objValue;
    }
}
