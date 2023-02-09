package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qx8 a() {
        InterceptResult invokeV;
        qx8 qx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rx8.class) {
                if (a == null) {
                    a = new qx8();
                }
                qx8Var = a;
            }
            return qx8Var;
        }
        return (qx8) invokeV.objValue;
    }
}
