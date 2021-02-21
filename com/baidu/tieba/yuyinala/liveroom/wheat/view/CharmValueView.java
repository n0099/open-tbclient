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
    private View oKV;
    private View oKW;
    private CharmProgressBar oKX;
    private TextView oKY;
    private ValueAnimator oKZ;
    private ValueAnimator oLa;
    private ValueAnimator oLb;
    private ValueAnimator oLc;
    private int oLd;
    private int oLe;

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
        this.oKX = (CharmProgressBar) findViewById(a.f.charm_pb);
        this.oKY = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
        this.oKW = findViewById(a.f.eighty_iv);
        this.oKV = findViewById(a.f.hundred_fl);
    }

    public void setProgress(int i) {
        dI(this.oLe, i);
        this.oLe = i;
        if (i < 80) {
            efa();
            efb();
        } else if (i < 100) {
            eeY();
            efb();
        } else {
            eeZ();
            efa();
        }
    }

    public void setCharmValue(int i) {
        dJ(this.oLd, i);
        this.oLd = i;
    }

    private void dI(int i, int i2) {
        c(this.oLc);
        this.oLc = ValueAnimator.ofInt(i, i2);
        this.oLc.setDuration(700L);
        this.oLc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oKX.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        b(this.oLc);
    }

    private void dJ(int i, int i2) {
        c(this.oLb);
        this.oLb = ValueAnimator.ofInt(i, i2);
        this.oLb.setDuration(700L);
        this.oLb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oKY.setText(CharmValueView.this.hR(((Integer) valueAnimator.getAnimatedValue()).intValue()));
            }
        });
        b(this.oLb);
    }

    private void eeY() {
        if (this.oKZ == null) {
            this.oKZ = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.oKZ.setDuration(700L);
            this.oKZ.setRepeatMode(2);
            this.oKZ.setRepeatCount(-1);
            this.oKZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oKW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oKZ);
        this.oKW.setVisibility(0);
    }

    private void eeZ() {
        if (this.oLa == null) {
            this.oLa = ValueAnimator.ofFloat(1.0f, 1.2f);
            this.oLa.setDuration(700L);
            this.oLa.setRepeatMode(2);
            this.oLa.setRepeatCount(-1);
            this.oLa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oKV.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    CharmValueView.this.oKV.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oLa);
    }

    private void efa() {
        c(this.oKZ);
        this.oKW.setVisibility(8);
    }

    private void efb() {
        c(this.oLa);
        this.oKV.setScaleX(1.0f);
        this.oKV.setScaleY(1.0f);
    }

    private void efc() {
        c(this.oLb);
        this.oKY.setText(hR(this.oLd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hR(long j) {
        return j < 10000 ? String.valueOf(j) : String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d)) + "万";
    }

    private void efd() {
        c(this.oLc);
        this.oKX.setProgress(this.oLe);
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
        efa();
        efb();
        efc();
        efd();
    }
}
