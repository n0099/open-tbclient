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
/* loaded from: classes6.dex */
public class FullRewardExpressBackupView extends BackupView {
    private View k;
    private NativeExpressView l;
    private FrameLayout m;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a n;

    public FullRewardExpressBackupView(@NonNull Context context) {
        super(context);
        this.f4471a = context;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        u.b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.b = lVar;
        this.l = nativeExpressView;
        this.n = aVar;
        if (aj.c(this.b.aj()) == 7) {
            this.e = "rewarded_video";
        } else {
            this.e = "fullscreen_interstitial_ad";
        }
        b();
        this.l.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void b() {
        this.f = ak.c(this.f4471a, this.l.getExpectExpressWidth());
        this.g = ak.c(this.f4471a, this.l.getExpectExpressWidth());
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
        this.b.n();
        c();
    }

    private void c() {
        this.k = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_full_reward"), (ViewGroup) this, true);
        this.m = (FrameLayout) this.k.findViewById(ac.e(this.f4471a, "tt_bu_video_container"));
        this.m.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (this.l != null) {
            this.l.a(i, jVar);
        }
    }
}
