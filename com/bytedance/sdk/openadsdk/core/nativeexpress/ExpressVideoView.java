package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public int f29045a;
    public boolean p;

    public ExpressVideoView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        super(context, lVar, false, false, str, false, false);
        this.p = false;
        if ("draw_ad".equals(str)) {
            this.p = true;
        }
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    private void k() {
        al.a((View) this.f29273f, 0);
        al.a((View) this.f29274g, 0);
        al.a((View) this.f29276i, 8);
    }

    private void l() {
        h();
        RelativeLayout relativeLayout = this.f29273f;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.i.e.c().a(this.f29269b.X().h(), this.f29274g);
        }
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void a(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        this.f29272e = false;
        int d2 = ak.d(this.f29269b.ap());
        if ("banner_ad".equalsIgnoreCase(this.k)) {
            p.h().r(String.valueOf(d2));
        }
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        if (this.p) {
            super.b(this.f29045a);
        }
    }

    public void d() {
        ImageView imageView = this.f29276i;
        if (imageView != null) {
            al.a((View) imageView, 8);
        }
    }

    public void e() {
        h();
        al.a((View) this.f29273f, 0);
    }

    public boolean f() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29270c;
        return (cVar == null || cVar.u() == null || !this.f29270c.u().g()) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f29275h;
        if (imageView != null && imageView.getVisibility() == 0) {
            al.f(this.f29273f);
        }
        b(this.f29045a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.f29275h;
        if (imageView != null && imageView.getVisibility() == 0) {
            l();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        ImageView imageView = this.f29275h;
        if (imageView != null && imageView.getVisibility() == 0) {
            l();
        } else {
            super.onWindowVisibilityChanged(i2);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.p = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29270c;
        if (cVar != null) {
            cVar.f(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h v;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.f29270c;
        if (cVar == null || (v = cVar.v()) == null) {
            return;
        }
        v.d(z);
    }

    public void setVideoPlayStatus(int i2) {
        this.f29045a = i2;
    }
}
