package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile il a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized il a() {
        InterceptResult invokeV;
        il ilVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jl.class) {
                if (a == null) {
                    a = new il();
                }
                ilVar = a;
            }
            return ilVar;
        }
        return (il) invokeV.objValue;
    }
}
