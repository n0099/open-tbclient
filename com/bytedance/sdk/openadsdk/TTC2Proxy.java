package com.bytedance.sdk.openadsdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.splash.b;
import com.bytedance.sdk.openadsdk.component.splash.c;
/* loaded from: classes6.dex */
public class TTC2Proxy {
    public static void a(Context context) {
        c.a(context);
    }

    public static void load(Context context, AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i) {
        adSlot.setDurationSlotType(3);
        b.a(context).a(adSlot, splashAdListener, i);
    }
}
