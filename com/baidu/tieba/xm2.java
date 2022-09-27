package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wm2 a() {
        InterceptResult invokeV;
        wm2 wm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xm2.class) {
                if (a == null) {
                    a = new wm2();
                }
                wm2Var = a;
            }
            return wm2Var;
        }
        return (wm2) invokeV.objValue;
    }
}
