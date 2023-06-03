package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w86 a() {
        InterceptResult invokeV;
        w86 w86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x86.class) {
                if (a == null) {
                    a = new w86();
                }
                w86Var = a;
            }
            return w86Var;
        }
        return (w86) invokeV.objValue;
    }
}
