package com.baidu.ufosdk.f;

import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return Build.VERSION.class.getField("SDK_INT").getInt(null);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
                return Integer.parseInt(Build.VERSION.SDK);
            }
        }
        return invokeV.intValue;
    }
}
