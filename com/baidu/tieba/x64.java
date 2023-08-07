package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w64 a() {
        InterceptResult invokeV;
        w64 w64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x64.class) {
                if (a == null) {
                    a = new w64();
                }
                w64Var = a;
            }
            return w64Var;
        }
        return (w64) invokeV.objValue;
    }
}
