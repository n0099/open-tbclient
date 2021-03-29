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
        this.f28544d = "feed_video_middle_page";
        if (lVar != null && lVar.X() != null) {
            this.f28541a = new NativeExpressVideoView(context, lVar, adSlot, this.f28544d);
        } else {
            this.f28541a = new NativeExpressView(context, lVar, adSlot, this.f28544d);
        }
        a(this.f28541a, this.f28543c);
        this.f28541a.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                return false;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k, com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f28541a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = this.f28541a;
        if (nativeExpressView == null || !(nativeExpressView instanceof NativeExpressVideoView)) {
            return;
        }
        ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
    }
}
