package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vr5 a() {
        InterceptResult invokeV;
        vr5 vr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wr5.class) {
                if (a == null) {
                    a = new vr5();
                }
                vr5Var = a;
            }
            return vr5Var;
        }
        return (vr5) invokeV.objValue;
    }
}
