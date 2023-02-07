package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ls2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ks2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ks2 a() {
        InterceptResult invokeV;
        ks2 ks2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ls2.class) {
                if (a == null) {
                    a = new ks2();
                }
                ks2Var = a;
            }
            return ks2Var;
        }
        return (ks2) invokeV.objValue;
    }
}
