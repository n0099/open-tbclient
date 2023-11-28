package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sx {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xx a;
    public transient /* synthetic */ FieldHolder $fh;

    public static xx a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new yx();
            }
            return a;
        }
        return (xx) invokeV.objValue;
    }
}
