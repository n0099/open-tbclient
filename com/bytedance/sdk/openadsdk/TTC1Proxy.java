package com.bytedance.sdk.openadsdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.a.b;
/* loaded from: classes5.dex */
public class TTC1Proxy {
    public static void load(Context context, AdSlot adSlot, @NonNull TTAdNative.BannerAdListener bannerAdListener) {
        adSlot.setDurationSlotType(1);
        b.a(context).a(adSlot, bannerAdListener);
    }
}
