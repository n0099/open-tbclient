package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Map;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.core.video.c.a {
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
        this.j = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected int a() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void a(int i, int i2) {
        if (this.b != null && i != 308) {
            String str = this.h ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.b, i, i2, u());
            if (this.h) {
                a2.put("duration", Long.valueOf(p()));
                a2.put("percent", Integer.valueOf(r()));
                a2.put("buffers_time", Long.valueOf(o()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.f4526a.get(), this.b, "splash_ad", str, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    public void b() {
        if (!this.j) {
            this.j = true;
            com.bytedance.sdk.openadsdk.c.d.a(this.f4526a.get(), this.b, "splash_ad", "feed_over", this.c, 100, C());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void e() {
        com.bytedance.sdk.openadsdk.c.d.c(this.f4526a.get(), this.b, "splash_ad", "feed_play", B());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void f() {
        com.bytedance.sdk.openadsdk.c.d.c(this.f4526a.get(), this.b, "splash_ad", "feed_play", B());
    }
}
