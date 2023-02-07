package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static v20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new w20();
            }
            return a;
        }
        return (v20) invokeV.objValue;
    }
}
