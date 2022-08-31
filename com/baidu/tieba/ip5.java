package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ip5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hp5 a() {
        InterceptResult invokeV;
        hp5 hp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ip5.class) {
                if (a == null) {
                    a = new hp5();
                }
                hp5Var = a;
            }
            return hp5Var;
        }
        return (hp5) invokeV.objValue;
    }
}
