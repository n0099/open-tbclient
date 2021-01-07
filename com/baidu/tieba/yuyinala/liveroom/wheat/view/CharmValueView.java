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
    private View oFp;
    private View oFq;
    private CharmProgressBar oFr;
    private TextView oFs;
    private ValueAnimator oFt;
    private ValueAnimator oFu;
    private ValueAnimator oFv;
    private ValueAnimator oFw;
    private int oFx;
    private int oFy;

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
        this.oFr = (CharmProgressBar) findViewById(a.f.charm_pb);
        this.oFs = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
        this.oFq = findViewById(a.f.eighty_iv);
        this.oFp = findViewById(a.f.hundred_fl);
    }

    public void setProgress(int i) {
        dK(this.oFy, i);
        this.oFy = i;
        if (i < 80) {
            egw();
            egx();
        } else if (i < 100) {
            egu();
            egx();
        } else {
            egv();
            egw();
        }
    }

    public void setCharmValue(int i) {
        dL(this.oFx, i);
        this.oFx = i;
    }

    private void dK(int i, int i2) {
        c(this.oFw);
        this.oFw = ValueAnimator.ofInt(i, i2);
        this.oFw.setDuration(700L);
        this.oFw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oFr.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        b(this.oFw);
    }

    private void dL(int i, int i2) {
        c(this.oFv);
        this.oFv = ValueAnimator.ofInt(i, i2);
        this.oFv.setDuration(700L);
        this.oFv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oFs.setText(CharmValueView.this.hO(((Integer) valueAnimator.getAnimatedValue()).intValue()));
            }
        });
        b(this.oFv);
    }

    private void egu() {
        if (this.oFt == null) {
            this.oFt = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.oFt.setDuration(700L);
            this.oFt.setRepeatMode(2);
            this.oFt.setRepeatCount(-1);
            this.oFt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oFq.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oFt);
        this.oFq.setVisibility(0);
    }

    private void egv() {
        if (this.oFu == null) {
            this.oFu = ValueAnimator.ofFloat(1.0f, 1.2f);
            this.oFu.setDuration(700L);
            this.oFu.setRepeatMode(2);
            this.oFu.setRepeatCount(-1);
            this.oFu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oFp.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    CharmValueView.this.oFp.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oFu);
    }

    private void egw() {
        c(this.oFt);
        this.oFq.setVisibility(8);
    }

    private void egx() {
        c(this.oFu);
        this.oFp.setScaleX(1.0f);
        this.oFp.setScaleY(1.0f);
    }

    private void egy() {
        c(this.oFv);
        this.oFs.setText(hO(this.oFx));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hO(long j) {
        return j < 10000 ? String.valueOf(j) : String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d)) + "万";
    }

    private void egz() {
        c(this.oFw);
        this.oFr.setProgress(this.oFy);
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
        egw();
        egx();
        egy();
        egz();
    }
}
