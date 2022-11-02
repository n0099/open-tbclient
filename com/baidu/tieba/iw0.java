package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class iw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hw0 a() {
        InterceptResult invokeV;
        hw0 hw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iw0.class) {
                if (a == null) {
                    a = new hw0();
                }
                hw0Var = a;
            }
            return hw0Var;
        }
        return (hw0) invokeV.objValue;
    }
}
