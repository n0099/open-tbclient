package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kpa a() {
        InterceptResult invokeV;
        kpa kpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lpa.class) {
                if (a == null) {
                    a = new kpa();
                }
                kpaVar = a;
            }
            return kpaVar;
        }
        return (kpa) invokeV.objValue;
    }
}
