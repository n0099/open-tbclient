package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class kkb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jkb a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jkb a() {
        InterceptResult invokeV;
        jkb jkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kkb.class) {
                if (a == null) {
                    a = new jkb();
                }
                jkbVar = a;
            }
            return jkbVar;
        }
        return (jkb) invokeV.objValue;
    }
}
