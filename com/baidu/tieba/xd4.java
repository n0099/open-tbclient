package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wd4 a() {
        InterceptResult invokeV;
        wd4 wd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xd4.class) {
                if (a == null) {
                    a = new wd4();
                }
                wd4Var = a;
            }
            return wd4Var;
        }
        return (wd4) invokeV.objValue;
    }
}
