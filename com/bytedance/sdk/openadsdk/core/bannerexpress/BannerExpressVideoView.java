package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class BannerExpressVideoView extends a {
    public BannerExpressVideoView(@NonNull Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public void a() {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f28053a, this.f28056d, this.f28057e, this.j);
        this.f28054b = nativeExpressVideoView;
        addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        NativeExpressView nativeExpressView = this.f28054b;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        super.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        super.setVideoAdListener(expressVideoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public void a(l lVar, AdSlot adSlot) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f28053a, lVar, adSlot, this.j);
        this.f28055c = nativeExpressVideoView;
        nativeExpressVideoView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                BannerExpressVideoView bannerExpressVideoView = BannerExpressVideoView.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = bannerExpressVideoView.f28058f;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdClicked(bannerExpressVideoView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                BannerExpressVideoView.this.a(f2, f3);
                BannerExpressVideoView.this.f();
            }
        });
        al.a((View) this.f28055c, 8);
        addView(this.f28055c, new ViewGroup.LayoutParams(-1, -1));
    }
}
