package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xu3 a() {
        InterceptResult invokeV;
        xu3 xu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yu3.class) {
                if (a == null) {
                    a = new xu3();
                }
                xu3Var = a;
            }
            return xu3Var;
        }
        return (xu3) invokeV.objValue;
    }
}
