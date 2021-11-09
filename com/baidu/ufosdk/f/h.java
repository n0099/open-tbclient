package com.baidu.ufosdk.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f56694a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - f56694a;
            if (0 >= j || j >= 500) {
                f56694a = currentTimeMillis;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
