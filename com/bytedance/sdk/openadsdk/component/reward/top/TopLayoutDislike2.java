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
import com.bytedance.sdk.openadsdk.utils.ac;
/* loaded from: classes4.dex */
public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {

    /* renamed from: a  reason: collision with root package name */
    private View f6650a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f6651b;
    private TextView c;
    private boolean d;
    private l e;
    private boolean f;
    private b g;
    private CharSequence h;
    private CharSequence i;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = "";
        this.i = "";
    }

    public TopLayoutDislike2 a(boolean z, @NonNull l lVar) {
        this.d = z;
        this.e = lVar;
        LayoutInflater.from(getContext()).inflate(ac.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.f6650a = findViewById(ac.e(getContext(), "tt_top_dislike"));
        this.f6651b = (ImageView) findViewById(ac.e(getContext(), "tt_top_mute"));
        this.c = (TextView) findViewById(ac.e(getContext(), "tt_top_skip"));
        this.c.setVisibility(0);
        this.c.setText("");
        this.c.setEnabled(false);
        this.c.setClickable(false);
        d();
        return this;
    }

    private void d() {
        if (this.f6650a != null) {
            this.f6650a.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.c(view);
                    }
                }
            });
        }
        if (this.f6651b != null) {
            this.f6651b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TopLayoutDislike2.this.f = !TopLayoutDislike2.this.f;
                    TopLayoutDislike2.this.f6651b.setImageResource(TopLayoutDislike2.this.f ? ac.d(TopLayoutDislike2.this.getContext(), "tt_mute") : ac.d(TopLayoutDislike2.this.getContext(), "tt_unmute"));
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.b(view);
                    }
                }
            });
        }
        if (this.c != null) {
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.a(view);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        if (this.c != null) {
            if (!z) {
                this.c.setText("");
            }
            if (this.c.getVisibility() != 4) {
                this.c.setVisibility(z ? 0 : 8);
            }
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
        if (this.f6651b != null) {
            this.f6651b.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        this.f = z;
        this.f6651b.setImageResource(this.f ? ac.d(getContext(), "tt_mute") : ac.d(getContext(), "tt_unmute"));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.i = charSequence2;
        }
        if (this.c != null) {
            CharSequence charSequence3 = this.h;
            if (!TextUtils.isEmpty(this.i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.i);
            }
            this.c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        if (this.f6650a != null) {
            this.f6650a.setVisibility(z ? 0 : 8);
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
        if (this.f6651b != null) {
            this.f6651b.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.c.setWidth(20);
        this.c.setVisibility(4);
    }
}
