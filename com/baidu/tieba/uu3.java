package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tu3 a() {
        InterceptResult invokeV;
        tu3 tu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uu3.class) {
                if (a == null) {
                    a = new tu3();
                }
                tu3Var = a;
            }
            return tu3Var;
        }
        return (tu3) invokeV.objValue;
    }
}
