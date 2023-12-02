package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kma a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kma a() {
        InterceptResult invokeV;
        kma kmaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lma.class) {
                if (a == null) {
                    a = new kma();
                }
                kmaVar = a;
            }
            return kmaVar;
        }
        return (kma) invokeV.objValue;
    }
}
