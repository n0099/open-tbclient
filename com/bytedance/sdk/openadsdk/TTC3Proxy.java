package com.bytedance.sdk.openadsdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.c;
import com.bytedance.sdk.openadsdk.component.reward.d;
import com.bytedance.sdk.openadsdk.component.reward.e;
import com.bytedance.sdk.openadsdk.component.reward.h;
/* loaded from: classes5.dex */
public class TTC3Proxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TTC3Proxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            try {
                h.a(context).b();
            } catch (Throwable unused) {
            }
            try {
                c.a(context).a();
            } catch (Throwable unused2) {
            }
        }
    }

    public static void loadFull(Context context, AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, adSlot, fullScreenVideoAdListener) == null) {
            adSlot.setDurationSlotType(8);
            c.a(context).a(adSlot, new e(fullScreenVideoAdListener));
        }
    }

    public static void loadReward(Context context, AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, adSlot, rewardVideoAdListener) == null) {
            adSlot.setDurationSlotType(7);
            h.a(context).a(adSlot, new e(rewardVideoAdListener));
        }
    }

    public static void verityPlayable(String str, int i2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), str2, str3, str4}) == null) {
            d.a(str, i2, str2, str3, str4);
        }
    }
}
