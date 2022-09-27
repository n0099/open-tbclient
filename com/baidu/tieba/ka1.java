package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ka1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ja1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ja1 a() {
        InterceptResult invokeV;
        ja1 ja1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ka1.class) {
                if (a == null) {
                    a = new ja1();
                }
                ja1Var = a;
            }
            return ja1Var;
        }
        return (ja1) invokeV.objValue;
    }
}
