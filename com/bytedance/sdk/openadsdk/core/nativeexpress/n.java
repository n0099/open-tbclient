package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes4.dex */
public class n extends k {
    public n(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f6945a = new NativeExpressVideoView(context, lVar, adSlot, "embeded_ad");
        a(this.f6945a, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        if (this.f6945a != null) {
            this.f6945a.setVideoAdListener(expressVideoAdListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        if (this.f6945a != null) {
            return ((NativeExpressVideoView) this.f6945a).getVideoModel();
        }
        return null;
    }
}
