package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ipa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ipa a() {
        InterceptResult invokeV;
        ipa ipaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jpa.class) {
                if (a == null) {
                    a = new ipa();
                }
                ipaVar = a;
            }
            return ipaVar;
        }
        return (ipa) invokeV.objValue;
    }
}
