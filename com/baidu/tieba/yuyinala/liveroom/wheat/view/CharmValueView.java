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
    private View oNa;
    private View oNb;
    private CharmProgressBar oNc;
    private TextView oNd;
    private ValueAnimator oNe;
    private ValueAnimator oNf;
    private ValueAnimator oNg;
    private ValueAnimator oNh;
    private int oNi;
    private int oNj;

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
        this.oNc = (CharmProgressBar) findViewById(a.f.charm_pb);
        this.oNd = (TextView) findViewById(a.f.yuyin_sdk_wheat_charm_value_text);
        this.oNb = findViewById(a.f.eighty_iv);
        this.oNa = findViewById(a.f.hundred_fl);
    }

    public void setProgress(int i) {
        dI(this.oNj, i);
        this.oNj = i;
        if (i < 80) {
            efi();
            efj();
        } else if (i < 100) {
            efg();
            efj();
        } else {
            efh();
            efi();
        }
    }

    public void setCharmValue(int i) {
        dJ(this.oNi, i);
        this.oNi = i;
    }

    private void dI(int i, int i2) {
        c(this.oNh);
        this.oNh = ValueAnimator.ofInt(i, i2);
        this.oNh.setDuration(700L);
        this.oNh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oNc.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        b(this.oNh);
    }

    private void dJ(int i, int i2) {
        c(this.oNg);
        this.oNg = ValueAnimator.ofInt(i, i2);
        this.oNg.setDuration(700L);
        this.oNg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CharmValueView.this.oNd.setText(CharmValueView.this.hR(((Integer) valueAnimator.getAnimatedValue()).intValue()));
            }
        });
        b(this.oNg);
    }

    private void efg() {
        if (this.oNe == null) {
            this.oNe = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.oNe.setDuration(700L);
            this.oNe.setRepeatMode(2);
            this.oNe.setRepeatCount(-1);
            this.oNe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oNb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oNe);
        this.oNb.setVisibility(0);
    }

    private void efh() {
        if (this.oNf == null) {
            this.oNf = ValueAnimator.ofFloat(1.0f, 1.2f);
            this.oNf.setDuration(700L);
            this.oNf.setRepeatMode(2);
            this.oNf.setRepeatCount(-1);
            this.oNf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.CharmValueView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CharmValueView.this.oNa.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    CharmValueView.this.oNa.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        b(this.oNf);
    }

    private void efi() {
        c(this.oNe);
        this.oNb.setVisibility(8);
    }

    private void efj() {
        c(this.oNf);
        this.oNa.setScaleX(1.0f);
        this.oNa.setScaleY(1.0f);
    }

    private void efk() {
        c(this.oNg);
        this.oNd.setText(hR(this.oNi));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hR(long j) {
        return j < 10000 ? String.valueOf(j) : String.format("%.1f", Double.valueOf((j * 1.0d) / 10000.0d)) + "万";
    }

    private void efl() {
        c(this.oNh);
        this.oNc.setProgress(this.oNj);
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
        efi();
        efj();
        efk();
        efl();
    }
}
