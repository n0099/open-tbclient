package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class wt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vt0 a() {
        InterceptResult invokeV;
        vt0 vt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wt0.class) {
                if (a == null) {
                    a = new vt0();
                }
                vt0Var = a;
            }
            return vt0Var;
        }
        return (vt0) invokeV.objValue;
    }
}
