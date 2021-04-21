package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
/* loaded from: classes5.dex */
public class n extends o {
    public n(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f28237d = "feed_video_middle_page";
        if (lVar != null && lVar.X() != null) {
            this.f28234a = new NativeExpressVideoView(context, lVar, adSlot, this.f28237d);
        } else {
            this.f28234a = new NativeExpressView(context, lVar, adSlot, this.f28237d);
        }
        a(this.f28234a, this.f28236c);
        this.f28234a.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                return false;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k, com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f28234a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = this.f28234a;
        if (nativeExpressView == null || !(nativeExpressView instanceof NativeExpressVideoView)) {
            return;
        }
        ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
    }
}
