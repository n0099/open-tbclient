package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ow3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ow3 a() {
        InterceptResult invokeV;
        ow3 ow3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pw3.class) {
                if (a == null) {
                    a = new ow3();
                }
                ow3Var = a;
            }
            return ow3Var;
        }
        return (ow3) invokeV.objValue;
    }
}
