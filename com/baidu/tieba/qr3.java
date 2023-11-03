package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class qr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pr3 a() {
        InterceptResult invokeV;
        pr3 pr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qr3.class) {
                if (a == null) {
                    a = new pr3();
                }
                pr3Var = a;
            }
            return pr3Var;
        }
        return (pr3) invokeV.objValue;
    }
}
