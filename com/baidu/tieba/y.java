package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) ? (i & i2) > 0 ? i - i2 : i : invokeII.intValue;
    }

    public static final PendingIntent a(Context context, int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 23) {
                return PendingIntent.getBroadcast(context, i, intent, b(i2, 33554432) | 67108864);
            }
            return PendingIntent.getBroadcast(context, i, intent, i2);
        }
        return (PendingIntent) invokeCommon.objValue;
    }
}
