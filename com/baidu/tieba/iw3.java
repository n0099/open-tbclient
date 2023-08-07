package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hw3 a() {
        InterceptResult invokeV;
        hw3 hw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iw3.class) {
                if (a == null) {
                    a = new hw3();
                }
                hw3Var = a;
            }
            return hw3Var;
        }
        return (hw3) invokeV.objValue;
    }
}
