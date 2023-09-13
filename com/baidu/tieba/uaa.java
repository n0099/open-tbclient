package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uaa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile taa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized taa a() {
        InterceptResult invokeV;
        taa taaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uaa.class) {
                if (a == null) {
                    a = new taa();
                }
                taaVar = a;
            }
            return taaVar;
        }
        return (taa) invokeV.objValue;
    }
}
