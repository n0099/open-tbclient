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
/* loaded from: classes10.dex */
public class CharmValueView extends FrameLayout {
    private View oAK;
    private View oAL;
    private CharmProgressBar oAM;
    private TextView oAN;
    private ValueAnimator oAO;
    private ValueAnimator oAP;
    private ValueAnimator oAQ;
    private ValueAnimator oAR;
    private int oAS;
    private int oAT;

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
        this.oAM = (CharmProgressBar) findViewById(a.f.charm_pb);
        this.oAN = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
        this.oAL = findViewById(a.f.eighty_iv);
        this.oAK = findViewById(a.f.hundred_fl);
    }

    public void setProgress(int i) {
        dK(this.oAT, i);
        this.oAT = i;
        if (i < 80) {
            ecE();
            ecF();
        } else if (i < 100) {
            ecC();
            ecF();
        } else {
            ecD();
            ecE();
        }
    }

    public void setCharmValue(int i) {
        dL(this.oAS, i);
        this.oAS = i;
    }

    private void dK(int i, int i2) {
        c(this.oAR);
        this.oAR = ValueAnimator.ofInt(i, i2);
        this.oAR.setDuration(700L);
        this.oAR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oAM.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        b(this.oAR);
    }

    private void dL(int i, int i2) {
        c(this.oAQ);
        this.oAQ = ValueAnimator.ofInt(i, i2);
        this.oAQ.setDuration(700L);
        this.oAQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oAN.setText(CharmValueView.this.hO(((Integer) valueAnimator.getAnimatedValue()).intValue()));
            }
        });
        b(this.oAQ);
    }

    private void ecC() {
        if (this.oAO == null) {
            this.oAO = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.oAO.setDuration(700L);
            this.oAO.setRepeatMode(2);
            this.oAO.setRepeatCount(-1);
            this.oAO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oAL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oAO);
        this.oAL.setVisibility(0);
    }

    private void ecD() {
        if (this.oAP == null) {
            this.oAP = ValueAnimator.ofFloat(1.0f, 1.2f);
            this.oAP.setDuration(700L);
            this.oAP.setRepeatMode(2);
            this.oAP.setRepeatCount(-1);
            this.oAP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oAK.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    CharmValueView.this.oAK.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oAP);
    }

    private void ecE() {
        c(this.oAO);
        this.oAL.setVisibility(8);
    }

    private void ecF() {
        c(this.oAP);
        this.oAK.setScaleX(1.0f);
        this.oAK.setScaleY(1.0f);
    }

    private void ecG() {
        c(this.oAQ);
        this.oAN.setText(hO(this.oAS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hO(long j) {
        return j < 10000 ? String.valueOf(j) : String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d)) + "万";
    }

    private void ecH() {
        c(this.oAR);
        this.oAM.setProgress(this.oAT);
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
        ecE();
        ecF();
        ecG();
        ecH();
    }
}
