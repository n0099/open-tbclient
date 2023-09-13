package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class laa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kaa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kaa a() {
        InterceptResult invokeV;
        kaa kaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (laa.class) {
                if (a == null) {
                    a = new kaa();
                }
                kaaVar = a;
            }
            return kaaVar;
        }
        return (kaa) invokeV.objValue;
    }
}
