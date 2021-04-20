package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.Map;
/* loaded from: classes5.dex */
public class g extends com.bytedance.sdk.openadsdk.core.video.c.a {
    public g(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public int a() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void a(int i, int i2) {
        if (this.f28337b == null) {
            return;
        }
        String str = this.f28343h ? "play_error" : "play_start_error";
        Map<String, Object> a2 = ak.a(this.f28337b, i, i2, u());
        a2.put("play_type", Integer.valueOf(ak.a(this, this.f28342g)));
        if (this.f28343h) {
            a2.put("duration", Long.valueOf(p()));
            a2.put(SapiOptions.s, Integer.valueOf(r()));
            a2.put("buffers_time", Long.valueOf(o()));
        }
        com.bytedance.sdk.openadsdk.c.d.d(this.f28336a.get(), this.f28337b, "rewarded_video", str, a2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void b() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(ak.a(this, this.f28342g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f28336a.get(), this.f28337b, "rewarded_video", "feed_over", this.f28338c, 100, C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void c() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(ak.a(this, this.f28342g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f28336a.get(), this.f28337b, "rewarded_video", "play_pause", p(), r(), C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void d() {
        Map<String, Object> C = C();
        C.put("play_type", Integer.valueOf(ak.a(this, this.f28342g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f28336a.get(), this.f28337b, "rewarded_video", "continue_play", this.i, r(), C);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void e() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ak.a(this, this.f28342g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f28336a.get(), this.f28337b, "rewarded_video", "feed_play", B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void f() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ak.a(this, this.f28342g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f28336a.get(), this.f28337b, "rewarded_video", "feed_play", B);
    }
}
