package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile um2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized um2 a() {
        InterceptResult invokeV;
        um2 um2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vm2.class) {
                if (a == null) {
                    a = new um2();
                }
                um2Var = a;
            }
            return um2Var;
        }
        return (um2) invokeV.objValue;
    }
}
