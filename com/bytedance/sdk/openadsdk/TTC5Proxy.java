package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.a.a;
/* loaded from: classes6.dex */
public class TTC5Proxy {
    private TTC5Proxy() {
    }

    public static void loadFeed(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        a.a().a(context, adSlot, feedAdListener);
    }

    public static void loadDraw(Context context, AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        a.a().a(context, adSlot, drawFeedAdListener);
    }
}
