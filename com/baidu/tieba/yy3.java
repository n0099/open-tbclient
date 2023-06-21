package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xy3 a() {
        InterceptResult invokeV;
        xy3 xy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yy3.class) {
                if (a == null) {
                    a = new xy3();
                }
                xy3Var = a;
            }
            return xy3Var;
        }
        return (xy3) invokeV.objValue;
    }
}
