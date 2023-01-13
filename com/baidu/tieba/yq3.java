package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xq3 a() {
        InterceptResult invokeV;
        xq3 xq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yq3.class) {
                if (a == null) {
                    a = new xq3();
                }
                xq3Var = a;
            }
            return xq3Var;
        }
        return (xq3) invokeV.objValue;
    }
}
