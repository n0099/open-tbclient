package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wv2 a() {
        InterceptResult invokeV;
        wv2 wv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xv2.class) {
                if (a == null) {
                    a = new wv2();
                }
                wv2Var = a;
            }
            return wv2Var;
        }
        return (wv2) invokeV.objValue;
    }
}
