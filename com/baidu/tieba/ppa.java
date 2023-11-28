package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ppa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile opa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized opa a() {
        InterceptResult invokeV;
        opa opaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ppa.class) {
                if (a == null) {
                    a = new opa();
                }
                opaVar = a;
            }
            return opaVar;
        }
        return (opa) invokeV.objValue;
    }
}
