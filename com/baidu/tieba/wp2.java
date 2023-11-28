package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vp2 a() {
        InterceptResult invokeV;
        vp2 vp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wp2.class) {
                if (a == null) {
                    a = new vp2();
                }
                vp2Var = a;
            }
            return vp2Var;
        }
        return (vp2) invokeV.objValue;
    }
}
