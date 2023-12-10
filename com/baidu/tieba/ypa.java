package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class ypa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xpa a() {
        InterceptResult invokeV;
        xpa xpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ypa.class) {
                if (a == null) {
                    a = new xpa();
                }
                xpaVar = a;
            }
            return xpaVar;
        }
        return (xpa) invokeV.objValue;
    }
}
