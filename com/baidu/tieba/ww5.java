package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ww5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vw5 a() {
        InterceptResult invokeV;
        vw5 vw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ww5.class) {
                if (a == null) {
                    a = new vw5();
                }
                vw5Var = a;
            }
            return vw5Var;
        }
        return (vw5) invokeV.objValue;
    }
}
