package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jaa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iaa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iaa a() {
        InterceptResult invokeV;
        iaa iaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jaa.class) {
                if (a == null) {
                    a = new iaa();
                }
                iaaVar = a;
            }
            return iaaVar;
        }
        return (iaa) invokeV.objValue;
    }
}
