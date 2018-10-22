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
    private View hAV;
    private View hAW;
    private View hAX;
    private ObjectAnimator hAY;
    private ObjectAnimator hAZ;
    private ObjectAnimator hBa;
    private ObjectAnimator hBb;

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
        this.hAV = findViewById(e.g.record_layer1);
        this.hAW = findViewById(e.g.record_layer2);
        this.hAX = findViewById(e.g.record_layer3);
        this.SX = (TextView) findViewById(e.g.tv_tip);
        this.hAX.setScaleX(0.766f);
        this.hAX.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hAX;
    }

    public View getLayer1() {
        return this.hAV;
    }

    public View getLayer2() {
        return this.hAW;
    }

    public TextView getTvTip() {
        return this.SX;
    }

    public void bJE() {
        if (this.hBb != null && this.hBb.isRunning()) {
            this.hBa.cancel();
        }
        if (this.hBa == null) {
            this.hBa = ObjectAnimator.ofPropertyValuesHolder(this.hAW, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hBa.setDuration(200L);
        }
        this.hBa.start();
    }

    public void bJF() {
        if (this.hBa != null && this.hBa.isRunning()) {
            this.hBa.cancel();
        }
        if (this.hAW.getScaleX() != 1.0f) {
            if (this.hBb == null) {
                this.hBb = ObjectAnimator.ofPropertyValuesHolder(this.hAW, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hBb.setDuration(200L);
            }
            this.hBb.start();
        }
    }

    public void nQ(boolean z) {
        if (this.hAZ != null && this.hAZ.isRunning()) {
            this.hAZ.cancel();
        }
        if (this.hAY == null) {
            this.hAY = ObjectAnimator.ofPropertyValuesHolder(this.hAX, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hAY.setRepeatCount(-1);
            this.hAY.setRepeatMode(2);
            this.hAY.setDuration(1000L);
        }
        this.hAX.setVisibility(0);
        if (z) {
            this.hAV.setVisibility(8);
        } else {
            this.hAV.setBackgroundResource(e.f.red_square_bg);
        }
        this.SX.setVisibility(8);
        this.hAY.start();
    }

    public void bJt() {
        if (this.hAY != null && this.hAY.isRunning()) {
            this.hAY.cancel();
        }
        if (this.hAZ == null) {
            this.hAZ = ObjectAnimator.ofPropertyValuesHolder(this.hAX, PropertyValuesHolder.ofFloat("scaleX", this.hAX.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hAX.getScaleY(), 0.766f));
            this.hAZ.setDuration((500.0f * Math.abs(0.766f - this.hAX.getScaleX())) / 0.3f);
        }
        this.hAV.setVisibility(0);
        this.hAV.setBackgroundResource(e.f.red_circle_bg);
        this.hAZ.start();
    }
}
