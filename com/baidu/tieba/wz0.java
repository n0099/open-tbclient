package com.baidu.tieba;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class wz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            AudioManager a = e01.a(context);
            if (a != null) {
                z = a.isWiredHeadsetOn();
            } else {
                z = false;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.getProfileConnectionState(1) == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            b01.b("BdHeadsetUtils", "当前耳机连接状态>>> 有线耳机=" + z + ", 蓝牙=" + z2);
            if (!z && !z2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
