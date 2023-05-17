package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class v46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u46 a() {
        InterceptResult invokeV;
        u46 u46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v46.class) {
                if (a == null) {
                    a = new u46();
                }
                u46Var = a;
            }
            return u46Var;
        }
        return (u46) invokeV.objValue;
    }
}
