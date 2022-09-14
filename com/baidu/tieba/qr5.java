package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pr5 a() {
        InterceptResult invokeV;
        pr5 pr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qr5.class) {
                if (a == null) {
                    a = new pr5();
                }
                pr5Var = a;
            }
            return pr5Var;
        }
        return (pr5) invokeV.objValue;
    }
}
