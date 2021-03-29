package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.c.a;
/* loaded from: classes6.dex */
public class TTC4Proxy {
    public static void load(Context context, AdSlot adSlot, TTAdNative.InteractionAdListener interactionAdListener) {
        adSlot.setDurationSlotType(2);
        a.a().a(context, adSlot, interactionAdListener);
    }
}
