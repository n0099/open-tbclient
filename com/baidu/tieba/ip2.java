package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ip2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hp2 a() {
        InterceptResult invokeV;
        hp2 hp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ip2.class) {
                if (a == null) {
                    a = new hp2();
                }
                hp2Var = a;
            }
            return hp2Var;
        }
        return (hp2) invokeV.objValue;
    }
}
