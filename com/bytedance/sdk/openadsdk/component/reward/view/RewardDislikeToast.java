package com.bytedance.sdk.openadsdk.component.reward.view;

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
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes4.dex */
public class RewardDislikeToast extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Handler f6373a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f6374b;

    public RewardDislikeToast(Context context) {
        this(context, null);
    }

    public RewardDislikeToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6373a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    private void a(Context context) {
        this.f6374b = new TextView(context);
        this.f6374b.setClickable(false);
        this.f6374b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int a2 = (int) ak.a(p.a(), 20.0f);
        int a3 = (int) ak.a(p.a(), 12.0f);
        this.f6374b.setPadding(a2, a3, a2, a3);
        this.f6374b.setLayoutParams(layoutParams);
        this.f6374b.setTextColor(-1);
        this.f6374b.setTextSize(16.0f);
        this.f6374b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(ak.a(p.a(), 6.0f));
        this.f6374b.setBackgroundDrawable(gradientDrawable);
        addView(this.f6374b);
    }

    public void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f6373a.removeCallbacksAndMessages(null);
            this.f6373a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.1
                @Override // java.lang.Runnable
                public void run() {
                    if (RewardDislikeToast.this.f6374b != null) {
                        RewardDislikeToast.this.f6374b.setText(String.valueOf(str));
                    }
                    RewardDislikeToast.this.setVisibility(0);
                }
            });
            this.f6373a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.2
                @Override // java.lang.Runnable
                public void run() {
                    RewardDislikeToast.this.setVisibility(8);
                }
            }, 2000L);
        }
    }

    public void a() {
        setVisibility(8);
        this.f6373a.removeCallbacksAndMessages(null);
    }

    public void b() {
        setVisibility(8);
        this.f6373a.removeCallbacksAndMessages(null);
    }
}
