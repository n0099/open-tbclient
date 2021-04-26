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
/* loaded from: classes5.dex */
public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {

    /* renamed from: a  reason: collision with root package name */
    public View f28368a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28369b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28370c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28371d;

    /* renamed from: e  reason: collision with root package name */
    public l f28372e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28373f;

    /* renamed from: g  reason: collision with root package name */
    public b f28374g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f28375h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f28376i;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    private void d() {
        View view = this.f28368a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.f28374g != null) {
                        TopLayoutDislike2.this.f28374g.c(view2);
                    }
                }
            });
        }
        ImageView imageView = this.f28369b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.f28373f = !topLayoutDislike2.f28373f;
                    TopLayoutDislike2.this.f28369b.setImageResource(TopLayoutDislike2.this.f28373f ? ad.d(TopLayoutDislike2.this.getContext(), "tt_mute") : ad.d(TopLayoutDislike2.this.getContext(), "tt_unmute"));
                    if (TopLayoutDislike2.this.f28374g != null) {
                        TopLayoutDislike2.this.f28374g.b(view2);
                    }
                }
            });
        }
        TextView textView = this.f28370c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.f28374g != null) {
                        TopLayoutDislike2.this.f28374g.a(view2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.f28374g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f28368a;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.f28370c;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.f28370c.getVisibility() == 4) {
                return;
            }
            this.f28370c.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.f28369b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.f28370c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f28370c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        this.f28373f = z;
        if (z) {
            d2 = ad.d(getContext(), "tt_mute");
        } else {
            d2 = ad.d(getContext(), "tt_unmute");
        }
        this.f28369b.setImageResource(d2);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f28369b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.f28370c.setWidth(20);
        this.f28370c.setVisibility(4);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28375h = "";
        this.f28376i = "";
    }

    public TopLayoutDislike2 a(boolean z, @NonNull l lVar) {
        this.f28371d = z;
        this.f28372e = lVar;
        LayoutInflater.from(getContext()).inflate(ad.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.f28368a = findViewById(ad.e(getContext(), "tt_top_dislike"));
        this.f28369b = (ImageView) findViewById(ad.e(getContext(), "tt_top_mute"));
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_top_skip"));
        this.f28370c = textView;
        textView.setVisibility(0);
        this.f28370c.setText("");
        this.f28370c.setEnabled(false);
        this.f28370c.setClickable(false);
        d();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f28375h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f28376i = charSequence2;
        }
        if (this.f28370c != null) {
            CharSequence charSequence3 = this.f28375h;
            if (!TextUtils.isEmpty(this.f28376i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.f28376i);
            }
            this.f28370c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.f28370c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
