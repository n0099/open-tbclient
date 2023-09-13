package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class naa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile maa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized maa a() {
        InterceptResult invokeV;
        maa maaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (naa.class) {
                if (a == null) {
                    a = new maa();
                }
                maaVar = a;
            }
            return maaVar;
        }
        return (maa) invokeV.objValue;
    }
}
