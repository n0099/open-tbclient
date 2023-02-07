package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kv3 a() {
        InterceptResult invokeV;
        kv3 kv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lv3.class) {
                if (a == null) {
                    a = new kv3();
                }
                kv3Var = a;
            }
            return kv3Var;
        }
        return (kv3) invokeV.objValue;
    }
}
