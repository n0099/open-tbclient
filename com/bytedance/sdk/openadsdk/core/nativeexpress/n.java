package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
/* loaded from: classes6.dex */
public class n extends o {
    public n(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f28380d = "feed_video_middle_page";
        if (lVar != null && lVar.X() != null) {
            this.f28377a = new NativeExpressVideoView(context, lVar, adSlot, this.f28380d);
        } else {
            this.f28377a = new NativeExpressView(context, lVar, adSlot, this.f28380d);
        }
        a(this.f28377a, this.f28379c);
        this.f28377a.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i2) {
                return false;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k, com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f28377a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = this.f28377a;
        if (nativeExpressView == null || !(nativeExpressView instanceof NativeExpressVideoView)) {
            return;
        }
        ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
    }
}
