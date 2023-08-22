package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v86 a() {
        InterceptResult invokeV;
        v86 v86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w86.class) {
                if (a == null) {
                    a = new v86();
                }
                v86Var = a;
            }
            return v86Var;
        }
        return (v86) invokeV.objValue;
    }
}
