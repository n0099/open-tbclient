package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class voa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uoa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uoa a() {
        InterceptResult invokeV;
        uoa uoaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (voa.class) {
                if (a == null) {
                    a = new uoa();
                }
                uoaVar = a;
            }
            return uoaVar;
        }
        return (uoa) invokeV.objValue;
    }
}
