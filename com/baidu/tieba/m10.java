package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m10 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static q10 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new r10();
            }
            return a;
        }
        return (q10) invokeV.objValue;
    }
}
