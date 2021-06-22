package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes6.dex */
public class c extends b {
    public c(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.b
    public void a(Context context, l lVar, AdSlot adSlot) {
        BannerExpressVideoView bannerExpressVideoView = new BannerExpressVideoView(context, lVar, adSlot);
        this.f27958a = bannerExpressVideoView;
        a(bannerExpressVideoView.getCurView(), this.f27960c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        a aVar = this.f27958a;
        if (aVar != null) {
            return ((BannerExpressVideoView) aVar).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        a aVar = this.f27958a;
        if (aVar != null) {
            aVar.setVideoAdListener(expressVideoAdListener);
        }
    }
}
