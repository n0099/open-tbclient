package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jv2 a() {
        InterceptResult invokeV;
        jv2 jv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kv2.class) {
                if (a == null) {
                    a = new jv2();
                }
                jv2Var = a;
            }
            return jv2Var;
        }
        return (jv2) invokeV.objValue;
    }
}
