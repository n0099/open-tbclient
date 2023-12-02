package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lpa a() {
        InterceptResult invokeV;
        lpa lpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mpa.class) {
                if (a == null) {
                    a = new lpa();
                }
                lpaVar = a;
            }
            return lpaVar;
        }
        return (lpa) invokeV.objValue;
    }
}
