package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private boolean n;

    public NativeDrawVideoTsView(@NonNull Context context, @NonNull l lVar) {
        super(context, lVar);
        this.n = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        this.d = false;
        this.i = "draw_ad";
        p.h().s(String.valueOf(aj.d(this.f7020a.W())));
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

    public void a(Bitmap bitmap, int i) {
        i.c().a(bitmap);
        this.j = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.g != null && this.g.getVisibility() == 0) {
            i();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.g != null && this.g.getVisibility() == 0) {
            i();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void d() {
        ak.a((View) this.e, 0);
        ak.a((View) this.f, 0);
        ak.a((View) this.h, 8);
    }

    private void i() {
        f();
        if (this.e != null) {
            if (this.e.getVisibility() != 0) {
                com.bytedance.sdk.openadsdk.i.e.a(getContext()).a(this.f7020a.F().g(), this.f);
            } else {
                return;
            }
        }
        d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.g != null && this.g.getVisibility() == 0) {
            ak.f(this.e);
        }
        c();
    }
}
