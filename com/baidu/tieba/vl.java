package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ul a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ul a() {
        InterceptResult invokeV;
        ul ulVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vl.class) {
                if (a == null) {
                    a = new ul();
                }
                ulVar = a;
            }
            return ulVar;
        }
        return (ul) invokeV.objValue;
    }
}
