package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.c;
import com.bytedance.sdk.openadsdk.component.reward.d;
import com.bytedance.sdk.openadsdk.component.reward.e;
import com.bytedance.sdk.openadsdk.component.reward.h;
/* loaded from: classes5.dex */
public class TTC3Proxy {
    public static void a(Context context) {
        try {
            h.a(context).b();
        } catch (Throwable unused) {
        }
        try {
            c.a(context).a();
        } catch (Throwable unused2) {
        }
    }

    public static void loadFull(Context context, AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        adSlot.setDurationSlotType(8);
        c.a(context).a(adSlot, new e(fullScreenVideoAdListener));
    }

    public static void loadReward(Context context, AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        adSlot.setDurationSlotType(7);
        h.a(context).a(adSlot, new e(rewardVideoAdListener));
    }

    public static void verityPlayable(String str, int i2, String str2, String str3, String str4) {
        d.a(str, i2, str2, str3, str4);
    }
}
