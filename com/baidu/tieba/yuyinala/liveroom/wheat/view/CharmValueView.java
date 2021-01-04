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
    private View oFq;
    private View oFr;
    private CharmProgressBar oFs;
    private TextView oFt;
    private ValueAnimator oFu;
    private ValueAnimator oFv;
    private ValueAnimator oFw;
    private ValueAnimator oFx;
    private int oFy;
    private int oFz;

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
        this.oFs = (CharmProgressBar) findViewById(a.f.charm_pb);
        this.oFt = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
        this.oFr = findViewById(a.f.eighty_iv);
        this.oFq = findViewById(a.f.hundred_fl);
    }

    public void setProgress(int i) {
        dK(this.oFz, i);
        this.oFz = i;
        if (i < 80) {
            egv();
            egw();
        } else if (i < 100) {
            egt();
            egw();
        } else {
            egu();
            egv();
        }
    }

    public void setCharmValue(int i) {
        dL(this.oFy, i);
        this.oFy = i;
    }

    private void dK(int i, int i2) {
        c(this.oFx);
        this.oFx = ValueAnimator.ofInt(i, i2);
        this.oFx.setDuration(700L);
        this.oFx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oFs.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        b(this.oFx);
    }

    private void dL(int i, int i2) {
        c(this.oFw);
        this.oFw = ValueAnimator.ofInt(i, i2);
        this.oFw.setDuration(700L);
        this.oFw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oFt.setText(CharmValueView.this.hO(((Integer) valueAnimator.getAnimatedValue()).intValue()));
            }
        });
        b(this.oFw);
    }

    private void egt() {
        if (this.oFu == null) {
            this.oFu = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.oFu.setDuration(700L);
            this.oFu.setRepeatMode(2);
            this.oFu.setRepeatCount(-1);
            this.oFu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oFr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oFu);
        this.oFr.setVisibility(0);
    }

    private void egu() {
        if (this.oFv == null) {
            this.oFv = ValueAnimator.ofFloat(1.0f, 1.2f);
            this.oFv.setDuration(700L);
            this.oFv.setRepeatMode(2);
            this.oFv.setRepeatCount(-1);
            this.oFv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oFq.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    CharmValueView.this.oFq.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oFv);
    }

    private void egv() {
        c(this.oFu);
        this.oFr.setVisibility(8);
    }

    private void egw() {
        c(this.oFv);
        this.oFq.setScaleX(1.0f);
        this.oFq.setScaleY(1.0f);
    }

    private void egx() {
        c(this.oFw);
        this.oFt.setText(hO(this.oFy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hO(long j) {
        return j < 10000 ? String.valueOf(j) : String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d)) + "万";
    }

    private void egy() {
        c(this.oFx);
        this.oFs.setProgress(this.oFz);
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
        egv();
        egw();
        egx();
        egy();
    }
}
