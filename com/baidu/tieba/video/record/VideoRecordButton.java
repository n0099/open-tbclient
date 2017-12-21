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
    private TextView IR;
    private View ham;
    private View han;
    private View hao;
    private ObjectAnimator hap;
    private ObjectAnimator haq;
    private ObjectAnimator har;
    private ObjectAnimator has;

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
        this.ham = findViewById(d.g.record_layer1);
        this.han = findViewById(d.g.record_layer2);
        this.hao = findViewById(d.g.record_layer3);
        this.IR = (TextView) findViewById(d.g.tv_tip);
        this.hao.setScaleX(0.766f);
        this.hao.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hao;
    }

    public View getLayer1() {
        return this.ham;
    }

    public View getLayer2() {
        return this.han;
    }

    public TextView getTvTip() {
        return this.IR;
    }

    public void bEE() {
        if (this.has != null && this.has.isRunning()) {
            this.har.cancel();
        }
        if (this.har == null) {
            this.har = ObjectAnimator.ofPropertyValuesHolder(this.han, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.har.setDuration(200L);
        }
        this.har.start();
    }

    public void bEF() {
        if (this.har != null && this.har.isRunning()) {
            this.har.cancel();
        }
        if (this.han.getScaleX() != 1.0f) {
            if (this.has == null) {
                this.has = ObjectAnimator.ofPropertyValuesHolder(this.han, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.has.setDuration(200L);
            }
            this.has.start();
        }
    }

    public void nN(boolean z) {
        if (this.haq != null && this.haq.isRunning()) {
            this.haq.cancel();
        }
        if (this.hap == null) {
            this.hap = ObjectAnimator.ofPropertyValuesHolder(this.hao, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hap.setRepeatCount(-1);
            this.hap.setRepeatMode(2);
            this.hap.setDuration(1000L);
        }
        this.hao.setVisibility(0);
        if (z) {
            this.ham.setVisibility(8);
        } else {
            this.ham.setBackgroundResource(d.f.red_square_bg);
        }
        this.IR.setVisibility(8);
        this.hap.start();
    }

    public void bEu() {
        if (this.hap != null && this.hap.isRunning()) {
            this.hap.cancel();
        }
        if (this.haq == null) {
            this.haq = ObjectAnimator.ofPropertyValuesHolder(this.hao, PropertyValuesHolder.ofFloat("scaleX", this.hao.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hao.getScaleY(), 0.766f));
            this.haq.setDuration((500.0f * Math.abs(0.766f - this.hao.getScaleX())) / 0.3f);
        }
        this.ham.setVisibility(0);
        this.ham.setBackgroundResource(d.f.red_circle_bg);
        this.haq.start();
    }
}
