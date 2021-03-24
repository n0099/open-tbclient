package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.b.a;
/* loaded from: classes5.dex */
public class TTC5Proxy {
    public static void loadDraw(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        adSlot.setDurationSlotType(9);
        a.a().a(context, adSlot, drawFeedAdListener);
    }

    public static void loadFeed(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        adSlot.setDurationSlotType(5);
        a.a().a(context, adSlot, feedAdListener);
    }

    public static void loadStream(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        adSlot.setDurationSlotType(6);
        a.a().b(context, adSlot, feedAdListener);
    }
}
