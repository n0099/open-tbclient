package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qpa a() {
        InterceptResult invokeV;
        qpa qpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rpa.class) {
                if (a == null) {
                    a = new qpa();
                }
                qpaVar = a;
            }
            return qpaVar;
        }
        return (qpa) invokeV.objValue;
    }
}
