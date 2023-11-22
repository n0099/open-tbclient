package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wja {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vja a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vja a() {
        InterceptResult invokeV;
        vja vjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wja.class) {
                if (a == null) {
                    a = new vja();
                }
                vjaVar = a;
            }
            return vjaVar;
        }
        return (vja) invokeV.objValue;
    }
}
