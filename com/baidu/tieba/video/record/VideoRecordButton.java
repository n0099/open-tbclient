package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView SX;
    private View hAU;
    private View hAV;
    private View hAW;
    private ObjectAnimator hAX;
    private ObjectAnimator hAY;
    private ObjectAnimator hAZ;
    private ObjectAnimator hBa;

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
        inflate(getContext(), e.h.layout_record_button, this);
        this.hAU = findViewById(e.g.record_layer1);
        this.hAV = findViewById(e.g.record_layer2);
        this.hAW = findViewById(e.g.record_layer3);
        this.SX = (TextView) findViewById(e.g.tv_tip);
        this.hAW.setScaleX(0.766f);
        this.hAW.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hAW;
    }

    public View getLayer1() {
        return this.hAU;
    }

    public View getLayer2() {
        return this.hAV;
    }

    public TextView getTvTip() {
        return this.SX;
    }

    public void bJE() {
        if (this.hBa != null && this.hBa.isRunning()) {
            this.hAZ.cancel();
        }
        if (this.hAZ == null) {
            this.hAZ = ObjectAnimator.ofPropertyValuesHolder(this.hAV, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hAZ.setDuration(200L);
        }
        this.hAZ.start();
    }

    public void bJF() {
        if (this.hAZ != null && this.hAZ.isRunning()) {
            this.hAZ.cancel();
        }
        if (this.hAV.getScaleX() != 1.0f) {
            if (this.hBa == null) {
                this.hBa = ObjectAnimator.ofPropertyValuesHolder(this.hAV, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hBa.setDuration(200L);
            }
            this.hBa.start();
        }
    }

    public void nQ(boolean z) {
        if (this.hAY != null && this.hAY.isRunning()) {
            this.hAY.cancel();
        }
        if (this.hAX == null) {
            this.hAX = ObjectAnimator.ofPropertyValuesHolder(this.hAW, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hAX.setRepeatCount(-1);
            this.hAX.setRepeatMode(2);
            this.hAX.setDuration(1000L);
        }
        this.hAW.setVisibility(0);
        if (z) {
            this.hAU.setVisibility(8);
        } else {
            this.hAU.setBackgroundResource(e.f.red_square_bg);
        }
        this.SX.setVisibility(8);
        this.hAX.start();
    }

    public void bJt() {
        if (this.hAX != null && this.hAX.isRunning()) {
            this.hAX.cancel();
        }
        if (this.hAY == null) {
            this.hAY = ObjectAnimator.ofPropertyValuesHolder(this.hAW, PropertyValuesHolder.ofFloat("scaleX", this.hAW.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hAW.getScaleY(), 0.766f));
            this.hAY.setDuration((500.0f * Math.abs(0.766f - this.hAW.getScaleX())) / 0.3f);
        }
        this.hAU.setVisibility(0);
        this.hAU.setBackgroundResource(e.f.red_circle_bg);
        this.hAY.start();
    }
}
