package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vo3 a() {
        InterceptResult invokeV;
        vo3 vo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wo3.class) {
                if (a == null) {
                    a = new vo3();
                }
                vo3Var = a;
            }
            return vo3Var;
        }
        return (vo3) invokeV.objValue;
    }
}
