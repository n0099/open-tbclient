package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lkb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kkb a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kkb a() {
        InterceptResult invokeV;
        kkb kkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lkb.class) {
                if (a == null) {
                    a = new kkb();
                }
                kkbVar = a;
            }
            return kkbVar;
        }
        return (kkb) invokeV.objValue;
    }
}
