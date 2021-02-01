package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class CharmValueView extends FrameLayout {
    private ValueAnimator oKA;
    private ValueAnimator oKB;
    private ValueAnimator oKC;
    private int oKD;
    private int oKE;
    private View oKv;
    private View oKw;
    private CharmProgressBar oKx;
    private TextView oKy;
    private ValueAnimator oKz;

    public CharmValueView(@NonNull Context context) {
        this(context, null, 0);
    }

    public CharmValueView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CharmValueView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_charm_value_view_layout, this);
        this.oKx = (CharmProgressBar) findViewById(a.f.charm_pb);
        this.oKy = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
        this.oKw = findViewById(a.f.eighty_iv);
        this.oKv = findViewById(a.f.hundred_fl);
    }

    public void setProgress(int i) {
        dH(this.oKE, i);
        this.oKE = i;
        if (i < 80) {
            eeS();
            eeT();
        } else if (i < 100) {
            eeQ();
            eeT();
        } else {
            eeR();
            eeS();
        }
    }

    public void setCharmValue(int i) {
        dI(this.oKD, i);
        this.oKD = i;
    }

    private void dH(int i, int i2) {
        c(this.oKC);
        this.oKC = ValueAnimator.ofInt(i, i2);
        this.oKC.setDuration(700L);
        this.oKC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oKx.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        b(this.oKC);
    }

    private void dI(int i, int i2) {
        c(this.oKB);
        this.oKB = ValueAnimator.ofInt(i, i2);
        this.oKB.setDuration(700L);
        this.oKB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oKy.setText(CharmValueView.this.hR(((Integer) valueAnimator.getAnimatedValue()).intValue()));
            }
        });
        b(this.oKB);
    }

    private void eeQ() {
        if (this.oKz == null) {
            this.oKz = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.oKz.setDuration(700L);
            this.oKz.setRepeatMode(2);
            this.oKz.setRepeatCount(-1);
            this.oKz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oKw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oKz);
        this.oKw.setVisibility(0);
    }

    private void eeR() {
        if (this.oKA == null) {
            this.oKA = ValueAnimator.ofFloat(1.0f, 1.2f);
            this.oKA.setDuration(700L);
            this.oKA.setRepeatMode(2);
            this.oKA.setRepeatCount(-1);
            this.oKA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oKv.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    CharmValueView.this.oKv.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oKA);
    }

    private void eeS() {
        c(this.oKz);
        this.oKw.setVisibility(8);
    }

    private void eeT() {
        c(this.oKA);
        this.oKv.setScaleX(1.0f);
        this.oKv.setScaleY(1.0f);
    }

    private void eeU() {
        c(this.oKB);
        this.oKy.setText(hR(this.oKD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hR(long j) {
        return j < 10000 ? String.valueOf(j) : String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d)) + "万";
    }

    private void eeV() {
        c(this.oKC);
        this.oKx.setProgress(this.oKE);
    }

    private void b(ValueAnimator valueAnimator) {
        if (valueAnimator != null && !valueAnimator.isRunning()) {
            valueAnimator.start();
        }
    }

    private void c(ValueAnimator valueAnimator) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        eeS();
        eeT();
        eeU();
        eeV();
    }
}
