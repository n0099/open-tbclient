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
    private TextView axF;
    private View hyp;
    private View hyq;
    private View hyr;
    private ObjectAnimator hys;
    private ObjectAnimator hyt;
    private ObjectAnimator hyu;
    private ObjectAnimator hyv;

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
        this.hyp = findViewById(d.g.record_layer1);
        this.hyq = findViewById(d.g.record_layer2);
        this.hyr = findViewById(d.g.record_layer3);
        this.axF = (TextView) findViewById(d.g.tv_tip);
        this.hyr.setScaleX(0.766f);
        this.hyr.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hyr;
    }

    public View getLayer1() {
        return this.hyp;
    }

    public View getLayer2() {
        return this.hyq;
    }

    public TextView getTvTip() {
        return this.axF;
    }

    public void bEn() {
        if (this.hyv != null && this.hyv.isRunning()) {
            this.hyu.cancel();
        }
        if (this.hyu == null) {
            this.hyu = ObjectAnimator.ofPropertyValuesHolder(this.hyq, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hyu.setDuration(200L);
        }
        this.hyu.start();
    }

    public void bEo() {
        if (this.hyu != null && this.hyu.isRunning()) {
            this.hyu.cancel();
        }
        if (this.hyq.getScaleX() != 1.0f) {
            if (this.hyv == null) {
                this.hyv = ObjectAnimator.ofPropertyValuesHolder(this.hyq, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hyv.setDuration(200L);
            }
            this.hyv.start();
        }
    }

    public void nu(boolean z) {
        if (this.hyt != null && this.hyt.isRunning()) {
            this.hyt.cancel();
        }
        if (this.hys == null) {
            this.hys = ObjectAnimator.ofPropertyValuesHolder(this.hyr, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hys.setRepeatCount(-1);
            this.hys.setRepeatMode(2);
            this.hys.setDuration(1000L);
        }
        this.hyr.setVisibility(0);
        if (z) {
            this.hyp.setVisibility(8);
        } else {
            this.hyp.setBackgroundResource(d.f.red_square_bg);
        }
        this.axF.setVisibility(8);
        this.hys.start();
    }

    public void bEc() {
        if (this.hys != null && this.hys.isRunning()) {
            this.hys.cancel();
        }
        if (this.hyt == null) {
            this.hyt = ObjectAnimator.ofPropertyValuesHolder(this.hyr, PropertyValuesHolder.ofFloat("scaleX", this.hyr.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hyr.getScaleY(), 0.766f));
            this.hyt.setDuration((500.0f * Math.abs(0.766f - this.hyr.getScaleX())) / 0.3f);
        }
        this.hyp.setVisibility(0);
        this.hyp.setBackgroundResource(d.f.red_circle_bg);
        this.hyt.start();
    }
}
