package com.bytedance.sdk.openadsdk.activity.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.TTScrollView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {

    /* renamed from: h  reason: collision with root package name */
    public TTScrollView f27160h;

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(ad.e(getApplicationContext(), "tt_scroll_view"));
        this.f27160h = tTScrollView;
        tTScrollView.setListener(new TTScrollView.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.TTScrollView.a
            public void a(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.f27169g != null && (TTVideoScrollWebPageActivity.this.f27169g instanceof f)) {
                        if (z && !TTVideoScrollWebPageActivity.this.f27169g.w()) {
                            ((f) TTVideoScrollWebPageActivity.this.f27169g).g(false);
                        } else {
                            TTVideoScrollWebPageActivity.this.f27169g.h();
                        }
                    }
                } catch (Throwable th) {
                    u.c("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        c cVar = this.f27169g;
        if (cVar != null) {
            cVar.e(false);
        }
        NativeVideoTsView nativeVideoTsView = this.f27168f;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setVideoAdInteractionListener(new c.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void a(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void d() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void d_() {
                    if (TTVideoScrollWebPageActivity.this.f27160h == null || TTVideoScrollWebPageActivity.this.f27160h.a()) {
                        return;
                    }
                    u.b("TTVideoScrollWebPageActivity", "video start play but video is hidden so pause");
                    c cVar2 = TTVideoScrollWebPageActivity.this.f27169g;
                    if (cVar2 != null) {
                        cVar2.i();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                public void e_() {
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(ad.f(getApplicationContext(), "tt_activity_video_scroll_landingpage"));
    }
}
