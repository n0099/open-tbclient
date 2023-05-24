package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ufa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tfa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tfa a() {
        InterceptResult invokeV;
        tfa tfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ufa.class) {
                if (a == null) {
                    a = new tfa();
                }
                tfaVar = a;
            }
            return tfaVar;
        }
        return (tfa) invokeV.objValue;
    }
}
