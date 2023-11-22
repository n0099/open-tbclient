package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oha {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nha a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nha a() {
        InterceptResult invokeV;
        nha nhaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oha.class) {
                if (a == null) {
                    a = new nha();
                }
                nhaVar = a;
            }
            return nhaVar;
        }
        return (nha) invokeV.objValue;
    }
}
