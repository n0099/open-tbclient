package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wg8 a() {
        InterceptResult invokeV;
        wg8 wg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xg8.class) {
                if (a == null) {
                    a = new wg8();
                }
                wg8Var = a;
            }
            return wg8Var;
        }
        return (wg8) invokeV.objValue;
    }
}
