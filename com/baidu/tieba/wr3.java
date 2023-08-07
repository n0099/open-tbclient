package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vr3 a() {
        InterceptResult invokeV;
        vr3 vr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wr3.class) {
                if (a == null) {
                    a = new vr3();
                }
                vr3Var = a;
            }
            return vr3Var;
        }
        return (vr3) invokeV.objValue;
    }
}
