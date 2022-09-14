package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p89 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o89 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o89 a() {
        InterceptResult invokeV;
        o89 o89Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p89.class) {
                if (a == null) {
                    a = new o89();
                }
                o89Var = a;
            }
            return o89Var;
        }
        return (o89) invokeV.objValue;
    }
}
