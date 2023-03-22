package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class or2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nr2 a() {
        InterceptResult invokeV;
        nr2 nr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (or2.class) {
                if (a == null) {
                    a = new nr2();
                }
                nr2Var = a;
            }
            return nr2Var;
        }
        return (nr2) invokeV.objValue;
    }
}
