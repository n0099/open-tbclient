package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rd4 a() {
        InterceptResult invokeV;
        rd4 rd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sd4.class) {
                if (a == null) {
                    a = new rd4();
                }
                rd4Var = a;
            }
            return rd4Var;
        }
        return (rd4) invokeV.objValue;
    }
}
