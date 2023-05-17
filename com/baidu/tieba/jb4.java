package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ib4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ib4 a() {
        InterceptResult invokeV;
        ib4 ib4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jb4.class) {
                if (a == null) {
                    a = new ib4();
                }
                ib4Var = a;
            }
            return ib4Var;
        }
        return (ib4) invokeV.objValue;
    }
}
