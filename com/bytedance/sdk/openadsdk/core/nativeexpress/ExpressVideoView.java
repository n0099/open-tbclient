package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected int f4474a;
    private boolean p;

    public ExpressVideoView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        super(context, lVar, false, false, str, false, false);
        this.p = false;
        if ("draw_ad".equals(str)) {
            this.p = true;
        }
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        this.e = false;
        int d = aj.d(this.b.aj());
        if ("banner_ad".equalsIgnoreCase(this.k)) {
            p.h().s(String.valueOf(d));
        }
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        if (this.p) {
            super.b(this.f4474a);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.p = z;
    }

    public void setVideoPlayStatus(int i) {
        this.f4474a = i;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.c != null) {
            this.c.f(z);
        }
    }

    public void d() {
        if (this.i != null) {
            ak.a((View) this.i, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.h != null && this.h.getVisibility() == 0) {
            k();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.h != null && this.h.getVisibility() == 0) {
            k();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void j() {
        ak.a((View) this.f, 0);
        ak.a((View) this.g, 0);
        ak.a((View) this.i, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void a(boolean z) {
    }

    private void k() {
        g();
        if (this.f != null) {
            if (this.f.getVisibility() != 0) {
                com.bytedance.sdk.openadsdk.h.d.a(getContext()).a(this.b.R().h(), this.g);
            } else {
                return;
            }
        }
        j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h != null && this.h.getVisibility() == 0) {
            ak.f(this.f);
        }
        b(this.f4474a);
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h v;
        if (this.c != null && (v = this.c.v()) != null) {
            v.d(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        g();
        ak.a((View) this.f, 0);
    }
}
