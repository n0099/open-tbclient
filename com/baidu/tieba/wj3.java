package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vj3 a() {
        InterceptResult invokeV;
        vj3 vj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wj3.class) {
                if (a == null) {
                    a = new vj3();
                }
                vj3Var = a;
            }
            return vj3Var;
        }
        return (vj3) invokeV.objValue;
    }
}
