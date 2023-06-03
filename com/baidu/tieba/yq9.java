package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yq9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xq9 a() {
        InterceptResult invokeV;
        xq9 xq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yq9.class) {
                if (a == null) {
                    a = new xq9();
                }
                xq9Var = a;
            }
            return xq9Var;
        }
        return (xq9) invokeV.objValue;
    }
}
