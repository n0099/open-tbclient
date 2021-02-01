package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Map;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.core.video.b.a {
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
        this.i = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected int a() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void a(int i, int i2) {
        if (this.f6692b != null && i != 308) {
            boolean z = z();
            String str = z ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.f6692b, i, i2, t());
            if (z) {
                a2.put("duration", Long.valueOf(o()));
                a2.put("percent", Integer.valueOf(q()));
                a2.put("buffers_time", Long.valueOf(n()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.f6691a.get(), this.f6692b, "splash_ad", str, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void b() {
        if (!this.i) {
            this.i = true;
            com.bytedance.sdk.openadsdk.c.d.a(this.f6691a.get(), this.f6692b, "splash_ad", "feed_over", this.c, 100, B());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void e() {
        com.bytedance.sdk.openadsdk.c.d.c(this.f6691a.get(), this.f6692b, "splash_ad", "feed_play", A());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    protected void f() {
        com.bytedance.sdk.openadsdk.c.d.c(this.f6691a.get(), this.f6692b, "splash_ad", "feed_play", A());
    }
}
