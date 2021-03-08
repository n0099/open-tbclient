package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
/* loaded from: classes6.dex */
public class m extends o {
    public m(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.d = "draw_ad";
        this.f4495a = new NativeExpressVideoView(context, lVar, adSlot, "draw_ad");
        a(this.f4495a, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        if (this.f4495a != null) {
            ((NativeExpressVideoView) this.f4495a).setCanInterruptVideoPlay(z);
        }
    }
}
