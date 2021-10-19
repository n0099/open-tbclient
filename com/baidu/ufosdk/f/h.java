package com.baidu.ufosdk.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f59769a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f59769a;
            if (0 >= j2 || j2 >= 500) {
                f59769a = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
