package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wf9 a() {
        InterceptResult invokeV;
        wf9 wf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xf9.class) {
                if (a == null) {
                    a = new wf9();
                }
                wf9Var = a;
            }
            return wf9Var;
        }
        return (wf9) invokeV.objValue;
    }
}
