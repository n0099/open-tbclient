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
    private TextView Ti;
    private View hOk;
    private View hOl;
    private View hOm;
    private ObjectAnimator hOn;
    private ObjectAnimator hOo;
    private ObjectAnimator hOp;
    private ObjectAnimator hOq;

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
        this.hOk = findViewById(e.g.record_layer1);
        this.hOl = findViewById(e.g.record_layer2);
        this.hOm = findViewById(e.g.record_layer3);
        this.Ti = (TextView) findViewById(e.g.tv_tip);
        this.hOm.setScaleX(0.766f);
        this.hOm.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hOm;
    }

    public View getLayer1() {
        return this.hOk;
    }

    public View getLayer2() {
        return this.hOl;
    }

    public TextView getTvTip() {
        return this.Ti;
    }

    public void bMG() {
        if (this.hOq != null && this.hOq.isRunning()) {
            this.hOp.cancel();
        }
        if (this.hOp == null) {
            this.hOp = ObjectAnimator.ofPropertyValuesHolder(this.hOl, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hOp.setDuration(200L);
        }
        this.hOp.start();
    }

    public void bMH() {
        if (this.hOp != null && this.hOp.isRunning()) {
            this.hOp.cancel();
        }
        if (this.hOl.getScaleX() != 1.0f) {
            if (this.hOq == null) {
                this.hOq = ObjectAnimator.ofPropertyValuesHolder(this.hOl, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hOq.setDuration(200L);
            }
            this.hOq.start();
        }
    }

    public void ok(boolean z) {
        if (this.hOo != null && this.hOo.isRunning()) {
            this.hOo.cancel();
        }
        if (this.hOn == null) {
            this.hOn = ObjectAnimator.ofPropertyValuesHolder(this.hOm, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hOn.setRepeatCount(-1);
            this.hOn.setRepeatMode(2);
            this.hOn.setDuration(1000L);
        }
        this.hOm.setVisibility(0);
        if (z) {
            this.hOk.setVisibility(8);
        } else {
            this.hOk.setBackgroundResource(e.f.red_square_bg);
        }
        this.Ti.setVisibility(8);
        this.hOn.start();
    }

    public void bMv() {
        if (this.hOn != null && this.hOn.isRunning()) {
            this.hOn.cancel();
        }
        if (this.hOo == null) {
            this.hOo = ObjectAnimator.ofPropertyValuesHolder(this.hOm, PropertyValuesHolder.ofFloat("scaleX", this.hOm.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hOm.getScaleY(), 0.766f));
            this.hOo.setDuration((500.0f * Math.abs(0.766f - this.hOm.getScaleX())) / 0.3f);
        }
        this.hOk.setVisibility(0);
        this.hOk.setBackgroundResource(e.f.red_circle_bg);
        this.hOo.start();
    }
}
