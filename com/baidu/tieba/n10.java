package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n10 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static r10 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new s10();
            }
            return a;
        }
        return (r10) invokeV.objValue;
    }
}
