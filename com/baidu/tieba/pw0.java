package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ow0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ow0 a() {
        InterceptResult invokeV;
        ow0 ow0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pw0.class) {
                if (a == null) {
                    a = new ow0();
                }
                ow0Var = a;
            }
            return ow0Var;
        }
        return (ow0) invokeV.objValue;
    }
}
