package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l10 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static p10 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new q10();
            }
            return a;
        }
        return (p10) invokeV.objValue;
    }
}
