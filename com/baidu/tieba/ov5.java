package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ov5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nv5 a() {
        InterceptResult invokeV;
        nv5 nv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ov5.class) {
                if (a == null) {
                    a = new nv5();
                }
                nv5Var = a;
            }
            return nv5Var;
        }
        return (nv5) invokeV.objValue;
    }
}
