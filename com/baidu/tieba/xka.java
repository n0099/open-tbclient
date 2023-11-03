package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wka a() {
        InterceptResult invokeV;
        wka wkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xka.class) {
                if (a == null) {
                    a = new wka();
                }
                wkaVar = a;
            }
            return wkaVar;
        }
        return (wka) invokeV.objValue;
    }
}
