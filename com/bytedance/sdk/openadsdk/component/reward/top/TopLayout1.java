package com.bytedance.sdk.openadsdk.component.reward.top;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes4.dex */
public class TopLayout1 extends FrameLayout implements a<TopLayout1> {

    /* renamed from: a  reason: collision with root package name */
    private TextView f6648a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f6649b;
    private TextView c;
    private View d;
    private boolean e;
    private boolean f;
    private b g;

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        if (this.c != null) {
            this.c.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        if (this.c != null) {
            this.c.setEnabled(z);
            this.c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        if (this.f6649b != null) {
            this.f6649b.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        this.f = z;
        this.f6649b.setImageResource(this.f ? ac.d(getContext(), "tt_mute") : ac.d(getContext(), "tt_unmute"));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        if (this.f6648a != null) {
            this.f6648a.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (this.f6648a != null && !TextUtils.isEmpty(charSequence)) {
            this.f6648a.setText(charSequence);
        }
        if (this.c != null && !TextUtils.isEmpty(charSequence2)) {
            this.c.setText(charSequence2);
            if (!this.e) {
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                layoutParams.width = charSequence2.length() <= 2 ? (int) ak.a(getContext(), 53.0f) : (int) ak.a(getContext(), 96.0f);
                this.c.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        if (this.d != null) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        if (this.c != null) {
            this.c.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        if (this.f6649b != null) {
            this.f6649b.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
    }
}
