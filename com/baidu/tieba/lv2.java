package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kv2 a() {
        InterceptResult invokeV;
        kv2 kv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lv2.class) {
                if (a == null) {
                    a = new kv2();
                }
                kv2Var = a;
            }
            return kv2Var;
        }
        return (kv2) invokeV.objValue;
    }
}
