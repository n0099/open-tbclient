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
    public View f27727a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27728b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27729c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27730d;

    /* renamed from: e  reason: collision with root package name */
    public l f27731e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27732f;

    /* renamed from: g  reason: collision with root package name */
    public b f27733g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f27734h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f27735i;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    private void d() {
        View view = this.f27727a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.f27733g != null) {
                        TopLayoutDislike2.this.f27733g.c(view2);
                    }
                }
            });
        }
        ImageView imageView = this.f27728b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.f27732f = !topLayoutDislike2.f27732f;
                    TopLayoutDislike2.this.f27728b.setImageResource(TopLayoutDislike2.this.f27732f ? ad.d(TopLayoutDislike2.this.getContext(), "tt_mute") : ad.d(TopLayoutDislike2.this.getContext(), "tt_unmute"));
                    if (TopLayoutDislike2.this.f27733g != null) {
                        TopLayoutDislike2.this.f27733g.b(view2);
                    }
                }
            });
        }
        TextView textView = this.f27729c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.f27733g != null) {
                        TopLayoutDislike2.this.f27733g.a(view2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.f27733g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f27727a;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.f27729c;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.f27729c.getVisibility() == 4) {
                return;
            }
            this.f27729c.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.f27728b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.f27729c;
        if (textView != null) {
            textView.setEnabled(z);
            this.f27729c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        this.f27732f = z;
        if (z) {
            d2 = ad.d(getContext(), "tt_mute");
        } else {
            d2 = ad.d(getContext(), "tt_unmute");
        }
        this.f27728b.setImageResource(d2);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.f27728b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.f27729c.setWidth(20);
        this.f27729c.setVisibility(4);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27734h = "";
        this.f27735i = "";
    }

    public TopLayoutDislike2 a(boolean z, @NonNull l lVar) {
        this.f27730d = z;
        this.f27731e = lVar;
        LayoutInflater.from(getContext()).inflate(ad.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.f27727a = findViewById(ad.e(getContext(), "tt_top_dislike"));
        this.f27728b = (ImageView) findViewById(ad.e(getContext(), "tt_top_mute"));
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_top_skip"));
        this.f27729c = textView;
        textView.setVisibility(0);
        this.f27729c.setText("");
        this.f27729c.setEnabled(false);
        this.f27729c.setClickable(false);
        d();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f27734h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f27735i = charSequence2;
        }
        if (this.f27729c != null) {
            CharSequence charSequence3 = this.f27734h;
            if (!TextUtils.isEmpty(this.f27735i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.f27735i);
            }
            this.f27729c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.f27729c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
