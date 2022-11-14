package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vt5 a() {
        InterceptResult invokeV;
        vt5 vt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wt5.class) {
                if (a == null) {
                    a = new vt5();
                }
                vt5Var = a;
            }
            return vt5Var;
        }
        return (vt5) invokeV.objValue;
    }
}
