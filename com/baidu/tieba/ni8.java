package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ni8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mi8 a() {
        InterceptResult invokeV;
        mi8 mi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ni8.class) {
                if (a == null) {
                    a = new mi8();
                }
                mi8Var = a;
            }
            return mi8Var;
        }
        return (mi8) invokeV.objValue;
    }
}
