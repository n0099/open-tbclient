package com.bytedance.sdk.openadsdk.core.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
/* loaded from: classes6.dex */
public class c extends b {
    public c(Context context, l lVar, AdSlot adSlot) {
        super(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.c.b
    protected void a(@NonNull Context context, l lVar, AdSlot adSlot, String str) {
        this.f4378a = new NativeExpressVideoView(context, lVar, adSlot, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        if (this.f4378a != null) {
            this.f4378a.setVideoAdListener(expressVideoAdListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        if (this.f4378a != null) {
            return ((NativeExpressVideoView) this.f4378a).getVideoModel();
        }
        return null;
    }
}
