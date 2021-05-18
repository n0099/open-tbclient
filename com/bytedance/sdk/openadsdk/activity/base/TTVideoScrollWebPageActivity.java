package com.bytedance.sdk.openadsdk.activity.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.TTScrollView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {

    /* renamed from: h  reason: collision with root package name */
    public TTScrollView f27235h;

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(ad.e(getApplicationContext(), "tt_scroll_view"));
        this.f27235h = tTScrollView;
        tTScrollView.setListener(new TTScrollView.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.TTScrollView.a
            public void a(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.f27244g != null && (TTVideoScrollWebPageActivity.this.f27244g instanceof f)) {
                        if (z && !TTVideoScrollWebPageActivity.this.f27244g.w()) {
                            ((f) TTVideoScrollWebPageActivity.this.f27244g).g(false);
                        } else {
                            TTVideoScrollWebPageActivity.this.f27244g.h();
                        }
                    }
                } catch (Throwable th) {
                    u.c("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        c cVar = this.f27244g;
        if (cVar != null) {
            cVar.e(false);
        }
        NativeVideoTsView nativeVideoTsView = this.f27243f;
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
                    if (TTVideoScrollWebPageActivity.this.f27235h == null || TTVideoScrollWebPageActivity.this.f27235h.a()) {
                        return;
                    }
                    u.b("TTVideoScrollWebPageActivity", "video start play but video is hidden so pause");
                    c cVar2 = TTVideoScrollWebPageActivity.this.f27244g;
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
    public void setContentView(int i2) {
        super.setContentView(ad.f(getApplicationContext(), "tt_activity_video_scroll_landingpage"));
    }
}
