package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ocb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ncb a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ncb a() {
        InterceptResult invokeV;
        ncb ncbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ocb.class) {
                if (a == null) {
                    a = new ncb();
                }
                ncbVar = a;
            }
            return ncbVar;
        }
        return (ncb) invokeV.objValue;
    }
}
