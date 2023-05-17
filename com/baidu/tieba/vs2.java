package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vs2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile us2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized us2 a() {
        InterceptResult invokeV;
        us2 us2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vs2.class) {
                if (a == null) {
                    a = new us2();
                }
                us2Var = a;
            }
            return us2Var;
        }
        return (us2) invokeV.objValue;
    }
}
