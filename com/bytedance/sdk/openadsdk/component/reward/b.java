package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.c.a {
    public b(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public int a() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void a(int i, int i2) {
        if (this.f28652b == null) {
            return;
        }
        String str = this.f28658h ? "play_error" : "play_start_error";
        Map<String, Object> a2 = ak.a(this.f28652b, i, i2, u());
        a2.put("play_type", Integer.valueOf(ak.a(this, this.f28657g)));
        if (this.f28658h) {
            a2.put("duration", Long.valueOf(p()));
            a2.put(SapiOptions.s, Integer.valueOf(r()));
            a2.put("buffers_time", Long.valueOf(o()));
        }
        com.bytedance.sdk.openadsdk.c.d.d(this.f28651a.get(), this.f28652b, "fullscreen_interstitial_ad", str, a2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void b() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(ak.a(this, this.f28657g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f28651a.get(), this.f28652b, "fullscreen_interstitial_ad", "feed_over", this.f28653c, 100, C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void c() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(ak.a(this, this.f28657g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f28651a.get(), this.f28652b, "fullscreen_interstitial_ad", "play_pause", p(), r(), C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void d() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(ak.a(this, this.f28657g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f28651a.get(), this.f28652b, "fullscreen_interstitial_ad", "continue_play", this.i, r(), C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void e() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ak.a(this, this.f28657g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f28651a.get(), this.f28652b, "fullscreen_interstitial_ad", "feed_play", B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void f() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ak.a(this, this.f28657g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f28651a.get(), this.f28652b, "fullscreen_interstitial_ad", "feed_play", B);
    }
}
