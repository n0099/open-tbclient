package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class LandingDislikeToast extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Handler f29694a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f29695b;

    public LandingDislikeToast(Context context) {
        this(context, null);
    }

    public LandingDislikeToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.f29695b = textView;
        textView.setClickable(false);
        this.f29695b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int a2 = (int) al.a(p.a(), 20.0f);
        int a3 = (int) al.a(p.a(), 12.0f);
        this.f29695b.setPadding(a2, a3, a2, a3);
        this.f29695b.setLayoutParams(layoutParams);
        this.f29695b.setTextColor(-1);
        this.f29695b.setTextSize(16.0f);
        this.f29695b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(al.a(p.a(), 6.0f));
        this.f29695b.setBackgroundDrawable(gradientDrawable);
        addView(this.f29695b);
    }

    public LandingDislikeToast(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29694a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f29694a.removeCallbacksAndMessages(null);
        this.f29694a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (LandingDislikeToast.this.f29695b != null) {
                    LandingDislikeToast.this.f29695b.setText(String.valueOf(str));
                }
                LandingDislikeToast.this.setVisibility(0);
            }
        });
        this.f29694a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                LandingDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }
}
