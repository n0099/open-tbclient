package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wpa a() {
        InterceptResult invokeV;
        wpa wpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xpa.class) {
                if (a == null) {
                    a = new wpa();
                }
                wpaVar = a;
            }
            return wpaVar;
        }
        return (wpa) invokeV.objValue;
    }
}
