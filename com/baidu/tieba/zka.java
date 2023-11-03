package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yka a() {
        InterceptResult invokeV;
        yka ykaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zka.class) {
                if (a == null) {
                    a = new yka();
                }
                ykaVar = a;
            }
            return ykaVar;
        }
        return (yka) invokeV.objValue;
    }
}
