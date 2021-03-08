package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.c.a {
    public b(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected int a() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void a(int i, int i2) {
        if (this.b != null) {
            String str = this.h ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.b, i, i2, u());
            a2.put("play_type", Integer.valueOf(aj.a(this, this.g)));
            if (this.h) {
                a2.put("duration", Long.valueOf(p()));
                a2.put("percent", Integer.valueOf(r()));
                a2.put("buffers_time", Long.valueOf(o()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.f4526a.get(), this.b, "fullscreen_interstitial_ad", str, a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void b() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f4526a.get(), this.b, "fullscreen_interstitial_ad", "feed_over", this.c, 100, C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void c() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f4526a.get(), this.b, "fullscreen_interstitial_ad", "play_pause", p(), r(), C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void d() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f4526a.get(), this.b, "fullscreen_interstitial_ad", "continue_play", this.i, r(), C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void e() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f4526a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void f() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f4526a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", B);
    }
}
