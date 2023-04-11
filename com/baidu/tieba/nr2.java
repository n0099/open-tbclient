package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mr2 a() {
        InterceptResult invokeV;
        mr2 mr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nr2.class) {
                if (a == null) {
                    a = new mr2();
                }
                mr2Var = a;
            }
            return mr2Var;
        }
        return (mr2) invokeV.objValue;
    }
}
