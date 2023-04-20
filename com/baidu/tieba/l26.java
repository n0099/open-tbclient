package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k26 a() {
        InterceptResult invokeV;
        k26 k26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l26.class) {
                if (a == null) {
                    a = new k26();
                }
                k26Var = a;
            }
            return k26Var;
        }
        return (k26) invokeV.objValue;
    }
}
