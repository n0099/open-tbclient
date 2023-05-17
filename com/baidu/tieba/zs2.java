package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zs2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ys2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ys2 a() {
        InterceptResult invokeV;
        ys2 ys2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zs2.class) {
                if (a == null) {
                    a = new ys2();
                }
                ys2Var = a;
            }
            return ys2Var;
        }
        return (ys2) invokeV.objValue;
    }
}
