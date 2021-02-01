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
    private boolean n;

    public ExpressVideoView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        super(context, lVar, false, str);
        this.n = false;
        if ("draw_ad".equals(str)) {
            this.n = true;
        }
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        this.d = false;
        p.h().s(String.valueOf(aj.d(this.f6722a.W())));
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        if (this.n) {
            super.c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.f6723b != null) {
            this.f6723b.f(z);
        }
    }

    public void d() {
        if (this.h != null) {
            ak.a((View) this.h, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.g != null && this.g.getVisibility() == 0) {
            j();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.g != null && this.g.getVisibility() == 0) {
            j();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void i() {
        ak.a((View) this.e, 0);
        ak.a((View) this.f, 0);
        ak.a((View) this.h, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void a(boolean z) {
    }

    private void j() {
        f();
        if (this.e != null) {
            if (this.e.getVisibility() != 0) {
                com.bytedance.sdk.openadsdk.i.e.a(getContext()).a(this.f6722a.F().g(), this.f);
            } else {
                return;
            }
        }
        i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.g != null && this.g.getVisibility() == 0) {
            ak.f(this.e);
        }
        c();
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h u;
        if (this.f6723b != null && (u = this.f6723b.u()) != null) {
            u.d(z);
        }
    }
}
