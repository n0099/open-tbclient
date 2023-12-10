package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vpa a() {
        InterceptResult invokeV;
        vpa vpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wpa.class) {
                if (a == null) {
                    a = new vpa();
                }
                vpaVar = a;
            }
            return vpaVar;
        }
        return (vpa) invokeV.objValue;
    }
}
