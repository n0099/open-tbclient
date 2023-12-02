package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mma a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mma a() {
        InterceptResult invokeV;
        mma mmaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nma.class) {
                if (a == null) {
                    a = new mma();
                }
                mmaVar = a;
            }
            return mmaVar;
        }
        return (mma) invokeV.objValue;
    }
}
