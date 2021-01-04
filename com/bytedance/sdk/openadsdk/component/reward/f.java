package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Map;
/* loaded from: classes4.dex */
public class f extends com.bytedance.sdk.openadsdk.core.video.b.a {
    public f(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected int a() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void a(int i, int i2) {
        if (this.f6989b != null) {
            boolean z = z();
            String str = z ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.f6989b, i, i2, t());
            a2.put("play_type", Integer.valueOf(aj.a(this, this.g)));
            if (z) {
                a2.put("duration", Long.valueOf(o()));
                a2.put("percent", Integer.valueOf(q()));
                a2.put("buffers_time", Long.valueOf(n()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.f6988a.get(), this.f6989b, "rewarded_video", str, a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void b() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6988a.get(), this.f6989b, "rewarded_video", "feed_over", this.c, 100, B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void c() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6988a.get(), this.f6989b, "rewarded_video", "play_pause", o(), q(), B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void d() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.f6988a.get(), this.f6989b, "rewarded_video", "continue_play", this.h, q(), B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void e() {
        Map<String, Object> A = A();
        A.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f6988a.get(), this.f6989b, "rewarded_video", "feed_play", A);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void f() {
        Map<String, Object> A = A();
        A.put("play_type", Integer.valueOf(aj.a(this, this.g)));
        com.bytedance.sdk.openadsdk.c.d.c(this.f6988a.get(), this.f6989b, "rewarded_video", "feed_play", A);
    }
}
