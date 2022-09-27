package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class no3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mo3 a() {
        InterceptResult invokeV;
        mo3 mo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (no3.class) {
                if (a == null) {
                    a = new mo3();
                }
                mo3Var = a;
            }
            return mo3Var;
        }
        return (mo3) invokeV.objValue;
    }
}
