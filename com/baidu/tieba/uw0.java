package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tw0 a() {
        InterceptResult invokeV;
        tw0 tw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uw0.class) {
                if (a == null) {
                    a = new tw0();
                }
                tw0Var = a;
            }
            return tw0Var;
        }
        return (tw0) invokeV.objValue;
    }
}
