package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ug8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ug8 a() {
        InterceptResult invokeV;
        ug8 ug8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vg8.class) {
                if (a == null) {
                    a = new ug8();
                }
                ug8Var = a;
            }
            return ug8Var;
        }
        return (ug8) invokeV.objValue;
    }
}
