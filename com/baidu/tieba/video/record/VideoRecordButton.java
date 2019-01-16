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
    private View hOj;
    private View hOk;
    private View hOl;
    private ObjectAnimator hOm;
    private ObjectAnimator hOn;
    private ObjectAnimator hOo;
    private ObjectAnimator hOp;

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
        this.hOj = findViewById(e.g.record_layer1);
        this.hOk = findViewById(e.g.record_layer2);
        this.hOl = findViewById(e.g.record_layer3);
        this.Ti = (TextView) findViewById(e.g.tv_tip);
        this.hOl.setScaleX(0.766f);
        this.hOl.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hOl;
    }

    public View getLayer1() {
        return this.hOj;
    }

    public View getLayer2() {
        return this.hOk;
    }

    public TextView getTvTip() {
        return this.Ti;
    }

    public void bMG() {
        if (this.hOp != null && this.hOp.isRunning()) {
            this.hOo.cancel();
        }
        if (this.hOo == null) {
            this.hOo = ObjectAnimator.ofPropertyValuesHolder(this.hOk, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hOo.setDuration(200L);
        }
        this.hOo.start();
    }

    public void bMH() {
        if (this.hOo != null && this.hOo.isRunning()) {
            this.hOo.cancel();
        }
        if (this.hOk.getScaleX() != 1.0f) {
            if (this.hOp == null) {
                this.hOp = ObjectAnimator.ofPropertyValuesHolder(this.hOk, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hOp.setDuration(200L);
            }
            this.hOp.start();
        }
    }

    public void ok(boolean z) {
        if (this.hOn != null && this.hOn.isRunning()) {
            this.hOn.cancel();
        }
        if (this.hOm == null) {
            this.hOm = ObjectAnimator.ofPropertyValuesHolder(this.hOl, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hOm.setRepeatCount(-1);
            this.hOm.setRepeatMode(2);
            this.hOm.setDuration(1000L);
        }
        this.hOl.setVisibility(0);
        if (z) {
            this.hOj.setVisibility(8);
        } else {
            this.hOj.setBackgroundResource(e.f.red_square_bg);
        }
        this.Ti.setVisibility(8);
        this.hOm.start();
    }

    public void bMv() {
        if (this.hOm != null && this.hOm.isRunning()) {
            this.hOm.cancel();
        }
        if (this.hOn == null) {
            this.hOn = ObjectAnimator.ofPropertyValuesHolder(this.hOl, PropertyValuesHolder.ofFloat("scaleX", this.hOl.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hOl.getScaleY(), 0.766f));
            this.hOn.setDuration((500.0f * Math.abs(0.766f - this.hOl.getScaleX())) / 0.3f);
        }
        this.hOj.setVisibility(0);
        this.hOj.setBackgroundResource(e.f.red_circle_bg);
        this.hOn.start();
    }
}
