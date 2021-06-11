package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ad;
/* loaded from: classes6.dex */
public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {

    /* renamed from: a  reason: collision with root package name */
    public View f27645a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27646b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27647c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27648d;

    /* renamed from: e  reason: collision with root package name */
    public l f27649e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27650f;

    /* renamed from: g  reason: collision with root package name */
    public b f27651g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f27652h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f27653i;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    private void d() {
        View view = this.f27645a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.f27651g != null) {
                        TopLayoutDislike2.this.f27651g.c(view2);
                    }
                }
            });
        }
        ImageView imageView = this.f27646b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.f27650f = !topLayoutDislike2.f27650f;
                    TopLayoutDislike2.this.f27646b.setImageResource(TopLayoutDislike2.this.f27650f ? ad.d(TopLayoutDislike2.this.getContext(), "tt_mute") : ad.d(TopLayoutDislike2.this.getContext(), "tt_unmute"));
                    if (TopLayoutDislike2.this.f27651g != null) {
                        TopLayoutDislike2.this.f27651g.b(view2);
                    }
                }
            });
        }
        TextView textView = this.f27647c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.f27651g != null) {
                        TopLayoutDislike2.this.f27651g.a(view2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.f27651g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f27645a;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.f27647c;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.f27647c.getVisibility() == 4) {
                return;
            }
            this.f27647c.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.f27646b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.f27647c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f27647c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        this.f27650f = z;
        if (z) {
            d2 = ad.d(getContext(), "tt_mute");
        } else {
            d2 = ad.d(getContext(), "tt_unmute");
        }
        this.f27646b.setImageResource(d2);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f27646b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.f27647c.setWidth(20);
        this.f27647c.setVisibility(4);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27652h = "";
        this.f27653i = "";
    }

    public TopLayoutDislike2 a(boolean z, @NonNull l lVar) {
        this.f27648d = z;
        this.f27649e = lVar;
        LayoutInflater.from(getContext()).inflate(ad.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.f27645a = findViewById(ad.e(getContext(), "tt_top_dislike"));
        this.f27646b = (ImageView) findViewById(ad.e(getContext(), "tt_top_mute"));
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_top_skip"));
        this.f27647c = textView;
        textView.setVisibility(0);
        this.f27647c.setText("");
        this.f27647c.setEnabled(false);
        this.f27647c.setClickable(false);
        d();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f27652h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f27653i = charSequence2;
        }
        if (this.f27647c != null) {
            CharSequence charSequence3 = this.f27652h;
            if (!TextUtils.isEmpty(this.f27653i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.f27653i);
            }
            this.f27647c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.f27647c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
