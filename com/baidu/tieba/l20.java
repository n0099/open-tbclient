package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static p20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new q20();
            }
            return a;
        }
        return (p20) invokeV.objValue;
    }
}
