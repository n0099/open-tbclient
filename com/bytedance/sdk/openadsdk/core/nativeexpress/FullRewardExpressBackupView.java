package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes4.dex */
public class FullRewardExpressBackupView extends BackupView {
    private View h;
    private NativeExpressView i;
    private FrameLayout j;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a k;

    public FullRewardExpressBackupView(@NonNull Context context) {
        super(context);
        this.f6615a = context;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        u.b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f6616b = lVar;
        this.i = nativeExpressView;
        this.k = aVar;
        if (aj.c(this.f6616b.W()) == 7) {
            this.e = "rewarded_video";
        } else {
            this.e = "fullscreen_interstitial_ad";
        }
        b();
        this.i.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void b() {
        this.f = ak.c(this.f6615a, this.i.getExpectExpressWidth());
        this.g = ak.c(this.f6615a, this.i.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.f6616b.h();
        c();
    }

    private void c() {
        this.h = LayoutInflater.from(this.f6615a).inflate(ac.f(this.f6615a, "tt_backup_full_reward"), (ViewGroup) this, true);
        this.j = (FrameLayout) this.h.findViewById(ac.e(this.f6615a, "tt_bu_video_container"));
        this.j.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (this.i != null) {
            this.i.a(i, jVar);
        }
    }
}
