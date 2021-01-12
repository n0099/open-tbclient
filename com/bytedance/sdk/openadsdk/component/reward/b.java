package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.b.a {
    public b(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected int a() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void a(int i, int i2) {
        if (this.f6690b != null) {
            boolean z = z();
            String str = z ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.f6690b, i, i2, t());
            a2.put("play_type", Integer.valueOf(aj.a(this, this.g)));
            if (z) {
                a2.put("duration", Long.valueOf(o()));
                a2.put("percent", Integer.valueOf(q()));
                a2.put("buffers_time", Long.valueOf(n()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.f6689a.get(), this.f6690b, "fullscreen_interstitial_ad", str, a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void b() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6689a.get(), this.f6690b, "fullscreen_interstitial_ad", "feed_over", this.c, 100, B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void c() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6689a.get(), this.f6690b, "fullscreen_interstitial_ad", "play_pause", o(), q(), B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void d() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6689a.get(), this.f6690b, "fullscreen_interstitial_ad", "continue_play", this.h, q(), B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void e() {
        Map<String, Object> A = A();
        A.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f6689a.get(), this.f6690b, "fullscreen_interstitial_ad", "feed_play", A);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void f() {
        Map<String, Object> A = A();
        A.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f6689a.get(), this.f6690b, "fullscreen_interstitial_ad", "feed_play", A);
    }
}
