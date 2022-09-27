package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vl3 a() {
        InterceptResult invokeV;
        vl3 vl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wl3.class) {
                if (a == null) {
                    a = new vl3();
                }
                vl3Var = a;
            }
            return vl3Var;
        }
        return (vl3) invokeV.objValue;
    }
}
