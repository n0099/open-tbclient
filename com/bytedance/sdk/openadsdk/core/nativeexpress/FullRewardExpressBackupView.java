package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public class FullRewardExpressBackupView extends BackupView {
    public View k;
    public NativeExpressView l;
    public FrameLayout m;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a n;

    public FullRewardExpressBackupView(@NonNull Context context) {
        super(context);
        this.f28208a = context;
    }

    private void b() {
        this.f28213f = al.c(this.f28208a, this.l.getExpectExpressWidth());
        this.f28214g = al.c(this.f28208a, this.l.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28213f, this.f28214g);
        }
        layoutParams.width = this.f28213f;
        layoutParams.height = this.f28214g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.f28209b.n();
        c();
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f28208a).inflate(ad.f(this.f28208a, "tt_backup_full_reward"), (ViewGroup) this, true);
        this.k = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f28208a, "tt_bu_video_container"));
        this.m = frameLayout;
        frameLayout.removeAllViews();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        u.b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f28209b = lVar;
        this.l = nativeExpressView;
        this.n = aVar;
        if (ak.c(lVar.ap()) == 7) {
            this.f28212e = "rewarded_video";
        } else {
            this.f28212e = "fullscreen_interstitial_ad";
        }
        b();
        this.l.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public FrameLayout getVideoContainer() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        NativeExpressView nativeExpressView = this.l;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, jVar);
        }
    }
}
