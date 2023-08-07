package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xf1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wf1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wf1 a() {
        InterceptResult invokeV;
        wf1 wf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xf1.class) {
                if (a == null) {
                    a = new wf1();
                }
                wf1Var = a;
            }
            return wf1Var;
        }
        return (wf1) invokeV.objValue;
    }
}
