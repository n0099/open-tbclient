package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ut0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ut0 a() {
        InterceptResult invokeV;
        ut0 ut0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vt0.class) {
                if (a == null) {
                    a = new ut0();
                }
                ut0Var = a;
            }
            return ut0Var;
        }
        return (ut0) invokeV.objValue;
    }
}
