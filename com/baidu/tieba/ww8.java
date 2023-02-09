package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ww8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vw8 a() {
        InterceptResult invokeV;
        vw8 vw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ww8.class) {
                if (a == null) {
                    a = new vw8();
                }
                vw8Var = a;
            }
            return vw8Var;
        }
        return (vw8) invokeV.objValue;
    }
}
