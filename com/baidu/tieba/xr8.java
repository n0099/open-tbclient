package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xr8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wr8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wr8 a() {
        InterceptResult invokeV;
        wr8 wr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xr8.class) {
                if (a == null) {
                    a = new wr8();
                }
                wr8Var = a;
            }
            return wr8Var;
        }
        return (wr8) invokeV.objValue;
    }
}
