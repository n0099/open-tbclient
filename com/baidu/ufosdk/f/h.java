package com.baidu.ufosdk.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f57616a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - f57616a;
            if (0 >= j || j >= 500) {
                f57616a = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
