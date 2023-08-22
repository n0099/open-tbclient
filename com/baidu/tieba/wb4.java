package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vb4 a() {
        InterceptResult invokeV;
        vb4 vb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wb4.class) {
                if (a == null) {
                    a = new vb4();
                }
                vb4Var = a;
            }
            return vb4Var;
        }
        return (vb4) invokeV.objValue;
    }
}
