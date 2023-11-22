package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kka a() {
        InterceptResult invokeV;
        kka kkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lka.class) {
                if (a == null) {
                    a = new kka();
                }
                kkaVar = a;
            }
            return kkaVar;
        }
        return (kka) invokeV.objValue;
    }
}
