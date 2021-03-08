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
        this.d = "feed_video_middle_page";
        if (lVar != null && lVar.R() != null) {
            this.f4495a = new NativeExpressVideoView(context, lVar, adSlot, this.d);
        } else {
            this.f4495a = new NativeExpressView(context, lVar, adSlot, this.d);
        }
        a(this.f4495a, this.c);
        this.f4495a.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                return false;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        if (this.f4495a != null && (this.f4495a instanceof NativeExpressVideoView)) {
            ((NativeExpressVideoView) this.f4495a).setCanInterruptVideoPlay(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k, com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f4495a;
    }
}
