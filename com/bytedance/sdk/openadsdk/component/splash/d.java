package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.Map;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.core.video.c.a {
    public boolean j;

    public d(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
        this.j = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public int a() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void a(int i2, int i3) {
        if (this.f28573b == null || i2 == 308) {
            return;
        }
        String str = this.f28579h ? "play_error" : "play_start_error";
        Map<String, Object> a2 = ak.a(this.f28573b, i2, i3, u());
        if (this.f28579h) {
            a2.put("duration", Long.valueOf(p()));
            a2.put(SapiOptions.KEY_CACHE_PERCENT, Integer.valueOf(r()));
            a2.put("buffers_time", Long.valueOf(o()));
        }
        com.bytedance.sdk.openadsdk.c.d.d(this.f28572a.get(), this.f28573b, "splash_ad", str, a2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void b() {
        if (this.j) {
            return;
        }
        this.j = true;
        com.bytedance.sdk.openadsdk.c.d.a(this.f28572a.get(), this.f28573b, "splash_ad", "feed_over", this.f28574c, 100, C());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void e() {
        com.bytedance.sdk.openadsdk.c.d.c(this.f28572a.get(), this.f28573b, "splash_ad", "feed_play", B());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void f() {
        com.bytedance.sdk.openadsdk.c.d.c(this.f28572a.get(), this.f28573b, "splash_ad", "feed_play", B());
    }
}
