package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class waa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vaa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vaa a() {
        InterceptResult invokeV;
        vaa vaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (waa.class) {
                if (a == null) {
                    a = new vaa();
                }
                vaaVar = a;
            }
            return vaaVar;
        }
        return (vaa) invokeV.objValue;
    }
}
