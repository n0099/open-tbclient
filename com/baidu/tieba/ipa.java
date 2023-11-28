package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ipa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hpa a() {
        InterceptResult invokeV;
        hpa hpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ipa.class) {
                if (a == null) {
                    a = new hpa();
                }
                hpaVar = a;
            }
            return hpaVar;
        }
        return (hpa) invokeV.objValue;
    }
}
