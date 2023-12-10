package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class npa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mpa a() {
        InterceptResult invokeV;
        mpa mpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (npa.class) {
                if (a == null) {
                    a = new mpa();
                }
                mpaVar = a;
            }
            return mpaVar;
        }
        return (mpa) invokeV.objValue;
    }
}
