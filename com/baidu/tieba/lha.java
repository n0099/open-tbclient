package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lha {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kha a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kha a() {
        InterceptResult invokeV;
        kha khaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lha.class) {
                if (a == null) {
                    a = new kha();
                }
                khaVar = a;
            }
            return khaVar;
        }
        return (kha) invokeV.objValue;
    }
}
