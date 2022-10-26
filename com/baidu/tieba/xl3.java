package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wl3 a() {
        InterceptResult invokeV;
        wl3 wl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xl3.class) {
                if (a == null) {
                    a = new wl3();
                }
                wl3Var = a;
            }
            return wl3Var;
        }
        return (wl3) invokeV.objValue;
    }
}
