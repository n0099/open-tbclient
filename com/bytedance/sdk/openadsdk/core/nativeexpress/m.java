package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
/* loaded from: classes5.dex */
public class m extends o {
    public m(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f28237d = "draw_ad";
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, lVar, adSlot, "draw_ad");
        this.f28234a = nativeExpressVideoView;
        a(nativeExpressVideoView, this.f28236c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = this.f28234a;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
        }
    }
}
