package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o94 a() {
        InterceptResult invokeV;
        o94 o94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p94.class) {
                if (a == null) {
                    a = new o94();
                }
                o94Var = a;
            }
            return o94Var;
        }
        return (o94) invokeV.objValue;
    }
}
