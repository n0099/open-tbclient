package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ww3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ww3 a() {
        InterceptResult invokeV;
        ww3 ww3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xw3.class) {
                if (a == null) {
                    a = new ww3();
                }
                ww3Var = a;
            }
            return ww3Var;
        }
        return (ww3) invokeV.objValue;
    }
}
