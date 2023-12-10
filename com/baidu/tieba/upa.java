package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class upa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tpa a() {
        InterceptResult invokeV;
        tpa tpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (upa.class) {
                if (a == null) {
                    a = new tpa();
                }
                tpaVar = a;
            }
            return tpaVar;
        }
        return (tpa) invokeV.objValue;
    }
}
