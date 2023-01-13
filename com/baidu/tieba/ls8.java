package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ls8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ks8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ks8 a() {
        InterceptResult invokeV;
        ks8 ks8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ls8.class) {
                if (a == null) {
                    a = new ks8();
                }
                ks8Var = a;
            }
            return ks8Var;
        }
        return (ks8) invokeV.objValue;
    }
}
