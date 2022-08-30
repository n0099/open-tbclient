package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wh3 a() {
        InterceptResult invokeV;
        wh3 wh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xh3.class) {
                if (a == null) {
                    a = new wh3();
                }
                wh3Var = a;
            }
            return wh3Var;
        }
        return (wh3) invokeV.objValue;
    }
}
