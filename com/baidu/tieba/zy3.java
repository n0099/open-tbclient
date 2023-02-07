package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yy3 a() {
        InterceptResult invokeV;
        yy3 yy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zy3.class) {
                if (a == null) {
                    a = new yy3();
                }
                yy3Var = a;
            }
            return yy3Var;
        }
        return (yy3) invokeV.objValue;
    }
}
