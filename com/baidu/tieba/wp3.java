package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vp3 a() {
        InterceptResult invokeV;
        vp3 vp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wp3.class) {
                if (a == null) {
                    a = new vp3();
                }
                vp3Var = a;
            }
            return vp3Var;
        }
        return (vp3) invokeV.objValue;
    }
}
