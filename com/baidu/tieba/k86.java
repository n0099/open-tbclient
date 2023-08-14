package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j86 a() {
        InterceptResult invokeV;
        j86 j86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k86.class) {
                if (a == null) {
                    a = new j86();
                }
                j86Var = a;
            }
            return j86Var;
        }
        return (j86) invokeV.objValue;
    }
}
