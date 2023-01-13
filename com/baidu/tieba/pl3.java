package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ol3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ol3 a() {
        InterceptResult invokeV;
        ol3 ol3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pl3.class) {
                if (a == null) {
                    a = new ol3();
                }
                ol3Var = a;
            }
            return ol3Var;
        }
        return (ol3) invokeV.objValue;
    }
}
