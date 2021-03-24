package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f28702a;

    public NativeDrawVideoTsView(@NonNull Context context, @NonNull l lVar) {
        super(context, lVar);
        this.f28702a = false;
        setOnClickListener(this);
    }

    private void d() {
        al.a((View) this.f28708f, 0);
        al.a((View) this.f28709g, 0);
        al.a((View) this.i, 8);
    }

    private void e() {
        h();
        RelativeLayout relativeLayout = this.f28708f;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.i.e.c().a(this.f28704b.X().h(), this.f28709g);
        }
        d();
    }

    public void a(Bitmap bitmap, int i) {
        i.d().a(bitmap);
        this.l = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        this.f28707e = false;
        this.k = "draw_ad";
        p.h().r(String.valueOf(ak.d(this.f28704b.ap())));
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        if (this.f28702a) {
            super.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f28710h;
        if (imageView != null && imageView.getVisibility() == 0) {
            al.f(this.f28708f);
        }
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.f28710h;
        if (imageView != null && imageView.getVisibility() == 0) {
            e();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.f28710h;
        if (imageView != null && imageView.getVisibility() == 0) {
            e();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.f28702a = z;
    }
}
