package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class qw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pw3 a() {
        InterceptResult invokeV;
        pw3 pw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qw3.class) {
                if (a == null) {
                    a = new pw3();
                }
                pw3Var = a;
            }
            return pw3Var;
        }
        return (pw3) invokeV.objValue;
    }
}
