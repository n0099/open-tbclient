package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vka a() {
        InterceptResult invokeV;
        vka vkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wka.class) {
                if (a == null) {
                    a = new vka();
                }
                vkaVar = a;
            }
            return vkaVar;
        }
        return (vka) invokeV.objValue;
    }
}
