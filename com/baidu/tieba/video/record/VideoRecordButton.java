package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView IS;
    private ObjectAnimator gXA;
    private ObjectAnimator gXB;
    private View gXv;
    private View gXw;
    private View gXx;
    private ObjectAnimator gXy;
    private ObjectAnimator gXz;

    public VideoRecordButton(Context context) {
        super(context);
        initView();
    }

    public VideoRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VideoRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), d.h.layout_record_button, this);
        this.gXv = findViewById(d.g.record_layer1);
        this.gXw = findViewById(d.g.record_layer2);
        this.gXx = findViewById(d.g.record_layer3);
        this.IS = (TextView) findViewById(d.g.tv_tip);
        this.gXx.setScaleX(0.766f);
        this.gXx.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.gXx;
    }

    public View getLayer1() {
        return this.gXv;
    }

    public View getLayer2() {
        return this.gXw;
    }

    public TextView getTvTip() {
        return this.IS;
    }

    public void bDV() {
        if (this.gXB != null && this.gXB.isRunning()) {
            this.gXA.cancel();
        }
        if (this.gXA == null) {
            this.gXA = ObjectAnimator.ofPropertyValuesHolder(this.gXw, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.gXA.setDuration(200L);
        }
        this.gXA.start();
    }

    public void bDW() {
        if (this.gXA != null && this.gXA.isRunning()) {
            this.gXA.cancel();
        }
        if (this.gXw.getScaleX() != 1.0f) {
            if (this.gXB == null) {
                this.gXB = ObjectAnimator.ofPropertyValuesHolder(this.gXw, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.gXB.setDuration(200L);
            }
            this.gXB.start();
        }
    }

    public void nM(boolean z) {
        if (this.gXz != null && this.gXz.isRunning()) {
            this.gXz.cancel();
        }
        if (this.gXy == null) {
            this.gXy = ObjectAnimator.ofPropertyValuesHolder(this.gXx, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.gXy.setRepeatCount(-1);
            this.gXy.setRepeatMode(2);
            this.gXy.setDuration(1000L);
        }
        this.gXx.setVisibility(0);
        if (z) {
            this.gXv.setVisibility(8);
        } else {
            this.gXv.setBackgroundResource(d.f.red_square_bg);
        }
        this.IS.setVisibility(8);
        this.gXy.start();
    }

    public void bDL() {
        if (this.gXy != null && this.gXy.isRunning()) {
            this.gXy.cancel();
        }
        if (this.gXz == null) {
            this.gXz = ObjectAnimator.ofPropertyValuesHolder(this.gXx, PropertyValuesHolder.ofFloat("scaleX", this.gXx.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.gXx.getScaleY(), 0.766f));
            this.gXz.setDuration((500.0f * Math.abs(0.766f - this.gXx.getScaleX())) / 0.3f);
        }
        this.gXv.setVisibility(0);
        this.gXv.setBackgroundResource(d.f.red_circle_bg);
        this.gXz.start();
    }
}
