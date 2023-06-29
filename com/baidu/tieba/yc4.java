package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xc4 a() {
        InterceptResult invokeV;
        xc4 xc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yc4.class) {
                if (a == null) {
                    a = new xc4();
                }
                xc4Var = a;
            }
            return xc4Var;
        }
        return (xc4) invokeV.objValue;
    }
}
