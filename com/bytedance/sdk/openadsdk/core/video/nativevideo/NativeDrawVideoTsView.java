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
/* loaded from: classes6.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4547a;

    public NativeDrawVideoTsView(@NonNull Context context, @NonNull l lVar) {
        super(context, lVar);
        this.f4547a = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        this.e = false;
        this.k = "draw_ad";
        p.h().s(String.valueOf(aj.d(this.b.aj())));
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        if (this.f4547a) {
            super.c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.f4547a = z;
    }

    public void a(Bitmap bitmap, int i) {
        i.d().a(bitmap);
        this.l = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.h != null && this.h.getVisibility() == 0) {
            e();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.h != null && this.h.getVisibility() == 0) {
            e();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void d() {
        ak.a((View) this.f, 0);
        ak.a((View) this.g, 0);
        ak.a((View) this.i, 8);
    }

    private void e() {
        g();
        if (this.f != null) {
            if (this.f.getVisibility() != 0) {
                com.bytedance.sdk.openadsdk.h.d.a(getContext()).a(this.b.R().h(), this.g);
            } else {
                return;
            }
        }
        d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h != null && this.h.getVisibility() == 0) {
            ak.f(this.f);
        }
        c();
    }
}
