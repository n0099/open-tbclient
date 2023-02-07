package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ow8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ow8 a() {
        InterceptResult invokeV;
        ow8 ow8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pw8.class) {
                if (a == null) {
                    a = new ow8();
                }
                ow8Var = a;
            }
            return ow8Var;
        }
        return (ow8) invokeV.objValue;
    }
}
