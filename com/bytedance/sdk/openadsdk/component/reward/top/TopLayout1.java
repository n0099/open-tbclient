package com.bytedance.sdk.openadsdk.component.reward.top;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class TopLayout1 extends FrameLayout implements a<TopLayout1> {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27606a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27607b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27608c;

    /* renamed from: d  reason: collision with root package name */
    public View f27609d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27610e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27611f;

    /* renamed from: g  reason: collision with root package name */
    public b f27612g;

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (this.f27606a != null && !TextUtils.isEmpty(charSequence)) {
            this.f27606a.setText(charSequence);
        }
        if (this.f27608c == null || TextUtils.isEmpty(charSequence2)) {
            return;
        }
        this.f27608c.setText(charSequence2);
        if (this.f27610e) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f27608c.getLayoutParams();
        layoutParams.width = (int) (charSequence2.length() <= 2 ? al.a(getContext(), 53.0f) : al.a(getContext(), 96.0f));
        this.f27608c.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f27607b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.f27612g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        TextView textView = this.f27606a;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f27609d;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.f27608c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.f27607b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.f27608c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f27608c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        this.f27611f = z;
        if (z) {
            d2 = ad.d(getContext(), "tt_mute");
        } else {
            d2 = ad.d(getContext(), "tt_unmute");
        }
        this.f27607b.setImageResource(d2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.f27608c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
