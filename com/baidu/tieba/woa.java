package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class woa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile voa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized voa a() {
        InterceptResult invokeV;
        voa voaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (woa.class) {
                if (a == null) {
                    a = new voa();
                }
                voaVar = a;
            }
            return voaVar;
        }
        return (voa) invokeV.objValue;
    }
}
