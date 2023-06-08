package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vr9 a() {
        InterceptResult invokeV;
        vr9 vr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wr9.class) {
                if (a == null) {
                    a = new vr9();
                }
                vr9Var = a;
            }
            return vr9Var;
        }
        return (vr9) invokeV.objValue;
    }
}
