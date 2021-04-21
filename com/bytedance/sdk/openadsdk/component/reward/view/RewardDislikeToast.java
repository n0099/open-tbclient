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
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class RewardDislikeToast extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Handler f27575a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27576b;

    public RewardDislikeToast(Context context) {
        this(context, null);
    }

    public void b() {
        setVisibility(8);
        this.f27575a.removeCallbacksAndMessages(null);
    }

    public RewardDislikeToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.f27576b = textView;
        textView.setClickable(false);
        this.f27576b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int a2 = (int) al.a(p.a(), 20.0f);
        int a3 = (int) al.a(p.a(), 12.0f);
        this.f27576b.setPadding(a2, a3, a2, a3);
        this.f27576b.setLayoutParams(layoutParams);
        this.f27576b.setTextColor(-1);
        this.f27576b.setTextSize(16.0f);
        this.f27576b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(al.a(p.a(), 6.0f));
        this.f27576b.setBackgroundDrawable(gradientDrawable);
        addView(this.f27576b);
    }

    public RewardDislikeToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27575a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27575a.removeCallbacksAndMessages(null);
        this.f27575a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (RewardDislikeToast.this.f27576b != null) {
                    RewardDislikeToast.this.f27576b.setText(String.valueOf(str));
                }
                RewardDislikeToast.this.setVisibility(0);
            }
        });
        this.f27575a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                RewardDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void a() {
        setVisibility(8);
        this.f27575a.removeCallbacksAndMessages(null);
    }
}
